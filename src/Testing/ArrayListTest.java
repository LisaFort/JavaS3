package Testing;

import com.company.ArrayList;
import com.company.List;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Melisa on 08/10/2015.
 */
public class ArrayListTest {

    private List ar;

    @org.junit.Before
    public void setUp() throws Exception {
        ar = new ArrayList<Integer>();
    }

    @Test
    public void testAdd() throws Exception {
        ar.add(33);
        int expected;
        expected = 33;
        assertEquals(expected, ar.get(0));
    }

    @Test
    public void testGetSize() throws Exception {
        assertEquals(0,ar.getSize());
        ar.add(44);
        assertEquals(1,ar.getSize());
    }

    @Test
    public void testGet() throws Exception {
        ar.add(43);
        ar.add(22);
        ar.add(12);
        assertEquals(22, ar.get(1));
    }

    @Test
    public void testIsEmpty() throws Exception {
        assertEquals(true,ar.isEmpty());
        ar.add(22);
        assertEquals(false,ar.isEmpty());
    }

    @Test
    public void testToString() throws Exception {
        ar.add(43);
        ar.add(22);
        ar.add(12);
        assertEquals("[43, 22, 12]", ar.toString());
    }
}