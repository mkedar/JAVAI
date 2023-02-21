import java.util.Scanner;

class countTheFirstNumber {
    // Matan Kedar 
    // 2.16.23
    public static void main(String[] args) {
        // scanner class
        Scanner myObj = new Scanner(System.in);  
        
        // ask for input 
        System.out.println("How long will your list of grades be? ");
        int num = myObj.nextInt();
        
        myObj.nextLine();
        System.out.println("Enter the list of grades: ");
        String user = myObj.nextLine();
        myObj.close();
        // call the calculate function 
        String final1 = reportGradeList(user, num);
        System.out.println(final1);
        
    }
    public static String reportGradeList(String input, int num ){
        
        // intalize varaibles 
        String value = "";
        int amountOfA = 0, invalidGrades = 0, passingGrades = 0;
        
        // scan input to add to the 3 counters 
        for(int i =0; i<input.length(); i++){
            // boolean logic gate for every char in the input varaible 
            //System.out.print(input.charAt(i));
            // If passes; adds 1 to A counter 
            if(input.charAt(i) == 'A'){
                amountOfA++;
            }
            // If passes; adds 1 to the passingGrades counter
            if((input.charAt(i) == 'A')
            ||(input.charAt(i) == 'B')
            ||(input.charAt(i) == 'C')) {
                passingGrades++;
            }
            // If passes: adds 1 to the invalidGrades counter 
            if((input.charAt(i) != 'A')
            &&(input.charAt(i) != 'B')
            &&(input.charAt(i) != 'C')
            &&(input.charAt(i) != 'D')
            &&(input.charAt(i) != 'F')
            &&(input.charAt(i) != ',')
            &&(input.charAt(i) != ' ')){
                invalidGrades++;
            }
        }    
        // return of the final string 
        return(String.valueOf(passingGrades)) + " , " + 
            (String.valueOf(amountOfA)) + " , " + 
            (String.valueOf(invalidGrades)); 
        
    }
    
}