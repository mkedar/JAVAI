public class midterm2 {

    // Matan Kedar
    // 4.26.2023
    // This is 1/2 of the java files

    public static int[] getLargest(Expression[] arrExpressions) { // PROBLEM #2 , returns an interger array with the right calculations
        int[] output = {-1, 0};
        int index = 0, largest = arrExpressions[0].translate(), count = 1;
        for (int i = 1; i < arrExpressions.length; i++) { // Single iteration
            int currentValue = arrExpressions[i].translate();
            if (currentValue > largest) {
                largest = currentValue;
                index = i;
                count = 1;
            } 
            if (currentValue == largest) {
                count++;
            }
        }
        if (index >= 0) { // final validation
            output[0] = index;
            output[1] = count;
        }
        return output;
    }

    public static int[] getExpListInfo(Expression[] expressions, Expression relate) { // PROBLEM #3 , returns an interger array with the right calculations
        int[] results = new int[2];
        int counter = 0, counter2 = 0;
        for (int i = 0; i < expressions.length; i++) {
            Expression exp = expressions[i];
            if (exp.hasOneOperandTheSame(relate)) { // add up counters if conditions has passed
                counter++;
            }
            if (exp.compare(relate) == 0) {  // add up counters if conditions has passed
                counter2++;
            }
        }
        results[0] = counter;
        results[1] = counter2;
        return results;
    }    

    public static Expression[] getTwoExpressions(int operand1, int operand2, char operator) { // PROBLEM #4,  returns an array of the Expression object
        Expression output[] = null;
        if ((operator == '+') || (operator == '-')) { // checks if its + or - or otherwise leaves the output array as null
            Expression one = new Expression(operand1, operand2, operator);
            Expression two = one.createDoubleExp();
            output = new Expression[]{one, two};
        }
        return output;
    }

    public static void main(String[] args) { // I used this for various testing of all the functions I made here
        Expression example1 = new Expression(100, 100, '+');
        Expression example2 = new Expression(100, 5, '/');
        System.out.println(example1);
        System.out.println(example2);
        System.out.println(example1.translate());
        System.out.println(example2.translate());
        System.out.println(example1.compare(example2));

        Expression[] arrExpressions1 = {new Expression(1, 1, '+'), new Expression(10, 10, '-')};
        Expression relate = new Expression(1, 1, '+');
        int[] expListInfo = getExpListInfo(arrExpressions1, relate);
        System.out.println(expListInfo[0] + " , " + expListInfo[1]);

        Expression[] arrExpressions2 = {new Expression(5, 10, '*'), new Expression(10, 5, '*'), new Expression(10, 10, '*')};
        Expression relate2 = new Expression(2, 2, '*');
        int[] expListInfo2 = getExpListInfo(arrExpressions2, relate2);
        System.out.println(expListInfo2[0] + " ,  " + expListInfo2[1]);

        Expression[] arrExpressions3 = {new Expression(20, 10, '+'), new Expression(2, 2, '-'), new Expression(10, 2, '/')};
        int[] largest = getLargest(arrExpressions3);
        System.out.println(largest[0] + " , " + largest[1]);
    
        Expression[] arrExpressions4 = getTwoExpressions(50, 100, '+');
        System.out.println(arrExpressions4[0]);
        System.out.println(arrExpressions4[1]);
    }


}