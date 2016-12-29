package SyntaxTest.interpreterTest;

import CodeGenerator.JavaGenerator;
import Lexer.Token.Token;
import Lexer.Token.Word;
import Syntax.AST.Basic.*;
import Syntax.AST.Env;
import Syntax.AST.Expressions.Arith.*;
import Syntax.AST.Expressions.Cast;
import Syntax.AST.Expressions.Logic.*;
import Syntax.AST.Statements.*;
import Syntax.AST.Type;
import javafx.util.Pair;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Project: CustomizeCompiler
 * Author: CtheSky
 * Create Date: 2016/12/25
 * Description:
 * All rights reserved.
 */
public class ASTEvalTest {
    public Token token;

    public ASTEvalTest(){
        token = new Word(0, "fake token");
        token.setPosition(new Pair<>(1,1));
    }

    @Test
    public void basicValue(){
        Env env = new Env();

        Int i1 = new Int(null, 1);
        assertEquals(1, i1.eval(env).val(), 0);
        assertEquals(Type.Int, i1.eval(env).type);

        Real r1 = new Real(null, 1);
        assertEquals(1, r1.eval(env).val(), 0);
        assertEquals(Type.Real, r1.eval(env).type);

        Bool t = new Bool(null, true);
        assertTrue(Basic.isTrue(t));

        Bool f = new Bool(null, false);
        assertFalse(Basic.isFalse(t));
    }

    @Test
    public void cast() {
        Env env = new Env();

        Int i0 = new Int(null, 0);
        Int i1 = new Int(null, 1);

        Basic r1 = new Cast(null, Type.Real, i1).eval(env);
        assertEquals(1, r1.eval(env).val(), 0);
        assertEquals(Type.Real, r1.eval(env).type);

        Basic t = new Cast(null, Type.Bool, i1).eval(env);
        assertTrue(Basic.isTrue(t));


        Basic f = new Cast(null, Type.Bool, i0).eval(env);
        assertTrue(Basic.isFalse(f));

        Basic r0 = new Cast(null, Type.Real, f).eval(env);
        assertEquals(0, r0.val(), 0);

    }

    @Test
    public void basicArithmetic() {
        Env env = new Env();
        Int i1 = new Int(null, 1);
        Int i2 = new Int(null, 2);

        Add add1_2 = new Add(null, Type.Int, i1, i2);
        assertEquals(3, add1_2.eval(env).val(), 0);
        assertEquals(Type.Int, add1_2.eval(env).type);

        Minus minus1_2 = new Minus(null, Type.Int, i1, i2);
        assertEquals(-1, minus1_2.eval(env).val(), 0);
        assertEquals(Type.Int, minus1_2.eval(env).type);

        Times times1_2 = new Times(null, Type.Int, i1, i2);
        assertEquals(2, times1_2.eval(env).val(), 0);
        assertEquals(Type.Int, times1_2.eval(env).type);

        Divide divide1_2 = new Divide(null, Type.Int, i1, i2);
        assertEquals(0, divide1_2.eval(env).val(), 0);
        assertEquals(Type.Int, divide1_2.eval(env).type);

        Divide divide2_1 = new Divide(null, Type.Int, i2, i1);
        assertEquals(2, divide2_1.eval(env).val(), 0);
        assertEquals(Type.Int, divide2_1.eval(env).type);

        Mod mod1_1d5 = new Mod(null, Type.Real, i2, new Real(null, 1.5));
        assertEquals(0.5, mod1_1d5.eval(env).val(), 0);
        assertEquals(Type.Real.name, mod1_1d5.eval(env).type.name);

        // check type error
        Bool f = new Bool(null, false);
        try{
            Add add1_f = new Add(token, Type.Int, i1, f);
            add1_f.eval(env);
            assertTrue(false);
        } catch(RuntimeException e) {
            String msg = e.getMessage();
            assertTrue(msg.contains("expect numeric but get bool"));
        }
    }

