package algorithms.algorithom_221102;

//에라토스테네스 채로 소수 구하기. step 1
//50 까지의 소수 찾기
//sqrt(50)이하의 수의 배수 모두 지우기
//list로 할 시 효율성테스트 실패. (remove시 리스트 복사 문제)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveMultipleOf {
    public int solution(int n) {

        int answer = 0;

        int [] nums = new int[n-1];
        boolean [] numChecks = new boolean[n-1];


        for(int i = 2; i <= n; i++) {
            nums[i-2] = i;
            numChecks[i-2] = true;
        }

        System.out.println(Arrays.toString(nums));

        for(int i = 2; i*i <= n; i++) {
            for(int j = 0; j < nums.length; j ++) {
                if(numChecks[i-2] == false && j == 0) {
                    System.out.println(i);
                    break;
                }
                if(nums[j]%i==0 && nums[j] != i){
                    numChecks[j] = false;
                }
            }
        }

        for(int i = 0; i < numChecks.length; i++) {
            if(numChecks[i] == true){
                answer += 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        RemoveMultipleOf rm = new RemoveMultipleOf();
        System.out.println(rm.solution(50));
    }
}
