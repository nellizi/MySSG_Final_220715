import javax.swing.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    Scanner sc = new Scanner(System.in);
    int WiseSayingLastId = 0;
    List<WiseSaying> wiseSayings = new ArrayList<>();
    public void run() {

        System.out.println("===명언 SSG===");

        outer:
        while (true){
            System.out.println("명령) ");
            String cmd = sc.nextLine();

            switch (cmd){
                case"등록" :
                    write();
                    break;

                case"목록" :
                    list();
                    break;

                case"종료" :
                    break outer;
            }
        }
    sc.close();

    }

    private void list() {
        System.out.println(" 번호 / 작가 / 명언 ");
        System.out.println(" ----------------- ");
        for(int i=WiseSayingLastId-1; i>=0; i--){
            WiseSaying wiseSaying = wiseSayings.get(i);
            System.out.printf(" %d / %s / %s\n",wiseSaying.id, wiseSaying.author, wiseSaying.content);
        }
    }

    private void write() {
        int id = ++WiseSayingLastId;
        System.out.println("명언 : ");
        String content = sc.nextLine();
        System.out.println("작가 : ");
        String author = sc.nextLine();

        WiseSaying wiseSaying = new WiseSaying(id, content, author);
        wiseSayings.add(wiseSaying);
        System.out.printf("%d번 명언이 등록되었습니다.\n", id);
    }
}
