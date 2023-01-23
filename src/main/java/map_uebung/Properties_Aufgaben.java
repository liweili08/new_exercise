package map_uebung;

import java.io.FileInputStream;
import java.util.Properties;

public class Properties_Aufgaben {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        FileInputStream fis = new FileInputStream("jdbc.properties");
        properties.load(fis);//加载流对应的文件

        String name = properties.getProperty("name");
        String password = properties.getProperty("password");

        System.out.println("name = " + name + ", password = " + password);
    }
}
