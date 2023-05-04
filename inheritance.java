
import java.util.Vector;

// Matan Kedar
// 5/3/2023

class Variable{ // default variable class
    private String name;

    public Variable(String name){
        this.name = name;
    }
    public String toString(){
        return "VAR(" + this.name + ")";
    }
    public boolean contains(String searching){
        return this.name.toLowerCase().contains(searching.toLowerCase());
    }
}

class VariableString extends Variable{ // inheritancy from varaible 
    private String valuesString;

    public VariableString(String name, String valuesString){
        super(name);
        this.valuesString = valuesString;
    }
    @Override
    public String toString(){
        return super.toString() +   "    VALUE(" + this.valuesString + ")";
    }
    @Override
    public boolean contains(String searching){    
        boolean output = super.contains(searching) || this.valuesString.toLowerCase().contains(searching.toLowerCase()); 
        return output;
    }
}

class VariableInt extends Variable{ // inheritancy from varaible 
    private int valueInt;

    public VariableInt(String name, int valueInt){
        super(name);
        this.valueInt = valueInt;
    }
    @Override
    public String toString(){
        return super.toString() +  "    VALUE(" + this.valueInt + ")";
    }
}
class findV{
    public static Vector<Variable> findVariables(Vector<Variable> list, String search){
        Vector<Variable> output = new Vector<Variable>();
        int size = list.size();
        for (int i = 0; i < size; i++){ // tries to find the search using .contains() function
            Variable var = list.get(i);
            if (var.contains(search)){
                output.add(var);
            }
        }
        return output;
    }
}

public class inheritance{
    public static void main(String[] args){
        
        Variable testing = new Variable("testing"); // testing default 
        System.out.println(testing);   // testing @overide     

        Vector<Variable> variables = new Vector<>(); // inhertancy testing for both VaraibleString and VaraibleInt functions 
        variables.add(new VariableString("first_name", "Matan")); // override for string
        variables.add(new VariableString("last_name", "Kedar"));  // overide for string 
        variables.add(new VariableInt("age", 18)); //override for int 
        variables.add(new VariableInt("phone", 650714888)); //override for int \
        variables.add(new VariableString("birth_country", "Israel")); //override for string 
        Vector<Variable> result = findV.findVariables(variables, "tan"); // look for tan in any of them. Find the tan from Matan
         System.out.println(result);
    }
}
