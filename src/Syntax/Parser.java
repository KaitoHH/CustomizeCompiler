
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package Syntax;

import java_cup.runtime.ComplexSymbolFactory.Location;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class Parser extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return ParserSym.class;
}

  /** Default constructor. */
  @Deprecated
  public Parser() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public Parser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public Parser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\057\000\002\002\003\000\002\002\004\000\002\003" +
    "\005\000\002\004\004\000\002\004\003\000\002\005\003" +
    "\000\002\005\003\000\002\005\003\000\002\005\003\000" +
    "\002\005\003\000\002\005\003\000\002\020\006\000\002" +
    "\021\011\000\002\022\007\000\002\024\011\000\002\017" +
    "\005\000\002\023\007\000\002\005\003\000\002\005\004" +
    "\000\002\006\003\000\002\006\003\000\002\007\003\000" +
    "\002\007\005\000\002\010\003\000\002\010\005\000\002" +
    "\011\003\000\002\011\005\000\002\011\005\000\002\012" +
    "\005\000\002\012\005\000\002\012\005\000\002\012\005" +
    "\000\002\012\003\000\002\013\003\000\002\013\005\000" +
    "\002\013\005\000\002\014\003\000\002\014\005\000\002" +
    "\014\005\000\002\014\005\000\002\015\004\000\002\015" +
    "\004\000\002\015\003\000\002\016\005\000\002\016\003" +
    "\000\002\016\003\000\002\016\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\131\000\004\007\005\001\002\000\004\002\133\001" +
    "\002\000\022\003\025\007\005\010\017\012\011\023\016" +
    "\025\014\041\026\042\013\001\002\000\004\002\001\001" +
    "\002\000\026\003\ufffc\007\ufffc\010\ufffc\012\ufffc\021\ufffc" +
    "\022\ufffc\023\ufffc\025\ufffc\041\ufffc\042\ufffc\001\002\000" +
    "\026\003\ufffa\007\ufffa\010\ufffa\012\ufffa\021\ufffa\022\ufffa" +
    "\023\ufffa\025\ufffa\041\ufffa\042\ufffa\001\002\000\004\023" +
    "\uffee\001\002\000\004\023\131\001\002\000\004\005\125" +
    "\001\002\000\004\005\117\001\002\000\026\003\ufff0\007" +
    "\ufff0\010\ufff0\012\ufff0\021\ufff0\022\ufff0\023\ufff0\025\ufff0" +
    "\041\ufff0\042\ufff0\001\002\000\004\011\114\001\002\000" +
    "\022\003\025\007\005\010\017\012\011\023\016\025\014" +
    "\041\026\042\013\001\002\000\026\003\ufff7\007\ufff7\010" +
    "\ufff7\012\ufff7\021\ufff7\022\ufff7\023\ufff7\025\ufff7\041\ufff7" +
    "\042\ufff7\001\002\000\026\003\ufff8\007\ufff8\010\ufff8\012" +
    "\ufff8\021\ufff8\022\ufff8\023\ufff8\025\ufff8\041\ufff8\042\ufff8" +
    "\001\002\000\024\003\025\007\005\010\017\012\011\021" +
    "\031\023\016\025\014\041\026\042\013\001\002\000\026" +
    "\003\ufff9\007\ufff9\010\ufff9\012\ufff9\021\ufff9\022\ufff9\023" +
    "\ufff9\025\ufff9\041\ufff9\042\ufff9\001\002\000\026\003\ufffb" +
    "\007\ufffb\010\ufffb\012\ufffb\021\ufffb\022\ufffb\023\ufffb\025" +
    "\ufffb\041\ufffb\042\ufffb\001\002\000\004\013\030\001\002" +
    "\000\004\023\uffed\001\002\000\024\003\ufffd\007\ufffd\010" +
    "\ufffd\012\ufffd\021\ufffd\023\ufffd\025\ufffd\041\ufffd\042\ufffd" +
    "\001\002\000\026\003\uffef\007\uffef\010\uffef\012\uffef\021" +
    "\uffef\022\uffef\023\uffef\025\uffef\041\uffef\042\uffef\001\002" +
    "\000\030\002\uffff\003\uffff\007\uffff\010\uffff\012\uffff\021" +
    "\uffff\022\uffff\023\uffff\025\uffff\041\uffff\042\uffff\001\002" +
    "\000\024\003\ufffe\007\ufffe\010\ufffe\012\ufffe\021\ufffe\023" +
    "\ufffe\025\ufffe\041\ufffe\042\ufffe\001\002\000\004\042\034" +
    "\001\002\000\004\005\035\001\002\000\016\005\042\014" +
    "\036\023\045\036\051\044\052\045\037\001\002\000\016" +
    "\005\042\014\036\023\045\036\051\044\052\045\037\001" +
    "\002\000\040\004\uffd3\006\uffd3\013\uffd3\014\uffd3\015\uffd3" +
    "\016\uffd3\020\uffd3\024\uffd3\026\uffd3\027\uffd3\030\uffd3\033" +
    "\uffd3\034\uffd3\040\uffd3\043\uffd3\001\002\000\012\006\uffec" +
    "\013\uffec\027\uffec\040\107\001\002\000\006\006\111\027" +
    "\105\001\002\000\016\005\042\014\036\023\045\036\051" +
    "\044\052\045\037\001\002\000\040\004\uffdd\006\uffdd\013" +
    "\uffdd\014\uffdd\015\uffdd\016\uffdd\020\uffdd\024\uffdd\026\uffdd" +
    "\027\uffdd\030\uffdd\033\uffdd\034\uffdd\040\uffdd\043\uffdd\001" +
    "\002\000\040\004\uffe0\006\uffe0\013\uffe0\014\uffe0\015\066" +
    "\016\uffe0\020\uffe0\024\uffe0\026\065\027\uffe0\030\067\033" +
    "\uffe0\034\uffe0\040\uffe0\043\uffe0\001\002\000\040\004\uffd5" +
    "\006\uffd5\013\uffd5\014\uffd5\015\uffd5\016\uffd5\020\uffd5\024" +
    "\uffd5\026\uffd5\027\uffd5\030\uffd5\033\uffd5\034\uffd5\040\uffd5" +
    "\043\uffd5\001\002\000\040\004\uffd7\006\uffd7\013\uffd7\014" +
    "\uffd7\015\uffd7\016\uffd7\020\uffd7\024\uffd7\026\uffd7\027\uffd7" +
    "\030\uffd7\033\uffd7\034\uffd7\040\uffd7\043\uffd7\001\002\000" +
    "\016\006\uffea\013\uffea\027\uffea\034\077\040\uffea\043\100" +
    "\001\002\000\032\004\060\006\uffe1\013\uffe1\014\061\016" +
    "\056\020\057\024\062\027\uffe1\033\055\034\uffe1\040\uffe1" +
    "\043\uffe1\001\002\000\016\005\042\014\036\023\045\036" +
    "\051\044\052\045\037\001\002\000\040\004\uffd4\006\uffd4" +
    "\013\uffd4\014\uffd4\015\uffd4\016\uffd4\020\uffd4\024\uffd4\026" +
    "\uffd4\027\uffd4\030\uffd4\033\uffd4\034\uffd4\040\uffd4\043\uffd4" +
    "\001\002\000\016\006\uffe8\013\uffe8\027\uffe8\034\uffe8\040" +
    "\uffe8\043\uffe8\001\002\000\040\004\uffd9\006\uffd9\013\uffd9" +
    "\014\uffd9\015\uffd9\016\uffd9\020\uffd9\024\uffd9\026\uffd9\027" +
    "\uffd9\030\uffd9\033\uffd9\034\uffd9\040\uffd9\043\uffd9\001\002" +
    "\000\016\005\042\014\036\023\045\036\051\044\052\045" +
    "\037\001\002\000\016\005\042\014\036\023\045\036\051" +
    "\044\052\045\037\001\002\000\016\005\042\014\036\023" +
    "\045\036\051\044\052\045\037\001\002\000\016\005\042" +
    "\014\036\023\045\036\051\044\052\045\037\001\002\000" +
    "\016\005\042\014\036\023\045\036\051\044\052\045\037" +
    "\001\002\000\016\005\042\014\036\023\045\036\051\044" +
    "\052\045\037\001\002\000\022\004\060\006\uffe3\013\uffe3" +
    "\014\061\027\uffe3\034\uffe3\040\uffe3\043\uffe3\001\002\000" +
    "\040\004\uffdf\006\uffdf\013\uffdf\014\uffdf\015\066\016\uffdf" +
    "\020\uffdf\024\uffdf\026\065\027\uffdf\030\067\033\uffdf\034" +
    "\uffdf\040\uffdf\043\uffdf\001\002\000\016\005\042\014\036" +
    "\023\045\036\051\044\052\045\037\001\002\000\016\005" +
    "\042\014\036\023\045\036\051\044\052\045\037\001\002" +
    "\000\016\005\042\014\036\023\045\036\051\044\052\045" +
    "\037\001\002\000\040\004\uffdc\006\uffdc\013\uffdc\014\uffdc" +
    "\015\uffdc\016\uffdc\020\uffdc\024\uffdc\026\uffdc\027\uffdc\030" +
    "\uffdc\033\uffdc\034\uffdc\040\uffdc\043\uffdc\001\002\000\040" +
    "\004\uffdb\006\uffdb\013\uffdb\014\uffdb\015\uffdb\016\uffdb\020" +
    "\uffdb\024\uffdb\026\uffdb\027\uffdb\030\uffdb\033\uffdb\034\uffdb" +
    "\040\uffdb\043\uffdb\001\002\000\040\004\uffda\006\uffda\013" +
    "\uffda\014\uffda\015\uffda\016\uffda\020\uffda\024\uffda\026\uffda" +
    "\027\uffda\030\uffda\033\uffda\034\uffda\040\uffda\043\uffda\001" +
    "\002\000\040\004\uffde\006\uffde\013\uffde\014\uffde\015\066" +
    "\016\uffde\020\uffde\024\uffde\026\065\027\uffde\030\067\033" +
    "\uffde\034\uffde\040\uffde\043\uffde\001\002\000\022\004\060" +
    "\006\uffe4\013\uffe4\014\061\027\uffe4\034\uffe4\040\uffe4\043" +
    "\uffe4\001\002\000\022\004\060\006\uffe2\013\uffe2\014\061" +
    "\027\uffe2\034\uffe2\040\uffe2\043\uffe2\001\002\000\022\004" +
    "\060\006\uffe5\013\uffe5\014\061\027\uffe5\034\uffe5\040\uffe5" +
    "\043\uffe5\001\002\000\016\005\042\014\036\023\045\036" +
    "\051\044\052\045\037\001\002\000\016\005\042\014\036" +
    "\023\045\036\051\044\052\045\037\001\002\000\016\006" +
    "\uffe6\013\uffe6\027\uffe6\034\uffe6\040\uffe6\043\uffe6\001\002" +
    "\000\016\006\uffe7\013\uffe7\027\uffe7\034\uffe7\040\uffe7\043" +
    "\uffe7\001\002\000\006\006\104\027\105\001\002\000\040" +
    "\004\uffd6\006\uffd6\013\uffd6\014\uffd6\015\uffd6\016\uffd6\020" +
    "\uffd6\024\uffd6\026\uffd6\027\uffd6\030\uffd6\033\uffd6\034\uffd6" +
    "\040\uffd6\043\uffd6\001\002\000\016\005\042\014\036\023" +
    "\045\036\051\044\052\045\037\001\002\000\012\006\uffeb" +
    "\013\uffeb\027\uffeb\040\107\001\002\000\016\005\042\014" +
    "\036\023\045\036\051\044\052\045\037\001\002\000\016" +
    "\006\uffe9\013\uffe9\027\uffe9\034\077\040\uffe9\043\100\001" +
    "\002\000\004\013\112\001\002\000\026\003\ufff3\007\ufff3" +
    "\010\ufff3\012\ufff3\021\ufff3\022\ufff3\023\ufff3\025\ufff3\041" +
    "\ufff3\042\ufff3\001\002\000\040\004\uffd8\006\uffd8\013\uffd8" +
    "\014\uffd8\015\uffd8\016\uffd8\020\uffd8\024\uffd8\026\uffd8\027" +
    "\uffd8\030\uffd8\033\uffd8\034\uffd8\040\uffd8\043\uffd8\001\002" +
    "\000\016\005\042\014\036\023\045\036\051\044\052\045" +
    "\037\001\002\000\006\013\116\027\105\001\002\000\026" +
    "\003\ufff6\007\ufff6\010\ufff6\012\ufff6\021\ufff6\022\ufff6\023" +
    "\ufff6\025\ufff6\041\ufff6\042\ufff6\001\002\000\016\005\042" +
    "\014\036\023\045\036\051\044\052\045\037\001\002\000" +
    "\006\006\121\027\105\001\002\000\022\003\025\007\005" +
    "\010\017\012\011\023\016\025\014\041\026\042\013\001" +
    "\002\000\026\003\ufff4\007\ufff4\010\ufff4\012\ufff4\021\ufff4" +
    "\022\123\023\ufff4\025\ufff4\041\ufff4\042\ufff4\001\002\000" +
    "\022\003\025\007\005\010\017\012\011\023\016\025\014" +
    "\041\026\042\013\001\002\000\026\003\ufff5\007\ufff5\010" +
    "\ufff5\012\ufff5\021\ufff5\022\ufff5\023\ufff5\025\ufff5\041\ufff5" +
    "\042\ufff5\001\002\000\016\005\042\014\036\023\045\036" +
    "\051\044\052\045\037\001\002\000\006\006\127\027\105" +
    "\001\002\000\022\003\025\007\005\010\017\012\011\023" +
    "\016\025\014\041\026\042\013\001\002\000\026\003\ufff1" +
    "\007\ufff1\010\ufff1\012\ufff1\021\ufff1\022\ufff1\023\ufff1\025" +
    "\ufff1\041\ufff1\042\ufff1\001\002\000\004\013\132\001\002" +
    "\000\026\003\ufff2\007\ufff2\010\ufff2\012\ufff2\021\ufff2\022" +
    "\ufff2\023\ufff2\025\ufff2\041\ufff2\042\ufff2\001\002\000\004" +
    "\002\000\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\131\000\006\002\003\003\005\001\001\000\002\001" +
    "\001\000\026\003\014\004\021\005\026\006\011\017\006" +
    "\020\023\021\007\022\022\023\020\024\017\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\024\003\014" +
    "\005\032\006\011\017\006\020\023\021\007\022\022\023" +
    "\020\024\017\001\001\000\002\001\001\000\002\001\001" +
    "\000\024\003\014\005\031\006\011\017\006\020\023\021" +
    "\007\022\022\023\020\024\017\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\022\007" +
    "\040\010\037\011\046\012\052\013\047\014\043\015\042" +
    "\016\045\001\001\000\006\015\112\016\045\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\022" +
    "\007\102\010\037\011\046\012\052\013\047\014\043\015" +
    "\042\016\045\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\006\015\053\016\045\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\012\013" +
    "\075\014\043\015\042\016\045\001\001\000\012\013\074" +
    "\014\043\015\042\016\045\001\001\000\012\013\073\014" +
    "\043\015\042\016\045\001\001\000\010\014\072\015\042" +
    "\016\045\001\001\000\010\014\063\015\042\016\045\001" +
    "\001\000\012\013\062\014\043\015\042\016\045\001\001" +
    "\000\002\001\001\000\002\001\001\000\006\015\071\016" +
    "\045\001\001\000\006\015\070\016\045\001\001\000\006" +
    "\015\067\016\045\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\014\012\101\013" +
    "\047\014\043\015\042\016\045\001\001\000\014\012\100" +
    "\013\047\014\043\015\042\016\045\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\020\010\105\011\046\012\052\013\047\014\043\015" +
    "\042\016\045\001\001\000\002\001\001\000\016\011\107" +
    "\012\052\013\047\014\043\015\042\016\045\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\022\007\114\010\037\011\046\012\052\013" +
    "\047\014\043\015\042\016\045\001\001\000\002\001\001" +
    "\000\002\001\001\000\022\007\117\010\037\011\046\012" +
    "\052\013\047\014\043\015\042\016\045\001\001\000\002" +
    "\001\001\000\024\003\014\005\121\006\011\017\006\020" +
    "\023\021\007\022\022\023\020\024\017\001\001\000\002" +
    "\001\001\000\024\003\014\005\123\006\011\017\006\020" +
    "\023\021\007\022\022\023\020\024\017\001\001\000\002" +
    "\001\001\000\022\007\125\010\037\011\046\012\052\013" +
    "\047\014\043\015\042\016\045\001\001\000\002\001\001" +
    "\000\024\003\014\005\127\006\011\017\006\020\023\021" +
    "\007\022\022\023\020\024\017\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$Parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$Parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws Exception
  {
    /* call code in generated class */
    return action_obj.CUP$Parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 1;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}


