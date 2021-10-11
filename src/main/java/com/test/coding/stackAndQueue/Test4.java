package com.test.coding.stackAndQueue;

import java.util.Scanner;
import java.util.Stack;

public class Test4 {

    public int solution(String str) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (char x : str.toCharArray()) {
            if (Character.isDigit(x)) stack.push(x-48); //문자를 아스키코드로 - 48를 해줘야 실제 숫자가 됨
            else {
                int rt = stack.pop();  //오른쪽 숫자
                int lt = stack.pop();   //왼쪽 숫자
                if(x == '+') stack.push(lt + rt);
                else if(x == '-') stack.push(lt - rt);
                else if(x == '*') stack.push(lt * rt);
                else if(x == '/') stack.push(lt / rt);
            }
        }
        answer = stack.get(0);

        return answer;
    }

    public static void main(String[] args) {
        Test4 T = new Test4();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(T.solution(str));
    }

}
