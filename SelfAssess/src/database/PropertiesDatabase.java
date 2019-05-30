package database;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDatabase {
    private Properties properties;
    private String propsFileName = System.getProperty("user.dir") + "\\src\\testDatabase\\evaluation.properties";
    FileOutputStream output;

    public PropertiesDatabase(String path) throws FileNotFoundException {
        properties = new Properties();
        setProperties(path);
        output = new FileOutputStream(propsFileName);
    }

    private String setFirstCharUppercase(String s) {
        String str = s.substring(0, 1).toUpperCase() + s.substring(1);
        return str;
    }

    private void setProperties(String path) {

        try {
            //load a properties file from class path, inside static method
            this.properties.load(new FileInputStream(path));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getDatabaseType() {
        return setFirstCharUppercase(properties.getProperty("fileType")) + "Database";
    }

    public String getEvaluationType() {
        return setFirstCharUppercase(properties.getProperty("evaluation"));
    }

    public boolean isTestIsCompleted() {
        return Boolean.parseBoolean(setFirstCharUppercase(properties.getProperty("testIsCompleted")));
    }

    public void setIsCompleted(Boolean isCompleted) throws IOException {
        this.properties.setProperty("testIsCompleted", isCompleted.toString());
    }

    public void setLastTestScores(String scores) throws IOException {
        this.properties.setProperty("lastTestScore", scores);
        this.properties.save(output, null);
    }

    public String getLastTestScores() {
        return this.properties.getProperty("lastTestScore");
    }
}
