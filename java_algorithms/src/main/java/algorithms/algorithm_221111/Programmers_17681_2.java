package algorithms.algorithm_221111;

import java.util.ArrayList;


//https://school.programmers.co.kr/learn/courses/30/lessons/17681
//비트연산 풀이
public class Programmers_17681_2 {
    class Solution {

        String getBinaryString(int decNum) {
            String answer = "";
            while (decNum > 0) {
                answer += decNum % 2;
                decNum /= 2;
            }
            return answer;
        }

        public ArrayList<String> solution(int n, int[] arr1, int[] arr2) {

            ArrayList<String> binaryArr1 = new ArrayList<>();
            ArrayList<String> binaryArr2 = new ArrayList<>();
            ArrayList<String> answer1 = new ArrayList<>();

            for(int i = 0; i< arr1.length; i++) {
                binaryArr1.add(getBinaryString(arr1[i]));
                binaryArr2.add(getBinaryString(arr2[i]));
                System.out.println(binaryArr1);
                System.out.println(binaryArr2);
            }

            return answer1;
        }

    }
}
