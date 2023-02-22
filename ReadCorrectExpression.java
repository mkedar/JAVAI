import java.util.Scanner;

public class ReadCorrectExpression
{
    // Matan Kedar
    // 2.20.23
    public static void main(String[] args) {
        // scanner class
        Scanner myObj = new Scanner(System.in);  
        
        // declare booleans
        boolean loop1 = true, loop2 = true, loop3 = true; 
        String raw1 = "", raw2 = "", raw3 = "";
        
        // collect operand 1 with needed verification 
        while(loop1){
            System.out.println("Please enter the first operand: ");
            raw1 = myObj.nextLine();
            if(isNum(raw1)&&(Integer.parseInt(raw1) >= 0)){
                loop1 = false;
            }
            else{
                handleError(raw1, "first");
            }
        }
        // collect operand 2 with needed verification 
        while(loop2){
            System.out.println("Please enter the second operand: ");
            raw2 = myObj.nextLine();
            if(isNum(raw2)&&(Integer.parseInt(raw2) >= 0)){
                loop2 = false;
            }
            else{
                handleError(raw2, "second");
            }
        }
        // collect operator with needed verification 
        while(loop3){
            System.out.println("Please enter the expression operator: ");
            raw3 = myObj.nextLine();
            if(isOperation(raw3)){
                loop3 = false;
            }
            else{
                System.out.println("Unsupported operator. Please try again.");
            }
        }
        // display correct operator 
        String output = "Something went wrong";
        output =    raw3.equals("+") ? ("    " + raw1 + "    +    " + raw2 + "    =    " + (Integer.parseInt(raw1) + Integer.parseInt(raw2))): 
                    raw3.equals("-") ? ("    " + raw1 + "    -    " + raw2 + "    =    " + (Integer.parseInt(raw1) - Integer.parseInt(raw2))): 
                    raw3.equals("*") ? ("    " + raw1 + "    *    " + raw2 + "    =    " + (Integer.parseInt(raw1) * Integer.parseInt(raw2))):
                    raw3.equals("/") ? ("    " + raw1 + "    /    " + raw2 + "    =    " + (Integer.parseInt(raw1) / Integer.parseInt(raw2))):
                    raw3.equals("%") ? ("    " + raw1 + "    %    " + raw2 + "    =    " + (Integer.parseInt(raw1) % Integer.parseInt(raw2))):
                    output;

        // print final message         
        System.out.println(output);
        
    }
    
    // verification for operand 1 & 2  
    public static boolean isNum(String raws){
        int output = 0; 
        try{
            output = Integer.parseInt(raws);
        } catch(Exception e){
            return false;
        }
        return true;
    }
    // verification for the inputted operator 
    public static boolean isOperation(String raws) {
        if(raws.equals("+") || raws.equals("-") || raws.equals("/") || raws.equals("*") || raws.equals("%")){
            return true;
        }
        return false;
    }
    // handle the 2 types of erros 
    public static void handleError(String raws, String order){
        if(isNum(raws) && (Integer.parseInt(raws) < 0)){
            System.out.println("The " + order + " operand cannot be negative. Please try again." );
        }
        else{
            System.out.println("Unable to read the number for the " + order + " operand. Please try again.");
        }
    }
}