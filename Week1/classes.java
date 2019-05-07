/**
 * Classes
 * Author:      Pawel Wodyk
 * Student ID:  B00122935
 * Written on:  21/01/19
 * Description:
 * 	This code defines classes for Written Exercise
 */

class ComputerMonitor {
    
    String manufacturer, model, panelType;
    int[][] dimentsions = new int[2][2];
    int[] resolution = new int[2];
    short[] aspectRatio = new short[2];
    int brigtness, refreshRate, responseTime;
    boolean hasSpeakers;

    public static void displayFrame(){}
    public static void togglePower(){}

}

class Car {
    
    String make, year, engine, type;
    long millage;	
    
    public static void startEngine(){}
    public static void makeATurn(int degrees){}
}

class Video {

    String title, director, genre, yearReleased;
    String[] actors;
    int[] resolution = new int[2];
    
    public static void playVideo(){}
    public static void changeVolume(int volLevel){}

}

class Employee {
    String name, companyLogin;
    byte age;
    int experienceYears, salary;
    
    public static void doWork(){}
    public static void goToLunch(int minutesBreak){}
} 