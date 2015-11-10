package Testing;

import Controller.Controller;
import Controller.Ctrl;
import Domain.*;
import Repository.Repo;
import Repository.Repository;
import com.company.ArrayDictionary;
import com.company.ArrayList;
import com.company.ArrayStack;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Melisa on 18/10/2015.
 */
public class ControllerTest {
    Ctrl ctrl;

    @Before
    public void setUp() throws Exception {
        Repo rep = new Repository();
        ctrl = new Controller(rep);
    }

    @Test
    public void testAdd() throws Exception {
        IStmt stm = new CompStmt(new AssignStmt(new ArithExpr(new ConstExpr(2), "*",
                new ConstExpr(3)),"a"), new PrintStmt(new ConstExpr(33)));
        ctrl.add(stm);
        ProgState prg = new ProgState(new ArrayStack(), new ArrayDictionary(), new ArrayList());
        prg = ctrl.getProg();
        assertEquals("[ (a=( 2*3 );print(33)) ]", prg.toStrExe());
    }

    @Test
    public void testOneStep() throws Exception {
        IStmt stm = new AssignStmt(new ArithExpr(new ConstExpr(2), "+",
                new ConstExpr(3)),"a");
        ctrl.add(stm);
        ProgState prg = new ProgState(new ArrayStack(), new ArrayDictionary(), new ArrayList());
        prg = ctrl.getProg();
        ctrl.oneStep(prg);
//        prg = ctrl.getProg();
        assertEquals("[ a : 5 ]", prg.toStrSym());

        stm =  new CompStmt(new AssignStmt(new ArithExpr(new ConstExpr(2), "*",
                new ConstExpr(3)),"a"), new PrintStmt(new ConstExpr(33)));
        ctrl.add(stm);
//        prg = ctrl.getProg();
//        ctrl.oneStep(prg);
//        prg = ctrl.getProg();
        ctrl.allStep(1);
        prg = ctrl.getProg();
        assertEquals("[ print(33) a=( 2*3 ) ]", prg.toStrExe());
//        ctrl.allStep(0);

        stm = new PrintStmt(new ArithExpr(new ConstExpr(3), "+", new ConstExpr(4)));
        ctrl.add(stm);
        prg = ctrl.getProg();
        ctrl.oneStep(prg);
//        prg = ctrl.getProg();
        assertEquals("[ 7 ]", prg.toStrOut());

        stm = new IfStmt(new ConstExpr(22),new AssignStmt(new ConstExpr(2), "v"), new
                AssignStmt(new ConstExpr(3), "v"));
        ctrl.add(stm);
        prg = ctrl.getProg();
        ctrl.oneStep(prg);
//        prg = ctrl.getProg();
        assertEquals("[ v=2 ]", prg.toStrExe());

        stm = new CompStmt(new AssignStmt(new ConstExpr(4),"v"), new switchStmt(new ConstExpr(5), new ConstExpr(4), new VarExpr("v"), new AssignStmt(new ConstExpr(44), "v"), new AssignStmt(new ConstExpr(55), "v"),new AssignStmt(new ConstExpr(66), "v")));
        ctrl.add(stm);
        prg = ctrl.getProg();
        ctrl.oneStep(prg);
        ctrl.oneStep(prg);
        ctrl.oneStep(prg);
        ctrl.oneStep(prg);
        assertEquals("[ v=55 ]", prg.toStrExe());

    }

    @Test
    public void testAllStep() throws Exception {
        IStmt stm = new CompStmt(new AssignStmt(new ArithExpr(new ConstExpr(2), "+",
                new ConstExpr(3)),"a"), new CompStmt(new PrintStmt(new VarExpr("a")),
                new AssignStmt(new ArithExpr(new VarExpr(("a")), "+", new ConstExpr(3)),"a")));
        ctrl.add(stm);
        ProgState prg = new ProgState(new ArrayStack(), new ArrayDictionary(), new ArrayList());
        ctrl.allStep(0);
        prg = ctrl.getProg();
        assertEquals("[ 5 ]", prg.toStrOut());
    }

    @Test
    public void testGetProg() throws Exception {

    }
}