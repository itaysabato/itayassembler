package test;

import junit.framework.TestCase;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Names: Itay Sabato, Rotem Barzilay <br/>
 * Logins: itays04, rotmus <br/>
 * IDs: 036910008, 300618592 <br/>
 * Date: 16/11/2010 <br/>
 * Time: 01:54:00 <br/>
 */
public class ScannerTest extends TestCase {

    public void testScanner() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("C:\\Users\\itay\\IdeaProjects\\assembler\\src\\test\\stuff\\spaces.txt"));
        while(scanner.hasNextLine()) {
            String str = scanner.nextLine();
            
            System.out.println(str.replaceAll("( )|(//(.*))", ""));
        }
    }
}
