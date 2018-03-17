package cards;

import java.util.ArrayList;

import exceptions.UnAvailableCardException;

public class Card{
    private PaymentSystemName paymentSystem;
    private ArrayList<Long> numOfCardArray;

    public Card(){numOfCardArray=new ArrayList<>();}

    public void setPaymentSystem(PaymentSystemName paymentSystem) {
        this.paymentSystem=paymentSystem;
    }
    public void setNumOfCard(long numOfCard) {
        String s=Long.toString(numOfCard);
        for(int i=s.length()-1;i>=0;i--){
            numOfCardArray.add(0,numOfCard%10);
            numOfCard/=10;
        }
    }

    public PaymentSystemName getPaymentSystem() {
        return paymentSystem;
    }
    public String getNumOfCard() {
        return numOfCardArray.toString();
    }

    public boolean check() throws UnAvailableCardException {

        if(numOfCardArray.size()!=16) throw new UnAvailableCardException("Lenght of your card's number is either too short or too long. Enter correct number.");
        if(countCheckSum()%10!=0) throw new UnAvailableCardException("Number of your card is wrong. Enter correct number.");
        return true;
    }

    public int countCheckSum(){

        int checkSum=0;
        for(int i=numOfCardArray.size()-1;i>=0;i--){
            if(i%2!=0) checkSum+=numOfCardArray.get(i);
            else {
                long temp=numOfCardArray.get(i) * 2;
                if (temp > 9){
                    String s=Long.toString(temp);
                    for(int y=s.length()-1;y>=0;y--){
                        checkSum+=temp%10;
                        temp/=10;
                    }
                }
                else checkSum+=temp;
            }
        }
        System.out.println(checkSum);
        return checkSum;
    }
}
