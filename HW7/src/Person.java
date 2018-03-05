public abstract class Person {
    private String id;
    private String name;
    private String email;


    public Person(String id, String name, String email){

    }

    public String getId()     {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public abstract boolean isValidId(String id);

    public String toString() {
        String report = "";
        report += "User's Id is    = " + id + "\n";
        report += "User's Name is  = " + name + "\n";
        report += "User's Email is = " + email + "\n";
        return report ;
    }

}
