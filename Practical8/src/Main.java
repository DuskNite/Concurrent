import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dusk on 29/5/2017.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        HashMap<String,Integer> hm = new HashMap<>();
        BufferedReader file;
        try {
             file = new BufferedReader(new FileReader("src/abstract.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Well fuck.");
            return;
        }
        String st = file.readLine();
        String[] split = st.split("[\\p{Punct}\\s]+");

        for(String s:split){
            if(hm.containsKey(s)){
                Integer j = hm.get(s)+1;
                hm.put(s,j);
            }
            else{
                hm.put(s,1);
            }
            System.out.print(s + " ");
        }

        for(Map.Entry<String, Integer> i : hm.entrySet()){
            String s = i.getKey();
            Integer j = i.getValue();
            System.out.println(s + ": " + j);
        }
    }
}
