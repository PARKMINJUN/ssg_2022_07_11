package com.ll.exam;

import java.util.Scanner;

public class App {
    public void run() {
        Scanner sc = new Scanner(System.in);

        System.out.println("== 명언 SSG ==");

        outer:  // outer 라벨을 달면 이하에 있는 전체문이 break 된다.
        while ( true ) {
            System.out.printf("명령)");
            String cmd = sc.nextLine();

            switch(cmd) {
                case "종료":
                    break outer;    // break만 하면 "종료" 라는 출력문 만 꺼진다 그러므로 outer 라벨을 달아준다.
            }
        }

        sc.close();
    }
}
