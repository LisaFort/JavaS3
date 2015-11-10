package Exceptions;

/**
 * Created by Melisa on 10/11/2015.
 */
public class EmptyList extends RuntimeException {
    public EmptyList(String msg) {
        super(msg);
    }
}
