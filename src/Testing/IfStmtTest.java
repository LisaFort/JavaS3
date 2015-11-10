package Testing;

import Domain.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Melisa on 13/10/2015.
 */
public class IfStmtTest {
    IStmt stmt;

    @Before
    public void setUp() throws Exception {
        int a = 0;
        stmt = new IfStmt(new VarExpr("a"),new AssignStmt(new ConstExpr(2), "v"), new
                AssignStmt(new ConstExpr(3), "v"));
    }

    @Test
    public void testToStr() throws Exception {
        assertEquals("if ( a ) then ( v=2 ) else ( v=3 )", stmt.toString());
    }
}