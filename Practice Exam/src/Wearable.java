
public class Wearable
{
    private int ranking;
    private String name;
    private double price;
    private String bodyLocation;
    private String category;
    private String companyName;
    private String companyURL;
    private String companyLocation;
    private String city;
    private String state;
    private String country;
    /**
     * Constructor for the Wearable class
     */
    public Wearable(int ranking, String name, double price, String bodyLocation, String category, String companyName, String companyURL, String companyLocation, String city, String state, String country){
        if(ranking <= 0){
            throw new IllegalArgumentException("Ranking can not be negative!");
        }
        if(name == null){
            throw new IllegalArgumentException("Name can not be null!");
        }
        if(price < 0 && price != -99.99){
            throw new IllegalArgumentException("Price can not be negative!");
        }
        if(bodyLocation == null){
            throw new IllegalArgumentException("Body location can not be null!");
        }
        if(category == null){
            throw new IllegalArgumentException("Category can not be null!");
        }
        if(companyName == null){
            throw new IllegalArgumentException("Company name can not be null!");
        }
        if(companyURL == null){
            throw new IllegalArgumentException("CompanyURL can not be null!");
        }
        if(companyLocation == null){
            throw new IllegalArgumentException("Company location can not be null!");
        }
        if(city == null){
            throw new IllegalArgumentException("City can not be null!");
        }
        if(state == null){
            throw new IllegalArgumentException("State can not be null!");
        }
        if(country == null){
            throw new IllegalArgumentException("Country can not be null!");
        }
        this.ranking = ranking;
        this.name = name;
        this.price = price;
        this.bodyLocation = bodyLocation;
        this.category = category;
        this.companyName = companyName;
        this.companyURL = companyURL;
        this.companyLocation = companyLocation;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    /**
     * Accessors for Wearable class
     *
     * Get the ranking information and return it
     */
    public int getRanking(){
        return ranking;
    }

    /**
     * Accessors for Wearable class
     *
     * Get the item name information and return it
     */
    public String getName(){
        return name;
    }

    /**
     * Accessors for Wearable class
     *
     * Get the price information and return it
     */
    public double getPrice(){
        return price;
    }

    /**
     * Accessors for Wearable class
     *
     * Get the body location information and return it
     */
    public String getBodyLocation(){
        return bodyLocation;
    }

    /**
     * Accessors for Wearable class
     *
     * Get the category information and return it
     */
    public String getCategory(){
        return category;
    }

    /**
     * Accessors for Wearable class
     *
     * Get the company name information and return it
     */
    public String getCompanyName(){
        return companyName;
    }

    /**
     * Accessors for Wearable class
     *
     * Get the company URL information and return it
     */
    public String getCompanyURL(){
        return companyURL;
    }

    /**
     * Accessors for Wearable class
     *
     * Get the company location information and return it
     */
    public String getCompanyLocation(){
        return companyLocation;
    }

    /**
     * Accessors for Wearable class
     *
     * Get the city information and return it
     */
    public String getCity(){
        return city;
    }

    /**
     * Accessors for Wearable class
     *
     * Get the state information and return it
     */
    public String getState(){
        return state;
    }

    /**
     * Accessors for Wearable class
     *
     * Get the country information and return it
     */
    public String getCountry(){
        return country;
    }

    /**
     * Accessors for Wearable class
     *
     * Get the whole information of this wearable and return it
     */
    public String toString(){
        String report = "";
        report += "Ranking           :     "   +     getRanking()         +   "\n";
        report += "Name              :     "   +     getName()            +   "\n";
        report += "Price             :     "   +     getPrice()           +   "\n";
        report += "Body loation      :     "   +     getBodyLocation()    +   "\n";
        report += "Category          :     "   +     getCategory()        +   "\n";
        report += "Company name      :     "   +     getCompanyName()     +   "\n";
        report += "Company URL       :     "   +     getCompanyURL()      +   "\n";
        report += "Company location  :     "   +     getCompanyLocation() +   "\n";
        report += "City              :     "   +     getCity()            +   "\n";
        report += "State             :     "   +     getState()           +   "\n";
        report += "Country           :     "   +     getCountry()         +   "\n";
        return report;
    }

    /**
     * Accessors for Wearable class
     *
     * Get the important information of this wearable and return it
     */
    public String extraCreditInformation(){
        String report = "";
        report += "Ranking           :     "   +     getRanking()         +   "\n";
        report += "Name              :     "   +     getName()            +   "\n";
        report += "Price             :     "   +     getPrice()           +   "\n";
        report += "Company name      :     "   +     getCompanyName()     +   "\n";
        return report;
    }
}
