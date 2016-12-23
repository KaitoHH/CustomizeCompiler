package SyntaxTest.CFLTest;

import Syntax.CFL.CFL;
import Syntax.CFL.Ntrl;
import Syntax.CFL.Production;
import Syntax.CFL.Trl;
import Syntax.SyntaxConfig;
import Utils.SyntaxJSONUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * Project: CustomizeCompiler
 * Author: CtheSky
 * Create Date: 2016/12/23
 * Description:
 * All rights reserved.
 */
public class CFLTest {
    @Test
    public void computeFirstSetTest() {
        URL testInputUrl = CFLTest.class.getResource("/SyntaxTest/CFLTest/TestFirstSet.json");
        String testInput;
        try{
            testInput = new Scanner(new File(testInputUrl.getPath())).useDelimiter("\\Z").next();
        } catch (IOException e) {
            System.out.println("Missing test required file: TestFirstSet.json");
            return;
        }

        SyntaxConfig config = new SyntaxConfig(SyntaxJSONUtils.getCFLfromJSONstring(testInput));
        CFL cfl = config.getCfl();
        cfl.computeAllFirstSets();

        Trl id = null,lb = null, rb = null;
        for (Trl trl : cfl.trlSet) {
            if (trl.toString().equals("id"))
                id = trl;
            if (trl.toString().equals("("))
                lb = trl;
            if (trl.toString().equals(")"))
                rb = trl;

            assertEquals(1, trl.firstSet.size());
            assertEquals(trl, trl.firstSet.iterator().next());
        }

        for (Map.Entry<Ntrl, List<Production>> entry : cfl.productionMap.entrySet()) {
            Ntrl ntrl = entry.getKey();

            if (ntrl.toString().equals("$E`")) {
                assertEquals(3, ntrl.firstSet.size());
                assertTrue(ntrl.firstSet.contains(id));
                assertTrue(ntrl.firstSet.contains(lb));
                assertTrue(ntrl.firstSet.contains(Trl.Epsilon));
            }

            if (ntrl.toString().equals("$E")) {
                assertEquals(3, ntrl.firstSet.size());
                assertTrue(ntrl.firstSet.contains(id));
                assertTrue(ntrl.firstSet.contains(lb));
                assertTrue(ntrl.firstSet.contains(Trl.Epsilon));
            }

            if (ntrl.toString().equals("$F")) {
                assertEquals(2, ntrl.firstSet.size());
                assertTrue(ntrl.firstSet.contains(id));
                assertTrue(ntrl.firstSet.contains(lb));
            }

            if (ntrl.toString().equals("$T")) {
                assertEquals(2, ntrl.firstSet.size());
                assertTrue(ntrl.firstSet.contains(id));
                assertTrue(ntrl.firstSet.contains(lb));
            }

            if (ntrl.toString().equals("$D")) {
                assertEquals(1, ntrl.firstSet.size());
                assertTrue(ntrl.firstSet.contains(Trl.Epsilon));
            }
        }
    }
}
