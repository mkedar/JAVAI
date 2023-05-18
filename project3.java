import java.util.Scanner;
import java.util.Vector;

// Matan Kedar
// 5/17/23

class Assignment { // creating assignment object
    private String variableName;
    private int value;

    public Assignment(String variableName, int value) {
        this.variableName = variableName;
        this.value = value;
    }
    public String getVariableName() {
        return variableName;
    }
    public int getValue() {
        return value;
    }
    @Override 
    public String toString() {
        return variableName + " = " + value;
    }
}
class CompoundAssignment extends Assignment { // compound assignment inhearants assignment functions
    private String binaryOperator;

    public CompoundAssignment(String variableName, int value, String binaryOperator) {
        super(variableName, value);
        this.binaryOperator = binaryOperator;
    }

    public void setBinaryOperator(String binaryOperator) { // getters and setters 
        this.binaryOperator = binaryOperator;
    }
    public String getBinaryOperator(){
        return binaryOperator;
    }

    @Override
    public String toString() {
        return getVariableName() + " = " + getVariableName() + " " + getBinaryOperator() + " " + getValue();
    }
    
}

public class project3 { 
    public static String input(){ // gather input from user
        Scanner myObj = new Scanner(System.in);  
        boolean loop = true;
	String input = ""; 
    while(loop){  // filter input to be 1/4 words
	    System.out.println("Please enter a command (add, list, stats or exit):");
	    input = myObj.nextLine();
 	    if(input.equals("add") == true ||input.equals("list") == true||input.equals("stats") == true||input.equals("exit") == true){
            loop = false;
        }
	    else{
	        System.out.println("Unsupported command. Please try again.");  
        }
	}
        return input;
    }
    public static boolean isNum(String input) {  // find if input is between 0-9 or has a negative sign
        return input.matches("-?\\d+") ? true : false;
    }
    public static boolean isNum(char input) { // find if the char is a number
        return Character.isDigit(input);
    }    
    public static Assignment add(){ // add a assignment to the vector 
        Scanner myObj = new Scanner(System.in);
        boolean loop = true;
        String[] arr = null; 
        while (loop) {
            String input = myObj.nextLine().replaceAll("\\s", "");
            try { // filter certian ways to create the assignments. And output the correct errors, when the errors are made.
                arr = input.split("=", 2);
                if (arr.length != 2 ){
                    throw new Exception("Invalid assignment operator");
                }
                if (isNum(arr[0]) || isNum(arr[0].charAt(0))){
                    throw new Exception("Invalid variable name.");
                }
                if (!isNum(arr[1])){
                    throw new Exception("The assignment value is not a number.");
                }
                loop = false;
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage()); 
            }
        }
        Assignment output = new Assignment(arr[0], Integer.parseInt(arr[1])); // combine the info from the for loop 

        return output;
    }    
    public static void list(Vector<Assignment> vector, Vector<CompoundAssignment> vector1) { // list the assingments in order 
        if (vector.isEmpty() && vector1.isEmpty()) {
            System.out.println("There are no assignments");
        } else {
            int j = vector.size();
            if (vector1.size() > vector.size()) {
                j = vector1.size();
            }            
            for (int i = 0; i < j; i++) {
                if (i < vector.size() && vector.get(i).getVariableName() != null) { // skips over null for correct placement
                    System.out.println(vector.get(i));
                }
                else if(i < vector1.size() && vector1.get(i).getVariableName() != null) { // skips over null for correct placement
                    System.out.println(vector1.get(i));
                }
            }
            
        }
    }
    
    public static void stats(Vector<Assignment> vector, Vector<CompoundAssignment> vector1) { // simple counters
        if (vector.isEmpty() && vector1.isEmpty()) {
            System.out.println("No assignments found.");
            return;
        }
        
        int pos = 0, neg = 0, counter = 0;
        Assignment highest = vector.get(0);
        Assignment smallest = vector.get(0);
        
        for (Assignment currentAssignment : vector) {
            if (currentAssignment.getVariableName() == null) {
                continue; // skip the null iteration
            }
            if (currentAssignment.getValue() > highest.getValue()) {
                highest = currentAssignment;
            }
            if (currentAssignment.getValue() < smallest.getValue()) {
                smallest = currentAssignment;
            }
            if (currentAssignment.getValue() > 0) {
                pos++;
            }
            if (currentAssignment.getValue() < 0) {
                neg++;
            }
            counter++;
        }
        
        for (CompoundAssignment currentAssignment : vector1) {
            if (currentAssignment.getVariableName() == null) {
                continue;// skip the null iteration
            }
            if (currentAssignment.getValue() > highest.getValue()) {
                highest = currentAssignment;
            }
            if (currentAssignment.getValue() < smallest.getValue()) {
                smallest = currentAssignment;
            }
            if (currentAssignment.getValue() > 0) {
                pos++;
            }
            if (currentAssignment.getValue() < 0) {
                neg++;
            }
            counter++;
        }
        
        System.out.println("Total number of assignments:          " + counter);
        System.out.println("Total number of positive assignments: " + pos);
        System.out.println("Total number of negative assignments: " + neg);
        System.out.println("The largest assignment:               " + highest);
        System.out.println("The smallest assignment:              " + smallest);
    }

    public static String getOperator(String input) {
        String output = "";    
        if (input.contains("+")) {
            output = "+";
        } else if (input.contains("-")) {
            output = "-";
        } else if (input.contains("*")) {
            output = "*";
        } else if (input.contains("/")) {
            output = "/";
        } else if (input.contains("%")) {
            output = "%";
        } else {
            output = "No operator found";
        }
    
        return output;
    }
    
    public static void main(String[] args) { // main method 
    System.out.println("Welcome to assignment recording program.");
    Vector<Assignment> vector= new Vector<>(); // main vector creation to track all the assignments. 
    Vector<CompoundAssignment> vector1 = new Vector<>(); // track compound asisngments. 
    boolean update = true;
    while(update){ // while loop for the program to be able to be run indefiently 
        String userInput = input(); // gather validated user input 
        if(userInput.equals("add")){
            Assignment assignment = add(); // find if the assignment is a compound assignment
            if (assignment.getVariableName().endsWith("+") || assignment.getVariableName().endsWith("-") ||
            assignment.getVariableName().endsWith("/") || assignment.getVariableName().endsWith("*") ||
            assignment.getVariableName().endsWith("%")) {
                    CompoundAssignment assignment2 = new CompoundAssignment(assignment.getVariableName().substring(0, 
                                                        assignment.getVariableName().length() - 1), assignment.getValue(), 
                                                        getOperator(assignment.getVariableName()));
                    vector1.add(assignment2);
                    vector.add(new Assignment(null, 0)); // makes it easier to list them later on
            }
            else{
                vector.add(assignment);
                vector1.add(new CompoundAssignment(null, 0,"+")); // makes it easier to list them later on
            }            
        }
        if(userInput.equals("list")){
            list(vector, vector1); // calls the list function 
        }
        if(userInput.equals("stats")){
            stats(vector, vector1); // calls the stats function
        }
        if(userInput.equals("exit")){ // exits out of the while loop
                System.out.println("Thank you. Goodbye.");
                update = false;
        }
        }
    }
}

