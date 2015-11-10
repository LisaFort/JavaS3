package Domain;

import com.company.Dictionary;

/**
 * Created by Melisa on 11/10/2015.
 */
public class ConstExpr extends Expr {
    public int getNr() {
        return nr;
    }

    private int nr;

    /**
     * Constructor
     * @param number - integer
     */
    public ConstExpr(int number) {
        nr = number;
    }

    @Override
    public int eval(Dictionary tbl) {
        return nr;
    }

    @Override
    public String toString() {
        return String.valueOf(nr);
    }
}

