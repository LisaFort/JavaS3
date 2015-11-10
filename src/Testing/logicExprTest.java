package Testing;

import Domain.ArithExpr;
import Domain.ConstExpr;
import Domain.logicExpr;
import com.company.ArrayDictionary;
import com.company.Dictionary;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Melisa on 09/11/2015.
 */
public class logicExprTest {
    private logicExpr b,c,d;
    private Dictionary tbl;

    @Before
    public void setUp() throws Exception {
        b = new logicExpr(new ConstExpr(0), "||", new ArithExpr(new ConstExpr(2),"+", new ConstExpr(4)));
        c = new logicExpr(new ConstExpr(0), "&&", new ArithExpr(new ConstExpr(2),"+", new ConstExpr(4)));
        d = new logicExpr(new ConstExpr(1), "!", new ArithExpr(new ConstExpr(2),"+", new ConstExpr(4)));
        tbl  = new ArrayDictionary();
    }

    @Test
    public void testEval() throws Exception {
        assertEquals(1, b.eval(tbl));
        assertEquals(0, c.eval(tbl));
        assertEquals(0, d.eval(tbl));
    }

    @Test
    public void testToStr() throws Exception {

    }
}