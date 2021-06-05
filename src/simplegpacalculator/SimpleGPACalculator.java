/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplegpacalculator;

import java.util.Scanner;

/**
 *
 * @author lenovo
 */
public class SimpleGPACalculator {

    /**
     * @param args the command line arguments
     */
    
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        //create new gpa array
        GPA[] allGPA = new GPA[100];
        //displays intro
        introduction();
        //goes to main menu
        mainMenu(allGPA);
    }
    
    public static void introduction() {
        System.out.println("Welcome to SIMPLE GPA CALCULATOR");
        // put team member names
        System.out.println("Made by Amir Khalis, etc.");
    }
    
    public static void mainMenu(GPA[] arr) {
        System.out.println("1. Count GPA for new Semester"); // adds a new gpa object for respective sem
        System.out.println("2. Check GPA of Semester"); // check results for respective sem
        System.out.println("3. Check CGPA"); // check current cumulative gpa
        System.out.println("4. Add known GPA to list"); // add gpa of sem you already know to the list
        System.out.print("Enter number to choose command : ");
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                countGPASemester(arr);
                break;
            case 2:
                checkGPASemester(arr);
                break;
            case 3:
                checkCGPA(arr); //use of overloaded method
                break;
            case 4:
                addKnownGPA(arr);
                break;
            default:
                System.out.println("Error. Wrong input.");
                mainMenu(arr);
                break;
        }
        mainMenu(arr);
    }
    
    public static void countGPASemester(GPA[] arr) {
        System.out.print("Enter Semester :");
        int sem = input.nextInt();
        arr[sem - 1] = getGPAObject(sem);
        double totalgpa = 0;
        Subject[] arr2 = arr[sem - 1].getAllSubjects();
        int numOfSubjects = 0;
        for (Subject s : arr2) {
            if (s == null) {
                continue;
            }
            numOfSubjects++;
            s.enterGrade();
            totalgpa += s.getGpa();
        }
        //new gpa for sem
        double semgpa = totalgpa / (double) numOfSubjects;
        //sem - 1 because array starts at 0
        // create new gpa object, set gpa , set num of subs
        arr[sem - 1].setOverallgpa(semgpa);
        arr[sem - 1].setnumOfSubjects(numOfSubjects);
        System.out.println("\nThe following GPA is added for Semester " + sem);
        // use of overloaded method
        checkGPASemester(arr, sem);
        return;

    }
    // example of overloaded method checkGPASemester (takes in gpa[])
    public static void checkGPASemester(GPA[] arr) {
        System.out.print("Enter Semester :");
        int sem = input.nextInt();
        if (arr[sem - 1] == null) {
            System.out.println("\nThis semester does not exist\n");
            return;
        }
        arr[sem - 1].displayGPA(arr[sem - 1].getAllSubjects());
        return;
    }
    // example of overloaded method checkGPASemester (takes gpa[] and sem)
    public static void checkGPASemester(GPA[] arr, int sem) {
        if (arr[sem - 1] == null) {
            System.out.println("\nThis semester does not exist\n");
            return;
        }
        arr[sem - 1].displayGPA(arr[sem - 1].getAllSubjects());
        return;
    }
        
    public static void checkCGPA(GPA[] arr) {
        double sum = 0;
        int numgpa = 0;
        for (GPA g : arr) {
            if (g == null) {
                continue;
            }
            numgpa++;
            sum += g.getOverallgpa();
        }
        double cgpa = sum / (double) numgpa;
        System.out.printf("\nCurrent CGPA: %.2f\n", cgpa);
    }
    //example returning object GPA from a method
    // example of overloaded constructor for gpa (uses only int for sem)
    public static GPA getGPAObject(int sem) {
        //creates new gpa object and returns the gpa object
        GPA gpa = new GPA(sem);
        return gpa;
    }
    // example of returning object GPA from method
    // example 2 of overloaded constructor for gpa (uses int and double)
    public static GPA getKnownGPAObject(int sem, double pointer) {
        GPA gpa = new GPA(pointer, sem);
        return gpa;
    }
    
    public static void addKnownGPA(GPA[] arr) {
        System.out.println("Enter Semester:");
        int sem = input.nextInt();
        System.out.println("Enter GPA: ");
        double gpa = input.nextDouble();
        arr[sem - 1] = getKnownGPAObject(sem,gpa);
    }
}
