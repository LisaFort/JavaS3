package Domain;

/**
 * Created by Melisa on 11/10/2015.
 */
public class AssignStmt implements IStmt {
    private Expr exp;
    private String var;

    /**
     * Constructor
     * @param expression - expression
     * @param variable - variable name to assign the expression to
     */
    public AssignStmt(Expr expression, String variable) {
        exp = new Expr();
        var = variable;
        exp = expression;
    }

    public String getVar() {
        return var;
    }

    public Expr getExp() {

        return exp;
    }

    @Override
    public String toString() {
        return var + "=" + exp.toString();
    }
}
