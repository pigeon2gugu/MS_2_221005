package algorithms.algorithm_221111;

import java.util.ArrayList;


//https://school.programmers.co.kr/learn/courses/30/lessons/17681
//비트연산 풀이
public class Programmers_17681_2 {
    class Solution {


        public ArrayList<String> solution(int n, int[] arr1, int[] arr2) {

            ArrayList<String> answer1 = new ArrayList<>();

            for(int i = 0; i< arr1.length; i++) {
                String temp = Integer.toBinaryString(arr1[i] | arr2[i]).replace("1", "#").replace("0", " ");
                answer1.add(" ".repeat(n - temp.length()) +temp );
            }

            return answer1;
        }

    }
}
