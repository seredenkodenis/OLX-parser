import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
      Victim rozetka = new Victim();
      //rozetka.setParametr(".price");
      rozetka.setWebUrl("https://www.olx.ua/list/q-%D0%BC%D1%8B%D1%88%D0%BA%D0%B0/?search%5Bprivate_business%5D=private");
      rozetka.checkUrl();
      rozetka.sitePrise();
      //Victim ali  = new Victim("https://www.amazon.com/-/de/dp/B0742HZW9B/ref=lp_18332383011_1_1?srs=18332383011&ie=UTF8&qid=1578690362&sr=8-1");
      //ali.checkUrl();
    }
}
