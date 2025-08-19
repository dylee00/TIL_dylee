package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beakjoon_12981_2 {
    static int checkout = 0;
    static int check[];
    static int check_part[];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader((new InputStreamReader(System.in)));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        //DNA문자열 저장할 배열의 크기
        int S = Integer.parseInt(st.nextToken());
        //부분 문자열 배열 크기
        int P = Integer.parseInt(st.nextToken());

        //result, checkout 선언
        int result = 0;


        //DNA문자열 배열 선언 후 저장
        char dna[] = new char[S];
        dna = bf.readLine().toCharArray();
        
        

        //check배열에 부분 문자열 받아서 개수 저장
        int check[] = new int[4];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < 4; i++) {
            check[i] = Integer.parseInt(st.nextToken());
            if (check[i] == 0) { //0이라면 확인할 필요 없기 때문에 Checkout++, checkout=4라면 result++
                checkout++;
            }

        }

        //부분 문자열 상태 배열 선언
        int check_part[] = new int[4];


        //부분 문자열까지 확인 -> check 배열과 비교 -> 부분 문자열 상태 배열에 저장 -> 메소드로 선언
        for (int i = 0; i < P; i++) {
            AddCheck(dna[i]); //문자열 저장 배열을 P번쨰 Index까지 확인 -> 부분 문자열 상태 배열에 저장
        }
        if (checkout == 4) {
            result++;
        }

        //슬라이딩 윈도우 알고리즘을 이용하여 이전 칸 제거, 다음 칸 확인
        for (int i = P; i < S; i++) {
            int j = i-P;
            RemoveCheck(dna[j]);
            AddCheck(dna[i]);
            if (checkout == 4) {
                result++;
            }
        }


    }

    private static void RemoveCheck(char c) {
        switch (c) {
            case 'A' -> {
                if (check_part[0] == check[0]) {
                    checkout--;
                }
                check_part[0]--;
                break;
            }
            case 'C' -> {
                if (check_part[1] == check[1]) {
                    checkout--;
                }
                check_part[1]--;
                break;
            }
            case 'G' -> {
                if (check_part[2] == check[2]) {
                    checkout--;
                }
                check_part[2]--;
                break;
            }
            case 'D' -> {
                if (check_part[3] == check[3]) {
                    checkout--;
                }
                check_part[3]--;
                break;
            }
        }
    }

    private static void AddCheck(char c) {
        switch (c) {
            case 'A' -> {
                check_part[0]++;
                if (check_part[0] == check[0]) {
                    checkout++;
                }
                break;
            }
            case 'C' -> {
                check_part[1]++;
                if (check_part[1] == check[1]) {
                    checkout++;
                }
                break;
            }
            case 'G' -> {
                check_part[2]++;
                if (check_part[2] == check[2]) {
                    checkout++;
                }
                break;
            }
            case 'D' -> {
                check_part[3]++;
                if (check_part[3] == check[3]) {
                    checkout++;
                }
                break;
            }
        }
    }


}
