import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Victim {
    private String webUrl;
    private String parametr =".price > strong";
    private String priceString;
    private float price;
    private String[] prices = new String[1000];

    public void checkUrl() throws IOException {
            Document document = Jsoup.connect(webUrl).get();
        //document.select(".price > strong").forEach(System.out::println);
    }

    public void SitePrise(){
        try {
            int j = -1;
            Document document = Jsoup.connect(webUrl).get();
            Elements elements = document.select(parametr);
            for(Element element: elements){
                ++j;
                //System.out.println(element.ownText());
                prices[j] = element.ownText();
                System.out.println(prices[j]);
            }
            priceString = String.valueOf(document.select(parametr));

            int first = 0,last = 0;
            for(int i = 2; i < priceString.length(); ++i){
                if(priceString.charAt(i) == '>')first = i+1;
                if(priceString.charAt(i) == 'г'){
                    last = i;
                    break;
                }
            }
            priceString = priceString.substring(first,last);
           // System.out.println(priceString);
            price = Float.parseFloat(priceString.replaceAll(" ",""));
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    public String getPriceString() {
        return priceString;
    }

    public void setPriceString(String priceString) {
        this.priceString = priceString;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
