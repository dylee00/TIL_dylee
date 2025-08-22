package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baekjoon_1874_practice {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //수열 개수
        int A[] = new int[N]; //숫자 받는 배열

        //배열에 숫자 넣기
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        Stack<Integer> stack = new Stack<>();
        int num = 1;
        boolean result = true;
        //+,-를 저장하기 위한 bf
        StringBuffer bf = new StringBuffer();
        for (int i = 0; i < N; i++) {
            int su = A[i];
            if (su >= num) {
                while (su >= num) {
                    stack.push(num++);
                    bf.append("+\n");
                }
                stack.pop();
                bf.append("-\n");
            } else {
                int n = stack.pop();
                if (n > su) {
                    System.out.printf("No");
                    result = false;
                    break;
                }
                bf.append("-\n");
            }
        }
        if(result) System.out.printf(bf.toString());

    }
}
