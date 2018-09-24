package zookeeper;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

public class ZKClient {
    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        String conn = "192.168.199.201:2181,192.168.199.177:2181,192.168.199.115:2181";
        ZooKeeper zk = new ZooKeeper(conn, 5000, null);
        while (true) {
            if(zk.getState().isConnected())
                break;
        }
        zk.create("/chao", "123".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);

        Thread.sleep(10000);
        zk.close();
    }
}