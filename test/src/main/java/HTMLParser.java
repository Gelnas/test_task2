import lombok.AllArgsConstructor;
import lombok.Data;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;

/**
 * Класс для парсинга HTML файла и разбиения его на слова
 */
@Data
@AllArgsConstructor
public class  HTMLParser {
     private String directory;
     public String[] getContent(){
         Document doc = null;
         try {
             doc = Jsoup.parse(new File(directory), "UTF-8");
         } catch (IOException e) {
             e.printStackTrace();
         }
         String s = doc.getElementsByTag("html").text();
         String[] list = s.split("[^а-яА-Яa-zA-Z]");

         return list;
     }
}
