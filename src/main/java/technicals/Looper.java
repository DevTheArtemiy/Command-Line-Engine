package technicals;

import technicals.exceptions.BreakLoopException;

import java.util.List;
import java.util.Scanner;
public class Looper {
    private boolean loopGoing;
    private String input;
    private List<String> separated;
    private final FunctionMediator mediator = new FunctionMediator();
    private final LineSeparator separator = new LineSeparator();
    private final Scanner sc = new java.util.Scanner(System.in);

    public void startLoop(){
        loopGoing = true;
        loop();
    }

    public void loop(){
        while(loopGoing){
            input = sc.nextLine();
            if(input.isBlank()){
                continue;
            }
            separated = separator.separate(input);
            String result = "";
            try{
                result = mediator.callFunction(separated);
            }catch(BreakLoopException _){stopLoop();}
            System.out.println(result);
        }
    }

    public boolean isLoopGoing() {
        return loopGoing;
    }

    public void stopLoop(){
        this.loopGoing = false;
    }
}
