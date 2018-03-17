package sample;

import cards.Card;

import cards.PaymentSystemName;
import exceptions.UnAvailableCardException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {

    //Views
    @FXML private Label label;
    @FXML private TextField field;
    @FXML private ComboBox comboBox;

    private Main main;

    ObservableList<PaymentSystemName> paymentSystemList= FXCollections.observableArrayList(PaymentSystemName.Maestro,
            PaymentSystemName.Master,PaymentSystemName.Visa,PaymentSystemName.Белкард);//тип элементов передаваемый в качестве параметра это пользовательский enum PaymentSystemName


    public void setMain(Main main){
        this.main=main;
        comboBox.setItems(paymentSystemList);
    }

    public void handleButton(){
        Card card=new Card();
        card.setPaymentSystem((PaymentSystemName)comboBox.getValue());
        try {
            card.setNumOfCard(Long.parseLong(field.getText()));
        }catch (NumberFormatException e) {
            label.setText("Enter number of your card, please.");
        }
        try {
            card.check();
            label.setText(card.getPaymentSystem()+": Checked!");
        } catch (UnAvailableCardException e) {
            label.setText(e.getMessage());
        }
    }
}
