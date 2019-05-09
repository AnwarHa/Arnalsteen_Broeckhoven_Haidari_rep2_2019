package testDatabase;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

/**
 *
 */
public abstract class SerializableStrategy implements DatabaseStrategy {
    protected String path;
    public SerializableStrategy() {
    }

    public void writeData(Object o) {
        try {
            FileOutputStream fileOut = new FileOutputStream(path);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(o);
            objectOut.close();
            System.out.println("The "+o.getClass()  +" was succesfully written to a file");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Object readData() {
        Object o = null;
        try {

            FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            o = objectIn.readObject();
            System.out.println("The Object has been read from the file");
            objectIn.close();


        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return o;
    }
}
