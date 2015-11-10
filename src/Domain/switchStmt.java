package Domain;

/**
 * Created by Melisa on 09/11/2015.
 */
public class switchStmt implements IStmt {
    VarExpr var;
    Expr exp1;
    Expr exp2;
    IStmt stm1;
    IStmt stm2;
    IStmt stm3;

    public switchStmt(Expr ex1, Expr ex2, VarExpr varn, IStmt st1 ,IStmt st2, IStmt st3) {
        var = varn;
        exp1 = ex1;
        exp2 = ex2;
        stm1 = st1;
        stm2 = st2;
        stm3 = st3;
    }

    public IStmt getStm3() {
        return stm3;
    }

    public IStmt getStm2() {

        return stm2;
    }

    public IStmt getStm1() {

        return stm1;
    }

    public Expr getExp2() {

        return exp2;
    }

    public Expr getExp1() {

        return exp1;
    }

    public VarExpr getVar() {
        return var;
    }

    @Override
    public String toString() {
        return "Switch (" + var.toString() + ") case (" +  exp1.toString() +"): " + stm1.toString() + "case (" +  exp2.toString() +"):" + stm2.toString() + "default: " + stm3.toString();
    }
}
