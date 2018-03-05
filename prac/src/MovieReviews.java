import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;
/**
 * Assignment 6 of Computer Science 142
 *
 * @author Yuanjun Zhang
 * @version 2/26/2017
 */
public class MovieReviews
{
    private int[][] rawReviews;
    private String[] movieTitles;
    private String[] Reviewers;
    private int[][] rankedReviews;
    private double[] avgRanks;
    private String File;
    private int moviesNum, reviewersNum;

    public MovieReviews()throws FileNotFoundException{
        this("");
    }

    public MovieReviews(String File1)throws FileNotFoundException{
        this.File = File1;
        readReviews(File);
        generateRankings();
        calculateAvgRankings();
        sortByRanking();

    }

    public int getReviewerCount(){
        return reviewersNum;
    }

    public int getMovieCount(){
        return moviesNum;
    }

    public int getRawReview(int Reviewer, int Movie){
        if(Reviewer >= reviewersNum || Movie >= moviesNum){
            throw new IllegalArgumentException("Parameter out of range.");
        }
        return rawReviews[Reviewer][Movie];
    }

    public int getRankedReview(int Reviewer, int Movie){
        if(Reviewer >= reviewersNum || Movie >= moviesNum){
            throw new IllegalArgumentException("Parameter out of range.");
        }
        return rankedReviews[Reviewer][Movie];
    }

    public String getMovieTitle(int Movie){
        if(Movie >= moviesNum){
            throw new IllegalArgumentException("Parameter out of range.");
        }
        return movieTitles[Movie];
    }

    public String getReviewerName(int Reviewer){
        if(Reviewer >= reviewersNum){
            throw new IllegalArgumentException("Parameter out of range.");
        }
        return Reviewers[Reviewer];
    }

    public double getAvgRank(int Movie){
        if(Movie >= moviesNum){
            throw new IllegalArgumentException("Parameter out of range.");
        }
        return avgRanks[Movie];
    }

    public void displayRawReviews(){
        displayReviews(rawReviews);
    }

    public void displayRankedReviews(){
        displayReviews(rankedReviews);
    }

    public void displayRankedMovies(){
        System.out.println("MOVIE                                     RANKING" );
        System.out.println("--------------------------------------    -------");
        int dif = 0;
        for(int i = 0; i < moviesNum; i++){
            dif = 44-movieTitles[i].length();
            System.out.println(movieTitles[i]);
            for(int j = 0; j < dif; j++){
                System.out.print(" ");
            }
            System.out.print(avgRanks[i]);
        }
    }

    private void readReviews(String file) throws FileNotFoundException{
        File filea = new File(file);
        Scanner console = new Scanner(filea);
        reviewersNum = console.nextInt();
        moviesNum = console.nextInt();

        if(reviewersNum < 0){
            throw new FileNotFoundException("The number of reviewers can not be negative.");
        }

        if(moviesNum < 0){
            throw new FileNotFoundException("The number of movies can not be negative.");
        }

        rawReviews = new int [reviewersNum][moviesNum];

        for(int i = 0; i < reviewersNum; i++){
            for(int a = 0; a < moviesNum; a++){
                rawReviews[i][a] = console.nextInt();
            }
        }

        console.nextLine();
        movieTitles = new String[moviesNum];
        for(int j = 0; j < moviesNum; j++){
            movieTitles[j] = console.nextLine();
        }

        Reviewers = new String[reviewersNum];
        for(int k = 0; k < reviewersNum; k++){
            Reviewers[k] = console.nextLine();
        }
    }

    private void generateRankings(){
        rankedReviews = new int[reviewersNum][moviesNum];
        int[] temp = new int[moviesNum];

        for(int i = 0; i < reviewersNum; i++){
            temp = Arrays.copyOf(rawReviews[i], rawReviews[i].length);
            Arrays.sort(temp);
            int r = 1;
            for(int j = temp.length -1; j >= 0; j--){
                for(int k = 0; k < temp.length; k++){
                    if(temp[j] == rawReviews[i][k]){
                        rankedReviews[i][k] = r;
                    }
                }
                if(j > 0 && temp[j] != temp[j-1]) r++;
            }
        }
    }

