package Testing;

import Domain.Expr;
import com.company.ArrayDictionary;
import com.company.Dictionary;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Melisa on 08/10/2015.
 */
public class DictionaryTest {
    Dictionary di;

    @Before
    public void setUp() throws Exception {
        di = new ArrayDictionary<Integer, String>();
    }

    @Test
    public void testAdd() throws Exception {
        assertEquals(0, di.getSize());
        di.add(1, "aa");
        assertEquals(1, di.getSize());
        di.add(1, "bb");
        assertEquals(1, di.getSize());
    }

    @Test
    public void testModify() throws Exception {
        di.add(1, "aa");
        di.modify(1, "aaa");
        Object ob = new Object();
        ob = di.get(1);
        assertEquals("aaa", ob);

    }

    @Test
    public void testIsEmpty() throws Exception {
        assertEquals(true, di.isEmpty());
        di.add(1, "aa");
        assertEquals(false, di.isEmpty());
    }

    @Test
    public void testGetSize() throws Exception {
        assertEquals(0, di.getSize());
        di.add(1, "aa");
        assertEquals(1, di.getSize());
    }

    @Test
    public void testRemove() throws Exception {
        di.add(1, "aa");
        di.add(2, "bb");
        assertEquals(2, di.getSize());
        di.remove(2);
        assertEquals(1, di.getSize());
        di.remove(3);
        assertEquals(1, di.getSize());

    }

    @Test
    public void testGet() throws Exception {
        di.add(1, "aa");
        di.add(2, "bb");
        Object ob = new Object();
        ob = di.get(1);
        assertEquals("aa",ob);
        ob = di.get(3);
        assertEquals(null, ob);

    }

    @Test
    public void testToString() throws Exception {
        di.add(1, "aa");
        di.add(2, "bb");
        assertEquals("{1=aa, 2=bb}", di.toString());
    }
}