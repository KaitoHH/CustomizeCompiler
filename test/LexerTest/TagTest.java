package LexerTest;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import Lexer.Tag;

/**
 * Project: CustomizeCompiler
 * Author: CtheSky
 * Create Date: 2016/11/28
 * Description:
 * All rights reserved.
 */
public class TagTest {

    @Test
    public void initializeTest(){
        assertNotNull(Tag.KEY);
        assertTrue(Tag.KEY instanceof Map);
        assertTrue(Tag.KEY.isEmpty());
    }

    @Test
    public void addKeyTest(){
        Tag.KEY.clear();

        Set<Integer> checkDuplicate = new HashSet<>();
        for (int i = 1; i <= 100; i++) {
            String key = "" + i;

            // check whether key is added
            Tag.addKey(key);
            assertEquals(Tag.KEY.size(), i);

            // check whether id generated is unique
            int id = Tag.KEY.get(key);
            assertTrue(!checkDuplicate.contains(id));
            checkDuplicate.add(id);
        }

        Tag.KEY.clear();
    }
}
