package database;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDatabase {
    private Properties properties;

    public PropertiesDatabase(String path) {
        properties = new Properties();
        setProperties(path);
    }

    private String setFirstCharUppercase(String s){
        String str = s.substring(0,1).toUpperCase()+s.substring(1);
        return str;
    }

    private void setProperties(String path){

        try {
            //load a properties file from class path, inside static method
            this.properties.load(new FileInputStream(path));
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getDatabaseType() {
        return setFirstCharUppercase(properties.getProperty("fileType"))+"Database";
    }

    public String getEvaluationType() {
        return setFirstCharUppercase(properties.getProperty("evaluation"));
    }

    public boolean isTestIsCompleted() {
        return Boolean.parseBoolean( setFirstCharUppercase(properties.getProperty("testIsCompleted")));
    }

    public void setIsCompleted(Boolean isCompleted) {
        this.properties.setProperty("testIsCompleted",isCompleted.toString());
    }

    public void setLastTestScores(String scores){
        this.properties.setProperty("lastTestScore", scores);
    }

    public String getLastTestScores(){
        return this.properties.getProperty("lastTestScore");
    }
}
