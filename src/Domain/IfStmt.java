package Domain;


/**
 * Created by Melisa on 11/10/2015.
 */
public class IfStmt implements IStmt {
    private Expr exp;
    private IStmt thenStmt;
    private IStmt elseStmt;

    /**
     * Constructor
     * @param expression - expression to be evaluated
     * @param thenS - then statement
     * @param elseS - else statement
     */
    public IfStmt(Expr expression, IStmt thenS, IStmt elseS) {
        exp = expression;
        thenStmt = thenS;
        elseStmt = elseS;
    }

    public IStmt getElseStmt() {
        return elseStmt;
    }

    public IStmt getThenStmt() {

        return thenStmt;
    }

    public Expr getExp() {

        return exp;
    }

    @Override
    public String toString() {
        return "if ( " + exp.toString() + " ) then ( " + thenStmt.toString() + " ) else ( " + elseStmt.toString()+ " )";
    }

}
