package Syntax.AST.Statements;

import CodeGenerator.CoverageInfo;
import Syntax.AST.Env;
import org.json.JSONObject;

import java.io.Serializable;

/**
 * Project: CustomizeCompiler
 * Author: CtheSky
 * Create Date: 2016/12/25
 * Description:
 * All rights reserved.
 */
public abstract class Stmt implements Serializable{
    private int lineNum;
    private int calledNum;

    public int getLineNum() { return lineNum; }
    public void setLineNum(int lineNum) { this.lineNum = lineNum; }
    public int getCalledNum() { return calledNum; }
    public void setCalledNum(int calledNum) { this.calledNum = calledNum; }

    public abstract void execute(Env env);
    public abstract String toJava();
    public abstract JSONObject toJSON();
    public void getCoverage(CoverageInfo info){
        info.set(lineNum,calledNum);
    }
}
