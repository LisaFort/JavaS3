package Testing;

import Domain.ConstExpr;
import Domain.Expr;
import com.company.ArrayDictionary;
import com.company.Dictionary;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Melisa on 12/10/2015.
 */
public class ConstExprTest {
    Expr constE;
    Dictionary dict;

    @Before
    public void setUp() throws Exception {
        constE = new ConstExpr(33);
        dict = new ArrayDictionary();
        dict.add("g",44);
        dict.add("h",22);
    }

    @Test
    public void testEval() throws Exception {
        assertEquals(33, constE.eval(dict));
    }

    @Test
    public void testToStr() throws Exception {
        assertEquals("33",constE.toString());
    }
}