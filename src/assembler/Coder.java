package assembler;
import java.util.HashMap;
import java.util.Map;

/**
 * Names: Itay Sabato, Rotem Barzilay <br/>
 * Logins: itays04, rotmus <br/>
 * IDs: 036910008, RID <br/>
 * Date: 13/11/2010 <br/>
 * Time: 23:14:51 <br/>
 */
public class Coder {
    private static Coder instance = new Coder();
    private  Map<String, String> mnemonicsToBinary;

    private Coder() {
        mnemonicsToBinary = new HashMap<String, String>();
        initJumps();
        initComps();
    }

    public static Coder getInstance() {
        return instance;
    }

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

     public  String comp(String comp) {
         if(comp.contains("M")) {
                  return  "1"+mnemonicsToBinary.get(comp.replaceAll("M","A"));
         }
         else {
             return "0"+ mnemonicsToBinary.get(comp);
         }
    }

     public String jump(String jump) {
        return mnemonicsToBinary.get(jump);
    }
}
