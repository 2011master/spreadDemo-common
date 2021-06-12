package struct.linkedList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LRUCache {

    //创建双向链表类
    class Node{
        private int key,value;
        private Node left;
        private Node right;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int num ;

    private  Map<Integer,Node> map;
    private Node head;
    private Node tail;

    //构造器
    public  LRUCache(int capacity) {

        num = capacity;
        map = new HashMap<>(num);

        head = new Node(-1,-1);
        tail = new Node(-1,-1);

        head.right = tail;
        tail.left = head;

    }

    public Node getNode(int key){
        //从map中查询
        Node node = map.get(key);
        if (null == node) return null;
        //不为空时要将当前数据移动到队列头部,需要修改map中node及链表中node,需要先删除在插入到头部
        refreshNode(node);

        return node;
    }

    public void push(int key, int value) {

        if (map.containsKey(key)) {
            //存在
            Node nodeOld = map.get(key);
            nodeOld.value = value;
            refreshNode(nodeOld);
            return;
        }

        if (!map.containsKey(key)) {

            Node node = new Node(key, value);

            if (num == map.size()) {
                //先删除尾部节点
                Node deleteNode = tail.left;
                map.remove(deleteNode.key);
                deleteNode(deleteNode);
                //插入
                refreshNode(node);

            } else if (map.size() < num) {
                //直接放到头部
                refreshNode(node);
            } else {
                throw new RuntimeException("num只能大于等于map.size");
            }
        }

    }

    public void refreshNode(Node node) {
        deleteNode(node);
        //插入到头部
        node.right = head.right;
        node.left = head;
        head.right.left = node;
        head.right = node;

    }

    // delete 操作：将当前节点从双向链表中移除
    // 由于我们预先建立 head 和 tail 两位哨兵，因此如果 node.l 不为空，则代表了 node 本身存在于双向链表（不是新节点）

    public void deleteNode(Node node) {
        if (node.left != null) {
            node.left.right = node.right;
            node.right.left = node.left;
        }
    }

 
}
