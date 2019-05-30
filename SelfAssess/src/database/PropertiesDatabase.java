package database;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDatabase {
    private String databaseType,evaluationType;
    private boolean testIsCompleted;
    private String path;

    public PropertiesDatabase(String path) {
        setProperties(path);
    }

    private String setFirstCharUppercase(String s){
        String str = s.substring(0,1).toUpperCase()+s.substring(1);
        return str;
    }

    private void setProperties(String path){
        this.path = path;
        Properties prop = new Properties();
        try {
            //load a properties file from class path, inside static method
            prop.load(new FileInputStream(path));

            //get the property value
            this.evaluationType = setFirstCharUppercase(prop.getProperty("evaluation"));
            this.databaseType =  setFirstCharUppercase(prop.getProperty("fileType"));
            this.testIsCompleted = Boolean.parseBoolean( setFirstCharUppercase(prop.getProperty("testIsCompleted")));

        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getDatabaseType() {
        return databaseType+"Database";
    }

    public String getEvaluationType() {
        return evaluationType;
    }

    public boolean isTestIsCompleted() {
        return testIsCompleted;
    }

    public void setIsCompleted(Boolean isCompleted) {
        this.testIsCompleted = isCompleted;
    }
}
