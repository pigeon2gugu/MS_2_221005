package algorithms.algorithm_221130;

//두 노드 간의 거리
//https://codeup.kr/problem.php?id=1936
public class LowestCommonAncstor {

    public static int NodeLength(int a, int b) {
        int parentA = a;
        int parentB = b;

        int lenth = 0;
        while(parentA != parentB) {

            if (parentA > 1) {
                parentA = Math.floorDiv(a, 2);
                a = parentA;
                lenth += 1;
            }

            if (parentB > 1) {
                parentB = Math.floorDiv(b, 2);
                b = parentB;
                lenth += 1;
            }

        }

        return lenth;

    }

    public static void main(String[] args) {
        System.out.println(NodeLength(6, 4));
    }

}
