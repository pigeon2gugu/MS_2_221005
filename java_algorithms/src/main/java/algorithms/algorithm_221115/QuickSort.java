package algorithms.algorithm_221115;

import java.util.ArrayList;
import java.util.List;

//재귀 이용
public class QuickSort {

    public List<Integer> merge(List<Integer> left, List<Integer> middle, List<Integer> right) {
        List<Integer> answer = new ArrayList<>();
        answer.addAll(left);
        answer.addAll(middle);
        answer.addAll(right);
        return answer;
    }

    public List<Integer> sort(List<Integer> arr) {

        if(arr.size() <= 1) return arr;

        int idx = (int)(arr.size()/2);
        int pivot = arr.get(idx);

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        List<Integer> middle = new ArrayList<>();

        middle.add(pivot);

        for(int i = 0; i<arr.size(); i++) {
            if(i == idx) {
                continue;
            }
            if(arr.get(i) <= pivot) {
                left.add(arr.get(i));
            } else {
                right.add(arr.get(i));
            }
        }

        System.out.println(left);
        System.out.println(right);

        return merge(sort(left), middle, sort(right));
    }

    public static void main(String[] args) {

        int[] arr = new int[] {20, 18, 5, 19, 5, 25, 40, 50};
        List<Integer> al = new ArrayList<>();
        for(int i = 0; i<arr.length; i++) {
            al.add(arr[i]);
        }

        QuickSort qs = new QuickSort();
        System.out.println(qs.sort(al));


    }

}
