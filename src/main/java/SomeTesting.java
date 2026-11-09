public class SomeTesting {
    public static void main(String[] args) {
        int beginningNum = 10;
        for (int i = 0; i < 100; i++) {
           int randInt = (int)(Math.random() * (100 - beginningNum) + beginningNum);
            System.out.println(randInt);
        }
    }
}
