
import java.util.*;

// Min-Gyu Jung
public class Practice{

    public static void main(String[] args){

        System.out.println("How many numbers you want to draw?");
        Scanner console = new Scanner(System.in);
        int numbers = console.nextInt();

        System.out.println("Please give me range");
        int range = console.nextInt();

        int [] Number = new int[numbers];
        for (int i=0; i<Number.length; i++){
            Number[i] = (int) (Math.random()*range+1);
            for(int j =i-1; j>=0; j--){
                if(Number[i] == Number[j]){
                    i--;
                    break;
                }
            }
        }
        System.out.print("What you got is [");
        for(int i=0; i<Number.length; i++){
            System.out.print(Number[i] + ", ");
        }
        System.out.print("]");




    }
}