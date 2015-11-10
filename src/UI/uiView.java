package UI;

import Controller.Ctrl;
import Domain.*;
import Exceptions.*;
import com.company.ArrayDictionary;
import com.company.ArrayList;
import com.company.ArrayStack;
import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Scanner;

/**
 * Created by Melisa on 18/10/2015.
 */
public class uiView implements View{
    Ctrl ctrl;
    Scanner sc;

    public uiView(Ctrl ctrl1) {
        ctrl = ctrl1;
        sc = new Scanner(System.in);
    }

    private void menu1() {
        System.out.println("1. Input program");
        System.out.println("2. One Step evaluation");
        System.out.println("3. Complete evaluation");
        System.out.println("4. Break");
        System.out.println("5. Print stack ");
    }


    private void stmtMenu() {
        System.out.println("What kind of statement? ");
        System.out.println("1. Assign Statement \n" +
                "2. Print Statement \n" +
                "3. If Statement \n" +
                "4. Compound Statement \n");
    }

    private void exprMenu() {
        System.out.println("1. Arithmetic Expression \n" +
                "2. Constant Expression \n" +
                "3. Variable Expression \n" +
                "4. Read \n" +
                "5. Bool expr \n");
    }


    private void printMenu() {
        System.out.println("1. Constant Expression \n" +
                "2. Variable Expression \n" +
                "3. Read \n" +
                "4. Bool expr \n");
    }

    public void uiInput() {
        stmtMenu();
        IStmt stmt = addStmt(sc.nextLine());
        System.out.println("You've added to program: ");
        System.out.println(stmt.toString());
        ctrl.add(stmt);
    }

    private IStmt addStmt(String val) {
        switch (val) {
            case "1":
                return addAssignStmt();
            case "2":
                return addPrintStmt();
            case "3":
                return addIfStmt();
            case "4":
                return addCompStmt();
            default:
                System.out.println("Invalid option, try again");
                stmtMenu();
                return addStmt(sc.nextLine());
        }
    }

    private IStmt addAssignStmt() {
        System.out.println("Give id");
        String id = sc.nextLine();
        exprMenu();
        Expr expr = addExpr(sc.nextLine());
        return new AssignStmt(expr, id);
    }

    private IStmt addIfStmt() {
        exprMenu();
        Expr exp = addExpr(sc.nextLine());
        stmtMenu();
        IStmt stmt1 = addStmt(sc.nextLine());
        stmtMenu();
        IStmt stmt2 = addStmt(sc.nextLine());
        return new IfStmt(exp, stmt1, stmt2);
    }

    private IStmt addCompStmt() {
        stmtMenu();
        IStmt stmt1 = addStmt(sc.nextLine());
        stmtMenu();
        IStmt stmt2 = addStmt(sc.nextLine());
        return new CompStmt(stmt1, stmt2);
    }

    private IStmt addPrintStmt() {
        printMenu();
        Expr ex = printSwitch(sc.nextLine());
        return new PrintStmt(ex);
    }

    private Expr printSwitch(String val) {
        switch (val) {
            case "1":
                return addConstExpr();
            case "2":
                return addVarExpr();
            case "3":
                return addReadExpr();
            case "4":
                return addBoolExpr();
            default:
                System.out.println("Invalid option, try again");
                printMenu();
                return printSwitch(sc.nextLine());
        }
    }
    private Expr addBoolExpr() {
        exprMenu();
        String input = sc.nextLine();
        Expr exp1 = boolSwitch(input);
        System.out.println("Give < <= > >= != ==");
        String operator = sc.nextLine();
        exprMenu();
        input = sc.nextLine();
        Expr exp2 = boolSwitch(input);
        return new boolExpr(exp1, operator, exp2);
    }

    private Expr boolSwitch(String val) {
        switch (val) {
            case "1":
                return addArithmeticExpr();
            case "2":
                return addConstExpr();
            case "3":
                return addVarExpr();
            case "4":
                return addReadExpr();
            case "5":
                return addBoolExpr();
            default:
                System.out.println("Invalid option, try again");
                printMenu();
                return printSwitch(sc.nextLine());
        }
    }

