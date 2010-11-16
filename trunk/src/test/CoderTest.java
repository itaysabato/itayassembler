package test;

import assembler.Coder;
import junit.framework.TestCase;

/**
 * Names: Itay Sabato, Rotem Barzilay <br/>
 * Logins: itays04, rotmus <br/>
 * IDs: 036910008, 300618592 <br/>
 * Date: 16/11/2010 <br/>
 * Time: 03:54:23 <br/>
 */
public class CoderTest extends TestCase {

    private final Coder coder = Coder.getInstance();

    public void testJump() {
        System.out.println("Testing jump:");

        String str = "" ;
        System.out.println(coder.jump(str));

        str = "JGT" ;
        System.out.println(coder.jump(str));

        str = "JEQ" ;
        System.out.println(coder.jump(str));

        str = "JGE" ;
        System.out.println(coder.jump(str));

        str = "JLT" ;
        System.out.println(coder.jump(str));

        str = "JNE" ;
        System.out.println(coder.jump(str));

        str = "JLE" ;
        System.out.println(coder.jump(str));

        str = "JMP" ;
        System.out.println(coder.jump(str));
    }

    public void testDest() {
        System.out.println("Testing dest:");

        String str = "" ;
        System.out.println(coder.dest(str));

        str = "M" ;
        System.out.println(coder.dest(str));

        str = "D" ;
        System.out.println(coder.dest(str));

        str = "MD" ;
        System.out.println(coder.dest(str));

        str = "A" ;
        System.out.println(coder.dest(str));

        str = "AM" ;
        System.out.println(coder.dest(str));

        str = "AD" ;
        System.out.println(coder.dest(str));

        str = "AMD" ;
        System.out.println(coder.dest(str));
    }

    public void testCompA() {
        System.out.println("Testing compA:");

        String str = "0" ;
        System.out.println(coder.comp(str));

        str = "1" ;
        System.out.println(coder.comp(str));

        str = "-1" ;
        System.out.println(coder.comp(str));

        str = "D" ;
        System.out.println(coder.comp(str));

        str = "A" ;
        System.out.println(coder.comp(str));

        str = "!D" ;
        System.out.println(coder.comp(str));

        str = "!A" ;
        System.out.println(coder.comp(str));

        str = "-D" ;
        System.out.println(coder.comp(str));

        str = "-A" ;
        System.out.println(coder.comp(str));

        str = "D+1" ;
        System.out.println(coder.comp(str));

        str = "A+1" ;
        System.out.println(coder.comp(str));

        str = "D-1" ;
        System.out.println(coder.comp(str));

        str = "A-1" ;
        System.out.println(coder.comp(str));

        str = "D+A" ;
        System.out.println(coder.comp(str));

        str = "D-A" ;
        System.out.println(coder.comp(str));

        str = "A-D" ;
        System.out.println(coder.comp(str));

        str = "D&A" ;
        System.out.println(coder.comp(str));

        str = "D|A" ;
        System.out.println(coder.comp(str));
    }

    public void testCompM() {
        System.out.println("Testing compM:");

        String str = "0" ;
        System.out.println(coder.comp(str));

        str = "1" ;
        System.out.println(coder.comp(str));

        str = "-1" ;
        System.out.println(coder.comp(str));

        str = "D" ;
        System.out.println(coder.comp(str));

        str = "M" ;
        System.out.println(coder.comp(str));

        str = "!D" ;
        System.out.println(coder.comp(str));

        str = "!M" ;
        System.out.println(coder.comp(str));

        str = "-D" ;
        System.out.println(coder.comp(str));

        str = "-M" ;
        System.out.println(coder.comp(str));

        str = "D+1" ;
        System.out.println(coder.comp(str));

        str = "M+1" ;
        System.out.println(coder.comp(str));

        str = "D-1" ;
        System.out.println(coder.comp(str));

        str = "M-1" ;
        System.out.println(coder.comp(str));

        str = "D+M" ;
        System.out.println(coder.comp(str));

        str = "D-M" ;
        System.out.println(coder.comp(str));

        str = "M-D" ;
        System.out.println(coder.comp(str));

        str = "D&M" ;
        System.out.println(coder.comp(str));

        str = "D|M" ;
        System.out.println(coder.comp(str));
    }

}


