public class main {
    public static void main(String[] args) {
        Wearables myWearables = new Wearables();
        System.out.println("========================================================================");
        System.out.println("=================Reporting Ranking data 1st to 582st====================");
        System.out.println("========================================================================");

        System.out.println(myWearables.getReport(myWearables.getCoNamePositionData()));
        System.out.println("========================================================================");
        System.out.println("=================Reporting Price data Low to High ====================");
        System.out.println("========================================================================");
        System.out.println(myWearables.getReport(myWearables.getPricePositionData()));

        System.out.println("========================================================================");
        System.out.println("=================Reporting Ranking data A to Z =========================");
        System.out.println("========================================================================");

        System.out.println(myWearables.getReport(myWearables.getCoNamePositionData()));




    }
}