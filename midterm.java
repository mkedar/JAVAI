import java.util.Scanner;

class midterm {
    // Matan Kedar
    // 3.22.23

    // For validation and test cases of these problems, I inputted the given test cases (all in the main function) on the pdf in the Strings tester 0-4. 
    // In my validation at the end, every test case passed. 
    // Print lines are commented off at each problem. Uncomment them for the solution. It is important to note that problem 4 will turn on a scanner whenever the code is run.
    // Thank you, Matan

    public static void main(String[] args) {       
       
        //  HAS TWO DASHES, PROBLEM 1 
        String tester ="-ab-"; // Can swich this out to test code. Passed 9/9 of the given test cases. ("a--b" is supposed to be true , false)
        boolean[] boolOutput1 = {false, false}; 
        hasTwoDashes(tester, boolOutput1);
        //System.out.println(boolOutput1[0] + "\n" + boolOutput1[1]);
        

        //  CHECK FOR BLANKS, PROBLEM 2
        char[] tester2 = {' ', ' ', ' ', 'a', ' ', 'b', '\0'}; // Can switch out this array to test code. Passed 9/9 of the given test cases.
        int[] intOutput2 = {0};
        boolean[] boolOutput2 = {false};
        int[] int2Output2 = {0};
        checkForBlanks(tester2, intOutput2, boolOutput2, int2Output2);
        //System.out.println(intOutput2[0] + "\n" + boolOutput2[0] + "\n" + int2Output2[0]);

        
        //  REMOVE ALL NEGATIVES, PROBLEM 3
        int[] tester3 = {10, 20, 30, -1, 40, -1, 0, 50}; // Can switch out this array to test code. Passed 10/10 of the given test cases.  
        boolean[] boolOutput3 = {false};
        int[] intOutput3 = {0};
        removeAllNegatives(tester3, boolOutput3, intOutput3);
        //System.out.println(intOutput3[0] + "\n" + boolOutput3[0]);


        // READ NUMBER UNTIL TWO NEGATIVES, PROBLEM 4
        int result4 = readNumUntilTwoNegatives(); // For this problem, I copied all the test cases to see if the right output is given. Passed 4/4 of the given test cases. 
        System.out.println("Count: " + result4); // If you run this code, the scanner in this function will automatically ask for input.
    }

    public static void hasTwoDashes(String userInput, boolean[] boolOutput1){
        boolean[] calculations = new boolean[2];
        calculations[0] = false;
        calculations[1] = false;

        for(int i = 0; i < userInput.length(); i++){ // Only 1 itteration 
            if(i != userInput.length()-1 && userInput.charAt(i) == '-' && userInput.charAt(i+1) == '-' ){
                calculations[0] = true; 
            }    
        }
        try{
        if((userInput.charAt(0) == '-' && userInput.charAt(1)== '-')||(userInput.charAt(userInput.length()-1) == '-' && userInput.charAt(userInput.length()-2)== '-')) {
            calculations[1] = true;
        }} catch(Exception e) {}
        boolOutput1[0] = calculations[0];
        boolOutput1[1] = calculations[1];
    }

    public static void checkForBlanks(char[] input, int[] intOutput2, boolean[] boolOutput3, int[] int2Output2){
        int blankCounter = 0, leadingCounter = 0, voidCounter = 0;
        boolean allBlanks = false, streak = true;
        for(int i = 0; i < input.length; i++){ // Only 1 itteration 
            if(input[i] == ' '){
                blankCounter++;
                leadingCounter = streak == true ? leadingCounter+1 : leadingCounter;
            }
            else if(input[i] == '\0'){
                voidCounter++; 
            }
            else{
                streak = false;
            }
        } 
        if(blankCounter+voidCounter == input.length){
            allBlanks = true;
        }
        intOutput2[0] = blankCounter;
        boolOutput3[0] = allBlanks;
        int2Output2[0] = leadingCounter;
    
    }
    
    public static void removeAllNegatives(int[] input, boolean[] boolOutput3, int[] intOutput3){
        boolean allZeros = false;
        int negativeCounter = 0, allZeroCounter = 0;
        int[] alteredInput = input; 
        for(int i = 0; i < input.length; i++){ // Only 1 itteration 
            if(input[i] <= 0){
                allZeroCounter++;
            }
            if(input[i] < 0){
                negativeCounter++;
                alteredInput[i] = 0; 
            }
        }
        //System.out.println("BLANKCOUNTER  =     " + allZeroCounter + "INPUTLENGHT =    " + (input.length) );
        if(allZeroCounter == input.length){
            allZeros = true; 
        }
        boolOutput3[0] = allZeros;
        intOutput3[0] = negativeCounter;
    }

    public static int readNumUntilTwoNegatives(){
        System.out.println("Please enter the list ending with two negatives: "); // No arrys or array list used 
        boolean loop = true;
        int length = 0, pastNum = 0; 
        Scanner scanner = new Scanner(System.in); 
        while(loop){
            int userInput = scanner.nextInt();
            length++; 
            if(userInput < 0 && pastNum < 0){
                loop = false;
            }
            pastNum = userInput; 
        }
        return length-2; // This funtion returns an int as asked instead of changing the values through arrays. 
    }
}
