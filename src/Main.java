import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void prob1() throws UnsupportedOperationException, InputMismatchException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input of score in the range of 0 to 100");
        int score = 0;
        try{
            score = scanner.nextInt();
        }
        catch (InputMismatchException e){
            System.out.println("Try int number");
            prob1();
        }
        if(score >= 0 && score <= 100){
            System.out.println("score is " + score);
        }else{
            throw new UnsupportedOperationException("Score is not in the range of 0 to 100");
        }
    }
    public static void main(String[] args) {
        try {
            prob1();
        }
        catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
            prob1();
        }
    }
}