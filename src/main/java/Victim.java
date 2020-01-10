import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class Victim {
    private String webUrl;
    private String parametr;
    private String priceString;
    private float price;

    public void checkUrl() throws IOException {
            Document document = Jsoup.connect(webUrl).get();
        document.select(".price").forEach(System.out::println);
    }

    public void SitePrise(){
        try {
            Document document = Jsoup.connect(webUrl).get();
            priceString = String.valueOf(document.select(parametr));
        } catch (IOException e) {
            e.printStackTrace();
        }
        int first = 0,last = 0;
        for(int i = 2; i < priceString.length(); ++i){
            if(priceString.charAt(i) == '>')first = i+1;
            if(priceString.charAt(i) == '<'){
                last = i;
                break;
            }
        }
        priceString = priceString.substring(first,last);
        price = Float.parseFloat(priceString.replaceAll("&nbsp;",""));
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
