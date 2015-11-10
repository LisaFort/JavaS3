package Domain;

import com.company.Dictionary;

import java.util.Scanner;

/**
 * Created by Melisa on 03/11/2015.
 */
public class read extends Expr{
    Scanner sc;

    public read() {
        sc = new Scanner(System.in);
    };

    @Override
    public int eval (Dictionary tbl) {
        System.out.println("Enter int: ");
        int i = sc.nextInt();
        return i;
    }

    @Override
    public String toString() {
        return "read()";
    }
}
