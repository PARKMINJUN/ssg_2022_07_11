package com.ll.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.sun.tools.attach.VirtualMachine.list;

public class App {
    private Scanner sc; // private 한 이유 : 딱히 외부에 노출 될 필요없다.
    // Scanner sc = new Scanner(System.in);    // 상관은 없지만 보통 스캐너는 생성자로 많이 한다.
    private int wiseSayingsLastId;

    // private WiseSaying[] wiseSayings;        // 알아서 유연하게 늘어나길 원한다면 리스트로 바꿔야한다.
    private List<WiseSaying> wiseSayings;

    App() {
        sc = new Scanner(System.in);
        wiseSayingsLastId = 0;
    //  wiseSayings = new WiseSaying[100]; // 명언 리모콘을 100개 꽂을 수 있는 배열 객체 한개가 생성된 것
        wiseSayings = new ArrayList<>();
    }

    public void run() {     // run은 외부(여기서는 Main) 에서 호출할 수 있어야 하기 때문에 private 하면 안된다.
        System.out.println("== 명언 SSG ==");

        outer:  // outer 라벨을 달면 이하에 있는 전체문이 break 된다.
        while ( true ) {
            System.out.printf("명령)");
            String cmd = sc.nextLine();

//            String[] cmdBits = cmd.split("\\?", 2);                     //
//                                                                        //    ====> Rq클래스로 이동
//            String path = cmdBits[0];                                   //
//            String queryStr = cmdBits.length == 2 ? cmdBits[1] : null;  //

            Rq rq = new Rq(cmd);

            switch (rq.getPath()) {
                case "등록":
                    write();
                    break;
                case "목록":
                    list();
                    break;
                case "삭제":
                    remove(rq);
                    break;
                case "종료":
                    break outer;
            }
        }

        sc.close();
    }


    private void remove(Rq rq) {
        System.out.println("명언을 삭제합니다.");

        int id = rq.getIntParam("id", 0);

        if (id == 0) {
            System.out.println("id를 입력해주세요.");
            return;
        }

        System.out.printf("%d번 명언을 삭제합니다.\n", id);
    }

    private void list() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        for (int i = wiseSayings.size() - 1; i >= 0; i--) {
            WiseSaying wiseSaying = wiseSayings.get(i);
            System.out.printf("%d / %s / %s\n", wiseSaying.id, wiseSaying.content, wiseSaying.author);
        }
    }

    private void write() {
        int id = ++wiseSayingsLastId;
        System.out.printf("명언 : ");
        String content = sc.nextLine();
        System.out.printf("작가 : ");
        String author = sc.nextLine();

        WiseSaying wiseSaying = new WiseSaying(id, content, author);

        wiseSayings.add(wiseSaying);

        System.out.printf("%d번 명언이 등록되었습니다.\n", id);
    }
}