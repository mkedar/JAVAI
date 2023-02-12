import java.util.Scanner;  

class PrintPurchaseReceipt {
    // Matan Kedar
    // 2.8.23 
    public static void main(String[] args) {
        // create the scanner object 
        Scanner myObj = new Scanner(System.in);

        // gather input 
        System.out.println("Please enter the name of the item: ");
        String itemName = myObj.nextLine();
        System.out.println("Please enter the price for each item: ");
        Double itemPrice = myObj.nextDouble();
        System.out.println("Please enter the quantity: ");
        int itemQuantity = myObj.nextInt();
        System.out.println("Is this a gift? ");
        String gift = myObj.next();
        char giftC = gift.charAt(0);
        System.out.println("Please enter the description of the occasion: ");
        String description = myObj.next();
        
        // print inputs
        double TAX = 0.1;
        System.out.println("========== RECEIPT ==========");
        System.out.println("Name:       " + itemName);
        System.out.println("Price:      $" + itemPrice);
        System.out.println("Quantity:   " + itemQuantity);
        System.out.println("Subtotal:   $" + itemQuantity*itemPrice);
        double taxs = itemQuantity * itemPrice * TAX;
        taxs = Math.round(taxs * 100.0) / 100.0;
        System.out.println("Tax:        $" + taxs);
        double total = ((itemQuantity*itemPrice) + itemQuantity*itemPrice*TAX);
        total = Math.round(total * 100.0) / 100.0;
        System.out.println("Total:      $" + total);
        System.out.println("Gift (y/n): " + giftC );
        System.out.println("Occasion:   " + description);
        System.out.println("============================");
    }
}
