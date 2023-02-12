import java.util.Scanner;  

class PrintExpressionsConditionally {
    // Matan Kedar
    // 2.9.23 
    public static void main(String[] args) {
        
        // intialize scanner object
        Scanner myObj = new Scanner(System.in);
        int firstInt, secondInt;
        // ask for input and store input inform
        System.out.println("Please enter the first operand: ");
        String first = myObj.next();
        if(first.matches("[0-9]+")){
            firstInt = Integer.parseInt(first);
        } 
        else{
            System.out.println("Unable to read the number for the first operand.");
            return;
        }
        
        System.out.println("Please enter the second operand: ");
        String second = myObj.next();
        if(second.matches("[0-9]+")){
            secondInt = Integer.parseInt(second);
        } 
        else{
            System.out.println("Unable to read the number for the second operand.");
            return;
        }

        System.out.println("Please enter the printing option ('A' or 'B'): ");
        String input = myObj.next();

        // verify inputs 
        if (!input.equals("A") && !input.equals("B")) {
            System.out.println("Unsupported printing option.");
            return;
        }
        
        // print statements based on input 
        if(input.equals("A")){
            System.out.println(firstInt + "    +    " + secondInt + "    =    " + (firstInt + secondInt)); 
            System.out.println(firstInt + "    -    " + secondInt + "    =    " + (firstInt - secondInt)); 
            System.out.println(firstInt + "    *    " + secondInt + "    =    " + (firstInt * secondInt)); 
            System.out.println(firstInt + "    /    " + secondInt + "    =    " + (firstInt / secondInt)); 
            System.out.println(firstInt + "    %    " + secondInt + "    =    " + (firstInt % secondInt)); 
        }
        else{
            System.out.println(firstInt + " + " + secondInt + " = " + (firstInt + secondInt)); 
            System.out.println(firstInt + " - " + secondInt + " = " + (firstInt - secondInt)); 
        }




    }
}