package zookeeper;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.List;

public class WatcherTest {
    private static ZooKeeper zkClient;
    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        String conn = "192.168.199.201:2181,192.168.199.177:2181,192.168.199.115:2181";
        int sessionTimeout = 5000;
        Watcher watcher = new MasterWatcher();
        zkClient = new ZooKeeper(conn, sessionTimeout, watcher);

        Thread.sleep(Integer.MAX_VALUE);
        zkClient.close();
    }
    static class MasterWatcher implements Watcher {
        @Override
        public void process(WatchedEvent watchedEvent) {
//            if (watchedEvent.getType() == Event.EventType.NodeChildrenChanged) {
                try {
                    List<String> list = zkClient.getChildren("/", true);
                    for (String str : list) {
                        System.out.println(str);
                    }
                    System.out.println("---------------------");
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//            }
        }
    }
}