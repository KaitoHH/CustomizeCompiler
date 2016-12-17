package PreprocessorTest;

import javafx.util.Pair;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Scanner;

import Preprocessor.Preprocessor;

/**
 * Project: CustomizeCompiler
 * Author: CtheSky
 * Create Date: 2016/11/29
 * Description:
 * All rights reserved.
 */
public class PreprocessorTest {

    @Test
    public void removeCommentTest(){
        URL inputUrl = PreprocessorTest.class.getResource("/PreprocessorTest/removeCommentInput.txt");
        URL outputUrl = PreprocessorTest.class.getResource("/PreprocessorTest/removeCommentOutput.txt");

        try {
            String input = new Scanner(new File(inputUrl.getPath())).useDelimiter("\\Z").next();
            String output = new Scanner(new File(outputUrl.getPath())).useDelimiter("\\Z").next();

            // test whether comment is removed properly
            String answer =  Preprocessor.removeComment(input);
            assertEquals(answer, output);

            // test line position mapping
            assertEquals(new Pair<>(1, 29),Preprocessor.getPositionPair(12));
            assertEquals(new Pair<>(6, 1),Preprocessor.getPositionPair(25));
        } catch (FileNotFoundException e) {
            System.out.println("Missing test required file: removeCommentInput.txt || removeCommentOutput.tx");
        }
    }
}
