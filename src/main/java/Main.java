import sun.applet.AppletResourceLoader;

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
        int pages = in.nextInt();
        System.out.println("Please wait, we are counting!");
        long medium = 0;
        int j;

        Victim rozetka = new Victim();
        rozetka.setWebUrl(url);
        for(j = 0; j < pages; ++j){
            rozetka.setWebUrl(url + "?page=" + j+1);
            rozetka.checkUrl();
            rozetka.sitePrise();
            int[] prices =  rozetka.getPricesInt();
            for (int price : prices) {
                if (price == 0) break;
                medium += price;
            }
            rozetka.getNames();
            rozetka.getUrls();
        }
        medium /= (j*44);
        System.out.println("Some statistic for you!");
        System.out.println("-----------------------");
        System.out.println("Medium of your product is: " + medium + " grn.");
    }
}
