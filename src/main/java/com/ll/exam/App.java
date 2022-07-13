package com.ll.exam;

import java.util.Scanner;

public class App {
    private Scanner sc; // private 한 이유 : 딱히 외부에 노출 될 필요없다.
    // Scanner sc = new Scanner(System.in);    // 상관은 없지만 보통 스캐너는 생성자로 많이 한다.
    private int wiseSayingsLastId;
    App() {
        sc = new Scanner(System.in);
        wiseSayingsLastId = 0;
    }

    public void run() {     // run은 외부(여기서는 Main) 에서 호출할 수 있어야 하기 때문에 private 하면 안된다.
        System.out.println("== 명언 SSG ==");

        outer:  // outer 라벨을 달면 이하에 있는 전체문이 break 된다.
        while ( true ) {
            System.out.printf("명령)");
            String cmd = sc.nextLine();

            switch(cmd) {
                case "등록":
                    write();
                    break ;

                case "종료":
                    break outer;    // break만 하면 "종료" 라는 출력문 만 꺼진다 그러므로 outer 라벨을 달아준다.
            }
        }

        sc.close();
    }

    private void write() {
        int id = ++wiseSayingsLastId;   // 처음에 0이지만 ++이 붙으면서 1로 시작
        System.out.printf("명언 : ");
        String content = sc.nextLine();
        System.out.printf("작가 : ");
        String author = sc.nextLine();

        System.out.printf("%d번 명언이 등록되었습니다.\n", id);

    }
}
