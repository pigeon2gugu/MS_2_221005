package algorithms.algorithm_221130;

import java.util.Scanner;

//두 노드 간의 거리
//https://codeup.kr/problem.php?id=1936
public class LowestCommonAncstor2 {

    public static int NodeLength(int a, int b) {

        if(a>b) {
            return NodeLength(a/2, b) + 1;
        } else if (a<b) {
            return NodeLength(a, b/2) + 1;
        } else {
            return 0;
        }

    }

    public static void main(String[] args) {

        System.out.println(NodeLength(3, 4));
    }

}
