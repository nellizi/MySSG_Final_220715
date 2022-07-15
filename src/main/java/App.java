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
            Rq rq = new Rq(cmd);
            String path = rq.getPath();

            switch (path){
                case"등록" :
                    write();
                    break;

                case"목록" :
                    list();
                    break;

                case"수정" :
                    modify(rq);
                    break;
                    
                case"삭제" :
                    remove(rq);
                    break;

                case"종료" :
                    break outer;
            }
        }
    sc.close();

    }

    private void modify(Rq rq) {
        System.out.println("명언을 수정합니다.");
        int paramId = rq.getIntParam("id",0);
        if(paramId == 0){
            return;
        }

        WiseSaying foundwiseSaying = findById(paramId);
        if( foundwiseSaying  == null){
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", paramId);
            return;
        }
        System.out.printf("명언 (기존) %s\n",foundwiseSaying.content);
        foundwiseSaying.content = sc.nextLine();
        System.out.printf("작가 (기존) %s\n",foundwiseSaying.author);
        foundwiseSaying.author = sc.nextLine();
        System.out.printf("%d번 명언이 수정되었습니다.\n",paramId);


    }

    private void remove(Rq rq){
        System.out.println("명언을 삭제합니다.");
        int paramId = rq.getIntParam("id",0);
        if(paramId == 0){
            return;
        }

        WiseSaying foundwiseSaying = findById(paramId);
        if( foundwiseSaying  == null){
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", paramId);
            return;
        }
        wiseSayings.remove(foundwiseSaying);
        System.out.printf("%d번 명언이 삭제되었습니다.\n",paramId);

    }

    private WiseSaying findById(int id) {
        for(WiseSaying wiseSaying:wiseSayings){
            if(wiseSaying.id == id){
              return wiseSaying;
            }
        }
        return null;
    }

    private void list() {
        System.out.println(" 번호 / 작가 / 명언 ");
        System.out.println(" ----------------- ");
        for(int i=wiseSayings.size()-1; i>=0; i--){
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
