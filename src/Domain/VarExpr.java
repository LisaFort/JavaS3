package Domain;

import com.company.Dictionary;

/**
 * Created by Melisa on 12/10/2015.
 */
public class VarExpr extends Expr {
    String id;

    /**
     * Constructor
     * @param idd - variable name
     */
    public VarExpr(String idd) {
        id = idd;
    }

    @Override
    public int eval (Dictionary tbl) {
        return (int)tbl.get(id);
    }

    @Override
    public String toString() {
        return id;
    }

}
