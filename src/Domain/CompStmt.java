package Domain;

/**
 * Created by Melisa on 10/10/2015.
 */
public class CompStmt implements IStmt {
    private IStmt first;
    private IStmt second;

    public IStmt getSecond() {
        return second;
    }

    public IStmt getFirst() {

        return first;
    }

    /**
     * Constructor - first statement
     * @param secondstmt - second statement
     */
    public CompStmt (IStmt firststmt, IStmt secondstmt) {
        first = firststmt;
        second = secondstmt;
    }

    @Override
    public String toString() {
        return "(" + first.toString() + ";" + second.toString() + ")";
    }
}
