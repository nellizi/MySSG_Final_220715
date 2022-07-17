import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingController {


    List<WiseSaying> wiseSayings ;
    private int WiseSayingLastId ;
    private Scanner sc;
    WiseSayingController(Scanner sc){
        this.sc = sc;
        wiseSayings = new ArrayList<>();
        WiseSayingLastId = 0;


    }


    public void modify(Rq rq) {
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

    public void remove(Rq rq){
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

    public void list() {
        System.out.println(" 번호 / 작가 / 명언 ");
        System.out.println(" ----------------- ");
        for(int i=wiseSayings.size()-1; i>=0; i--){
            WiseSaying wiseSaying = wiseSayings.get(i);
            System.out.printf(" %d / %s / %s\n",wiseSaying.id, wiseSaying.author, wiseSaying.content);
        }
    }

    public void write() {
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



