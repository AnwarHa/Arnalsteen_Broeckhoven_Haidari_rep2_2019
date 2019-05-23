package database.categoryDatabase;

import model.Category;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 *
 */
public class SerializableStrategyCategory implements CategoryDatabaseStrategy {
    protected String path = "database/categoryDatabase/category.txt";

    public SerializableStrategyCategory() {
    }



    public void writeData(Object o) {
        try {
            FileOutputStream fileOut = new FileOutputStream(path);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(o);
            objectOut.close();
            System.out.println("The "+o.getClass().getSimpleName()  +" was succesfully written to a file");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<Category> readData() {
        Object o = null;
        try {

            FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            o = objectIn.readObject();
            System.out.println(o.getClass().getSimpleName() + " has been read from the file");
            objectIn.close();


        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return (List<Category>) o;
    }
}
