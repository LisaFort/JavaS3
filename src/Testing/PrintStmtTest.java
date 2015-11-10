package Testing;

import Domain.ArithExpr;
import Domain.ConstExpr;
import Domain.IStmt;
import Domain.PrintStmt;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Melisa on 13/10/2015.
 */
public class PrintStmtTest {
    IStmt stmt;

    @Before
    public void setUp() throws Exception {
        stmt = new PrintStmt(new ArithExpr(new ConstExpr(3), "+", new ConstExpr(4)));
    }

    @Test
    public void testToStr() throws Exception {
        assertEquals("print(( 3+4 ))", stmt.toString());
    }
}