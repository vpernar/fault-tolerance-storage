package rs.raf.log;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import static rs.raf.Main.LOG_PATH;

@Slf4j
@Getter
public class ReplicatedLog {
    public static Long lastEntryIndex = 0L;
    public static final ReentrantReadWriteLock FILE_LOCK = new ReentrantReadWriteLock();

    private final Long logEntryIndex;
    private final String command;
    private final String key;
    private final String value;

    public ReplicatedLog(String command, String key, String value) {
        this.command = command;
        this.key = key;
        this.value = value;
        this.logEntryIndex = lastEntryIndex + 1;
    }

    public ReplicatedLog(Long logEntryIndex, String command, String key, String value) {
        this.logEntryIndex = logEntryIndex;
        this.command = command;
        this.key = key;
        this.value = value;
    }

    public ReplicatedLog(Long logEntryIndex, String command, String key) {
        this.logEntryIndex = logEntryIndex;
        this.command = command;
        this.key = key;
        this.value = "";
    }

    public void appendToLocalLog() {
        FILE_LOCK.writeLock().lock();
        try {
            FileWriter fileWriter = new FileWriter(LOG_PATH, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(this.toString());
            bufferedWriter.newLine();

            bufferedWriter.close();
            lastEntryIndex++;
        } catch (IOException e) {
            log.error(e.getMessage());
        } finally {
            FILE_LOCK.writeLock().unlock();
        }
    }

    public static ReplicatedLog logFromString(String logString) {
        String[] parts = logString.split(" ");
        System.out.println(logString);
        if(parts.length >= 4) {
            return new ReplicatedLog(Long.parseLong(parts[0]), parts[1], parts[2], parts[3]);
        } else {
            return new ReplicatedLog(Long.parseLong(parts[0]), parts[1], parts[2]);
        }
    }

    @Override
    public String toString() {
        return logEntryIndex + " " + command + " " + key + (value == null ? "" : " " + value);
    }
}
