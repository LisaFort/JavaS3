package Domain;

import com.company.*;

/**
 * Created by Melisa on 13/10/2015.
 */
public class ProgState {
    private List out;
    private Dictionary symTable;
    private Stack exeStack;
    private Stack origProg;

    /**
     * Constructor
     * @param stk - execution stack
     * @param symtbl - symbol table
     * @param ot - output list
     */
    public ProgState(Stack stk, Dictionary symtbl, List ot) {
        out = ot;
        symTable = symtbl;
        exeStack = stk;
        origProg = stk;
    }

    public List getOut() {
        return out;
    }

    public Dictionary getSym() {
        return symTable;
    }

    public Stack getexe() {
        return exeStack;
    }

    public Stack getOrig() {
        return origProg;
    }

    public String toStrOut() {
        return out.toString();
    }

    public String toStrSym() {
        return symTable.toString();
    }

    public String toStrExe() {
        return exeStack.toString();
    }

    public String toStrOrig() {
        return origProg.toString();
    }

    public String toStr() {
        String stat = "Stack: ";
        stat = stat.concat(toStrExe());
        stat = stat.concat("\n");
        stat = stat.concat("Output: ");
        stat = stat.concat(toStrOut());
        stat = stat.concat("\n");
        stat = stat.concat("SymTable: ");
        stat = stat.concat(toStrSym());
        stat = stat.concat("\n");
//        stat = stat.concat("Original: ");
//        stat = stat.concat(toStrOrig());
        return stat;
    }

}
