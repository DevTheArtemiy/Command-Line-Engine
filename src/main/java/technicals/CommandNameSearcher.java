package technicals;

import technicals.exceptions.SearchFailedException;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CommandNameSearcher {
    private final List<String> lines;
    private final HashMap<String,String> dict;
    private final String URLScheme = "file:///";
    private final String resFileLocation = "src/main/resources/commands_shortnames.txt";

    public CommandNameSearcher() {
        try {
            lines = Files.readAllLines(
                    Paths.get(resFileLocation)
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        dict = new HashMap<>();
        for(String line : lines){
            String[] split = line.split(" ");
            dict.put(split[0], split[1]);
        }
    }

    public String search(String shortname){
        String value = dict.get(shortname);
        if(value==null){
            throw new SearchFailedException("");
        }
        return value;
    }
}
