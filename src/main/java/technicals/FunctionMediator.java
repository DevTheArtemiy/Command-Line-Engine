package technicals;

import functions.Command;
import technicals.exceptions.SearchFailedException;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class FunctionMediator {
    private Command functionInstance;
    private final String functionsPackagePath = "functions";
    private final CommandNameSearcher searcher = new CommandNameSearcher();

    public String callFunction(List<String> line){
        String first = line.getFirst();
        String command = String.valueOf(
                first.charAt(0)
        )
                .toUpperCase() +
                 first.substring(1);
        try {
            Class<?> clazz = null;
            try{
            clazz = Class.forName(functionsPackagePath + "." + command);
            }catch(ClassNotFoundException e){
                try{
                    command = searcher.search(first);
                    clazz = Class.forName(functionsPackagePath + "." + command);
                }catch(SearchFailedException | ClassNotFoundException _){
                    return "Command \""+first+"\" was not recognized.";
                }
            }
            functionInstance = (Command) clazz.getConstructor().newInstance();
        } catch (  NoSuchMethodException
                 | IllegalAccessException
                 | InvocationTargetException
                 | InstantiationException e) {
            throw new RuntimeException(e);
        }
    return functionInstance.function(line.subList(1,line.size()));
    }


}
