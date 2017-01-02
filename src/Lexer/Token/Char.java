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
    private static final String regex = "'(0|1|2|3|4|5|6|7|8|9|a|b|c|d|e|f|g|h|i|j|k|l|m|n|o|p|q|r|s|t|u|v|w|x|y|z| |_|,|.|:)'";
    public final char value;

    public Char(char value) {
        super(Tag.INT);
        this.value = value;
    }

    @Override
    public int getLength() {
        return toString().length();
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
