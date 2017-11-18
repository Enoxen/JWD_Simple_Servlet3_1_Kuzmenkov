package by.tc.task.exceptions;

/**
 * Created by Y50-70 on 12.11.2017.
 */
public class RequestToDbException extends Exception {
    public RequestToDbException(){}
    public RequestToDbException(String message){
        super(message);
    }
    public RequestToDbException(String message, Throwable exception){
        super(message,exception);
    }
    public RequestToDbException(Throwable exception){
        super(exception);
    }
}
