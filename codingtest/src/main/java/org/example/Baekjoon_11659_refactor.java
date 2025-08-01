package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_11659_refactor {
    public static void main(String[] args) throws IOException {
        //bufferReader로 입력 받고
        //tokenizer로 한 줄씩 string으로 토큰화
        //토큰화된 문장을 한 글자씩 split
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        //숫자의 개수 -> 합 배열의 크기
        int N = Integer.parseInt(st.nextToken());
        //구간합 구해야 하는 횟수
        int M = Integer.parseInt(st.nextToken());
        //구간 합을 구해야 하는 배열을 받아와서 구간합 공식을 이용하여 계산 후 배열에 저장

        //구간합 배열S
        long Sum[] =new long[N+1];

        //N개의 숫자를 읽어 와서 배열에 저장
        st = new StringTokenizer(bf.readLine());
        for (int n = 1; n < Sum.length; n++) {
            Sum[n] = Sum[n - 1] + Integer.parseInt(st.nextToken());
        }

        //구간합 계산 후 출력
        for (int k = 0; k < M; k++) {
            st = new StringTokenizer(bf.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            System.out.println(Sum[j] - Sum[i-1]);
        }
    }
}
