package assembler;

import java.io.*;
import java.util.Arrays;

/**
 * Names: Itay Sabato, Rotem Barzilay <br/>
 * Logins: itays04, rotmus <br/>
 * IDs: 036910008, RID <br/>
 * Date: 13/11/2010 <br/>
 * Time: 23:08:29 <br/>
 */
public class Assembler {
    private static final int ADDRESS_LEN = 16;

    public static void main(String[] args) {
        try {
            File in = new File(args[0]);
            File out = new File(args[0].replaceAll("\\.asm", ".hack"));
//            if(out.exists()) {
//                out.delete();
//            }
//            out.createNewFile();

            PrintStream printer =  new PrintStream(out);
            Parser parser = new Parser(in);
            Coder coder = Coder.getInstance();

            while(parser.advance()) {
                String bits = "";

                if(parser.commandType() == CommandType.C) {
                    String[] cdj = parser.CParameters();
                    bits = "111"+coder.comp(cdj[0])+coder.dest(cdj[1])+coder.jump(cdj[2]);
                }

                else if(parser.commandType() == CommandType.A) {
                    bits = Integer.toBinaryString(Integer.parseInt(parser.symbol()));
                    char[] paddingZeros =   new char[ADDRESS_LEN - bits.length()];
                    Arrays.fill(paddingZeros, '0');
                    bits = new String(paddingZeros)  + bits;
                }

                else {
                    
                }
                printer.println(bits);
            }
        }
        catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

}
