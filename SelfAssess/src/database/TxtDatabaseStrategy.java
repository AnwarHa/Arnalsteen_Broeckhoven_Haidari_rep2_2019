package database;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.DomainException;
import model.ListItem;
import org.apache.commons.io.FileUtils;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public abstract class TxtDatabaseStrategy implements DatabaseStrategy {
    protected File file;
    protected List<ListItem> objects;

    public TxtDatabaseStrategy(String path) {
        setFile(path);
        setObjects();
        readData();
    }

    private void setObjects(){
        this.objects = FXCollections.observableArrayList(new ArrayList<>());
    }

    public void changeFile(String path) {
        setFile(path);
    }

    @Override
    public final List<ListItem> readData() {
        stringToObject(read());
        return this.objects;
    }

    @Override
    public final void writeData(List<ListItem> objects) {
        writeString(objectToStringListInMap());
        System.out.println("data succesfully written to file");
    }

    protected abstract HashMap<Integer,List<String>> objectToStringListInMap();

    protected void setFile(String path) {
        try {
            this.file = new File(path);
        }catch (Exception ex){
            ex.printStackTrace();
            throw new DomainException("can not read file");
        }
    }

    protected void writeString(HashMap<Integer,List<String>> data){
        String out = "";
        try{
            System.out.println(this.file.getPath());
            FileOutputStream outputStream = new FileOutputStream(this.file.getPath());
            List<String> stringsList = new ArrayList<>();
            for(Map.Entry<Integer,List<String>> entry : data.entrySet()){
            List<String> strings = entry.getValue();

                for(String s : strings){
                    if(strings.indexOf(s)==strings.size()-1){
                        out = out+s+'\n';
                    }else {
                        out = out+s + ",";
                    }
                }

            }
            System.out.println(out);
            byte[] strBytes = out.getBytes();
            outputStream.write(strBytes);
            outputStream.close();
        }catch(Exception e){
            throw new DatabaseException("can not write to txt-file: "+e.getClass().getSimpleName());
        }
    }


    protected HashMap<Integer, List<String>> read(){

        boolean isSuccesful = true;
        HashMap<Integer,List<String>> allStrings = new HashMap<>();
        ArrayList<String> strings = new ArrayList<>();
        try {
            System.out.println(FileUtils.readFileToString(this.file, StandardCharsets.UTF_8));
            Scanner scan = new Scanner(FileUtils.readFileToString(this.file, StandardCharsets.UTF_8));
            scan.useDelimiter("\n");
            int i = 0;
            while (scan.hasNextLine()) {
                System.out.println("i= "+ i);
                strings.clear();
                Scanner line = new Scanner(scan.nextLine());
                line.useDelimiter(",");
                while(line.hasNext()){
                    String next = line.next();
                    System.out.println( "next string= " + next);
                    strings.add(next);
                }
                System.out.println("waarde van array= "+strings.get(0)+"(0) en "+strings.get(1)+" (1)");
                allStrings.put(i,strings);
                i++;
            }

        } catch (Exception e) {
            isSuccesful = false;
            throw new DatabaseException("Error when trying to read txt file.");
        }finally{
            System.out.println("Succesfully scanned = "+ isSuccesful+ " (number of objects= "+allStrings.size()+")");
        }
        return allStrings;
    }
    protected abstract void stringToObject(HashMap<Integer,List<String>> readedMap);
}
