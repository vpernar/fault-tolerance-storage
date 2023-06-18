package rs.raf.zookeeper;

import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

@Slf4j
public class SyncPrimitive implements Watcher {
    protected ZooKeeper zooKeeper;
    protected final Object mutex = new Object();
    protected String root;

    protected SyncPrimitive(String address, String root) {
        try {
            log.info("Starting ZooKeeper...");
            this.zooKeeper = new ZooKeeper(address, 3000, this);
            this.root = root;
            log.info("Finished starting ZooKeeper: " + this.zooKeeper);
        } catch (IOException e) {
            log.error("ZooKeeper didn't start: {}", e.toString());
            this.zooKeeper = null;
        }

    }

    @Override
    public synchronized void process(WatchedEvent event) {
        synchronized (this.mutex) {
            this.mutex.notify();
        }
    }
}