    private Expr addConstExpr() {
        System.out.println("Give number: ");
        return new ConstExpr(Integer.parseInt(sc.nextLine()));
    }

    private Expr addVarExpr() {
        System.out.println("Give variable: ");
        return new VarExpr(sc.nextLine());
    }

    private Expr addReadExpr() {
        return new read();
    }


    private Expr addArithmeticExpr() {
        exprMenu();
        String input = sc.nextLine();
        Expr exp1 = arithSwitch(input);
        System.out.println("Give Operation: + - * /");
        String operator = sc.nextLine();
        exprMenu();
        input = sc.nextLine();
        Expr exp2 = arithSwitch(input);
        return new ArithExpr(exp1, operator, exp2);
    }

    private Expr arithSwitch(String value) {
        switch (value) {
            case "1":
                return addArithmeticExpr();
            case "2":
                return addConstExpr();
            case "3":
                return addVarExpr();
            case "4":
                return addReadExpr();
            case "5":
                return addBoolExpr();
            default:
                exprMenu();
                return addArithmeticExpr();
        }
    }

    private Expr addExpr(String val) {
        switch (val) {
            case "1":
                return addArithmeticExpr();
            case "2":
                return addConstExpr();
            case "3":
                return addVarExpr();
            case "4":
                return addReadExpr();
            case "5":
                return addBoolExpr();
            default:
                System.out.println("Invalid option, try again");
                exprMenu();
                return addExpr(sc.nextLine());
        }
    }

    public void uioneStep() {
        int i = 1;
        try {
            ctrl.allStep(1);
            ProgState prg = new ProgState(new ArrayStack(), new ArrayDictionary(), new ArrayList());
            System.out.println(prg.toStr());
            prg = ctrl.getProg();
            System.out.println(prg.toStr());
            ctrl.addPrg(prg);
        }catch (VarNotFound| EmptyStack| DivByZero| UnsupportedOperator|EmptyDict|EmptyList e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

    public void uiAllSteps() {
        try {
            ctrl.allStep(0);
            ProgState prg = new ProgState(new ArrayStack(), new ArrayDictionary(), new ArrayList());
            System.out.println(prg.toStr());
            prg = ctrl.getProg();
            System.out.println(prg.toStr());
        } catch (VarNotFound| EmptyStack| DivByZero | UnsupportedOperator |EmptyDict|EmptyList e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

    private void printStack() {
        ProgState prg = new ProgState(new ArrayStack(), new ArrayDictionary(), new ArrayList());
        prg = ctrl.getProg();
        if (prg == null) {
            System.out.println("Nothing to print");
            return;
        }
        System.out.println(prg.toStr());
        ctrl.addPrg(prg);
    }

    public void uiprintAll() {
        while ( true ) {
            menu1();
            System.out.println("Enter option: ");
            String input = sc.nextLine();

            if ( input.equals("1") ) {
                uiInput();
            }
            if ( input.equals("2") ) {
//                IStmt ex2 = new CompStmt(new AssignStmt(new ArithExpr(new ConstExpr(2),"+",new
//                        ArithExpr(new ConstExpr(3),"*", new ConstExpr(5))),"a"),
//                        new CompStmt(new AssignStmt(new ArithExpr(new VarExpr("a"),"+", new
//                                ConstExpr(1)),"b"), new PrintStmt(new VarExpr("b"))));
//                ctrl.add(ex2);
                uioneStep();
            }
            if ( input.equals("3") ) {
//                IStmt ex2 = new CompStmt(new AssignStmt(new ArithExpr(new ConstExpr(2),"+",new
//                        ArithExpr(new ConstExpr(3),"*", new ConstExpr(5))),"a"),
//                        new CompStmt(new AssignStmt(new ArithExpr(new VarExpr("a"),"+", new
//                                ConstExpr(1)),"b"), new PrintStmt(new VarExpr("b"))));
//                ctrl.add(ex2);
                uiAllSteps();
            }
            if ( input.equals("4") ) {
                break;
            }
            if( input.equals("5") ) {
                printStack();
            }
        }
    }
}
