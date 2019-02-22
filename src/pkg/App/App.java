package pkg.App;

import pkg.Debug.Debug;
import pkg.Engine.Build;
import pkg.Engine.Input;
import pkg.Engine.Table;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Input.ReadFile();
        Scanner scan_in = new Scanner(System.in);
        Build.InputString = scan_in.next();
        //Debug.WriteDomoLTable();
        Build.Run();
        Table.Write();
    }
}
