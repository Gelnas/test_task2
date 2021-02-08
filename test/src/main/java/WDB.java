import lombok.Data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

/**
 * Класс для заполнения базы данными о количестве уникальных слов и их вывода на экран
 */

@Data
public class WDB {

    private  final Connection conn = Conn.dbconnect();
    private int countAll = 0;

    /**
     * метод заполняющий БД данными о количестве уникальных слов и подсчитывающий количество слов
     */
    public void processing(){

        try {
            HTMLParser parser = new HTMLParser(Const.DIRECTORY);
            String[] list = parser.getContent();
            Statement statement = conn.createStatement();
            String del = "DELETE FROM " + Const.USER_TABLE + " w";
            statement.executeUpdate(del);
            System.out.println("Processing...");
            for (String word : list){
                String w = word.toUpperCase().trim();
                if(!w.equals("")){
                    countAll++;
                    String s =  "UPDATE " + Const.USER_TABLE + " SET " + Const.COUNT + " = count+1 WHERE " + Const.WORD + " = '" + w + "'";
                    int count =  statement.executeUpdate(s);
                    if(count == 0){
                        String str = "INSERT INTO " + Const.USER_TABLE + "(" + Const.WORD + ", " + Const.COUNT + ") VALUES ('" + w + "', 1)";
                        statement.executeUpdate(str);
                    }
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Data processed successfully");

    }

    /**
     * Метод, выводящий данные о количестве слов на экран
     */
    public void printData(){
        Statement statement = null;
        Map<String, Integer> map = new HashMap<>();
        try {
            statement = conn.createStatement();
            String query = "select id, word, count from words";
            ResultSet result = statement.executeQuery(query);
            while (result.next()) {
                map.put(result.getString(2), result.getInt(3));
            }
            map.entrySet().stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                    .forEach(System.out::println);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
