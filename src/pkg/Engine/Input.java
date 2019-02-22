package pkg.Engine;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Input {

    private static final String LocationOfTable  = "tablazat.txt";
    private static char[] symbols = {'b', 'n', '{', '}', '(', '*', ')', ':', '=', '<', '>', ' ', 'e', '$'};

    public static void ReadFile(){
        try(BufferedReader br = new BufferedReader(new FileReader(LocationOfTable))) {
            for(String line; (line = br.readLine()) != null; ) {
                String[] SplitedLine = line.split(";");
                for(int i = 0; i < symbols.length; i++){
                    Build.DomoLTable.add(
                            new Operator(
                                    Integer.parseInt(SplitedLine[0]),
                                    Integer.parseInt(SplitedLine[i + 1]),
                                    symbols[i],
                                    Boolean.parseBoolean(SplitedLine[15]),
                                    Boolean.parseBoolean(SplitedLine[16])
                            ));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
