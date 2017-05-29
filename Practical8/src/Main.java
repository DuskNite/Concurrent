import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dusk on 29/5/2017.
 */
public class Main {

    public static void main(String[] args){
        HashMap<String,Integer> hm = new HashMap<>();
        String st = "I have a red cat I like blue cat cats are nice";
        String[] split = st.split(" ");

        for(String s:split){
            if(hm.containsKey(s)){
                Integer j = hm.get(s)+1;
                hm.put(s,j);
            }
            else{
                hm.put(s,1);
            }
        }

        for(Map.Entry<String, Integer> i : hm.entrySet()){
            String s = i.getKey();
            Integer j = i.getValue();
            System.out.println(s + ": " + j);
        }
    }
}
