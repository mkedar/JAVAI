import java.util.Vector;

public class java_final {
 
    // Matan Kedar
    // 5/24/2023
    // Java Final 

    // When I tested the classes and the functions it all worked. But it is important to note that some of the varaible names that are 
    // commented out might have the same variable names as other so make sure to check the one by one.
    public static void main(String[] args) { // i do my testing here
        try {
            //User user = new User("Matan", "123");
            //System.out.println("Username: " + user.getUsername());
            //System.out.println("Password: " + user.getPassword());
            // System.out.println(user);
            // User user2 = new User("Matan", "1234");
            // System.out.println("MATCH() = " + user.match("444"));
            // System.out.println("ISTHESAME() =  " + user.isTheSame(user2));
            

            // Course course = new Course("CIST 041B", "Intermediate JAVA", 4);
            // Course course2 = new Course("CIST 041A", "Begginer JAVA", 4);
            // Course course3 = new Course("CIST 041B", "Super hard JAVA", 20);
            // System.out.println(course);
            // System.out.println(course.match("Intermediate JAVA"));
            // System.out.println(course.match("Begginer JAVA"));
            // System.out.println(course.match("CIST 041C"));
            // System.out.println(course.isTheSame(course2));
            // System.out.println(course.isTheSame(course3));

            Name[] listNames = new Name[5]; // testing for PROBLEM 3
            listNames[0] = new User("Matan", "password");
            listNames[1] = new User("Nadav", "password");
            listNames[2] = new Course("Matan", "History", 4); // matching name 
            listNames[3] = new Course("Matan", "AP US GOVENRMENT", 7); // matching name 
            listNames[4] = new User("Matan", "newPasswordVerySecure123123"); // the first and last element are the same in this example.
        
            //[] results = new String[2]; // output array // PROBLEM 4 TESTING
            //reportAndSwapNameList(listNames, results); // use the method
            //System.out.println("Matching the name = " + results[0]);
            //System.out.println("First and last element the same = " + results[1]); 
            // this example should have 2 matching (index 2, 3 ) and results[1] should be true as the first and last elements are the same
            // check out of it has succesfully swapped the object by checking the password. The code should output newPasswordVerySecure123123 before password as it should swap the first and last element.
            //System.out.println(((User) listNames[0]).getPassword());
            //System.out.println(((User) listNames[4]).getPassword());
            

            // testing for PROBLEM 4 from my testing it all works
            // String name = "Matan Kardosh";
            // String password = "SuperSecretPassword!@#";
            // String description = "Chemistry";
            // int unit = -10;
            // int[] results = new int[1];
            // Name nameObj = createOneNameObj(name, password, description, unit, results);
        
            // if (nameObj != null) {
            //     System.out.println("Successfully created: " + nameObj.toString());
            // } else {
            //     System.out.println("Failed to create name object.");
            // }
            // System.out.print("The error code is: " + results[0]);

            Vector<Name> names = new Vector<>(); // PROBLEM 5 TESTING
            names.add(new User("Matan", "passwor3333d1"));
            names.add(new Course("Physics", "Hard physics", 3));
            names.add(new Course("PE", "Running", 3));
            names.add(new User("Matan", "password1133333"));
            names.add(new Course("Track and field", "Jumping and sprinting ", 6));
            names.add(new User("Ido", "IloveBurgers123"));
            names.add(new User("Matan", "passwo1213rd1")); 
            names.add(new User("Matan", "123123123"));
        
            String searchName = "Matan";
            String[] result = removeThisName(names, searchName);

            int totalDeleted = Integer.parseInt(result[1]);
            System.out.println("Number of objects deleted: " + totalDeleted);
            System.out.println("List of deleted objects:");
            System.out.println(result[0]);
            System.out.println("New vector:");
            for (Name name : names) {
                System.out.println(name.toString());
            }
        } 
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
    }
    public static void reportAndSwapNameList(Name[] names, String[] results) { // PROBLEM 3        
        int sameNameCounter = 0;
        for (Name name : names) { // for loop to check if there is anywhere the same name in all objects
            if (names[0].isTheSame(name)) {
                sameNameCounter++; // add to the counter 
            }
        }
        int lastIndex = names.length-1;
       
        boolean FirstLastSame = names[0].isTheSame(names[lastIndex]);
        // swaping postitions
        Name firstElement = names[0]; // create dummy varaible for swapping
        names[0] = names[lastIndex];
        names[lastIndex] = firstElement;
        
        results[0] = String.valueOf(sameNameCounter);
        results[1] = String.valueOf(FirstLastSame);
    }
    
    public static Name createOneNameObj(String name, String password, String description, int unit, int[] results) throws Exception { // PROBLEM 4
        int errorCode = 0;
        Name nameObj = null;

        try {
            if (name.length() == 0 || password.length() == 0) { // checks if the names are blank and if so assinged error code #1
                errorCode = 1;
                throw new IllegalArgumentException("Name or password cannot be blank");
            }
            
            if (unit < 0) {  // checks if the units are negative and if so it assigned error code number 2 and creates the user obect 
                nameObj = new User(name, password);
                errorCode = 2;
                throw new IllegalArgumentException("The unit cannot be a negative integer");
            }
            else {
                nameObj = new Course(name, description, unit);
                errorCode = 0;
            }
        } catch (IllegalArgumentException e) {}
        

        results[0] = errorCode;
        return errorCode == 0 || errorCode == 2 ? nameObj : null; // only output the object if it falls under error code 0 and 2
    }
    
    public static String[] removeThisName(Vector<Name> names, String search) { // PROBLEM 5 
        int totalDeleted = 0;
        StringBuilder deletedObjects = new StringBuilder(); // stiring builder for easy list

        for (int i = names.size() - 1; i >= 0; i--) {
            Name name = names.get(i);
            if (name.getName().equals(search)) {
                deletedObjects.append(name.toString()).append("\n"); //add deleted to a new list using string builder
                names.remove(i); // remove from the intial list 
                totalDeleted++; // add to total deleted counter
            }
        }
        // sort the outputs
        String[] result = new String[2];
        result[0] = deletedObjects.toString();
        result[1] = String.valueOf(totalDeleted);

        return result; // return the array of outputs
    }
    


}

