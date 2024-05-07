import java.util.Scanner;

public class FizzBuzz {

    //   Fizz Buzz
    public static void fizzBuzzCalc(){

        //Divisible by 5 - Print Fizz
        //Divisible by 3 - Print Buzz
        //Number divisible by both 5 and 3 - Print FizzBuzz
        //Number not divisible by both 5 and 3 - Print the same number on terminal

        Scanner scanner = new Scanner(System.in);

        System.out.print("Number: ");
        int inputNumber = Integer.parseInt(scanner.nextLine());
        String output = "";
        boolean divisibleByFive = ((inputNumber % 5) == 0);
        boolean divisibleByThree = ((inputNumber % 3) == 0);
        boolean divisibleByThreeAndFive = (((inputNumber % 3) == 0) && ((inputNumber % 5) == 0));
        if(divisibleByThreeAndFive)
            output = "FizzBuzz";
        else if (divisibleByFive)
            output = "Fizz";
        else if (divisibleByThree)
            output = "Buzz";
        else
            output = Integer.toString(inputNumber);
        System.out.print(output);
    }
}
