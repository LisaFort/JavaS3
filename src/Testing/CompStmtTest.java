package Testing;

import Domain.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Melisa on 10/10/2015.
 */
public class CompStmtTest {
    IStmt stmt;

    @Before
    public void setUp() throws Exception {
        stmt = new CompStmt(new AssignStmt(new ArithExpr(new ConstExpr(2), "*",
                new ConstExpr(3)),"a"), new PrintStmt(new ConstExpr(33)));
    }

    @Test
    public void testToStr() throws Exception {
        assertEquals("(a=( 2*3 );print(33))", stmt.toString());
    }
}