package base;

/*
 *  UCF COP3330 Summer 2021 Assignment 19 Solution
 *  Copyright 2021 Brianne Juntunen
 */
import java.util.Scanner;

public class App {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        App myApp = new App();

        int weight = myApp.promptInt("weight in pounds");
        int height = myApp.promptInt("height in inches");

        double bmi = myApp.calculateBMI(weight, height);

        myApp.printOutput(bmi);
    }

    public void printOutput(double bmi){
        System.out.printf("Your BMI is %.1f.\n", bmi);
        System.out.print(generateResponse(bmi));
    }

    public String generateResponse(double bmi){
        if(bmi < 18.5){
            return "You are underweight. You should see your doctor.";
        } else if (bmi <= 25){
            return "You are within the ideal weight range.";
        } else {
            return "You are overweight. You should see your doctor.";
        }
    }

    public double calculateBMI(double weight, double height){
        return (weight / (height * height)) * 703;
    }

    public int promptInt(String prompt){
        System.out.printf("What is your %s? ", prompt);
        while(!in.hasNextInt()){
            System.out.println("Please enter a number. ");
            in.nextLine();
        }
        return Integer.parseInt(in.nextLine());
    }
}