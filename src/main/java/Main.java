import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
      Victim rozetka = new Victim();
      //rozetka.setParametr(".price");
      rozetka.setWebUrl("https://www.olx.ua/list/q-%D0%B0%D0%B9%D1%84%D0%BE%D0%BD-7/?search%5Bprivate_business%5D=private&search%5Bfilter_float_price%3Afrom%5D=2000&search%5Bfilter_float_price%3Ato%5D=5000&view=gallery");
      rozetka.checkUrl();
      //rozetka.SitePrise();
      //Victim ali  = new Victim("https://www.amazon.com/-/de/dp/B0742HZW9B/ref=lp_18332383011_1_1?srs=18332383011&ie=UTF8&qid=1578690362&sr=8-1");
      //ali.checkUrl();
    }
}
