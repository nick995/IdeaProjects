import java.util.ArrayList;
/** Practice activity of ArrayList in CSC 142
 *  @author Min-Gyu Jung
 *  @version 2017-12-03
 */
public class CSC142Point {
    private double x, y;  // the coordinates

    // two different constructors

    /**
     * Create a CSC142Point at (0, 0)
     */
    public CSC142Point() {
        x = 0;
        y = 0;
    }

    /**
     * Create a CSC142Point with the given coordinates
     * @param initialX the x-coordinate
     * @param initialY the y-coordinate
     */
    public CSC142Point (double initialX, double initialY) {
        x = initialX;
        y = initialY;
    }

    // update (mutator) methods
    // that change the state of a CSC142Point object

    /**
     * Set the x-coordinate of this CSC142Point
     * @param updateX the new x-coordinate
     */
    public void setX(double updateX) {
        x = updateX;
    }

    /**
     * Set the y-coordinate of this CSC142Point
     * @param newY the new y-coordinate
     */
    public void setY(double updateY) {
        y = updateY;
    }

    /**
     * Set the x and y coordinates of this CSC142Point
     * @param newX the new x-coordinate
     * @param newY the new y-coordinate
     */
    public void setPoint( double newX, double newY){
        x = newX;
        y = newY;
    }

    // query (accessor) methods
    // that somehow report the state of a CSC142Point
    // without changing it

    /**
     * Get the x-coordinate of this CSC142Point
     * @return the x-coordinate
     */
    public double getX() {
        return x;
    }

    /**
     * Get the y-coordinate of this CSC142Point
     * @return the y-coordinate
     */
    public double getY() {
        return y;
    }

    /**
     * Calculate the distance between this CSC142Point and the origin
     * @return the distance to (0, 0)
     */
    public double distanceToOrigin() {
        return Math.sqrt(x * x + y * y);
    }

    /** Calculate the distance between this CSC142Point and some other CSC142Point
     * @param other the other CSC142Point
     * @return the distance between the 2 CSC142Points
     */
    public double distance(CSC142Point other) {
        double diffX = x - other.x;
        double diffY = y - other.y;
        return  Math.sqrt(diffX * diffX + diffY * diffY);
    }

    /**
     * Find the midpoint between this CSC142Point and another CSC142Point
     * @param p the other CSC142Point
     * @return the CSC142Point midway between the two CSC142Points
     */
    public CSC142Point midPoint(CSC142Point other) {
        double midX = (x + other.x) / 2;
        double midY = (y + other.y) / 2;
        return new CSC142Point(midX, midY);
    }

    /**
     * The String version of this CSC142Point
     * @return the String representation
     */
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    /**
     * Write a method that is passed in an ArrayList of CSC142Points and removes
     * all the Points that lie on the x-axis and returns those CS142Points in another ArrayList
     */
    public static ArrayList<CSC142Point> removePoint(ArrayList<CSC142Point>myList){
        for(int i =0; i<myList.size(); i++){
            if(myList.get(i).getY() ==0){
                myList.remove(i);
            }
        }
        return myList;
    }

    /**
     * Write a method that is passed in an ArrayList of Integers and a positive int,
     * and removes all the multiples of that value.
     */
    public static ArrayList<Integer> removeMult(ArrayList<Integer> myList, int a){
        int currentIndex = 0;
        while(currentIndex < myList.size()){
            if(myList.get(currentIndex) % a == 0)
                myList.remove(currentIndex);
            else{
                currentIndex++;
            }
        }
        return myList;
    }

    /**
     * Write a method that is passed in an ArrayList of Strings
     * and reverses the order of the Strings in the list
     */
    public static ArrayList<String> reverseOrder(ArrayList<String> myList){
        int len = myList.size();
        for(int i = 0; i < len/2; i++){
            String temp = myList.get(i);
            myList.set(i, myList.get(len - 1 - i));
            myList.set(len-1-i, temp);
        }
        return myList;
    }

    /**
     * Write a method that is passed in an ArrayList of Strings
     * and swaps each pair of Strings.
     */
    public static ArrayList<String> swapPair(ArrayList<String> myList){
        for(int i = 0; i < myList.size(); i++){
            if(i != 0 && (i % 2) != 0){
                String temp = myList.get(i - 1);
                myList.set(i - 1, myList.get(i));
                myList.set(i,temp);
            }
        }
        return myList;
    }

    /**
     * Write a method that is passed in an ArrayList of Strings
     * and returns true of the list is sorted in non-descending order, false if not
     */
    public static boolean ascendingOrder(ArrayList<String> myList){
        boolean flag = true;
        for(int i = 1; i < myList.size(); i++){
            int s = myList.get(i).length();
            int s2 = myList.get(i-1).length();
            if(s2 > s){
                flag = false;
                break;
            }
        }
        return flag;
    }

    /**
     * Write a method that sorts an ArrayList of Strings passed
     * in using either the Selection Sort or Insertion Sort algorithm
     */
    public static ArrayList<String> sort(ArrayList<String> myList){
        for(int top = 0; top < myList.size(); top++){
            int smallIndex = top;
            for(int i = top + 1; i < myList.size(); i++){
                if(myList.get(i).length() < myList.get(smallIndex).length())smallIndex = i;
            }
            String temp = myList.get(top);
            myList.set(top,myList.get(smallIndex));
            myList.set(smallIndex,temp);
        }
        return myList;
    }


    /**
     * a test method - do not change this code!
     * it should display 3 results in a terminal window
     */
    public static void test (){
        CSC142Point alpha = new CSC142Point( 5, 5 );
        CSC142Point beta = new CSC142Point( -3, 7 );
        System.out.println( "alpha is " + alpha.distanceToOrigin() + " from the origin" );
        System.out.println( "The x coordinate of beta is " + beta.getX() );
        beta.setY( 72 );
        System.out.println( "The y coordinate of beta is " + beta.getY() );
        ArrayList<CSC142Point> newList = new ArrayList<CSC142Point>();
        newList.add(new CSC142Point(10,0));
        newList.add(new CSC142Point(10,10));
        newList.add(new CSC142Point(20,0));
        newList.add(new CSC142Point(20,20));
        System.out.println(removePoint(newList));
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        list = removeMult(list,2);
        for (int i = 0; i < list.size(); i++)
        {
            System.out.print(list.get(i));
        }
        System.out.println();

        ArrayList<String> newStrList = new ArrayList<String>();
        newStrList.add("***CSC142***");
        newStrList.add("ENG&102");
        newStrList.add("MATH163");
        newStrList.add("ECON202");
        System.out.println(reverseOrder(newStrList));
        System.out.println(swapPair(newStrList));
        System.out.println(ascendingOrder(newStrList));
        ArrayList<String> newStrList2 = new ArrayList<String>();
        newStrList2.add("ECON202");
        newStrList2.add("MATH163");
        newStrList2.add("ENG&102");
        newStrList2.add("***CSC142***");
        System.out.println(ascendingOrder(newStrList2));
        System.out.println(sort(newStrList));
    }
}