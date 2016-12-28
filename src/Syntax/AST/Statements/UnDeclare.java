package Syntax.AST.Statements;

import Syntax.AST.Basic.Basic;
import Syntax.AST.Basic.Id;
import Syntax.AST.Env;

/**
 * Project: CustomizeCompiler
 * Author: CtheSky
 * Create Date: 2016/12/26
 * Description:
 * All rights reserved.
 */
public class UnDeclare extends Stmt {
    public final Id id;
    public UnDeclare(Id id) { this.id = id; }

    @Override
    public void execute(Env env) {
        env.undeclare(id);
    }

    @Override
    public String toJava(String indent) {
        return indent + "\\\\ unDeclare not supported in java \n";
    }
}
