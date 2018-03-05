public class Teacher extends Person {

    private String[] coursesTaught = new String[50];
    private int nextCourseIndex;

    public Teacher(String id, String name, String email) {
        super(id, name, email);
        nextCourseIndex = 0;
    }
    public boolean isValidId(String id) {
        return id.matches("[0-9]{9}");
    }
}
