package com.company;

import Controller.Controller;
import Controller.Ctrl;
import Domain.*;
import Repository.Repo;
import Repository.Repository;
import UI.View;
import UI.uiView;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Repo repo = new Repository();
        Ctrl ctrl = new Controller(repo);
        IStmt stm = new CompStmt(new AssignStmt(new ConstExpr(4),"v"),new CompStmt(new IfStmt(new VarExpr("v"),new AssignStmt(new ConstExpr(5),"v"),new PrintStmt(new VarExpr("v"))),new PrintStmt(new VarExpr("v"))));
//        IStmt stm = new CompStmt(new AssignStmt( new ConstExpr(2), "a"), new CompStmt(new AssignStmt( new ConstExpr(5), "c"), new IfStmt(new VarExpr("a"), new AssignStmt(new ArithExpr(
////                new VarExpr("a"),"+", new ConstExpr(5)), "b"), new AssignStmt(new ArithExpr(new ConstExpr(4), "-", new VarExpr("c")),"b"))));
//        IStmt stm =new CompStmt(new AssignStmt(new ArithExpr(new ConstExpr(4), "+", new read())),new PrintStmt(new VarExpr("a")));
//        ctrl.add(stm);

        stm = new CompStmt(new AssignStmt(new ConstExpr(1),"a"), new CompStmt(new AssignStmt(new read(), "v"), new CompStmt(new switchStmt(new ConstExpr(1),
                new ConstExpr(0), new VarExpr("v"), new IfThenStmt(new logicExpr(new VarExpr("v"),"&&", new VarExpr("a")),new AssignStmt(new ConstExpr(5),
                "v")), new AssignStmt(new logicExpr(new VarExpr("v"),"k!", new ConstExpr(44)),"v"), new AssignStmt(new ConstExpr(100), "v")), new whileStmt(new
                VarExpr("v"), new CompStmt(new AssignStmt(new ArithExpr(new VarExpr("a"),"+",new ConstExpr(1)),"a"), new AssignStmt( new ArithExpr(new
                VarExpr("v"),"-", new ConstExpr(1)),"v"))))));
//        stm = new AssignStmt(new ArithExpr(new ConstExpr(3),"/", new ConstExpr(0)),"v");
//        stm = new AssignStmt(new ArithExpr(new ConstExpr(3),"i", new ConstExpr(0)),"v");
        ctrl.add(stm);
        View ui1 = new uiView(ctrl);
        ui1.uiprintAll();
    }
}
