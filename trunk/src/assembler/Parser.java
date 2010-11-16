package assembler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Names: Itay Sabato, Rotem Barzilay <br/>
 * Logins: itays04, rotmus <br/>
 * IDs: 036910008, 300618592 <br/>
 * Date: 13/11/2010 <br/>
 * Time: 23:09:28 <br/>
 */
public class Parser {
    private Scanner source;
    private String line = "";

    public Parser(File source) throws FileNotFoundException {
        this.source = new Scanner(source);
    }

    /**
     *   Advances to the next line.
     */
    public boolean advance() {
        while(source.hasNextLine()) {
            line = source.nextLine().replaceAll("( )|(//(.*))", ""); // get rid of spaces and comments
            if(!line.isEmpty()){
                return true;
            }
        }
        return false;
    }

     /**
     *   returns the command type.
     */
    public CommandType commandType()  {
        if(line.startsWith("@")) return CommandType.A;
        return line.startsWith("(") ? CommandType.L : CommandType.C;
    }

     /**
     *     returns the symbol of the A or L instruction.
     */
    public String symbol() {
        if(line.charAt(0) == '(') {
            return line.substring(1, line.length() - 1);
        }
        return line.substring(1);
    }

     /**
     *     returns the dest of the C-instruction.
     */
    public String dest() {
        if(!line.contains("=")) return "";
        String[] sp =  line.split("=");
        line = sp[1];
        return sp[0];
    }

      /**
     *     returns the comp of the C-instruction.
     */
    public String comp() {
        if(line.contains(";")) {
            String[] sp =  line.split(";");
            line = sp[1];
            return sp[0];
        }
        String res = line;
        line = "";
        return res;
    }

     /**
     *     returns the jump of the C-instruction.
     */
    public String jump() {
        return line;

     }

      /**
     *    closes the file.
     */
    public void close() {
        source.close();
    }

     /**
     *     returns the the C-instruction in an array(comp,dest,jump).
     */
    public String[] CParameters() {
        String[] result = new String[3];
        // the order DOES matter!
        result[1] = dest();
        result[0] = comp();
        result[2] = jump();
        return result;
    }
}
