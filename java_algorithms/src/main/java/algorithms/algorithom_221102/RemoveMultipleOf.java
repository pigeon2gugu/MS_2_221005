package algorithms.algorithom_221102;

//에라토스테네스 채로 소수 구하기. step 1
//50 까지의 소수 찾기
//sqrt(50)이하의 수의 배수 모두 지우기

import java.util.ArrayList;

public class RemoveMultipleOf {
    public int solution(int n) {

        ArrayList<Integer> nums = new ArrayList<Integer>();
        for(int i = 2; i <= n; i++) {
            nums.add(i);
        }

        for(int i = 2; i <= Math.sqrt(n); i++) {
            for(int j = 1; j < nums.size(); j ++) {
                if(nums.get(j)%i==0 && nums.get(j) != i){
                    nums.remove(nums.get(j));
                    j--;
                }
            }
        }
        System.out.println(nums);
        return nums.size();
    }

    public static void main(String[] args) {
        RemoveMultipleOf rm = new RemoveMultipleOf();
        System.out.println(rm.solution(50));
    }
}
