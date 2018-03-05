public class Student extends Person {

    private String[] coursesTaken = new String[30];
    private double[] courseGrades = new double[30];
    private int nextCourseIndex;

    public Student(String id, String name, String email) {
        super(id, name, email);
        nextCourseIndex = 0;

    }

    public boolean isValidId(String id) {
        return id.matches("^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\\\w+\\\\.)+\\\\w+$\"");
    }

}
