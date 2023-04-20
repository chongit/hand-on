package io.chone.algorithm.solution;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class DailyTemperature {

    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] ans = new DailyTemperature().dailyTemperatures1(temperatures);
        System.out.println(Arrays.toString(ans));
    }

    /**
     * 很容易想到每个元素向后遍历的方法，但复杂度是O(N)。
     * 其实每个元素向后遍历，如果后续元素同样是递减的，其实会出现重复计算。
     * 所以问题的关键在于如何保存首次遍历结果？
     * 这里特性是一次遍历会走到最远的地方，然后再回来
     *
     * @param t
     * @return
     */
    public int[] dailyTemperatures(int[] t) {
        int[] answer = new int[t.length];
        //定义栈
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < t.length; i++) {
            //栈不为空且当前值大于栈顶元素（递增），弹出
            while (!stack.isEmpty() && t[i] > t[stack.peek()]) {
                //每一次弹出，都会找对对应位置的idx，并设置其distance= i-top
                int top = stack.peek();
                answer[top] = i - top;
                stack.pop();
            }
            //入栈
            stack.push(i);
            System.out.println(stack);
        }
        return answer;
    }

    public int[] dailyTemperatures1(int[] T) {
        int[] res = new int[T.length];
        res[T.length - 1] = 0;
        for (int i = T.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < T.length; j += res[j]) {
                if (T[i] < T[j]) {
                    res[i] = j - i;
                    break;
                } else if (res[j] == 0) {
                    res[i] = 0;
                    break;
                }
            }
        }
        return res;
    }

}
