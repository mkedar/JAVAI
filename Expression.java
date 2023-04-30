public class Expression{
    
    // Matan Kedar
    // 4.26.2023
    // This is 1/2 of the java files

    private int operand1; // private variables throughout
    private int operand2;
    private char operator;

    public Expression(int operand1, int operand2, char operator) { // simple constructor
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operator = operator;
    }
    public int getOperand1() { // simple gets
        return operand1;
    }
    
    public char getOperator() { // simple gets
        return operator;
    }
    
    public int getOperand2() { // simple gets
        return operand2;
    }
    @Override
    public String toString(){ // required toString method 
        return "EXP(" + operand1 + " " + operator + " " + operand2 + ")";
    }
    public int compare(Expression comparison){ // rquired comaprison method
        int x = 0, output;
        x = Integer.compare(this.translate(), comparison.translate());
        output = x == 0 ? 0 : x < 0 ? -1 : 1; // ternary logic 
        return output;
    }
    public boolean hasOneOperandTheSame(Expression comparison) { // required method 
        boolean output = false;
        if (this.operand1 == comparison.getOperand1() || this.operand1 == comparison.getOperand2()) {
            output = true;
        } 
        if(this.operand2 == comparison.getOperand1() || this.operand2 == comparison.getOperand2()) {
            output = true;
        }  
        return output;
    }    
    public Expression createDoubleExp() { // double the given Expression
        int FACTOR = 2;
        int newOperand1 = this.operand1 * FACTOR;
        int newOperand2 = this.operand2 * FACTOR;
        Expression doubled = new Expression(newOperand1, newOperand2, this.operator);
        return doubled;
    }
    public int translate() {
        int result = 0;
        switch (operator) { // switch statement to use the correct operator
            case '+':
                result = operand1 + operand2;
                break;
            case '-':
                result = operand1 - operand2;
                break;
            case '*':
                result = operand1 * operand2;
                break;
            case '/':
                result = operand1 / operand2;
                break;
            default:
        }
        return result;
    }
}