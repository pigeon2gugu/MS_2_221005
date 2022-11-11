package algorithms.algorithm_221111;

import java.util.ArrayList;


//https://school.programmers.co.kr/learn/courses/30/lessons/17681
public class Programmers_17681 {
    class Solution {
        public ArrayList<String> solution(int n, int[] arr1, int[] arr2) {

            ArrayList<String> binaryArr1 = new ArrayList<>();
            ArrayList<String> binaryArr2 = new ArrayList<>();
            ArrayList<String> answer1 = new ArrayList<>();

            for(int i = 0; i< arr1.length; i++) {
                binaryArr1.add(String.format("%0"+n+"d", Long.parseLong(Long.toBinaryString(arr1[i]))));
                binaryArr2.add(String.format("%0"+n+"d", Long.parseLong(Long.toBinaryString(arr2[i]))));

                String temp = "";
                for(int j = 0; j<n; j++) {
                    if((binaryArr1.get(i).split("")[j]).equals("0") && (binaryArr2.get(i).split("")[j]).equals("0")) {
                        temp += " ";
                    } else {
                        temp += "#";
                    }
                }
                answer1.add(temp);
            }

            return answer1;
        }
    }
}
