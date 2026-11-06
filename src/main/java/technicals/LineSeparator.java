package technicals;

import java.util.Arrays;
import java.util.List;

public class LineSeparator {
    public List<String> separate(String s){
        return Arrays.stream(s.split(" ")).toList();
    }
}
