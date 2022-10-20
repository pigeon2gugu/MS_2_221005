package algorithms.algoritm_221020;

public class Stack02 {

    private int top;
    private Integer[] arr;

    public Stack02() {
        this.arr = new Integer[10000];
    }

    public Stack02(int size) {
        this.arr = new Integer[size];
    }

    public void push(int value) {
        this.arr[this.top] = value;
        this.top++;
    }

    public Integer[] getArr() {
        return arr;
    }

    public int pop() {
        int value = this.arr[this.top-1];
        this.top--;
        return value;
    }
}
