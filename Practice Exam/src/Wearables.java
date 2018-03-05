import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Wearables {
    private Wearable[] wearables;
    private UniqueTree<Integer> rankingIndex;
    private NonUniqueTree<Double> priceIndex;
    private NonUniqueTree<String> companyNameIndex;
    private int size;


    /**
     * Constructor for the Wearables class
     */
    public Wearables() {
        rankingIndex = new UniqueTree<>();
        priceIndex = new NonUniqueTree<>();
        companyNameIndex = new NonUniqueTree<>();
        readFile();
    }

    public Integer[] getRankPositionData() {
        return rankingIndex.getPositionData();
    }

    public Integer[] getPricePositionData() {
        return priceIndex.getPositionData();
    }

    public Integer[] getCoNamePositionData() {
        return companyNameIndex.getPositionData();
    }

    public Integer[] getRankPositionData(Integer min, Integer max) {
        return rankingIndex.getPositionData(min, max);
    }

    public Integer[] getPricePositionData(Double min, Double max) {
        return priceIndex.getPositionData(min, max);
    }

    public Integer[] getCoNamePositionData(String min, String max) {
        return companyNameIndex.getPositionData(min, max);
    }

    public String getRankReport(Integer[] positions) {
        return getReport(positions);
    }

    public String getPriceReport(Integer[] positions) {
        return getReport(positions);
    }

    public String getCoNameReport(Integer[] positions) {
        return getReport(positions);
    }

    public String getReport(Integer[] positions) {
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < positions.length; i++) {
            result.append(String.valueOf(wearables[positions[i]].extraCreditInformation()));
            result.append("\n");
        }

        return result.toString();
    }

    /**
     * Mutators for Wearables class
     * <p>
     * Read the file and save the wearables' information
     */
    public void readFile() {
        int position = 0;
        try {
            File file = new File("src/wearables.txt");
            Scanner console = new Scanner(file);
            if (console.hasNextInt()) {
                size = console.nextInt();
                wearables = new Wearable[size];
            }
            console.nextLine(); // number line
            console.nextLine(); // introduce line
            while (console.hasNextLine()) {
                String line = console.nextLine();
                String[] infor = line.split("@");
                int rank = Integer.parseInt(infor[0]);
                String name = infor[1];
                double price = Double.parseDouble(infor[2]);
                String bL = infor[3];
                String category = infor[4];
                String cN = infor[5];
                String cU = infor[6];
                String cL = infor[7];
                String city = infor[8];
                String state = infor[9];
                String country = infor[10];
                Wearable myWearable = new Wearable(rank, name, price, bL, category, cN, cU, cL, city, state, country);
                wearables[position] = myWearable;
                rankingIndex.add(myWearable.getRanking(), position);
                priceIndex.add(myWearable.getPrice(), position);
                companyNameIndex.add(myWearable.getCompanyName(), position);
                position++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Can't find the file!");
        }
    }


    // readFile https://stackoverflow.com/questions/3481828/how-to-split-a-string-in-java

}