package functions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Manual implements Command{
    private final static String  docRootPath = "src/main/resources/commands_documentation";
    private final static String docFileName = "documentation.txt";
    @Override
    public String function(List<String> args) {
        String command = args.getFirst();
        String completePath = docRootPath + "/" + command.toLowerCase() + "/" + docFileName;

        byte[] bytes = null;
        try{
            bytes = Files.readAllBytes(Path.of(completePath));
        }
        catch(IOException e){
            return "Command \"" + command + "\" was not found or there is no manual for the command.\n" +
                    "You can only search manuals using full names of commands.";
        }

        return new String(bytes, StandardCharsets.UTF_8);
    }
}
