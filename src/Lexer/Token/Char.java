package Lexer.Token;

import Lexer.Automata.Automata;
import Lexer.Automata.AutomataConstructor;

/**
 * Project: CustomizeCompiler
 * Author: CtheSky
 * Create Date: 2017/1/2
 * Description:
 * All rights reserved.
 */
public class Char extends Token {
    private static final String regex = "\'(a|b|c|d|e|f|g|h|i|j|k|l|m|n|o|p|q|r|s|t|u|v|w|x|y|z|A|B|C|D|E|F|G|H|I|J|K|L|M|N|O|P|Q|R|S|T|U|V|W|X|Y|Z|~~|!|@|#|$|%|^|&|~*|~(|~)|~ )\'";
    public final char value;

    public Char(char value) {
        super(Tag.CHAR);
        this.value = value;
    }

    @Override
    public int getLength() {
        return 3;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static Automata getAutomata() {
        AutomataConstructor automataConstructor = new AutomataConstructor(regex);
        Automata automata = automataConstructor.getAutomata();
        automata.setTagId(Tag.CHAR);
        return automata;
    }
}
