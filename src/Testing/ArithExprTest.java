package Testing;

import Domain.ArithExpr;
import Domain.ConstExpr;
import Domain.Expr;
import com.company.ArrayDictionary;
import com.company.Dictionary;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Melisa on 13/10/2015.
 */
public class ArithExprTest {
    Expr arithE;
    Dictionary dict;

    @Before
    public void setUp() throws Exception {
        arithE =  new ArithExpr(new ConstExpr(3), "+", new ConstExpr(4));
        dict = new ArrayDictionary();
        dict.add("g",44);
        dict.add("h",22);
    }

    @Test
    public void testEval() throws Exception {
        assertEquals(7, arithE.eval(dict));
    }

    @Test
    public void testToStr() throws Exception {
        assertEquals("( 3+4 )", arithE.toString());
    }
}