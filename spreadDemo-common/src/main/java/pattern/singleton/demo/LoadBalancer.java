package pattern.singleton.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 负载均衡器LoadBalancer：单例类，真实环境下该类将非常复杂，包括大量初始化的工作和业务方法，
 * 考虑到代码的可读性和易理解性， * 只列出部分与模式相关的核心代码
 */
public class LoadBalancer {
    //私有静态成员变量，存储唯一实例
    private static LoadBalancer instance = null;
    //服务器集合
    private List serverList = null;

    //私有构造函数
    private LoadBalancer() {
       serverList = new ArrayList();
    }

    //公有静态成员方法，返回唯一实例
    public static LoadBalancer getLoadBalance() {

        if (instance == null) {
            instance = new LoadBalancer();
        }
        return instance;
    }

    //增加服务器
    public void addServer(String server) {
        serverList.add(server);
    }
    //删除服务器
    public void removeServer(String server) {
        serverList.remove(server);
    }

    //使用random类随机获取服务器
    public String getServer() {
        Random random = new Random();
        int i = random.nextInt(serverList.size());
        return (String) serverList.get(i);
    }

    public static void main(String[] args) {
        LoadBalancer balancer1, balancer2, balancer3, balancer4;

        balancer1 = LoadBalancer.getLoadBalance();
        balancer2 = LoadBalancer.getLoadBalance();
        balancer3 = LoadBalancer.getLoadBalance();
        balancer4 = LoadBalancer.getLoadBalance();

        //判断服务器负载均衡是否相同
        if (balancer1 == balancer2 && balancer2 == balancer3 && balancer3 == balancer4) {
            System.out.println("服务器负载均衡具有唯一性！");
        }
        //增加服务器
        balancer1.addServer("Server1");
        balancer1.addServer("Server2");
        balancer1.addServer("Server3");
        balancer1.addServer("Server4");
        //模拟客户端请求分发
        for (int i = 0; i < 10; i++) {
            String server = balancer1.getServer();
            System.out.println("分发请求至服务器："+server);
        }
    }

}
