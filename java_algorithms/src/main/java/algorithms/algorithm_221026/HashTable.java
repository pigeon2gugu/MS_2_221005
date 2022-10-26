package algorithms.algorithm_221026;

import java.util.ArrayList;
import java.util.List;

public class HashTable {

    //hash충돌을 방지하기 위해서, hashtable에  key(String)과 value 모두 add. table index는 hash(key)
    class Node {
        private String key;
        private Integer value;

        public Node(String key, Integer value) {
            this.key = key;
            this.value = value;
        }
        public String getKey() {
            return key;
        }

        public Integer getValue() {
            return value;
        }
    }
    private int size = 10000;
    List<Node>[] table = new ArrayList[size];


    public HashTable() {
    }

    private HashTable(int size) {
        this.size = size;
        this.table =  new ArrayList[size];
    }

    //hash 구현
    public int hash(String  key) {
        int asciiSum = 0;
        for (int i = 0 ; i < key.length(); i++) {
            asciiSum += key.charAt(i);;
        }
        return asciiSum % size; //배열 size 내에 key를 할당하기 위해
    }

    //데이터 저장 method
    public void insert(String key, Integer value) {
        int hashCode = hash(key);
        if (this.table[hashCode] == null) {
            this.table[hashCode] = new ArrayList<>();
        }
        this.table[hashCode].add(new Node(key, value));
        System.out.println(hashCode + "방에 저장이 완료 되었습니다.");
    }

    //hash(key)값과 key (String)값으로 value search (hash(key)의 중복 경우 고려)
    public Integer get(String key) {
        List<Node> nodes = this.table[hash(key)];
        for (Node node : nodes) {
            if (key.equals(node.getKey())) {
                return node.value;
            }
        }
        return null;
    }


    public static void main(String[] args) {
        HashTable ht = new HashTable();
        ht.insert("Yoonseo", 1);
        ht.insert("Seoyoon", 2);

        int result = ht.get("Yoonseo");
        if (result == 1) {
            System.out.println("테스트 성공");
        } else {
            System.out.printf("테스트 실패 value:%d", result);
        }

        result = ht.get("Seoyoon");
        if (result == 2) {
            System.out.println("테스트 성공");
        } else {
            System.out.printf("테스트 실패 value:%d", result);
        }
    }
}
