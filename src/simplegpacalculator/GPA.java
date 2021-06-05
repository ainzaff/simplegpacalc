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
public class GPA {
    public static Scanner input = new Scanner(System.in);
    private double overallgpa;
    private int semester;
    private Subject[] allSubjects;
    private int numOfSubjects;
    
    // initializes subjects
    public static void initializeSubjects(Subject[] arr) {
        arr[0] = new Subject("Islam Kontemporari");
        arr[1] = new Subject("Digital Enterprise");
        arr[2] = new Subject("Real Time Operating System");
        arr[3] = new Subject("Object Oriented Programming");
        arr[4] = new Subject("Embedded System Communication");
        arr[5] = new Subject("Wireless Embedded Devices");
        arr[6] = new Subject("Final Year Project");
    }

    public int getnumOfSubjects() {
        return numOfSubjects;
    }

    public void setnumOfSubjects(int NumOfSubjects) {
        this.numOfSubjects = numOfSubjects;
    }
//overloading constructors example
    public GPA(double overallgpa, int semester) {
        this.overallgpa = overallgpa;
        this.semester = semester;
    }
    
    public GPA(int semester) {
        this.semester = semester;
        this.allSubjects = new Subject[20];
        initializeSubjects(this.allSubjects);
        
    }

    public Subject[] getAllSubjects() {
        return allSubjects;
    }

    public void setAllSubjects(Subject[] allSubjects) {
        this.allSubjects = allSubjects;
    }

    public double getOverallgpa() {
        return overallgpa;
    }

    public void setOverallgpa(double overallgpa) {
        this.overallgpa = overallgpa;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }
    
    public void displayGPA(Subject[] subs) {
        System.out.printf("GPA for Semester %d : %.2f\n", getSemester(), getOverallgpa());
        for (Subject s : subs) {
            if (s == null) {
                continue;
            }
            System.out.println(s.getName() + "\t\t\t\t: " + s.getGrade() + " Pointer : \t" + s.getGpa());
        }

     
        
        
    }
    
    






    
    
}
