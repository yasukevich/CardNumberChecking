package exceptions;

public class UnAvailableCardException extends Exception{
    public UnAvailableCardException(String textMessag){
        super(textMessag);
    }
}
