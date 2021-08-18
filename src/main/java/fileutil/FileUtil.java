package fileutil;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtil {


    public String util(String para) throws IOException {
        Properties properties = new Properties();
        FileInputStream fis = new FileInputStream("src/main/java/datadriven.properties");
        properties.load(fis);
        return switch (para) {
            case "email" -> properties.getProperty("email");
            case "password" -> properties.getProperty("password");
            case "confirm" -> properties.getProperty("confirm");
            case "lastname" -> properties.getProperty("lastname");
            case "firstname" -> properties.getProperty("firstname");
            case "phone" -> properties.getProperty("phone");
            case "address" -> properties.getProperty("address");
            case "city" -> properties.getProperty("city");
            case "zip" -> properties.getProperty("zip");
            case "modifiedlastname" -> properties.getProperty("modifiedlastname");
            case "modifiedfirstname" -> properties.getProperty("modifiedfirstname");
            case "firstsearchitem" -> properties.getProperty("firstsearchitem");
            case "secondsearchitem" -> properties.getProperty("secondsearchitem");
            case "thirdsearchitem" -> properties.getProperty("thirdsearchitem");
            case "fourthsearchitem" -> properties.getProperty("fourthsearchitem");
            default -> null;
        };
    }

}
