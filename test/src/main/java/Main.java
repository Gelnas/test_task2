import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class Main {

    public static void main(String[] args) throws  Exception{

        try {
            download(Const.URLD, Const.DIRECTORY);
        } catch (IOException e) {
            e.printStackTrace();
        }
        WDB wdb = new WDB();
        wdb.processing();
        System.out.println("Всего слов: " + wdb.getCountAll());
        wdb.printData();
}

    /**
     * Mетод для скачивания HTML страницы
     * @param urlToSave - URL для скачивания файла
     * @param directory - каталог, в который нужно скачать файл
     * @throws IOException
     */
    public  static void download(String urlToSave, String directory) throws IOException {
        URL url = new URL(urlToSave);
        int count = 0;
        byte[] buffer = new byte[1024];
        BufferedInputStream bufferedInputStream = new BufferedInputStream(url.openStream());
        FileOutputStream fileOutputStream = new FileOutputStream(directory);
        while ((count = bufferedInputStream.read(buffer, 0, 1024)) != -1){
            fileOutputStream.write(buffer, 0, count);
        }
        fileOutputStream.close();
        bufferedInputStream.close();
    }
}
