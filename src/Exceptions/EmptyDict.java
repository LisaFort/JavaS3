package Exceptions;

/**
 * Created by Melisa on 10/11/2015.
 */
public class EmptyDict extends RuntimeException {
    public EmptyDict(String msg) {
        super(msg);
    }
}
