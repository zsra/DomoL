package pkg.Engine;

public class Table {

    private String OperatorName;
    private String InputString;

    public Table(String name, String word){
        setOperatorName(name);
        setInputString(word);
    }

    public void setOperatorName(String operatorName) {
        this.OperatorName = operatorName;
    }

    public void setInputString(String inputString) {
        this.InputString = inputString;
    }

    public String getInputString() {
        return this.InputString;
    }

    public String getOperatorName() {
        return this.OperatorName;
    }

    public static void addTable(String op, String _str){
        Build.Result.add(new Table(op, _str));
    }

    public static void Write(){
        for(Table t : Build.Result){
            System.out.println(t.getInputString() + "\t==\t" + t.getOperatorName());
        }
    }
}
