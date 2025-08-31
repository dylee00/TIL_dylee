package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_11004_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //N,K
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] A = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(A, 0, N - 1, K);
        System.out.println(A[K-1]);
    }

    public static void quickSort(int[] A, int s, int e, int k){
        //피벗 설정 함수
        if (s < e) {
            int pivot = partition(A, s, e);
            if (pivot == k) { //k번째 수가 pivot이라면 구할 필요 x
                return;
            } else if (pivot > k) {
                //pivot이 k보다 크다면 -> pivot의 왼쪽 정렬
                quickSort(A, s, pivot - 1, k);
            } else {
                //pivot이 k보다 작다면 -> pivot의 오른쪽 정렬
                quickSort(A, pivot + 1, e, k);
            }
        }
    }

    //피벗 설정 함수 + 정렬
    public static int partition(int[] A, int s, int e){
        int M = (s+e) /2; //중간값을 피벗으로 설정
        //중간값을 배열의 1번째로 이동
        int temp = A[s];
        A[s] =A[M];
        A[M] = temp;

        int pivot = A[s];
        int i = s;
        int j = e;
        while (i < j) {
            while (pivot < A[j]) {
                //pivot보다 작은 수 나올 때까지 j--
                j--;
            }
            while (i < j && pivot >= A[i]) {
                //pivot보다 큰 수 나올 때까지 i++
                i++;
            }
            //i와 j 교환
            int temp_p = A[i];
            A[i] = A[j];
            A[j] = temp_p;
        }

        A[s] = A[i];
        A[i] = pivot;
        return i;
    }
}
