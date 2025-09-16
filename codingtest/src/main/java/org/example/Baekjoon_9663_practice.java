package org.example;

import java.util.Scanner;

public class Baekjoon_9663_practice {
    //백트래킹 -> 함수를 많이 사용하기 때문에 전역 변수로 선언해서 사용하기
    static int[] A; //퀸 배열
    static int N; //체스판 크기
    static int cnt = 0; //출력 값
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N= sc.nextInt();
        A = new int[N];
        backtracking(0); //행의 위치 -> 0
        System.out.println(cnt);
    }
    public static void backtracking(int row){
        //정답이 도출되었을 경우
        //행 = 6인 경우 -> N까지 배치한 경우
        if (row == N) { //정답출력
            cnt++;
            return;
        }
        //모든 케이스 순회
        for (int i = 0; i < N; i++) {
            A[row] = i; //일단 퀸을 배치
            //체크
            if (check(row)) { //가지치기 -> 퀸을 놓을 수 있는지 유효성 검사
                backtracking(row + 1); //check를 통과한다면 다음 행으로
            }
        }
    }
    public static boolean check(int row){
        for(int i=0;i<row;i++){
            //직선 공격
            if(A[i] ==  A[row]) return false;
            //대각선 공격
            if(Math.abs(row-i) == Math.abs(A[row]-A[i])) return false;
        }
        return true;
    }
}
