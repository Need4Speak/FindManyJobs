package zookeeper.serveronoff;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Client {
    private String conn = "192.168.199.201:2181,192.168.199.177:2181,192.168.199.115:2181";
    private ZooKeeper zkClient;

    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        Client client = new Client();
        // 1. 建立连接
        client.getConnect();
        // 2. 注册监听
        client.getChildren();
        // 3. 业务逻辑
        client.doSomething();
    }

    private void doSomething() throws InterruptedException {
        Thread.sleep(Integer.MAX_VALUE);
    }

    private void getChildren() throws KeeperException, InterruptedException {
        List<String> list = zkClient.getChildren("/servers", true);
        // 存储服务器节点名称
        List<String> hosts = new ArrayList<>();
        for (String str : list) {
            byte[] data = zkClient.getData("/servers/" + str, false, null);
            hosts.add(new String(data));
        }
        //将所有名称打印到控制台
        System.out.println(hosts);

    }

    private void getConnect() throws IOException {
        zkClient = new ZooKeeper(conn, 5000, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                try {
                    getChildren();
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
