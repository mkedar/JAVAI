public class Course extends Name { // PROBLEM 2
    private String name;
    private String description;
    private int numOfUnits;

    public Course(String name, String description, int numOfUnits) throws Exception {
        super(name);

        if (numOfUnits < 0) {
            throw new Exception("Course number cannot be a negative integer, please try agian.");
        }

        this.name = name;
        this.description = description;
        this.numOfUnits = numOfUnits;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getNumOfUnits() {
        return numOfUnits;
    }

    @Override
    public String toString() {
        return "COURSE(" + name + ") DESC(" + description + ") UNITS(" + numOfUnits + ")";
    }

    public boolean match(String search) {
        boolean isNameMatch = name.equals(search);
        boolean isDescriptionMatch = description.equals(search);
        boolean isNumOfUnitsMatch = String.valueOf(numOfUnits).equals(search);
        return isNameMatch || isDescriptionMatch || isNumOfUnitsMatch;
    }    

    public boolean isTheSame(Name another) {
        boolean output = false;
        if (another instanceof Course) {
            Course otherCourse = (Course) another;
            output = this.getName().equals(otherCourse.getName());
        }
        return output;
    }
    
}
