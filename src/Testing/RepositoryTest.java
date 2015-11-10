package Testing;
import Domain.ProgState;
import Repository.Repo;
import Repository.Repository;
import com.company.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Melisa on 14/10/2015.
 */
public class RepositoryTest {
    Repo repository;

    @Before
    public void setUp() throws Exception {
        repository = new Repository();
    }

    @Test
    public void testAddState() throws Exception {
        List ot = new ArrayList();
        Dictionary symtbl = new ArrayDictionary();
        Stack stk = new ArrayStack();
        ot.add(11);
        ot.add(12);
        symtbl.add("bb", 11);
        symtbl.add("bc", 12);
        stk.push(22);
        stk.push(23);
        ProgState prg;
        prg = new ProgState(stk, symtbl, ot);
        repository.addState(prg);
        assertEquals(1, repository.size() );
    }

    @Test
    public void testGetCtrlProg() throws Exception {
        List ot = new ArrayList();
        Dictionary symtbl = new ArrayDictionary();
        Stack stk = new ArrayStack();
        ot.add(11);
        ot.add(12);
        symtbl.add("bb", 11);
        symtbl.add("bc", 12);
        stk.push(22);
        stk.push(23);
        ProgState prg;
        prg = new ProgState(stk, symtbl, ot);
        repository.addState(prg);
        assertEquals(1, repository.size());
        prg = repository.getCtrlProg();
        assertEquals(0, repository.size() );
    }
}