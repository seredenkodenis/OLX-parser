import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Victim {
    private String webUrl;
    private String parametr =".price > strong";
    private int[] pricesInt = new int[1000];


    public void checkUrl() throws IOException {
            Document document = Jsoup.connect(webUrl).get();
    }


    public void sitePrise(){
        try {
            String[] prices = new String[1000];
            int j = -1;
            Document document = Jsoup.connect(webUrl).get();
            Elements elements = document.select(parametr);
            for(Element element: elements){
                ++j;
                prices[j] = element.ownText();
                prices[j] = prices[j].replaceAll(" ","");
                prices[j] = prices[j].replaceAll("грн.","");
                int localPrise;
                localPrise = Integer.parseInt(prices[j]);
                pricesInt[j] = localPrise;
                System.out.println(pricesInt[j]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    public void savePrices(int[] pricesInt){

    }

    //Constructor
    public Victim(String webUrl) {
        this.webUrl = webUrl;
    }

    public Victim() {
    }

    //Getters and Setters
    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public String getParametr() {
        return parametr;
    }

    public void setParametr(String parametr) {
        this.parametr = parametr;
    }


}