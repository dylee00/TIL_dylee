package org.example;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Beakjoon_2162_practice {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();
        int N = sc.nextInt();
        //카드 저장 ->  add는 아래에 저장하는 것(queue -> fifo)
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }
        while (queue.size() > 1) {
            queue.poll(); //가장 위의 원소 제거
            int k = queue.poll();
            queue.add(k);
        }

    }
}
