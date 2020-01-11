import java.io.IOException;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to OLX-parser!");
        System.out.println("Created by Denys Seredenko");
        System.out.println("----------------------------");
        System.out.println("Please input your CORRECT url address");
        String url = in.nextLine();
        System.out.println("Claim! Write how many pages do you want to parse?(Type a count)");
        System.out.println("We recommend you to write < 5");
        Integer pages = in.nextInt();
        System.out.println("Claim! Now choose your option");
      Victim rozetka = new Victim();
      rozetka.setWebUrl(url);
      for(int j = 0; j < pages; ++j){
              rozetka.setWebUrl(url + "?page=" + j+1);
          rozetka.checkUrl();
          rozetka.sitePrise();
          rozetka.getNames();
          rozetka.getUrls();
      }
    }
}