    @Test
    public void unaryMinus() {
        Env env = new Env();

        Int i1 = new Int(null, 1);
        UnaryMinus um_i1 = new UnaryMinus(null, i1);
        assertEquals(-1, um_i1.eval(env).val(), 0);
        assertEquals(Type.Int, um_i1.eval(env).type);

        Real r1 = new Real(null, 1);
        UnaryMinus um_r1 = new UnaryMinus(null, r1);
        assertEquals(-1, um_r1.eval(env).val(), 0);
        assertEquals(Type.Real, um_r1.eval(env).type);
    }

    @Test
    public void equal() {
        Env env = new Env();
        Int i1 = new Int(null, 1);
        Int i2 = new Int(null, 2);
        Real r2 = new Real(null, 2);
        Bool t = new Bool(null, true);
        Bool f = new Bool(null, false);

        assertTrue(Basic.isTrue(new UnEqual(null, i1, i2).eval(env)));
        assertTrue(Basic.isFalse(new UnEqual(null, r2, i2).eval(env)));
        assertTrue(Basic.isFalse(new UnEqual(null, t, t).eval(env)));
        assertTrue(Basic.isFalse(new UnEqual(null, f, f).eval(env)));
        assertTrue(Basic.isTrue(new UnEqual(null, t, f).eval(env)));
    }

    @Test
    public void unEqual() {
        Env env = new Env();
        Int i1 = new Int(null, 1);
        Int i2 = new Int(null, 2);
        Real r2 = new Real(null, 2);
        Bool t = new Bool(null, true);
        Bool f = new Bool(null, false);

        assertTrue(Basic.isFalse(new Equal(null, i1, i2).eval(env)));
        assertTrue(Basic.isTrue(new Equal(null, r2, i2).eval(env)));
        assertTrue(Basic.isTrue(new Equal(null, t, t).eval(env)));
        assertTrue(Basic.isTrue(new Equal(null, f, f).eval(env)));
        assertTrue(Basic.isFalse(new Equal(null, t, f).eval(env)));
    }

    @Test
    public void less() {
        Env env = new Env();
        Int i1 = new Int(null, 1);
        Int i3 = new Int(null, 3);
        Real r2 = new Real(null, 2);

        assertTrue(Basic.isTrue(new Less(null, i1, i3).eval(env)));
        assertTrue(Basic.isTrue(new Less(null, r2, i3).eval(env)));
        assertTrue(Basic.isTrue(new Less(null, i1, r2).eval(env)));
        assertTrue(Basic.isFalse(new Less(null, i1, i1).eval(env)));
    }

    @Test
    public void lessEqual() {
        Env env = new Env();
        Int i1 = new Int(null, 1);
        Int i3 = new Int(null, 3);
        Real r2 = new Real(null, 2);

        assertTrue(Basic.isTrue(new LessEqual(null, i1, i3).eval(env)));
        assertTrue(Basic.isTrue(new LessEqual(null, r2, i3).eval(env)));
        assertTrue(Basic.isTrue(new LessEqual(null, i1, r2).eval(env)));
        assertTrue(Basic.isTrue(new LessEqual(null, i1, i1).eval(env)));
    }

    @Test
    public void greater() {
        Env env = new Env();
        Int i1 = new Int(null, 1);
        Int i3 = new Int(null, 3);
        Real r2 = new Real(null, 2);

        assertTrue(Basic.isFalse(new Greater(null, i1, i3).eval(env)));
        assertTrue(Basic.isFalse(new Greater(null, r2, i3).eval(env)));
        assertTrue(Basic.isFalse(new Greater(null, i1, r2).eval(env)));
        assertTrue(Basic.isFalse(new Greater(null, i1, i1).eval(env)));
    }

