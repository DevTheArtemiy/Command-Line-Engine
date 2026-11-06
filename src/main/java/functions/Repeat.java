package functions;

import org.apache.commons.cli.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Repeat implements Command{
    private final Options opts = new Options();
    private String separator = "\n";
    private final int optsNumber = 1;

    private final Map<String, String> lettersWhitespaces = Map.of(
            "\\n","\n",
            "\\t","\t",
            "\\s", " ",
            " ", " "
    );
    @Override
    public String function(List<String> args) {
        opts.addOption("o", false, "write strings in one line without without whitespaces.");
        opts.addOption("s", true, "write strings separated by the separator.");

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = null;
        try {
            cmd = parser.parse(opts, args.toArray(new String[1]));
        } catch (MissingArgumentException e) {
            return "Missing argument for the command.";
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        String sOptionValue = cmd.getOptionValue("s");

        if(cmd.hasOption("o")){
            separator = "";
        }

        if(sOptionValue!=null){
            separator = sOptionValue
                    .chars().filter(el -> el != '\'' && el != '"')
                    .boxed()
                    .map(Character::toString)
                    .reduce("",(prev, cur) -> prev + cur);

            String tmp = lettersWhitespaces.get(separator);
            if(tmp!=null){
                separator = tmp;
            }
            System.out.println("Separator: " + separator);
        }


        if(args.size() < 2){
            return "\"Repeat\" function must have 2 parameters";
        }
        int howMany;
        String what = args.getFirst();
        try{
        howMany = Integer.parseInt(args.get(1));
        }catch(NumberFormatException e){
            return "The second parameter must be an integer.";
        }

        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < howMany; i++){
            builder.append(what).append(separator);
        }
        return builder.toString();
    }
}
