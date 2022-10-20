package algorithms.algoritm_221020;

public class Stack01 {
    private int[] arr = new int[10000];
    private int pointer = 0;

    public Stack01() {

    }

    public Stack01(int size) {
        this.arr = new int[size];
    }

    public void push(int value) {
        //int[] arr = new int[10000];
        //arr[0] = value;
        //return arr;
        this.arr[this.pointer] = value;
        this.pointer ++;
    }

    public int pop() {
        this.pointer --;
        int value = this.arr[this.pointer];
        return value;
    }

    public int[] getArr() {
        return arr;
    }
}
