package Syntax.AST.Expressions;

import Lexer.Token.Token;
import Syntax.AST.Basic.*;
import Syntax.AST.Env;
import Syntax.AST.Type;
import org.json.JSONObject;

/**
 * Project: CustomizeCompiler
 * Author: CtheSky
 * Create Date: 2016/12/26
 * Description:
 * All rights reserved.
 */
public class Cast extends Expr {
	public final Expr expr;

	public Cast(Token token, Type type, Expr expr) {
		super(token, type);
		this.expr = expr;
	}

	@Override
	public Basic eval(Env env) throws RuntimeException {
		Basic right = expr.eval(env);
		if (type.equals(right.type))
			return right;
		else if (type.equals(Type.Bool))
			return new Bool(null, right.val() != 0);
		else if (right.type.equals(Type.Bool)) {
			// bool - > numeric
			if (type.equals(Type.Int))
				return new Int(null, Basic.isTrue(right) ? 1 : 0);
			else
				return new Real(null, Basic.isTrue(right) ? 1 : 0);
		} else if (type.equals(Type.Char) && Type.numeric(right.type)) {
			return new Char(null, (char) right.val());
		} else {
			// numeric -> numeric
			if (type.equals(Type.Int))
				return new Int(null, (int) right.val());
			else
				return new Real(null, right.val());
		}
	}

	@Override
	public String toJava() {
		return "((" + Type.toJavaType(type) + ")" + expr.toJava() + ")";
	}

	@Override
	public JSONObject toJSON() {
		JSONObject object = new JSONObject();
		object.put("token", token.toJSON());
		object.put("type", type == null ? "" : type.name);
		object.put("expr1", expr.toJSON());
		object.put("exprType", "Cast");
		return object;
	}
}
