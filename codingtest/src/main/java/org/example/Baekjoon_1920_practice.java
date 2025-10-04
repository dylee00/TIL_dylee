package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Baekjoon_1920_practice {
    static int A[];
    static int N,M;
    public static void main(String[] args) throws IOException {
        //N개의 정수와 배열
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        A = new int[N];
        st =  new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        Arrays.sort(A);
        //M만큼 탐색하며 해당하는 정수가 존재하는지 순회
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            boolean find = false;
            int target = Integer.parseInt(st.nextToken());
            int start = 0;
            int end = N-1;
            while (start <= end) {
                int mid = (start + end)/2;
                int num = A[mid];
                if(num==target) {
                    find = true;
                    break;
                }
                //중앙값 < 타겟
                else if(num<target){
                    start = mid+1;
                }
                //중앙값 > 타겟
                else if(num>target){
                    end = mid-1;
                }
            }
            if(find){
                System.out.println(1);
            }else {
                System.out.println(0);
            }
        }


    }

}
