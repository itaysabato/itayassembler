package assembler;

import java.io.File;
import java.io.FileNotFoundException;
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
            File file = new File(args[0]);
            Parser parser = new Parser(file);

            while(parser.advance()) {
                String bits = "";

                if(parser.commandType() == CommandType.C) {
                    String[] cdj = parser.CParameters();
                    bits = "111"+Coder.comp(cdj[0])+Coder.dest(cdj[1])+Coder.jump(cdj[2]);
                }
                else if(parser.commandType() == CommandType.A) {
                    bits = Integer.toBinaryString(Integer.parseInt(parser.symbol()));
                    char[] paddingZeros =   new char[ADDRESS_LEN - bits.length()];
                    Arrays.fill(paddingZeros, '0');
                    bits = new String(paddingZeros)  + bits;
                }
                else {
                    
                }
                System.out.println(bits);
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }


    }

}
