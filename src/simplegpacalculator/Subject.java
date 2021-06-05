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
public class Subject {
    
    public static Scanner input = new Scanner(System.in);
    private String name;
    private String grade;
    private double gpa;
// overloading constructors example
    public Subject(String name, String grade) {
        this.name = name;
        this.grade = grade;
    }

    public Subject(String name) {
        this.name = name;
    }

    public Subject() {
        
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }
    
    public void enterGrade() {
        System.out.print("What grade did you get for " + name + ": ");
        this.grade = input.nextLine();
        double gradeNumber = gradeToGPA(grade);
        setGpa(gradeNumber);
    }
    
    public double gradeToGPA(String s) {
        double res = 0;
        switch (s.toUpperCase()) {
            case "A+":
                res = 4.00;
                break;
            case "A":
                res = 4.00;
                break;
            case "A-":
                res = 3.70;
                break;
            case "B+":
                res = 3.30;
                break;
            case "B":
                res = 3.00;
                break;
            case "B-":
                res = 2.70;
                break;
            case "C+":
                res = 2.30;
                break;
            case "C":
                res = 2.00;
                break;
            case "C-":
                res = 1.70;
                break;
            case "D":
                res = 1.30;
                break;
            case "E":
                res = 1.00;
                break;
            case "F":
                res = 0.00;
                break;
        }
        return res;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    
}
