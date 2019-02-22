package pkg.Engine;

import java.util.ArrayList;
import java.util.List;

public class Build {

    public static List<Operator> DomoLTable
            = new ArrayList<Operator>();

    private static int Position = 1;
    public static String InputString = "";
    public static List<Table> Result = new ArrayList<Table>();
    private static int index = 0;
    private static char[] specialCharacters =
            {'{', '}', '(', '*', ')', ':', '=', '<', '>', ' ', 'e', '$'};

    public static void Run(){
        do{
            //CHECK: Character is a number
            if(isNumber(InputString.charAt(index))){
                Position = 4;
            }
            //CHECK: Character is a letter
            else if(isLetter(InputString.charAt(index))){
                Position = 2;
            }
            //CHECK: Character is a special character
            else if(isSpecialChar(InputString.charAt(index))){
                switch (InputString.charAt(index)){
                    case '(': {
                        Position = 8;
                    } break;
                    case '{': {
                        Position = 6;
                    } break;
                    case ':': {
                        Position = 13;
                    } break;
                    case '*': {
                        index++;
                    }break;
                    case '}': {
                        index++;

                    }break;
                    case ')': {
                        index++;
                    }break;
                    default: {
                        Position = 15;
                    } break;
                }
            }

            switch (Position){
                case 2: {
                    /*
                    Read input and build azonosito
                    * */
                    String builder = "";
                    while (!isIndexOutOfRange(index) && isLetter(InputString.charAt(index))){
                        builder += InputString.charAt(index);
                        index++;
                    }
                    Position = 3;
                    Table.addTable("azonosito", builder);
                }break;
                case 4:{
                    /*
                    Read input and build szam
                    * */
                    String builder = "";
                    while (!isIndexOutOfRange(index) && isNumber(InputString.charAt(index))){
                        builder += InputString.charAt(index);
                        index++;
                    }
                    Position = 5;
                    Table.addTable("szam", builder);
                }break;
                case 6: {
                    /*
                    Read input and build {} komment
                    * */
                    String builder = "";
                    index++;
                    while (!isIndexOutOfRange(index) && InputString.charAt(index) != '}'){
                        builder += InputString.charAt(index);
                        index++;
                    }
                    Position = 5;
                    index++;
                    Table.addTable("{} komment", builder);
                    if(isIndexOutOfRange(index)){
                        Table.addTable("azonosito", builder);
                        Position = 21;
                        break;
                    }
                } break;
                case 8: {
                    /*
                    Read input and build (**) komment
                    * */
                    if(!isIndexOutOfRange(index + 1)){
                        if(InputString.charAt(index + 1) == '*'){
                            String builder = "";
                            index+=2;
                            while (!isIndexOutOfRange(index)){
                                if(InputString.charAt(index) == '*' ){
                                    if(!isIndexOutOfRange(index + 1)){
                                        if(InputString.charAt(index + 1) == ')'){
                                            Table.addTable("(**) komment", builder);
                                            Position = 11;
                                            index++;
                                            break;
                                        }
                                    }
                                }
                                builder += InputString.charAt(index);
                                index++;
                                // If, the input dont have e close tag, we set as azonisito
                                if(isIndexOutOfRange(index)){
                                    Table.addTable("azonosito", builder);
                                    Position = 21;
                                    break;
                                }
                            }
                        }
                    }
                    index++;
                }break;
                case 13: {
                    if(!isIndexOutOfRange(index + 1)){
                        if(InputString.charAt(index + 1) == '='){
                            Table.addTable("ertekadas", "ertekadas");
                            index+=2;
                        }
                        else {
                            Position = 21;
                            break;
                        }
                    }
                } break;
            }

            //CHECK the string end
            if(isIndexOutOfRange(index)){
                Position = 21;
            }
        } while (!(Position == 21));

    }

    private static boolean isSpecialChar(char c){
        for(int i = 0; i < specialCharacters.length; i++){
            if(specialCharacters[i] == c){
                return true;
            }
        }
        return false;
    }

    private static boolean isIndexOutOfRange(int index){
        if(index >= InputString.length()){
            return true;
        }
        return false;
    }

    private static boolean isLetter(char letter){
        for(int c = 'a'; c <= 'z'; c++){
            if(Character.toLowerCase(letter) == c){
                return true;
            }
        }
        return false;
    }

    private static boolean isNumber(char letter){
        for(int i = 0; i <= 9; i++){
            if(Character.getNumericValue(letter) == i){
                return true;
            }
        }
        return false;
    }
}