/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$Parser$actions {
  private final Parser parser;

  /** Constructor */
  CUP$Parser$actions(Parser parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$Parser$do_action_part00000000(
    int                        CUP$Parser$act_num,
    java_cup.runtime.lr_parser CUP$Parser$parser,
    java.util.Stack            CUP$Parser$stack,
    int                        CUP$Parser$top)
    throws Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$Parser$result;

      /* select the action based on the action number */
      switch (CUP$Parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // program ::= block 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("program",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // $START ::= program EOF 
            {
              Object RESULT =null;
		Location start_valxleft = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).xleft;
		Location start_valxright = ((java_cup.runtime.ComplexSymbolFactory.ComplexSymbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).xright;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		RESULT = start_val;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$Parser$parser.done_parsing();
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // block ::= SCOPE_START stmts SCOPE_END 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("block",1, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // stmts ::= stmts stmt 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("stmts",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // stmts ::= stmt 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("stmts",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // stmt ::= declaration 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("stmt",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // stmt ::= assignment 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("stmt",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // stmt ::= single_if 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("stmt",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // stmt ::= if_else 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("stmt",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // stmt ::= single_while 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("stmt",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // stmt ::= do_while 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("stmt",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // assignment ::= ID ASSIGN bool DELIMITER 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("assignment",14, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // single_if ::= IF BRACKET_LEFT bool BRACKET_RIGHT stmt ELSE stmt 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("single_if",15, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-6)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // if_else ::= IF BRACKET_LEFT bool BRACKET_RIGHT stmt 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("if_else",16, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-4)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // do_while ::= DO stmt WHILE BRACKET_LEFT bool BRACKET_RIGHT DELIMITER 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("do_while",18, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-6)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // declaration ::= type ID DELIMITER 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("declaration",13, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // single_while ::= WHILE BRACKET_LEFT bool BRACKET_RIGHT stmt 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("single_while",17, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-4)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // stmt ::= block 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("stmt",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // stmt ::= error DELIMITER 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("stmt",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // type ::= INT 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("type",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // type ::= REAL 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("type",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // bool ::= join 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("bool",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // bool ::= bool OR join 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("bool",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // join ::= equality 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("join",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // join ::= join AND equality 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("join",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // equality ::= rel 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("equality",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 26: // equality ::= equality EQ rel 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("equality",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 27: // equality ::= equality NEQ rel 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("equality",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 28: // rel ::= expr LESS_THAN expr 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("rel",8, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 29: // rel ::= expr GREATER_THAN expr 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("rel",8, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 30: // rel ::= expr LESS_EQUAL expr 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("rel",8, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 31: // rel ::= expr GREATER_EQUAL expr 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("rel",8, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 32: // rel ::= expr 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("rel",8, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 33: // expr ::= term 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",9, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 34: // expr ::= expr MINUS term 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",9, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 35: // expr ::= expr ADD term 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expr",9, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 36: // term ::= unary 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("term",10, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 37: // term ::= term TIMES unary 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("term",10, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 38: // term ::= term DIVIDE unary 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("term",10, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 39: // term ::= term MOD unary 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("term",10, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 40: // unary ::= NOT unary 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("unary",11, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 41: // unary ::= MINUS unary 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("unary",11, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 42: // unary ::= factor 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("unary",11, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 43: // factor ::= BRACKET_LEFT bool BRACKET_RIGHT 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("factor",12, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 44: // factor ::= ID 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("factor",12, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 45: // factor ::= INTNUM 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("factor",12, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 46: // factor ::= REALNUM 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("factor",12, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$Parser$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$Parser$do_action(
    int                        CUP$Parser$act_num,
    java_cup.runtime.lr_parser CUP$Parser$parser,
    java.util.Stack            CUP$Parser$stack,
    int                        CUP$Parser$top)
    throws Exception
    {
              return CUP$Parser$do_action_part00000000(
                               CUP$Parser$act_num,
                               CUP$Parser$parser,
                               CUP$Parser$stack,
                               CUP$Parser$top);
    }
}

}
