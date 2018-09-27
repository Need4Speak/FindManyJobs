package zookeeper.serveronoff;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.Scanner;

public class Server {
    private String conn = "192.168.199.201:2181,192.168.199.177:2181,192.168.199.115:2181";
    private ZooKeeper zkClient;

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        Scanner in = new Scanner(System.in);
        Server server = new Server();
        // 1. 连接 zookeeper 集群
        server.getConnect();
        // 2. 注册节点
        server.regist(in.nextLine());
        // 3. 业务代码
        server.doSomething();

    }

    private void doSomething() throws InterruptedException {
        Thread.sleep(Integer.MAX_VALUE);
    }

    private void regist(String hostname) throws KeeperException, InterruptedException {
        if (zkClient.exists("/servers", false) == null) {
            zkClient.create("/servers", "root".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }
        zkClient.create("/servers/server", hostname.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.EPHEMERAL_SEQUENTIAL);
        System.out.println(hostname + "is online");
    }

    private void getConnect() throws IOException {
        zkClient = new ZooKeeper(conn, 5000, null);
    }
}
