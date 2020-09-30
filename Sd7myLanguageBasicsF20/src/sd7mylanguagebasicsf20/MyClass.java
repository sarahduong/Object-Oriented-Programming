/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sd7mylanguagebasicsf20;

// lines 9-10 retrieved from  https://compiler.javatpoint.com/opr/test.jsp?filename=CurrentDateTimeExample1
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Sarah Duong
 */
public class MyClass
{
    private char c1 = 'a';
    private char c2 = 97;
    private short qualityScore = 89;
    private int months = 12;
    private float miles = (float)1023.5; // cast float
    private float days = 365;
    private boolean sunny = true;
    private boolean warm = false;

    LocalDateTime now = LocalDateTime.now();
    private int hour = now.getHour();
    private int minute = now.getMinute();

    private double grade = Math.random() * 4; // adapted from https://codippa.com/how-to-generate-a-random-number-with-in-a-range-in-java/

    private String greeting = "Hello";
    private String myPawPrint = "sd7my";
        
    public void setChar1(char c1)
    {
        this.c1 = c1;
    }
    public char getChar1()
    {
        return this.c1;
    }
    
    public void setChar2(char c2)
    {
        this.c2 = c2;
    }    
    public char getChar2()
    {
        return this.c2;
    }
    
    public void setQualityScore(short qualityScore)
    {
        this.qualityScore = qualityScore;
    }
    public short getQualityScore()
    {
        return this.qualityScore;
    }    
    
    public void setMonths(int months)
    {
        this.months = months;
    }
    public int getMonths()
    {
        return this.months;
    }
    
    public void setMiles(int miles)
    {
        this.miles = miles;
    }    
    public float getMiles()
    {
        return this.miles;
    }
    
    public void setDays(float days)
    {
        this.days = days;
    }    
    public float getDays()
    {
        return this.days;
    }
    
    public void setSunnyWeather(boolean sunny)
    {
        this.sunny = sunny;
    }
    public boolean getSunnyWeather()
    {
        return this.sunny;
    }
    
    public void setWarmWeather(boolean warm)
    {
        this.warm = warm;
    }  
    public boolean getWarmWeather()
    {
        return this.warm;
    }
    
    public void setGrade(double grade)
    {
        this.grade = grade;
    }
    public double getGrade()
    {
        return this.grade;
    }
        
    void invokeMe()
    {
        System.out.printf("%s, my pawprint is %s and today's date is: ", greeting, myPawPrint); // formatting referenced from https://stackoverflow.com/questions/41660150/how-to-print-the-value-of-variable-in-java
        
        // lines 86-89 retrieved and edited from https://compiler.javatpoint.com/opr/test.jsp?filename=CurrentDateTimeExample1
        DateTimeFormatter dtf = 
        DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mma"); // time formatting referenced from https://howtodoinjava.com/java/date-time/format-time-12-hours-pattern/
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
    } 
    
    void compChars()
    {               
        // lines 32-40 adapted from https://www.javatpoint.com/post/java-character-compare-method
        int compareOneTwo = Character.compare(c1, c2);  
        if (compareOneTwo == 0)
        {  
            System.out.println(c1 + " and " + c2  + " are the same.");  
        }
        else if (compareOneTwo > 0) 
        {  
            System.out.println(c1 + " and " + c2 + " are NOT the same.\n");
        }
    }
    
    void findQualityScore()
    {
        // Quality score
        if (qualityScore >= 0 && qualityScore <=75)
        {
            System.out.println("The quality is bad.");
        }
        else
        {
            System.out.println("Good Quality.");
        }
    }
    
    void calculateDCM()
    {
        // calculate daily car mileage
        float dcm = (float)(miles * months)/((float)(days));
        
        System.out.println("My average daily car mileage = " + String.format("%.2f", dcm)); // float truncating formatting adapted from https://stackoverflow.com/questions/11701399/round-up-to-2-decimal-places-in-java/11701415
    }
    
    void findWeather()
    {
        // sunny and warm
        if((sunny == true && warm == true) || (sunny == false && warm == true))
        {
            if(sunny == true && warm == true)
            {
                System.out.println("Go swimming at beach");
            }
            if(sunny == false && warm == true)
            {
                System.out.println("Go for a drive.");
            }
        }
        else
        {
            System.out.println("Stay home and code.");
        }
    }
    
    void findTimeOfDay()
    {
        switch(hour) 
        {
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10:
                System.out.printf("The current time is %02d:%02dAM in the MORNING", hour, minute);
                break;
            case 11: 
            case 12: 
            case 13: 
            case 14: 
            case 15: 
            case 16: 
                if(hour > 12)
                    hour = hour-12;
                System.out.printf("The current time is %02d:%02d", hour, minute);
                if(hour != 11)
                    System.out.println("PM in the AFTERNOON.");
                else 
                    System.out.println("AM in the AFTERNOON.");
                break;              
            case 17: 
            case 18: 
            case 19: 
            case 20: 
            case 21: 
            case 22:
                hour = hour-12;
                System.out.printf("The current time is %02d:%02dPM in the EVENING.\n", hour, minute);               
                break;
            case 23:
            case 0:
            case 1: 
            case 2: 
            case 3: 
            case 4:    
                if(hour > 12)
                    hour = hour-12;
                System.out.printf("The current time is %02d:%02d", hour, minute);
                if(hour == 23)
                    System.out.println("PM in the NIGHT.");
                else 
                    System.out.println("AM in the NIGHT.");
                break;
            default:
                System.out.println("You have the wrong time.");
                break;
        }
    }

    void determineGpaGrade()
    {
        // determine grade letter from random GPA generator previously initialized
        String gradeLetter = null;
        if(grade <= 0.69)
            gradeLetter = "F";
        if(grade >= 0.70 && grade <= 0.99)
            gradeLetter = "D-";
        if(grade >= 1.00 && grade <= 1.29)
            gradeLetter = "D";
        if(grade >= 1.30 && grade <= 1.69)
            gradeLetter = "D+";
        if(grade >= 1.70 && grade <= 1.99)
            gradeLetter = "C-";
        if(grade >= 2.00 && grade <= 2.29)
            gradeLetter = "C";
        if(grade >= 2.30 && grade <= 2.69)
            gradeLetter = "C+";
        if(grade >= 2.70 && grade <= 2.99)
            gradeLetter = "B-";
        if(grade >= 3.00 && grade <= 3.29)
            gradeLetter = "B";
        if(grade >= 3.30 && grade <= 3.69)
            gradeLetter = "B+";
        if(grade >= 3.70 && grade <= 3.99)
            gradeLetter = "A-";
        if(grade == 4.00)
            gradeLetter = "A";
        if(grade > 4.00)
            gradeLetter = "A+";
        
        // printing grade statement
        System.out.printf("The student's GPA grade is a %s in the class.\n", gradeLetter);
    }
    
    void countEven()
    {
        // count with even numbers
        for(int count=9; count>=3; count--)
        {
            // only print even numbers
            if(count%2 == 0)
            {
                System.out.printf("Count: %d\n", count);
            }
        }
    }
    
    void countDown()
    {
        // while loop countdown
        int countDown = 3;
        while(countDown > 0)
        {
            System.out.printf("Count Down: %d\n", countDown);
            countDown--;
        }
        if(countDown == 0)
                System.out.println("Houston, we have a lift off!");
    }
}
