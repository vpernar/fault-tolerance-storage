package rs.raf.log;

import lombok.extern.slf4j.Slf4j;
import rs.raf.StorageMapService;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import static rs.raf.Main.LOG_PATH;

@Slf4j
public class SnapshotScheduler {
    public static String SNAPSHOT_PATH;
    private static final int SCHEDULE_DELAY = 80; // Delay in seconds

    private ScheduledExecutorService scheduler;
    private final StorageMapService storageService;

    public SnapshotScheduler(StorageMapService storageService) {
        this.storageService = storageService;
        SNAPSHOT_PATH = setSnapShotPath();
    }

    private String  setSnapShotPath() {
        int lastSlashIndex = LOG_PATH.lastIndexOf("/");
        int lastDotIndex = LOG_PATH.lastIndexOf(".");

        String pathPrefix = LOG_PATH.substring(0, lastSlashIndex + 1);
        String fileNameSuffix = LOG_PATH.substring(lastDotIndex);

        // Extract the number part
        String numberPart = LOG_PATH.substring(lastSlashIndex + 1, lastDotIndex).replaceAll("[^0-9]", "");

        String modifiedFileName = "snapshot" + numberPart + fileNameSuffix;
        return pathPrefix + modifiedFileName;
    }

    private void saveSnapshot() {
        // Obtain the map from the StorageService
        Map<String, String> dataMap = storageService.getStorage();
        ReentrantReadWriteLock lock = storageService.getLock();

        lock.readLock().lock();
        try {
            // Clear the file
            FileWriter fileWriter = new FileWriter(LOG_PATH, false);
            fileWriter.close();

            // Convert the map to a string
            StringBuilder stringBuilder = new StringBuilder();

            for (Map.Entry<String, String> entry : dataMap.entrySet()) {
                stringBuilder.append(entry.getKey()).append(":").append(entry.getValue()).append("\n");
            }
            String mapAsString = stringBuilder.toString();

            // Save the map as a string in the file
            FileWriter fileWriterAppend = new FileWriter(SNAPSHOT_PATH, false);
            fileWriterAppend.write(mapAsString);
            fileWriterAppend.close();

            log.info("Snapshot saved.");
        } catch (IOException e) {
            log.error("Error saving the snapshot: {}", e.getMessage());
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void start() {
        // Create and schedule the snapshot task
        scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(this::saveSnapshot, SCHEDULE_DELAY, SCHEDULE_DELAY, TimeUnit.SECONDS);
    }
}
