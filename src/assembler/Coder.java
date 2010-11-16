package assembler;
import java.util.HashMap;
/**
 * Names: Itay Sabato, Rotem Barzilay <br/>
 * Logins: itays04, rotmus <br/>
 * IDs: 036910008, RID <br/>
 * Date: 13/11/2010 <br/>
 * Time: 23:14:51 <br/>
 */
public class Coder {

     private static HashMap<String,String> jumpMap =    new  HashMap<String,String>();

    public static  void buildMap() {
        jumpMap.put("null","000");
        jumpMap.put("JGT","001");
        jumpMap.put("JEO","010");
        jumpMap.put("JGE","011");
        jumpMap.put("JLT","100");
        jumpMap.put("JNE","101");
        jumpMap.put("JLE","110");
        jumpMap.put("JMP","111");
    }

    public static String dest(String dest) {
        char[] result = new char[3];
        if(dest.contains("A")) result[0] = '1';
        else   result[0] = '0';
        if(dest.contains("D")) result[1] = '1';
        else   result[1] = '0';
        if(dest.contains("M")) result[2] = '1';
        else   result[2] = '0';
        return new String(result);
    }

     public static String comp(String comp) {
        char[] result = new char[7];
         boolean M =  comp.contains("M"),  A =  comp.contains("A"),
                 D =  comp.contains("D"),  callSign =  comp.contains("!"),
                 and =   comp.contains("&"), number = true,
                 or =  comp.contains("|"), minus =  comp.contains("-"),
                 plus = comp.contains("+"), one =  comp.contains("1");
         try {
             Integer.parseInt(comp);
         }
         catch(NumberFormatException e) {
             number = false;
         }

        if(M) result[0] = '1';
         else result[0] = '0';

         if(((M || A) && !D) || number )
             result[1] = '1';
         else
             result[1] = '0';

         if((A || M || one) && !and && !comp.contains("D-1") &&
                 !comp.contains("D+A") && !comp.contains("A-D") &&
                  !comp.contains("D+M") && !comp.contains("M-D"))
             result[2] = '1';
         else
             result[2] = '0';

         if((!(M || A) && D) || number )
             result[3] = '1';
         else
             result[3] = '0';

         if(one || or || (D && !(A || M)) || ((A || M) && plus && one) ||
                 ((A || M) && minus && D))
             result[4] = '1';
         else
             result[4] = '0';

         if(callSign || (comp.length()==1 && !number) || or || and )
             result[5] = '0';
         else
             result[5] = '1';

         if(callSign || or || (one && !minus) ||  ((A || M) && D && minus) ||
                 (minus && !one &&(A || D || M)))
             result[6] = '1';
         else
             result[6] = '0';

        return new String(result);
    }

     public static String jump(String jump) {
        return jumpMap.get(jump);
    }
}
