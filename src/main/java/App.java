import javax.swing.*;
import java.sql.SQLOutput;
import java.util.Scanner;

public class App {
    public void run() {

        System.out.println("===명언 SSG===");

        outer:
        while (true){
            System.out.println("명령) ");
            Scanner sc = new Scanner(System.in);
            String cmd = sc.nextLine();

            switch (cmd){

                case"종료" :
                    break outer;
            }
        }


    }
}
