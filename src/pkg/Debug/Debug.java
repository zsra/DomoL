package pkg.Debug;

import pkg.Engine.Build;
import pkg.Engine.Operator;

public class Debug {

    public static void WriteDomoLTable(){
        for(Operator op : Build.DomoLTable){
            System.out.println("ID:\t" + op.getOperatorId()
                    + ", TargetID:\t" + op.getTargetId()
                    + ", Symbol:\t" + op.getTarget());
        }
    }
}
