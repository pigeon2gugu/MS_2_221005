package algorithms.algoritm_221020;

import java.util.EmptyStackException;

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
        this.arr[this.top++] = value;
    }

    public Integer[] getArr() {
        return arr;
    }

    public int pop() {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        return this.arr[--this.top];
    }

    public boolean isEmpty(){
        boolean isEmpty = this.top == 0;
        return isEmpty;
    }

    public int peek() {
        if (isEmpty()) throw new EmptyStackException();
        return this.arr[--this.top];
    }
}
