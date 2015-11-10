package Testing;

import Domain.ArithExpr;
import Domain.AssignStmt;
import Domain.ConstExpr;
import Domain.IStmt;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Melisa on 13/10/2015.
 */
public class AssignStmtTest {
    IStmt stmt;

    @Before
    public void setUp() throws Exception {
        stmt = new AssignStmt(new ArithExpr(new ConstExpr(2), "*", new ConstExpr(3)),"a");
    }

    @Test
    public void testToStr() throws Exception {
        assertEquals("a=( 2*3 )", stmt.toString());
    }
}