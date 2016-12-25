package Syntax.AST;

import Syntax.AST.Basic.Basic;
import Syntax.AST.Basic.Id;

import java.util.Hashtable;

/**
 * Project: CustomizeCompiler
 * Author: CtheSky
 * Create Date: 2016/12/24
 * Description:
 * All rights reserved.
 */
public class Env {
    public Hashtable<String, Basic> table;
    public Env prev;

    public Env() { table = new Hashtable<>(); this.prev = null; }
    public Env(Env prev) { table = new Hashtable<>(); this.prev = prev; }
    public Env createInner() { return new Env(this); }
    public void put(Id id, Basic basic) { table.put(id.name, basic); }
    public Basic getWithinCurEnv(Id id) { return table.get(id.name); }
    public Basic get(Id id) {
        for (Env env = this; env != null; env = env.prev) {
            Basic found = env.table.get(id.name);
            if (found != null)
                return found;
        }
        return null;
    }

    public void update(Id id, Basic basic) {
        for (Env env = this; env != null; env = env.prev) {
            Basic found = env.table.get(id.name);
            if (found != null){
                env.table.put(id.name, basic);
                return;
            }
        }
    }
}
