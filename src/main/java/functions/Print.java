package functions;

import java.util.List;
import java.util.NoSuchElementException;

public class Print implements Command{
    @Override
    public String function(List<String> args) {
        String toPrint;

        try
        {
             toPrint = args.getFirst();
        }
        catch(NoSuchElementException e){
            return "Nothing to print.";
        }
        return toPrint;
    }
}

