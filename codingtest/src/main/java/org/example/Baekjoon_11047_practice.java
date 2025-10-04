package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_11047_practice {
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        //N가지의 동전 저장
        int value[] = new int[N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            value[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = N - 1; i >= 0; i--) {
            int coin = value[i];
            if ((K / coin) != 0) {
                result += K/coin;
                K = K%coin;
            }
        }
        System.out.println(result);
    }

}
