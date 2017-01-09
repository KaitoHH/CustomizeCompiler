package Syntax.AST.Expressions;

import Lexer.Token.Token;
import Syntax.AST.Basic.*;
import Syntax.AST.Env;
import Syntax.AST.Type;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Project: CustomizeCompiler
 * Author: CtheSky
 * Create Date: 2017/1/9
 * Description:
 * All rights reserved.
 */
public class GetChar extends Expr{
    public GetChar(Token token) { super(token, Type.Char); }

    @Override
    public Basic eval(Env env) throws RuntimeException {
        try{
            System.out.println("GetChar:");
            int input = System.in.read();
            return new Char(token, (char)input);
        } catch (IOException e) {
            error("Error occurs when reading input.");
            return null;
        }
    }

    @Override
    public JSONObject toJSON() {
        JSONObject object = new JSONObject();
        object.put("token", token.toJSON());
        object.put("type", type == null ? "":type.name);
        object.put("exprType", "GetChar");
        return object;
    }

    @Override
    public String toJava() {
        return "((char)System.in.read())";
    }

}