    @Test
    public void greaterEqual() {
        Env env = new Env();
        Int i1 = new Int(null, 1);
        Int i3 = new Int(null, 3);
        Real r2 = new Real(null, 2);

        assertTrue(Basic.isFalse(new GreaterEqual(null, i1, i3).eval(env)));
        assertTrue(Basic.isFalse(new GreaterEqual(null, r2, i3).eval(env)));
        assertTrue(Basic.isFalse(new GreaterEqual(null, i1, r2).eval(env)));
        assertTrue(Basic.isTrue(new GreaterEqual(null, i1, i1).eval(env)));
    }

    @Test
    public void and() {
        Env env = new Env();
        Bool t = new Bool(null, true);
        Bool f = new Bool(null, false);

        And and_tt = new And(null, t, t);
        assertTrue(!Type.numeric(and_tt.eval(env).type));
        assertTrue(Basic.isTrue(and_tt.eval(env)));

        And and_tf = new And(null, t, f);
        assertTrue(!Type.numeric(and_tf.eval(env).type));
        assertTrue(Basic.isFalse(and_tf.eval(env)));

        And and_ft = new And(null, f, t);
        assertTrue(!Type.numeric(and_ft.eval(env).type));
        assertTrue(Basic.isFalse(and_ft.eval(env)));

        And and_ff = new And(null, f, f);
        assertTrue(!Type.numeric(and_ff.eval(env).type));
        assertTrue(Basic.isFalse(and_ff.eval(env)));

        // shortcut
        And and_f_error = new And(null, f, new Int(null, 1));
        assertTrue(!Type.numeric(and_f_error.eval(env).type));
        assertTrue(Basic.isFalse(and_f_error.eval(env)));

        // check type error
        Int i1 = new Int(null, 1);
        try{
            And and1_f = new And(token, i1, f);
            and1_f.eval(env);
            assertTrue(false);
        } catch(RuntimeException e) {
            String msg = e.getMessage();
            assertTrue(msg.contains("expect bool but get numeric"));
        }

        System.out.println(new And(null, and_ff, t).toJava());
    }

    @Test
    public void or() {
        Env env = new Env();
        Bool t = new Bool(null, true);
        Bool f = new Bool(null, false);

        Or or_tt = new Or(null, t, t);
        assertTrue(!Type.numeric(or_tt.eval(env).type));
        assertTrue(Basic.isTrue(or_tt.eval(env)));

        Or or_tf = new Or(null, t, f);
        assertTrue(!Type.numeric(or_tf.eval(env).type));
        assertTrue(Basic.isTrue(or_tf.eval(env)));

        Or or_ft = new Or(null, f, t);
        assertTrue(!Type.numeric(or_ft.eval(env).type));
        assertTrue(Basic.isTrue(or_ft.eval(env)));

        Or or_ff = new Or(null, f, f);
        assertTrue(!Type.numeric(or_ff.eval(env).type));
        assertTrue(Basic.isFalse(or_ff.eval(env)));

        // shortcut
        Or or_t_error = new Or(null, t, new Int(null, 1));
        assertTrue(!Type.numeric(or_t_error.eval(env).type));
        assertTrue(Basic.isTrue(or_t_error.eval(env)));
    }

    @Test
    public void not() {
        Env env = new Env();
        Bool t = new Bool(null, true);

        Not not_t = new Not(null, t);
        assertTrue(!Type.numeric(not_t.eval(env).type));
        assertTrue(Basic.isFalse(not_t.eval(env)));

        Basic f = not_t.eval(env);
        Not not_not_t = new Not(null, f);
        assertTrue(!Type.numeric(not_not_t.eval(env).type));
        assertTrue(Basic.isTrue(not_not_t.eval(env)));
    }

    @Test
    public void Declare() {
        Env env = new Env();
        String name = "i5";
        Id id = new Id(null, Type.Int, name);

        Declare declare = new Declare(id);
        declare.execute(env);

        assertNotNull(env.table.get(name));
        assertEquals(Basic.Uninitialized, env.get(id));
    }

