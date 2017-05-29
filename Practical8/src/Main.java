import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dusk on 29/5/2017.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        //Define needed variables here.
        HashMap<String,Integer> hm = new HashMap<>();
        HashMap<String,Integer> hmTotal = new HashMap<>();
        ArrayList<HashMap<String,Integer>> hmlist = new ArrayList<>();
        ArrayList<FileReader> frlist = new ArrayList<>();


        //Read the 10 files here.
        frlist.add(new FileReader("src/abstract1.txt"));
        frlist.add(new FileReader("src/abstract2.txt"));
        frlist.add(new FileReader("src/abstract3.txt"));
        frlist.add(new FileReader("src/abstract4.txt"));
        frlist.add(new FileReader("src/abstract5.txt"));
        frlist.add(new FileReader("src/abstract6.txt"));
        frlist.add(new FileReader("src/abstract7.txt"));
        frlist.add(new FileReader("src/abstract8.txt"));
        frlist.add(new FileReader("src/abstract9.txt"));
        frlist.add(new FileReader("src/abstract10.txt"));

        BufferedReader file;

        //For each file, get a string and split it.
        for(FileReader fr: frlist){
            file = new BufferedReader(fr);

            String st = file.readLine();
            String[] split = st.split("[\\p{Punct}\\s]+");

            //For each string, check both hm and hmTotal for the word, and either create a new object, or if the key already exists, increase the key value by 1.
            for(String s:split){
                if(hm.containsKey(s)){
                    Integer j = hm.get(s)+1;
                    hm.put(s,j);
                }
                else{
                    hm.put(s,1);
                }

                if(hmTotal.containsKey(s)){
                    Integer j = hmTotal.get(s)+1;
                    hmTotal.put(s,j);
                }
                else{
                    hmTotal.put(s,1);
                }
            }

            //Now clone the completed hm and clear it. Admittedly, it can be a little cleaner, but it probably doesn't matter that much.
            //hmTotal is not cleared for future use.
            hmlist.add((HashMap<String,Integer>)hm.clone());
            hm.clear();
        }

        //For each hashmap, for each entry in the hashmap...
        int z = 0;
        for(HashMap<String,Integer> hash : hmlist) {
            z++;
            System.out.println("Patent " + z);
            System.out.println();
            for (Map.Entry<String, Integer> i : hash.entrySet()) {
                String s = i.getKey();
                Integer j = i.getValue();
                System.out.println(s + ":" + j);
            }
            System.out.println();
            System.out.println("-------------------------------------");
        }
    }
}
