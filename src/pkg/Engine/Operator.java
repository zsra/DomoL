package pkg.Engine;

public class Operator {

    private int OperatorId;
    private int TargetId;
    private char Target;
    private boolean Backup;
    private boolean Input;

    public Operator(int id, int t_id, char t, boolean bu, boolean in){
        this.setOperatorId(id);
        this.setTargetId(t_id);
        this.setTarget(t);
        this.setBackup(bu);
    }

    public void setInput(boolean input) {
        this.Input = input;
    }

    public void setBackup(boolean backup) {
        this.Backup = backup;
    }

    public void setOperatorId(int id){
        this.OperatorId = id;
    }

    public void setTargetId(int id){
        this.TargetId = id;
    }

    public void setTarget(char target) {
        this.Target = target;
    }

    public boolean isInput() {
        return this.Input;
    }

    public boolean isBackup() {
        return this.Backup;
    }

    public int getOperatorId(){
        return this.OperatorId;
    }

    public int getTargetId(){
        return this.TargetId;
    }

    public char getTarget() {
        return this.Target;
    }
}
