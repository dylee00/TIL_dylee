package org.example;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Baekjoon_1427 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String number = input.nextLine();
        int length = number.length();
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
         if(o1 < o2) return 1;
         else return -1;
        });

        for(int i = 0; i < length; i++){
            Character c = number.charAt(i);
            int num = c - '0';
            pq.add(num);
        }

        for(int i = 0; i < length; i++){
            System.out.println(pq.poll());
        }
    }
}
