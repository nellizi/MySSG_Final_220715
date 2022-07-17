
import java.util.Scanner;



public class App {

    Scanner sc = new Scanner(System.in);

    public void run() {

        WiseSayingController wiseSayingController = new WiseSayingController(sc);

        System.out.println("===명언 SSG===");

        outer:
        while (true) {
            System.out.println("명령) ");
            String cmd = sc.nextLine();
            Rq rq = new Rq(cmd);
            String path = rq.getPath();

            switch (path) {
                case "등록":
                    wiseSayingController.write();
                    break;

                case "목록":
                    wiseSayingController.list();
                    break;

                case "수정":
                    wiseSayingController.modify(rq);
                    break;

                case "삭제":
                    wiseSayingController.remove(rq);
                    break;

                case "종료":
                    break outer;
            }
        }
        sc.close();

    }
}
