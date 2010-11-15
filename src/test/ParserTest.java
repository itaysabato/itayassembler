package test;

import assembler.CommandType;
import assembler.Parser;
import junit.framework.TestCase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Names: Itay Sabato, Rotem Barzilay <br/>
 * Logins: itays04, rotmus <br/>
 * IDs: 036910008, RID <br/>
 * Date: 15/11/2010 <br/>
 * Time: 17:16:52 <br/>
 */
public class ParserTest extends TestCase {
    private static final String PATH = "C:\\Users\\itay\\IdeaProjects\\assembler\\src\\test\\";

    public void testRect() throws IOException {
        parse("rect\\RectL.asm");
        parse("rect\\Rect.asm");
    }

    public void testMax() throws IOException {
        parse("max\\MaxL.asm");
        parse("max\\Max.asm");
    }

    public void testPong() throws IOException {
        parse("pong\\PongL.asm");
        parse("pong\\Pong.asm");
    }

    private static void parse(String fileName) throws IOException {
        System.out.println("Parsing file: "+ fileName);
        Parser parser = new Parser(new File(PATH+fileName));
        while(parser.advance()) {
            if(parser.commandType() == CommandType.A){
                System.out.println("A: "+parser.symbol());
            }

            else if(parser.commandType() == CommandType.L){
                System.out.println("L: "+parser.symbol());
            }
            else {
                System.out.println("C:");
                System.out.println("dest: "+parser.dest());
                System.out.println("comp: "+parser.comp());
                System.out.println("jump: "+parser.jump());
            }
        }
        parser.close();
    }
}
