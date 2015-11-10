package Testing;

import Domain.ProgState;
import com.company.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Melisa on 13/10/2015.
 */
public class ProgStateTest {
    ProgState prg;

    @Before
    public void setUp() throws Exception {
        List ot = new ArrayList();
        Dictionary symtbl = new ArrayDictionary();
        Stack stk = new ArrayStack();
        ot.add(11);
        ot.add(12);
        symtbl.add("bb", 11);
        symtbl.add("bc", 12);
        stk.push(22);
        stk.push(23);
        prg = new ProgState(stk, symtbl, ot);

    }

    @Test
    public void testGetOut() throws Exception {
        List wtf = new ArrayList();
        List wtf2 = new ArrayList();
        wtf2 = prg.getOut();
        wtf.add(11);
        wtf.add(12);
        int i = 0;
        if (wtf.get(0) != wtf2.get(0)) { i = 1;};
        if (wtf.get(0) != wtf2.get(0)) { i = 1;};
        assertEquals(0, i);
    }

    @Test
    public void testGetSym() throws Exception {
        Dictionary sym = new ArrayDictionary();
        sym = prg.getSym();
        int i = 0;
        if ( (int)sym.get("bb") != 11 ){ i = 1; };
        if ( (int)sym.get("bc") != 12 ){ i = 2; };
        assertEquals(0, i);

    }

    @Test
    public void testGetexe() throws Exception {
        Stack st = new ArrayStack();
        st = prg.getexe();
        int i = 0;
        if ( (int)st.pop() != 23) { i = 1; };
        if ( (int)st.pop() != 22) { i = 2; };
        assertEquals(0 , i);
    }

    @Test
    public void testGetOrig() throws Exception {
        Stack st = new ArrayStack();
        st = prg.getOrig();
        int i = 0;
        if ( (int)st.pop() != 23) { i = 1; };
        if ( (int)st.pop() != 22) { i = 2; };
        assertEquals(0 , i);
    }

    @Test
    public void testToStrOut() throws Exception {
        assertEquals("[ 11 12 ]", prg.toStrOut());
    }

    @Test
    public void testToStrSym() throws Exception {
        assertEquals("[ bb : 11, bc : 12 ]", prg.toStrSym());
    }

    @Test
    public void testToStrExe() throws Exception {
        assertEquals("[ 22 23 ]", prg.toStrExe());
    }

    @Test
    public void testToStrOrig() throws Exception {
        assertEquals("[ 22 23 ]", prg.toStrExe());
    }
}