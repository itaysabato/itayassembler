package assembler;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Names: Itay Sabato, Rotem Barzilay <br/>
 * Logins: itays04, rotmus <br/>
 * IDs: 036910008, 300618592 <br/>
 * Date: 13/11/2010 <br/>
 * Time: 23:08:29 <br/>
 */

/**
 * An assembler program which get the file path of an asm file
 *  in his args, traslate it to binary code and output a hack file.
 */
public class Assembler {
    private static final int ADDRESS_LEN = 16;
    private static final int ADDRESS_START= 16;

    public static void main(String[] args) {
        try {
            File in = new File(args[0]);
            File out = new File(args[0].replaceAll("\\.asm", ".hack"));
            PrintStream printer =  new PrintStream(out);
            Parser parser = new Parser(in);
            Map<String, String> symbols = initSymbols();

            int PC= 0;    // first pass
            while(parser.advance()) {
                if(parser.commandType() == CommandType.L) {
                    symbols.put(parser.symbol(), toAddress(PC));
                }
                else PC++;
            }

            Coder coder = Coder.getInstance();
            parser =  new Parser(in);

            int VC = ADDRESS_START; // second pass
            while(parser.advance()) {
                String bits;

                if(parser.commandType() == CommandType.C) {
                    String[] cdj = parser.CParameters();
                    bits = "111" + coder.comp(cdj[0]) + coder.dest(cdj[1]) + coder.jump(cdj[2]);
                }

                else if(parser.commandType() == CommandType.A) {
                    String symbol =    parser.symbol();
                    // assuming user defined symbols do not start with a digit:
                    if(symbol.matches("\\d(.*)")) {
                        bits = toAddress( Integer.parseInt(symbol) );
                    }
                    else {
                        bits = symbols.get(symbol);
                        if(bits == null) {
                            bits = toAddress(VC++);
                            symbols.put(symbol, bits);
                        }
                    }
                }
                else continue;
                printer.println(bits);
            }
        }
        catch (IOException e) {
            System.out.println("caught IOException: "+e.getMessage());
        }
    }

    /**
     * pads the given address with zeros
     */
    private static String toAddress(int address) {
        String bits = Integer.toBinaryString(address);
        char[] paddingZeros =  new char[ADDRESS_LEN - bits.length()];
         Arrays.fill(paddingZeros, '0');
         return new String(paddingZeros)  + bits;
    }

    /**
     * insert to the map the predefined symbols
     */
    private static Map<String, String> initSymbols() {
        Map<String, String> symbols = new HashMap<String, String>();
        symbols.put("SP", toAddress(0));
        symbols.put("LCL", toAddress(1));
        symbols.put("ARG", toAddress(2));
        symbols.put("THIS", toAddress(3));
        symbols.put("THAT", toAddress(4));
        symbols.put("SCREEN", toAddress(16384));
        symbols.put("KBD", toAddress(24576));

        for(int i = 0; i < 16; i++) {
            symbols.put("R"+i, toAddress(i));
        }
        return symbols;
    }
}
