package zookeeper;

import org.apache.zookeeper.*;

import java.io.IOException;

public class HATest {
    static String status;
    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        String conn = "192.168.199.201:2181,192.168.199.177:2181,192.168.199.115:2181";
        ZooKeeper zk = new ZooKeeper(conn, 5000, null);
        while (true) {
            if(zk.getState().isConnected())
                break;
        }
        if (zk.exists("/matser", new MasterWatcher()) != null) {
            status = "STANDBY";
            System.out.println("启动为 standby");
        } else {
            zk.create("/matser", "123".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
            System.out.println("启动为 active");
        }


        Thread.sleep(Integer.MAX_VALUE);
        zk.close();
    }
    static class MasterWatcher implements Watcher {
        @Override
        public void process(WatchedEvent watchedEvent) {
            if (watchedEvent.getType() == Event.EventType.NodeDeleted) {
                status = "ACTIVE";
                System.out.println("切换为 active");
            }
        }
    }
}