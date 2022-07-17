import java.util.ArrayList;
import java.util.List;

public class WiseSayingRepository {

    List<WiseSaying> wiseSayings ;
    public int WiseSayingLastId ;

    WiseSayingRepository(){
        wiseSayings = new ArrayList<>();
        WiseSayingLastId = 0;

    }

    public WiseSaying findById(int id) {
        for(WiseSaying wiseSaying:wiseSayings){
            if(wiseSaying.id == id){
                return wiseSaying;
            }
        }
        return null;
    }

}
