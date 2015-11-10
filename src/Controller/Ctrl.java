package Controller;

import Domain.IStmt;
import Domain.ProgState;
import Exceptions.EmptyStack;
import Exceptions.VarNotFound;
import Repository.Repository;
import Repository.Repo;

import javax.swing.*;

/**
 * Created by Melisa on 14/10/2015.
 */
public interface Ctrl {

    public void add(IStmt stm);
    public void oneStep(ProgState prg)throws VarNotFound, EmptyStack;
    public void allStep(int flag) throws VarNotFound, EmptyStack;
    public ProgState getProg();
    public void addPrg(ProgState prg);


}
