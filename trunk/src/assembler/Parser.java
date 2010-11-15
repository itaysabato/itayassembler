package assembler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Names: Itay Sabato, Rotem Barzilay <br/>
 * Logins: itays04, rotmus <br/>
 * IDs: 036910008, RID <br/>
 * Date: 13/11/2010 <br/>
 * Time: 23:09:28 <br/>
 */
public class Parser {
    private Scanner source;
    private String line = "";

    public Parser(File source) throws FileNotFoundException {
        this.source = new Scanner(source);
    }

    public boolean advance() {
        boolean hasNext = false;
        while(source.hasNextLine()) {
            line = source.nextLine();
            if(!line.isEmpty() && !line.startsWith("/")){
                hasNext = true;
                break;
            }
        }
        return hasNext;
    }

    public CommandType commandType()  {
        if(line.startsWith("@")) return CommandType.A;
        return line.startsWith("(") ? CommandType.L : CommandType.C;
    }

    public String symbol() {
        if(line.charAt(0) == '(') {
            return line.substring(1, line.length() - 1);
        }
        return line.substring(1);
    }

    public String dest() {
        if(!line.contains("=")) return null;
        String[] sp =  line.split("=");
        line = sp[1];
        return sp[0];
    }

    public String comp() {
        if(line.contains(";")) {
            String[] sp =  line.split(";");
            line = sp[1];
            return sp[0];
        }
        String res = line;
        line = null;
        return res;
    }

    public String jump() {
        return line;
    }

    public void close() {
        source.close();
    }
}
