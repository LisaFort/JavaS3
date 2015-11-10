package Exceptions;

/**
 * Created by Melisa on 24/10/2015.
 */
public class EmptyStack extends RuntimeException {

    public EmptyStack(String msg) {
        super(msg);
    }
}
