package sd7myhelloworldf20;

// lines 4-5 retrieved from  https://compiler.javatpoint.com/opr/test.jsp?filename=CurrentDateTimeExample1
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;  
import static sd7myhelloworldf20.Sd7myHelloWorldF20.myPawPrint;


public class Sd7myHelloWorldF20 
{
    // declare global variable for myPawPrint
    public static String myPawPrint = "sd7my";
    void invokeMe()
    {
        System.out.printf("My PawPrint is \"%s\"\n", myPawPrint); // formatting referenced from https://stackoverflow.com/questions/41660150/how-to-print-the-value-of-variable-in-java
        System.out.println("Today's date is: ");
        
        // lines 28-31 retrieved and edited from https://compiler.javatpoint.com/opr/test.jsp?filename=CurrentDateTimeExample1
        DateTimeFormatter dtf = 
        DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a"); // time formatting referenced from https://howtodoinjava.com/java/date-time/format-time-12-hours-pattern/
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
    } 
    
    public static void main(String[] args) 
    {
        System.out.println("Hello World!");
        Sd7myHelloWorldF20 myObject = new Sd7myHelloWorldF20();
        myObject.invokeMe();
    }
}