    private void calculateAvgRankings(){
        avgRanks = new double[moviesNum];
        double average = 0.0;
        double sum = 0.0;
        for(int i = 0; i < moviesNum; i++){
            for(int j = 0; j < reviewersNum; j++){
                sum += rankedReviews[j][i];
            }
            average = sum/reviewersNum;
            avgRanks[i] = average;
            sum = 0;
        }

    }

    private void displayReviews(int[][] display){
        for(int i = 0; i < reviewersNum; i++){
            for(int j = 0; j < moviesNum; j++){
                System.out.print(display[i][j]+ " ");
            }
            System.out.println();
        }
    }

    public void sortByRanking(){
        double[] newAvgRank = new double[moviesNum];
        String[] newMovieTitle = new String[moviesNum];
        int[][] newRawReviewers = new int[reviewersNum][moviesNum];
        int[][] newRankedReview = new int[reviewersNum][moviesNum];

        for(int i = 0; i < moviesNum; i++){
            newAvgRank[i] = avgRanks[i];
        }
        Arrays.sort(newAvgRank);
        for(int j = 0; j < moviesNum; j++){

            for(int p = 0; p < moviesNum; p++){
                if(newAvgRank[j] == avgRanks[p]){
                    newMovieTitle[j] = movieTitles[p];
                    for(int a = 0; a < reviewersNum; a++){
                        newRawReviewers[a][j] = rawReviews[a][p];
                        newRankedReview[a][j] = rankedReviews[a][p];
                    }
                }
            }
        }

    }

    public static void test() throws FileNotFoundException{
        System.out.println("The test of class MovieReviews starts.");
        MovieReviews Test = new MovieReviews("SD.txt");

        // Check the information about the reviewers and movies
        if(Test.getReviewerCount() != 4)System.out.println("The amount of reviewers fails.");
        if(Test.getMovieCount() != 3)System.out.println("The amount of movie fails.");

        // Check the information about the raw review matrix
        if(Test.getRawReview(0, 2) != 9)System.out.println("Raw review matrix 1 fails.");
        if(Test.getRawReview(2, 1) != 7)System.out.println("Raw review matrix 2 fails.");
        if(Test.getRawReview(1, 1) != 2)System.out.println("Raw review matrix 3 fails.");

        // Check the information about the ranked review matrix
        if(Test.getRankedReview(0, 2) != 1)System.out.println("Ranked review matrix 1 fails.");
        if(Test.getRankedReview(2, 1) != 1)System.out.println("Ranked review matrix 2 fails.");
        if(Test.getRankedReview(1, 1) != 3)System.out.println("Ranked review matrix 3 fails.");

        // Check the information about the movie titles
        if(!Test.getMovieTitle(0).equals("The Way We Weren't"))System.out.println("Movie titles 0 array fails.");
        if(!Test.getMovieTitle(1).equals("The Girl with the Hello Kitty Tattoo"))System.out.println("Movie titles 1 array fails.");
        if(!Test.getMovieTitle(2).equals("Alice in Blunderland"))System.out.println("Movie titles 2 array fails.");

        // Check the information about the name of reviewers
        if(!Test.getReviewerName(0).equals("Elmore Fudd"))System.out.println("Name of reviewers 0 fails.");
        if(!Test.getReviewerName(1).equals("Jess Ika Rabbit (Seattle Times)"))System.out.println("Name of reviewers 1 fails.");
        if(!Test.getReviewerName(2).equals("Doff E. Duckett"))System.out.println("Name of reviewers 2 fails.");
        if(!Test.getReviewerName(3).equals("Marvin T. Martien"))System.out.println("Name of reviewers 3 fails.");

        // Check the information about the average rank of movies
        if(Test.getAvgRank(0) != 1.75)System.out.println("Average rank for movie 0 fails.");
        if(Test.getAvgRank(1) != 2.5)System.out.println("Average rank for movie 1 fails.");
        if(Test.getAvgRank(2) != 1.25)System.out.println("Average rank for movie 2 fails.");


        System.out.println("The test of class MovieReviews ends.");

    }

}
