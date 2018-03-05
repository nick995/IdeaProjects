import java.io.FileNotFoundException;
import java.util.*;
public class prac2 {

    public static void temparture(Scanner console) throws FileNotFoundException{

        String month = console.nextLine();
        int day = console.nextInt();
        int mintemperature, maxtemperature, minDay, maxDay = 0;
        int count = 0;
        for(int i=0; i<day; i++) {
            count++;
            int tempartrue = console.nextInt();

            if (tempartrue > maxtemperature) {
                maxDay = day;
                maxtemperature = tempartrue;
            }
            if (tempartrue < mintemperature) {
                minDay = day;
                mintemperature = tempartrue;
            }
        }
    }
}


