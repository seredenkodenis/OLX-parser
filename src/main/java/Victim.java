import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Victim {
    private String webUrl;
    private String priceParametr =".price > strong";
    private String urlParametr = ".rel > h3 > a > strong";
    private int[] pricesInt = new int[1000];
    private String[] names = new String[1000];
    private Document document;

    //Method for checking if url exists
    public void checkUrl() throws IOException {
            Document documentTest = Jsoup.connect(webUrl).get();
    }

    //Method for parsing prices
    public void sitePrise(){
        try {
            String[] prices = new String[1000];
            int j = -1;
            document = Jsoup.connect(webUrl).get();
            Elements elements = document.select(priceParametr);
            for(Element element: elements){
                ++j;
                prices[j] = element.ownText();
                prices[j] = prices[j].replaceAll(" ","");
                prices[j] = prices[j].replaceAll("грн.","");
                int localPrise;
                localPrise = Integer.parseInt(prices[j]);
                pricesInt[j] = localPrise;
               // System.out.println(pricesInt[j]);
            }

            //save prices to file
            savePrices(pricesInt);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Method for prices save
    public void savePrices(int[] pricesInt){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("prices"));
            for(int i = 0; i < pricesInt.length; ++i){
                if(pricesInt[i] == 0){
                    break;
                }
                writer.write(i+1 + ") " + pricesInt[i]);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Method for parsing titles
    public void getNames(){
        Elements elements = document.select(urlParametr);
        int i = -1;
        for(Element element: elements){
            i++;
            names[i] = element.ownText();
        }
        saveNames(names);
    }

    //Method for saving titles
    public void saveNames(String[] names){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("names"));
            for(int i = 0; i < names.length; ++i){
                if(names[i] == null) break;
                writer.write(i+1 + ") " + names[i]);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Construcor
    public Victim() {
    }

    //Getters and Setters
    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

}
