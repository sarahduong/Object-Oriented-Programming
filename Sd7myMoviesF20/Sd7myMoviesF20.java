package sd7mymoviesf20;

import static sd7mymoviesf20.Category.ANIMATION;
import static sd7mymoviesf20.Category.COMEDY;
import static sd7mymoviesf20.Category.SCI_FI;
import static sd7mymoviesf20.Category.SUSPENSE;
// imports from https://javadevnotes.com/java-integer-to-string-with-commas/
import java.text.NumberFormat;
import java.util.Locale;
import static sd7mymoviesf20.Category.ROMANCE;

public class Sd7myMoviesF20 
{
    public static void main(String[] args)
    {
        // Frozen 2
        Movie movie1 = new Movie("Frozen 2 (Plus Bonus Content)", "Chris Buck and Jennifer Lee");
        movie1.setCategory(ANIMATION);
        movie1.setSummary("Together with Anna, Kristoff, Olaf and Sven, Elsa faces a dangerous but remarkable journey into the unknown — to the enchanted forests and dark seas beyond Arendelle, in search of truths about the past.");
        movie1.setRating(6.9f);
        movie1.setRevenue(1450000000);
        movie1.setYear(2019);
        
        // Shrek
        Movie movie2 = new Movie("Shrek Forever After", "Mike Mitchell", "The further adventures of the giant green ogre, Shrek, living in the land of Far, Far Away.", COMEDY, 2010, 6.3f, 752600000);
        
        // The Matrix
        Movie movie3 = new Movie("The Matrix", "The Wahowski Brothers", "A computer hacker learns from mysterious rebels about the true nature of his reality and his role in the", SCI_FI, 1999);
        movie3.setRating(8.7f);
        movie3.setRevenue(460000000);
        
        // Inception
        Movie movie4 = new Movie();
        movie4.setName("Inception");
        movie4.setDirector("Christopher Nolan");
        movie4.setSummary("A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O.");
        movie4.setCategory(SUSPENSE);
        movie4.setRating(8.8f);
        movie4.setRevenue(826137188);
        movie4.setYear(2010);
        
        // print movie1
        double revenue = movie1.getRevenue();
        // formatting from https://javadevnotes.com/java-integer-to-string-with-commas/
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
        String revenueStringCommas = numberFormat.format(revenue);
        
        float rating = movie1.getRating();
        int version = movie1.getVersion();
        int year = movie1.getYear();
        System.out.println("Movie 1: ");
        System.out.printf("NAME: %s\n", movie1.getName());   
        System.out.printf("Director: %s\n", movie1.getDirector());
        System.out.printf("Summary: %s\n", movie1.getSummary());
        System.out.printf("Category: %s\n", movie1.getCategory());
        System.out.printf("Rating: %s\n", Float.toString(rating));
        System.out.printf("Revenue: $%s\n" , revenueStringCommas);
        System.out.printf("Year: %s\n", Integer.toString(year));
        System.out.printf("Version: %s\n\n", Integer.toString(version));
        
        // print movie2
        revenue = movie2.getRevenue();
        // formatting for lines 62-63 from https://javadevnotes.com/java-integer-to-string-with-commas/
        numberFormat = NumberFormat.getNumberInstance(Locale.US);
        revenueStringCommas = numberFormat.format(revenue);
        
        rating = movie2.getRating();
        version = movie2.getVersion();
        year = movie2.getYear();
        System.out.println("Movie 2: ");
        System.out.printf("NAME: %s\n", movie2.getName());   
        System.out.printf("Director: %s\n", movie2.getDirector());
        System.out.printf("Summary: %s\n", movie2.getSummary());
        System.out.printf("Category: %s\n", movie2.getCategory());
        System.out.printf("Rating: %s\n", Float.toString(rating));
        System.out.printf("Revenue: $%s\n" , revenueStringCommas);
        System.out.printf("Year: %s\n", Integer.toString(year));
        System.out.printf("Version: %s\n\n", Integer.toString(version));
        
        movie3.printMovie(movie3, 3);
        movie4.printMovie(movie4, 4);
        
        // extra movie 5
        Movie movie5 = new Movie("Knives Out", "Rian Johnson", "A modern whodunit, the film follows a master detective investigating the patriarch's death after a family gathering gone awry.", COMEDY, 2019, 7.9f, 165300000); // description of movie from Wikipedia
        movie5.printMovie(movie5, 5);
        
        // print number of movies
        System.out.printf("Number of Movies: %d\n", Movie.numOfMovies);
    }
}