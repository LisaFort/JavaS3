package Controller;

import Domain.*;
import Exceptions.*;
import Repository.Repo;
import com.company.*;

/**
 * Created by Melisa on 17/10/2015.
 */
public class Controller implements Ctrl {
    private Repo repo;

    /**
     * Constructor
     * @param rep - repository
     */
    public Controller(Repo rep) {
        repo = rep;
    }

    /**
     * Adds a statemtn to the repository
     * @param stmt - type IStmt, statement to be added
     */
    public void add(IStmt stmt) {
        ProgState prg = new ProgState(new ArrayStack(), new ArrayDictionary(), new ArrayList());
        prg.getexe().push(stmt);
        repo.addState(prg);
    }

    /**
     * Adds a program state to the repository
     * @param prg - type ProgState, progState to be added
     */
    public void addPrg(ProgState prg) {
        repo.addState(prg);
    }

    /**
     * Runs the program state only one step
     * @param prg - type ProgState,
     * @throws VarNotFound
     * @throws EmptyStack
     */
    public void oneStep(ProgState prg) throws VarNotFound, EmptyStack, DivByZero, UnsupportedOperator, EmptyDict{
        if ( prg == null ) {
            throw new EmptyStack("No prog ");
        }
        Stack stk = prg.getexe();
        if (stk.isEmpty()) {
            throw new EmptyStack("The stack is empty");
        } else {
            IStmt stmt = (IStmt)stk.pop();
            try {
                if (stmt instanceof CompStmt) {
                    CompStmt cstmt = (CompStmt) stmt;
                    prg.getexe().push(cstmt.getSecond());
                    prg.getexe().push(cstmt.getFirst());
                    //                repo.addState(prg);
                    return;
                }
                if (stmt instanceof PrintStmt) {
                    PrintStmt pstmt = (PrintStmt) stmt;
                    Expr e = pstmt.getExp();
                    Dictionary dict = prg.getSym();
                    int val = e.eval(dict);
                    prg.getOut().add(val);
                    //                repo.addState(prg);
                    return;
                }
                if (stmt instanceof AssignStmt) {
                    AssignStmt astmt = (AssignStmt) stmt;
                    Expr e = astmt.getExp();
                    String str = astmt.getVar();
                    Dictionary dict = prg.getSym();
                    int val = e.eval(dict);
                    if (dict.get(str) != null) {
                        prg.getSym().modify(str, val);
                        //                    repo.addState(prg);
                    } else {
                        prg.getSym().add(str, val);
                        //                    repo.addState(prg);
                    }
                    return;
                }
                if (stmt instanceof IfStmt) {
                    IfStmt istmt = (IfStmt) stmt;
                    Expr e = istmt.getExp();
                    IStmt stm1 = istmt.getThenStmt();
                    IStmt stm2 = istmt.getElseStmt();
                    Dictionary dict = prg.getSym();
                    int val = e.eval(dict);
                    if (val != 0) {
                        prg.getexe().push(stm1);
                        //                    repo.addState(prg);
                    } else {
                        prg.getexe().push(stm2);
                        //                    repo.addState(prg);
                    }
                }
                if (stmt instanceof switchStmt) {
                    switchStmt sstmt = (switchStmt) stmt;
                    Dictionary dict = prg.getSym();
                    IfStmt istmt = new IfStmt(new ArithExpr(sstmt.getVar(), "-", sstmt.getExp2()), new IfStmt(new ArithExpr(sstmt.getVar(), "-", sstmt.getExp1()), sstmt.getStm3(), sstmt.getStm1()), sstmt.getStm2());
                    prg.getexe().push(istmt);
                }
                if (stmt instanceof whileStmt) {
                    whileStmt wstmt = (whileStmt) stmt;
                    Dictionary dicti = prg.getSym();
                    int evalu = wstmt.getExpr().eval(dicti);
                    if (evalu != 0) {
                        prg.getexe().push(wstmt);
                        prg.getexe().push(wstmt.getStmt());
                    }
                }
                if (stmt instanceof IfThenStmt) {
                    IfThenStmt ifThen = (IfThenStmt) stmt;
                    IStmt is = new IfStmt(ifThen.getExpr(), ifThen.getThenStmt(), new SkipStmt());
                    prg.getexe().push(is);
                }
            }catch ( VarNotFound| EmptyStack| DivByZero| UnsupportedOperator|EmptyDict|EmptyList e) {
                throw e;
            }
        }
    }

    /**
     * takes a program state from the repository and runs it until the stack is empty
     * if flag is 1, it only runs one step
     * @param flag - type integer
     * @throws VarNotFound
     */
    public void allStep(int flag) throws VarNotFound{
        ProgState prg = repo.getCtrlProg();
        if (prg == null) {
            throw new VarNotFound("Nothing to compile");
        }
        if ( flag == 1) {
            try {
                oneStep(prg);
            } catch (EmptyStack e) {
                System.err.print("Exception: " + e.getMessage());
            }
        } else {
            while (!prg.getexe().isEmpty()) {
                try {
                    oneStep(prg);
                } catch (EmptyStack e) {
                    System.err.print("Exception: " + e.getMessage());
                }
            }
        }
        repo.addState(prg);
    }

    /**
     * Returns a program state from the repositoryyy
     * @return
     */
    public ProgState getProg() {
        return repo.getCtrlProg();
    }

}
