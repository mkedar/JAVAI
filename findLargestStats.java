class findLargestStats {
    // Matan Kedar
    // 3/7/23
    public static String findLargestStats(int[] num) { 
        int largest = 0, amountOfLargest = 0;
        boolean bigger = false;
        for(int i = 0; i < num.length; i++){
            largest = num[i] > largest ? num[i] : largest;
        }
        bigger = (largest == num[0]||largest == num[num.length-1]) ? true: false;
        for(int j = 0; j < num.length; j++){
            amountOfLargest = num[j] == largest ? amountOfLargest + 1 : amountOfLargest;
        }
        return largest + " , " + (bigger == true ? "true" : "false") + " , " +  amountOfLargest;
    }
       
    public static void main(String[] args) {
       int[] num =  {50, 20, 30, 40, 10};
       String final1 = findLargestStats(num);
       System.out.println(final1);
    }
}