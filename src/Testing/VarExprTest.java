package Testing;

import Domain.Expr;
import Domain.VarExpr;
import com.company.ArrayDictionary;
import com.company.Dictionary;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Melisa on 12/10/2015.
 */
public class VarExprTest {
    Expr varE;
    Dictionary dict;

    @Before
    public void setUp() throws Exception {
        varE = new VarExpr("g");
        dict = new ArrayDictionary();
        dict.add("g",44);
        dict.add("h",22);
    }

    @Test
    public void testEval() throws Exception {
        assertEquals(44,varE.eval(dict));
    }

    @Test
    public void testToStr() throws Exception {
        assertEquals("g", varE.toString());
    }
}