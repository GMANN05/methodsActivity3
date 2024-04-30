
import java.util.Random;
import java.util.Scanner;

public class movieSimulationThree
{
    public static void main(String[] args)
    {
        String [] movieNames = {"Jumanji","Matrix","Star Wars","Oppenheimer"};
        String [] movieTypes= {"2D","3D","2D","Drama/Historical"};
        double [] moviePrice = {15.25,20.15,18.11,14.14};
        //Constants
        final int ROWS = 5;
        final int COLUMNS = 10;

        //Convert to a 2D array [][]
        int [][] movieAvailability = new int [ROWS][COLUMNS];


        //METHOD CALLS
        displayMovieDetails(movieNames,movieTypes,moviePrice);
        int index = selectMovie(movieNames);
        displaySelectedMovie(movieNames[index],movieTypes[index], moviePrice[index],index);
        setSeatAvailability(movieAvailability);        // sets the available seats to 0
        displaySeatAvailability(movieAvailability);    // display the available seats
        randomizeAvailability(movieAvailability);      // sets seats to be either available or not available using random
        displaySeatAvailability(movieAvailability);    // display the available seats
    }
    static void randomizeAvailability(int [][] movieAvailability){
        System.out.println("\n------------ RANDOMIZED SEATS -----------\n");
        Random rand = new Random();
        // for(initialize; condition; increment/decrement)
        for(int i = 0 ; i <movieAvailability.length ; i++ )
        {
            for(int j = 0 ; j < movieAvailability[i].length ; j++)
            {
                movieAvailability[i][j] = rand.nextInt(2);
            }
        }
    }
    static void displaySeatAvailability(int [][] movieAvailability){
        System.out.println("\nSeating Availability: [ 1 = unavailable ; 0 = available ]\n");
        char[] rowLabel = {'A', 'B', 'C', 'D', 'E'};
        for (int i = 1; i <= movieAvailability[0].length; i++) {
            System.out.printf(" %d", i);
        }
        System.out.printf(" \n%s\n", "-".repeat(10));
        // for(initialize; condition; increment/decrement)
        for(int i = 0 ; i <movieAvailability.length ; i++ )
        {
            System.out.printf(" %c |", rowLabel[i]);
            for(int j = 0 ; j < movieAvailability[i].length ; j++)
            {
                System.out.print(movieAvailability[i][j] + " " );

            }
            System.out.println();
        }
    }
    static void setSeatAvailability(int [][] movieAvailability){
        System.out.println("\n------------ INITIAL SEATS -----------\n");
        // for(initialize; condition; increment/decrement)
        for(int i = 0 ; i <movieAvailability.length ; i++ )
        {
            for(int j = 0 ; j < movieAvailability[i].length ; j++)
            {
                movieAvailability[i][j] = 0;
            }
        }
    }

    //access modifier return type method name and parameter
    static void displayMovieDetails(String [] mNames,String [] mTypes, double [] mPrice)
    {

        //%s --> String
        //%d --> integers
        //%f --> doubles floating point
        //%c --> characters
        // -  |--> Flag
        // %-10s --> Left aligned  10 spaces
        // %10s  --> Right aligned 10 spaces
        String header = String.format("\n --------------------------- Movie Details --------------------------\n" +
                "%-20s %-20s%-20s\n","Movie Name","Movie Type","Movie Price");
        System.out.println(header);
        for(int i = 0; i < mNames.length; i++) {
            System.out.printf("Movie %d : %-16s %-16s $%-16.2f\n",(i+1),mNames[i],mTypes[i],mPrice[i]);
        }
    }
    static int selectMovie(String[] movieNames) {
        Scanner scanner = new Scanner(System.in);
        int index = -1;
        while(index == -1) {
            System.out.print("Enter the name of the movie you would like to see: ");
            String selectedMovie = scanner.nextLine();
            for (int i = 0; i < movieNames.length; i++) {
                if (selectedMovie.equalsIgnoreCase(movieNames[i])) {
                    index = 1;
                    break;
                }
            }
            if(index == -1) {
                System.out.println("Movie not found. Try again. ");
            }
        }
        return index;
    }
    static void displaySelectedMovie(String[] movieNames, String[] movieTypes, double[] moviePrices, int index) {
        System.out.println("\n------------------ Movie Details ------------------");
        System.out.printf("Movie Name: %s\n", movieNames[index]);
        System.out.printf("Movie Type: %s\n", movieTypes[index]);
        System.out.printf("Movie Price: $%.2f\n", moviePrices[index]);
    }
}
