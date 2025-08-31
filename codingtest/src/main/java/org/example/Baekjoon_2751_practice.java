package org.example;

import java.io.*;

public class Baekjoon_2751_practice {
    public static int[] A, tmp;
    public static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        A = new int[N + 1];
        tmp = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        //병합 정렬 수행하기
        merge_sort(1, N);
        for (int i = 1; i <= N; i++) {
            bw.write(A[i] + "\n");
        }
        bw.flush();
        bw.close();
    }
    private static void merge_sort(int start, int end) {
        if (end - start < 1) {
            return;
        }
        int m = start + (end - start) / 2; //중간점 구하기

        //재귀 함수 형태로 구현
        merge_sort(start, m);
        merge_sort(m + 1, end);
        //tmp 배열 저장
        for(int i=start;i<=end;i++) {
            tmp[i] = A[i];
        }
        int k = start;
        int index1 = start;
        int index2 = m+1;
        //두 개의 그룹을 병합
        //양쪽 그룹의 index가 가리키는 값을 비교해 더 작은 수 -> 배열에 저장, 선택된 데이터의 index 값을 오른쪽으로 한 칸 이동
        while (index1 <= m && index2 <= end) {
            if (tmp[index1] > tmp[index2]) {
                A[k] = tmp[index2];
                k++;
                index2++;
            } else {
                A[k] = tmp[index1];
                k++;
                index1++;
            }
        }
        //한쪽 그룹 선택된 후 남아 있는값 정리
        while (index1 <= m) {
            A[k] = tmp[index1];
            k++;
            index1++;
        }
        while (index2 <= end) {
            A[k] = tmp[index2];
            k++;
            index2++;
        }
    }
}
