import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;

public class Victim {
    private String webUrl;
    private String priceParametr =".price > strong";
    private String nameParametr = ".rel > h3 > a > strong";
    private String urlParametr = ".rel > h3 > a[href]";
    private int[] pricesInt = new int[1000];
    private String[] names = new String[1000];
    private String[] urls = new String[1000];
    private Document document;
    int col  = 1;

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
                if(element.ownText().equals("Обмен")) continue;
                if(element.ownText().equals("Бесплатно")) continue;
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
            BufferedWriter writer = new BufferedWriter(new FileWriter(String.valueOf(col) + "_prices"));
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
        Elements elements = document.select(nameParametr);
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
            BufferedWriter writer = new BufferedWriter(new FileWriter(String.valueOf(col) + "_names"));
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

    public void getUrls(){
        Elements elements = document.select(urlParametr);
        int j = -1;
        for(Element element: elements){
            j++;
            urls[j] = String.format("%s", element.attr("abs:href"),element.text());
        }
        saveUrls(urls);
        col++;
    }

    public void saveUrls(String[] urls){
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(String.valueOf(col) + "_urls"));
            for(int i = 0; i < urls.length; ++i){
                if(urls[i] == null) break;
                bufferedWriter.write(i+1 + ") " + urls[i]);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
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

    public int[] getPricesInt() {
        return pricesInt;
    }

    public void setPricesInt(int[] pricesInt) {
        this.pricesInt = pricesInt;
    }
}
