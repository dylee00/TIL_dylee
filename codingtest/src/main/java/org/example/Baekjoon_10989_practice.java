package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baekjoon_10989_practice {
    public static int A[];
    public static long result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //숫자 개수
        int N = Integer.parseInt(br.readLine());
        A = new int[N];
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(br.readLine());
        }
        br.close();
        //기수정렬 함수(배열, 자릿수)
        Radix_sort(A, 5);
        for(int i = 0; i < N; i++){
            bw.write(A[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void Radix_sort(int[] A, int max_size){
        int[] output = new int[A.length];
        int jarisu = 1;
        int count = 0;
        //최대 자릿수만큼 반복
        while (count != max_size) {
            int[] bucket = new int[10];
            for(int i=0;i<A.length;i++){
                bucket[A[i]/jarisu % 10]++; //일의 자리부터 시작 -> 자릿수 파악 후 버킷에 저장
            }
            //합 배열을 이용해 index 계산 -> 숫자가 정렬된 결과에서 어느 위치에 들어가야 하는지 알려줌
            //누적 개수를 bucket에 체크하고, 이 숫자 만큼 output 배열에 저장
            //누적합 -> 끝자리가 i 이하인 모든 숫자들의 개수
            for (int i = 1; i < 10; i++) {
                bucket[i] += bucket[i-1];
            }
            //현재 자릿수를 기준으로 정렬
            //같은 키 값을 가진 원소들의 순서를 유지하기 위해 뒤쪽부터 처리
            for(int i = A.length-1; i >= 0; i--){
                output[bucket[(A[i] / jarisu % 10)] - 1] = A[i];
                bucket[(A[i] / jarisu % 10)]--;
            }
            for(int i=0;i<A.length;i++){
                A[i] = output[i];
            }
            jarisu = jarisu * 10;
            count++;
        }

    }
}
