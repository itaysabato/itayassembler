package assembler;
import java.util.HashMap;
import java.util.Map;

/**
 * Names: Itay Sabato, Rotem Barzilay <br/>
 * Logins: itays04, rotmus <br/>
 * IDs: 036910008, 300618592 <br/>
 * Date: 13/11/2010 <br/>
 * Time: 23:14:51 <br/>
 */

/**
 * This class translate C-instruction to binary.
 */
public class Coder {
    //singleton
    private static final Coder instance = new Coder();
    //This map contains all the symbols and their binary translation
    private  final Map<String, String> mnemonicsToBinary;

    private Coder() {
        mnemonicsToBinary = new HashMap<String, String>();
        initJumps();
        initComps();
    }

    public static Coder getInstance() {
        return instance;
    }

    /**
     *   Initialize the map with the jump symbols and their translation.
     */
    private void initJumps() {
        mnemonicsToBinary.put("","000");
        mnemonicsToBinary.put("JGT","001");
        mnemonicsToBinary.put("JEQ","010");
        mnemonicsToBinary.put("JGE","011");
        mnemonicsToBinary.put("JLT","100");
        mnemonicsToBinary.put("JNE","101");
        mnemonicsToBinary.put("JLE","110");
        mnemonicsToBinary.put("JMP","111");
    }

    /**
     *     //Initialize the map with the comp symbols and their translation.
     */
    private void initComps() {
        mnemonicsToBinary.put("0","101010");
        mnemonicsToBinary.put("1","111111");
        mnemonicsToBinary.put("-1","111010");
        mnemonicsToBinary.put("D","001100");
        mnemonicsToBinary.put("A","110000");
        mnemonicsToBinary.put("!D","001101");
        mnemonicsToBinary.put("!A","110001");
        mnemonicsToBinary.put("-D","001111");
        mnemonicsToBinary.put("-A","110011");
        mnemonicsToBinary.put("D+1","011111");
        mnemonicsToBinary.put("A+1","110111");
        mnemonicsToBinary.put("D-1","001110");
        mnemonicsToBinary.put("A-1","110010");
        mnemonicsToBinary.put("D+A","000010");
        mnemonicsToBinary.put("D-A","010011");
        mnemonicsToBinary.put("A-D","000111");
        mnemonicsToBinary.put("D&A","000000");
        mnemonicsToBinary.put("D|A","010101");
    }

       /**
     * returns the binary translation to the dest symbol
     */
    public String dest(String dest) {
        String  bits = "";

        if(dest.contains("A")) bits += '1';
        else   bits += '0';

        if(dest.contains("D")) bits += '1';
        else   bits += '0';

        if(dest.contains("M")) bits += '1';
        else   bits += '0';

        return bits;
    }

       /**
     * returns the binary translation to the comp symbol
     */
     public  String comp(String comp) {
         if(comp.contains("M")) {
                  return  "1"+mnemonicsToBinary.get(comp.replaceAll("M","A"));
         }
         else {
             return "0"+ mnemonicsToBinary.get(comp);
         }
    }

    /**
     * returns the binary translation to the jump symbol
     */
     public String jump(String jump) {
        return mnemonicsToBinary.get(jump);
    }
}
