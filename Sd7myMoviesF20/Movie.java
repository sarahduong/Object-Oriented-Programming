package sd7mymoviesf20;
// imports from https://javadevnotes.com/java-integer-to-string-with-commas/
import java.text.NumberFormat;
import java.util.Locale;

public class Movie
{
    private String name;
    private String director;
    private String summary;
    private float rating = 0.0f;        
    private double revenue = 0.0;
    private Category category;
    private int year = 1888;
    private int version;
    public static int numOfMovies = 0;

    // constructors
    Movie()
    { 
        this.version = 0;
        this.name = "";
        this.director = "";
        Movie.numOfMovies++;
    }
    Movie(String name, String director)
    {
        this();
        this.name = name;
        this.director = director;
    }
    Movie(String name, String director, String summary, Category category, int year)
    {
        this(name, director);
        this.summary = summary;
        this.category = category;
        this.version = 1;
        this.year = year;
    }
    Movie(String name, String director, String summary, Category category, int year, float rating, double revenue)
    {
        this(name, director, summary, category, year);
        this.rating = rating;
        this.revenue = revenue;
    }


    void setName(String name)
    {
        this.name = name;
        this.version++;
    }
    String getName()
    {
        return this.name;
    }
    
    void setDirector(String director)
    {
        this.director = director;
    }
    String getDirector()
    {
        return this.director;
    }
    
    void setRating(float rating)
    {
        this.rating = rating;
        this.version++;
    }
    float getRating()
    {
        return this.rating;
    }
    
    void setRevenue(double revenue)
    {
        this.revenue = revenue;
        this.version++;
    }
    double getRevenue()
    {
        return this.revenue;
    }
    
    void setYear(int year)
    {
        this.year = year;
        this.version++;
    }
    int getYear()
    {
        return this.year;
    }
    
    void setCategory(Category category)
    {
        this.category = category;
    }
    Category getCategory()
    {
        return this.category;
    }
    
    void setSummary(String summary)
    {
        this.summary = summary;
        this.version++;
    }
    String getSummary()
    {
        return this.summary;
    }
    
    int getVersion()
    {
        return this.version;
    }
    
    void printMovie(Movie movie, int movieNum)
    {
        // formatting for lines 124-126 from https://javadevnotes.com/java-integer-to-string-with-commas/
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
        String revenueStringCommas = numberFormat.format(revenue);
        
        rating = movie.getRating();
        revenue = movie.getRevenue();
        version = movie.getVersion();
        year = movie.getYear();
        System.out.printf("Movie %d: \n", movieNum);
        System.out.printf("NAME: %s\n", movie.getName());   
        System.out.printf("Director: %s\n", movie.getDirector());
        System.out.printf("Summary: %s\n", movie.getSummary());
        System.out.printf("Category: %s\n", movie.getCategory());
        System.out.printf("Rating: %s\n", Float.toString(rating));
        System.out.printf("Revenue: $%s\n" , revenueStringCommas);
        System.out.printf("Year: %s\n", Integer.toString(year));
        System.out.printf("Version: %s\n\n", Integer.toString(version));
    }
} // end class