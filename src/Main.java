import DataStructures.Array;

import java.text.NumberFormat;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

//       Mortgage calc
//       calculateMortgage();

//       FizzBuzz
//       fizzBuzzCalc();

        Array numbers = new Array(3);
        numbers.insert(2);
        numbers.insert(3);
        numbers.insert(4);
        numbers.insert(5);
        numbers.insert(6);
        numbers.insert(7);
        numbers.removeAt(1);
        numbers.print();
    }


    public static void calculateMortgage(){

        final byte months = 12;
        final byte percent = 100;

//        Mortgage calculator

        int principal = (int) getValidNumber("principal", 1000, 1000000);
        float annualInterestRate = getValidNumber("annualInterestRate", 0,30);
        byte periodInYears = (byte) getValidNumber("Period (Years)", 1,30);

        double interestRatePerMonth = (annualInterestRate/months/percent);

        //Period in months
        byte numberOfMonths = (byte) (periodInYears*months);

        double numerator = (Math.pow((1 + interestRatePerMonth), numberOfMonths))*interestRatePerMonth;

        double denominator = (Math.pow((1+interestRatePerMonth), numberOfMonths))-1;

        //Mortgage calculation
        double mortgagePerMonth =  (numerator/denominator)*principal;

        System.out.println("MORTGAGE");
        System.out.println("------");
        System.out.println("Monthly payments: " + NumberFormat.getCurrencyInstance().format(mortgagePerMonth));
        System.out.println();

        //PaymentSchedule
        printPaymentSchedule(principal, interestRatePerMonth, numberOfMonths);

    }

    public static void printPaymentSchedule( int principal,  double interestRatePerMonth, byte numberOfMonths){
        double paymentScheduleAmt = 0;

        System.out.println("PAYMENT SCHEDULE");
        System.out.println("------");
        int numberOfPaymentsMade = 0;

        while (numberOfMonths != 0){
            double numerator = ((Math.pow((1 + interestRatePerMonth), numberOfMonths)) - (Math.pow((1 + interestRatePerMonth), numberOfPaymentsMade))) * principal;
            double denominator = (Math.pow((1 + interestRatePerMonth), numberOfMonths)) - 1;
            paymentScheduleAmt = numerator/denominator;
            System.out.println(NumberFormat.getCurrencyInstance().format(paymentScheduleAmt));
            numberOfMonths --;
        }
    }

    public static float getValidNumber(String entity, int lowerLimit, int upperLimit){

        Scanner scanner = new Scanner(System.in);
        float entityValue;

        while (true){
            System.out.print(entity + " : ");
            entityValue = scanner.nextFloat();
            if(!(entityValue >= lowerLimit && entityValue <= upperLimit)) {
                System.out.println("invalid input - Enter a number between " + lowerLimit + " and " + upperLimit);
                System.out.print(entity + " : ");
                entityValue = scanner.nextInt();
            }
            break;
        }

        return entityValue;
    }





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