package Syntax.AST.Statements;

import Syntax.AST.Env;
import org.json.JSONObject;

/**
 * Project: CustomizeCompiler
 * Author: CtheSky
 * Create Date: 2016/12/25
 * Description:
 * All rights reserved.
 */
public abstract class Stmt {
    public abstract void execute(Env env);
    public abstract String toJava();
    public abstract JSONObject toJSON();
}
