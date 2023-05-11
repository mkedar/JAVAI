import java.util.Scanner;

class BadInfoException extends Exception{ 
    public BadInfoException(String message){
        super(message); // this message is can be displayed with the getMessage() function inhereted from the Execption class
    }
}
class VariableInt {
    private int value;
    private String name;

    public VariableInt(int value, String name) throws BadInfoException{ // regular constructor
        if (value < 0) { // verifies if the number is negative 
            throw new BadInfoException("The number cannot be a negative");
        }
        if (name == null || name.trim().length() == 0){ // checks if the name is null or the name is just a lot of spaces
            throw new BadInfoException("The name cannot be empty"); // checks by trimming the whitespaces and chekcing if the legnth is 0 afterwards
        }
        this.value = value;
        this.name = name.trim(); // take off white spaces
    
    }
    public int getValue(){  // accessor and mutator functions 
        return value;
    }

    public String getName(){ 
        return name;
    }
}

class VariableIntUtils{

    public static Object[] createVariableObject(){
        Scanner scanner = new Scanner(System.in);
        VariableInt variable = null;
        int attempts = 1; // always going to be at least 1 attempt 

        boolean isValidInput = false;
        while(!isValidInput){
            try{
                System.out.print("Enter variable name: ");
                String name = scanner.nextLine();
                System.out.print("Enter variable value: ");
                int value = Integer.parseInt(scanner.nextLine());

                variable = new VariableInt(value, name);
                isValidInput = true; // Set flag to true if input is valid
            } catch (NumberFormatException e){
                System.out.println("Please enter a positive integer");
                attempts++; // increase attempt if this catch statement is triggered 
            } catch (BadInfoException e){
                System.out.println("Error:  "  + e.getMessage());
                attempts++; // increase attempt if this catch statement is triggered 
            }
        }
        return new Object[]{variable, attempts}; // returns an object with the variable object and how many attempts it took 
    }
}


public class exceptions {
    // Matan Kedar
    // 2.1.23 
    public static void main(String[] args){ // testing was done here 
        Object[] values = VariableIntUtils.createVariableObject(); // create array of objects 
        VariableInt variable = (VariableInt) values[0]; // get the return values from the array
        int attempts = (int) values[1]; // // get the return values from the array
        //print out the values for testing 
        System.out.println("Variable created: [" + variable.getName() + " , " + variable.getValue() + "]");
        System.out.println("Attempts: " + attempts);
    }
}