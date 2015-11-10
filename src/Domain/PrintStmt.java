package Domain;

/**
 * Created by Melisa on 10/10/2015.
 */
public class PrintStmt implements IStmt {
    private Expr exp;

    /**
     * Constructor
     * @param e
     */
    public PrintStmt(Expr e) {
        exp = e;
    }

    @Override
    public String toString() {
        return "print(" + exp.toString() + ")";
    }

    public Expr getExp() {
        return exp;
    }
}
