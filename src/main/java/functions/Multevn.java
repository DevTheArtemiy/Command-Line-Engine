package functions;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class Multevn implements Command{
    private final Integer startSleepTime = 200;
    private final Integer beginningNum = 10;
    @Override
    public String function(List<String> args) {
        System.out.println("Get ready to solve.");
        try {
        Thread.sleep(startSleepTime);
        System.out.println("3");
        Thread.sleep(startSleepTime);
        System.out.println("2");
        Thread.sleep(startSleepTime);
        System.out.println("1");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Scanner in = new Scanner(System.in);
        String userInput = null;

        boolean passed = false;
        int intInput = 0;
        int randInt = 0;
        int answer = 0;
        do{
            randInt = (int)(Math.random() * (100 - beginningNum) + beginningNum);
            answer = randInt * 11;
            String msg = randInt + " x 11";
            System.out.println(msg);

            passed = false;
            while(!passed){
                userInput = in.nextLine();
                if(userInput.equals("e") || userInput.equals("skp")) passed = true;
                else try{
                    intInput = Integer.parseInt(userInput);
                    if(intInput == answer){
                        System.out.println("CORRECT");
                    }else{
                        throw new IllegalArgumentException();
                    }
                    passed = true;
                }catch(NumberFormatException _){
                    System.out.println("Only numbers allowed! Try again.");
                    System.out.println(msg);
                }
                catch(IllegalArgumentException _){
                    System.out.println("WRONG!");
                    System.out.println(msg);
                }
            }
        }while(!userInput.equals("e"));

        return "Finished.";
    }
}
