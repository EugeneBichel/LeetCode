import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class UnmodifialbeMapTest {
    public static void main(String[] args) {

        Map<Integer, String> source = new HashMap<>();
        source.put(1, "a");
        source.put(2, "b");
        source.put(3, "c");
        source.put(4, "d");


        Map<Integer, String> sink = Collections.unmodifiableMap(source);

        //sink.put(5, "e");

        HashSet<String> set = new HashSet<>();
        set.add("a");

        System.out.println(set.toString());
    }
}
