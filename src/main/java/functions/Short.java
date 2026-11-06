package functions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;

public class Short implements Command{
    private final static String shortnamesPath = "src/main/resources/commands_shortnames.txt";
    private HashMap<String,String> dict = new HashMap<>();
    @Override
    public String function(List<String> args) {
        String fullname = args.getFirst();
        String formatted = String.valueOf(fullname.charAt(0)).toUpperCase() + fullname.substring(1);
        List<String> lines = null;
        try{
            lines = Files.readAllLines(Path.of(shortnamesPath));
        }
        catch(IOException e){
            throw new RuntimeException(e);
        }

        dict = new HashMap<>();
        for(String line : lines){
            String[] split = line.split(" ");
            dict.put(split[1], split[0]);
        }

        String shortname =  dict.get(formatted);
        if(shortname == null){
            return "Could not find command fullname \"" + fullname + "\".";
        }
        return shortname;
    }
}
