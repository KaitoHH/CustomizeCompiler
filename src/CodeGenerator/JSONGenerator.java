package CodeGenerator;

import Syntax.AST.Statements.Stmt;
import org.json.JSONObject;

/**
 * Project: CustomizeCompiler
 * Author: CtheSky
 * Create Date: 2017/1/4
 * Description:
 * All rights reserved.
 */
public class JSONGenerator {
    public static JSONObject generate(Stmt root){
        return root.toJSON();
    }
}
