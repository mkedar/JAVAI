import java.util.Scanner; 

class confirmPIN {
  // Matan Kedar 
  // 3.14.23
    
    
    public static boolean confirmPin(int output[]) {
        System.out.println("Please enter a PIN: ");
        Scanner myObj = new Scanner(System.in);
        int input1 = myObj.nextInt();
        System.out.println("Please enter the same PIN again for confirmation: ");
        int input2 = myObj.nextInt();
        
        if(input1 == input2){
            output[0] = input1;
            return true;
        }
        else{
            output[0] = 0;
            return false;
        }
        
    }

    public static void main(String[] args) {
        int[] output = {0};
        boolean confirmPin = confirmPin(output); 
        if(confirmPin){
            System.out.println("Answer: true\nPIN:   " + output[0]);
        }
        else{
            System.out.println("Answer: false\nPIN:   " + output[0]);
        }
    }
}