    @Test
    public void UnDeclare() {
        Env env = new Env();
        String name = "i5";
        Id id = new Id(null, Type.Int, name);

        Declare declare = new Declare(id);
        declare.execute(env);

        UnDeclare unDeclare = new UnDeclare(id);
        unDeclare.execute(env);

        assertNull(env.get(id));
        assertNull(env.table.get(name));
    }

    @Test
    public void Assign() {
        Env env = new Env();
        String name = "i5";
        Id id = new Id(null, Type.Int, name);

        Declare declare = new Declare(id);
        declare.execute(env);

        Assign assign_i5 = new Assign(id, new Int(null, 5));
        assign_i5.execute(env);

        Assign assign_if = new Assign(id, new Bool(null, false));
        try{
            assign_if.execute(env);
            assertTrue(false);
        } catch(RuntimeException e) {
            String msg = e.getMessage();
            assertTrue(msg.contains("expect numeric but get bool"));
        }

        assertEquals(5, id.eval(env).val(), 0);
        assertEquals(Type.Int, id.eval(env).type);
    }

    @Test
    public void Stmts(){
        Env env = new Env();
        String name = "i5";
        Id id = new Id(null, Type.Int, name);

        Declare declare = new Declare(id);
        Assign assign_i5 = new Assign(id, new Int(null, 5));

        Stmts stmts = new Stmts(declare, new Stmts(assign_i5, null));
        stmts.execute(env);

        assertEquals(5, id.eval(env).val(), 0);
        assertEquals(Type.Int, id.eval(env).type);
    }

    @Test
    public void Scope() {
        Env env = new Env();
        String name = "i";

        // outer env : int i = 0
        Id outerId = new Id(null, Type.Int, name);
        Declare declare = new Declare(outerId);
        declare.execute(env);
        Assign assign_i0 = new Assign(outerId, new Int(null, 0));
        assign_i0.execute(env);

        // inner env : int i = 1
        Id innerId = new Id(null, Type.Int, name);
        Declare innerDeclare = new Declare(innerId);
        Assign innerAssign = new Assign(innerId, new Int(null, 1));
        Stmts stmts = new Stmts(innerDeclare, new Stmts(innerAssign, null));

        Scope scope = new Scope(stmts);
        scope.execute(env);

        assertEquals(0, outerId.eval(env).val(), 0);
        assertEquals(Type.Int, outerId.eval(env).type);
    }

    @Test
    public void While() {
        Env env = new Env();
        String name = "i";
        Id id = new Id(null, Type.Int, name);

        // initialize i with 0 and use while to accelerate i to 10
        Declare declare = new Declare(id);
        Assign assign_i0 = new Assign(id, new Int(null, 0));
        Stmts stmts = new Stmts(declare, new Stmts(assign_i0, null));
        stmts.execute(env);

        UnEqual neq_i_10 = new UnEqual(null, id, new Int(null, 10));
        Assign assign_i_iplus1 = new Assign(id, new Add(null, Type.Int, id, new Int(null, 1)));
        While w = new While(neq_i_10, assign_i_iplus1, true);
        w.execute(env);

        assertEquals(10, id.eval(env).val(), 0);
        assertEquals(Type.Int, id.eval(env).type);
        System.out.println(JavaGenerator.generate(w));
    }

    @Test
    public void If() {
        Env env = new Env();
        String name = "i";
        Id id = new Id(null, Type.Int, name);

        Declare declare = new Declare(id);
        declare.execute(env);

        Assign assign_i0 = new Assign(id, new Int(null, 0));
        Assign assign_i1 = new Assign(id, new Int(null, 1));

        If if_stmt = new If(new Bool(null, false),
                assign_i1,
                new If(new Bool(null, true), assign_i0, null, true),
                true);
        if_stmt.execute(env);

        assertEquals(0, id.eval(env).val(), 0);
    }
}
