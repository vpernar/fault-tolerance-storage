package rs.raf;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@NoArgsConstructor
@Slf4j
@Getter
@Setter
public class StorageMapService {
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private Map<String, String> storage = new HashMap<>();
    private boolean isLeader = false;

    public void put(String key, String value) {
        lock.writeLock().lock();
        try {
            log.info("Added: key:{}, value:{}", key, value);
            storage.put(key, value);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void remove(String key) {
        lock.writeLock().lock();
        try {
            log.info("Removed: key:{}", key);
            storage.remove(key);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public String get(String key) {
        lock.readLock().lock();
        try {
            log.info("Getting value for key: {}", key);
            return storage.get(key);
        } finally {
            lock.readLock().unlock();
        }
    }

    public void setServerState(boolean isLeader) {
        this.isLeader = isLeader;
    }
}
