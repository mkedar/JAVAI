import java.util.Scanner;
import java.util.ArrayList;

class project1 {
    // Matan Kedar 
    // 3/21/23

    // I understand some of the code might be vebose. I started coding without knowing of the array and arraylist restirctions.
    // So I had to revamp the entire code. But everything workes as inteended. 
    // Thanks, Matan!

    public static String assignmentMenu(){
        Scanner myObj = new Scanner(System.in); 
        String choice = "";
        boolean loop = true;
        while(loop){
            System.out.println("1. Enter a new assignment\n2. Show the largest assignment\n3. Show all assignments\n4. exit\n");
            System.out.print("Enter your option: ");
            choice = myObj.nextLine();
            try{
            if(Integer.parseInt(choice) < 5 && Integer.parseInt(choice) > 0){
                return choice;
            }
            else{
                System.out.println("\nInvalid selection. Please try again.\n");
            }
            } catch(Exception e){
                System.out.println("\nInvalid selection. Please try again.\n");   
            }
        }
        return "";
    }    

    public static String choice1(){ 
        Scanner myObj = new Scanner(System.in); 
        System.out.println("Please enter an assignment:");
        String input = myObj.nextLine() + "\n";
        System.out.println("     " + String.format("%-" + 10 + "s",  input.trim().replace(" = ", "         =        ")));
        return input;
    }
    public static void choice2(String total){
        int largest = -1; 
        total = total.replaceAll(" = "," ");
        total = total.replaceAll("\n",",");
        String[] str = total.split(",");
        for(int i = 0; i < str.length; i++){
            String[] parts = str[i].trim().split(" "); 
            int number = Integer.parseInt(parts[1]);
            if(number > largest || largest == -1){
                largest = number; 
            }
        }
        printNameAndNumber(total, largest);
    }
    public static void printNameAndNumber(String input, int number) {
        int fieldWidth = 10;
        String[] pairs = input.split(",");
        for (String pair : pairs) {
            String[] parts = pair.trim().split(" ");
            int value = Integer.parseInt(parts[1]);
            if (value == number) {
                System.out.println("\nThe largest assignment: ");
                System.out.println("     " + String.format("%-" + fieldWidth + "s",  pair.trim().replace(" ", "         =        ")));
                System.out.print("\n\n");
                break;
            }
        }
    }
    public static void choice3(String total){
        System.out.println("\nAll assignments: ");
        String[] lines = total.split("\\r?\\n");
        for (String line : lines) {
            String[] parts = line.split("=");
            String name = parts[0].trim();
            int value = Integer.parseInt(parts[1].trim());
            System.out.printf("%15s = %5d\n", name + "   ", value);
            
        }
        System.out.print("\n\n");
    }
    
    public static void main(String[] args) {
        String total = "", userInput = "", temp = "";
        System.out.println("Welcome to assignment recording program.");
        while(true){
            userInput = assignmentMenu();
            if(total.length() == 0 && (userInput.equals("2")|| userInput.equals("3"))){
                System.out.println("\nThere is no assignment.\n");     
            }
            else if(userInput.equals("1")){
                temp = choice1();
                total += temp;
            }
            else if(userInput.equals("2")){
                choice2(total);
            }
            else if(userInput.equals("3")){
                choice3(total);

            }
            else if(userInput.equals("4")){
                System.out.println("\n\nThank you. Goodbye.");
                System.exit(0);
            }
           
        } 
    }
}
