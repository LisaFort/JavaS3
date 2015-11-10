package Testing;

import com.company.ArrayStack;
import com.company.Stack;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Melisa on 08/10/2015.
 */
public class ArrayStackTest {

    private Stack st;
    @Before
    public void setUp() throws Exception {
        st = new ArrayStack<Integer>();
    }

    @Test
    public void testPush() throws Exception {
        st.push(33);
        assertEquals(33,st.pop());
    }

    @Test
    public void testPop() throws Exception {
        assertTrue(st.isEmpty());
        st.push(33);
        st.push(11);
        assertEquals(11, st.pop());
        assertEquals(33, st.pop());
    }

    @Test
    public void testIsEmpty() throws Exception {
        assertEquals(true, st.isEmpty());
        st.push(11);
        assertEquals(false, st.isEmpty());
    }

    @Test
    public void testTop() throws Exception {
        st.push(11);
        st.push(43);
        assertEquals(43,st.top());
        assertEquals(43,st.top());
    }

    @Test
    public void testToString() throws Exception {
        st.push(11);
        st.push(43);
        assertEquals("[11, 43]", st.toString());
    }
}