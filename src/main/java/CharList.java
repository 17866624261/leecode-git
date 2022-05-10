import java.util.Scanner;

public class CharList {
    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        int[] list = new int[]{32,39,45,90,91,80};
        //list 为char_list
        for(int i = 0;i<list.length;i++)
        {
            myHashMap.put(list[i],i+1);
        }
        Scanner scanner = new Scanner(System.in);

        String[] spilt = scanner.nextLine().split(",");
        int[] result =new int[spilt.length];
        for(int i = 0;i<spilt.length;i++)
        {
            int temp = Integer.parseInt(spilt[i]);
            result[i] = myHashMap.get(temp);
        }
        for (int i = 0; i < result.length-1; i++) {
            System.out.print(result[i]+",");
        }
        System.out.println(result[result.length-1]);
    }

}

class MyHashMap {

    static class Node {
        int key, value;
        Node next;
        boolean isDeleted;
        Node(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }
    int OFFSET = 1;
    Node[] nodes = new Node[200];

    public void put(int key, int value) {
        int idx = getIndex(key);
        Node node = nodes[idx];
        if (node != null) {
            node.value = value;
            node.isDeleted = false;
        } else {
            node = new Node(key, value);
            nodes[idx] = node;
        }
    }

    public void remove(int key) {
        Node node = nodes[getIndex(key)];
        if (node != null) node.isDeleted = true;
    }

    public int get(int key) {
        Node node = nodes[getIndex(key)];
        if (node == null) return -1;
        return node.isDeleted ? -1 : node.value;
    }

    int getIndex(int key) {
        int hash = Integer.hashCode(key);
        hash ^= (hash >>> 16);
        int n = nodes.length;
        int idx = hash % n;
        while (nodes[idx] != null && nodes[idx].key != key) {
            hash += OFFSET;
            idx = hash % n;
        }
        return idx;
    }


}
