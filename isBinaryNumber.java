import java.util.Scanner; 

class isBinaryNumber {
  // Matan Kedar 
  // 3.18.23
    
    
    public static boolean isBinaryNumber(String input) {
        if(input.length() == 0) {
            return false;
        }
        for(int i = 0; i < input.length(); i++) {
            if(input.charAt(i) != '0' && input.charAt(i) != '1') {
                return false; 
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Enter possible binary numnber: ");
        Scanner myObj = new Scanner(System.in);   
        String input1 = myObj.nextLine();
        System.out.println(isBinaryNumber(input1));
    }
}