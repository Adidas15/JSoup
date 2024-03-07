import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Scraper {
    public static void main(String[] args) {
        String url = "https://www.consumeraffairs.com/online/wayfair.html?page=3#scroll_to_reviews=true";
        
        try {
            
            Document document = Jsoup.connect(url).get();
            String title = document.title();
            System.out.println(title);
           // System.out.println(document);
            
          //Elements reviews = document.select("js-rvw rvw");
          //system.out.println(reviews);


         /*  for (Element element : document.getAllElements()) {
            System.out.println(element.nodeName() 
            + " " + element.ownText());

            }*/

           /*  Elements authors = document.select("span.rvw__inf-nm");
            for (Element author : authors) {
                System.out.println(author.text());
            }*/


            Elements reviews = document.select(".js-rvw");
            for (Element review : reviews) {
                System.out.println ("+++++++++++++++++++++++++++++++++++++++++++++");
                // Review review = new Review();
                System.out.println("author " + review.select(".rvw__inf-nm").text());
                // Re
                System.out.println("date " + review.select(".rvw__rvd-dt").text());
                System.out.println("location " + review.select(".rvw__inf-lctn").text());
               
                String ratingText = review.select("meta[itemprop=\"ratingValue\"]").toString();
                System.out.println("ratings " + ratingText.substring(ratingText.length()-3, (ratingText.length()-2)));

                 System.out.println("review " + review.select(".rvw__top-text").text());


            }

// first create file object for file placed at location 
    // specified by filepath 
    File file = new File("C:/Users/adida/.vscode/JSoupProject/reviews.csv"); 
    try { 
        // create FileWriter object with file as parameter 
        FileWriter outputfile = new FileWriter(file); 
  
        // create CSVWriter object filewriter object as parameter 
        CSVWriter writer = new CSVWriter(outputfile); 
       
  
        // adding header to csv 
        String[] header = { "Author", "Date", "Location", "Ratings", "Review" }; 
        writer.writeNext(header); 
  
        // add data to csv 
        String[] data1 = { "Aman", "10", "620" }; 
        writer.writeNext(data1); 
        String[] data2 = { "Suraj", "10", "630" }; 
        writer.writeNext(data2); 
  
        // closing writer connection 
        writer.close(); 



    } 
    catch (IOException e) { 
        // TODO Auto-generated catch block 
        e.printStackTrace(); 
    } 


          


          // Beginning of each review -  <div class="js-rvw rvw"; itemprop="reviews"
          // Review author - rvw__inf-nm
          // Review info location - rvw__inf-lctn
          // Review rating - rvw__rtg
          // Review date - rvw__rvd-dt
          // Actual review - rvw__top-text
          //

          /*   for (Element rev : reviews) {
                String user = rev.select(".a-profile-name").text();

                System.out.println(user);
            }*/
        }
        catch(IOException e) {
            System.out.println(e.getStackTrace());
        }

    }
}