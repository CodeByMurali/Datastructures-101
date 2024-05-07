import java.text.NumberFormat;
import java.util.Scanner;

public class CalculateMortgate {

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
}
