package org.cshaifasweng.winter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.cshaifasweng.winter.events.DashboardSwitchEvent;
import org.greenrobot.eventbus.EventBus;

import java.awt.event.MouseEvent;

public class OrderController implements Refreshable{

    @FXML
    private Button backButton;

    @FXML
    private Button cancelButton;

    @FXML
    private Button nextButton;

    @FXML
    private TabPane tabPane;

    @FXML
    private Tab tab1;

    @FXML
    private TableView<?> itemTable;

    @FXML
    private Tab tab2;

    @FXML
    private TextField firstNameVerField;

    @FXML
    private TextField lastNameVerField;

    @FXML
    private TextField idNumVerField;

    @FXML
    private TextField emailVerField;

    @FXML
    private TextField phoneNumVerField;

    @FXML
    private TextField addressVerField;

    @FXML
    private Label firstNameVerEmptyLabel;

    @FXML
    private Label lastNameVerEmptyLabel;

    @FXML
    private Label idVerEmptyLabel;

    @FXML
    private Label emailVerEmptyLabel;

    @FXML
    private Label phoneVerEmptyLabel;

    @FXML
    private Label addressVerEmptyLabel;

    @FXML
    private Label invalidFirstNameVerLabel;

    @FXML
    private Label invalidLastNameVerLabel;

    @FXML
    private Label invalidIdVerLabel;

    @FXML
    private Label invalidEmailVerLabel;

    @FXML
    private Label invalidPhoneVerLabel;

    @FXML
    private Label invalidAddressVerLabel;

    @FXML
    private Button changeDetailsButton;

    @FXML
    private Tab tab3;

    @FXML
    private TextArea greetingEntryTextArea;

    @FXML
    private Tab tab4;

    @FXML
    private RadioButton sendToMyAddRadio;

    @FXML
    private RadioButton sendToAnotherAddRadio;

    @FXML
    private Label deliveryAddressLabel;

    @FXML
    private Label recipientMailLabel;

    @FXML
    private TextField deliveryAddressField;

    @FXML
    private TextField recipientMailField;

    @FXML
    private Label deliveryAddressEmpty;

    @FXML
    private Label recipientMailEmpty;

    @FXML
    private Label invalidEmailAddressLabel;

    @FXML
    private Tab tab5;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField idNumField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField phoneNumberField;

    @FXML
    private TextField addressField;

    @FXML
    private TextArea greetingTextArea;

    private boolean radioStatus = false;

    private void restVisibleTab2()
    {
        //empty labels
        firstNameVerEmptyLabel.setVisible(false);
        lastNameVerEmptyLabel.setVisible(false);
        idVerEmptyLabel.setVisible(false);
        emailVerEmptyLabel.setVisible(false);
        phoneVerEmptyLabel.setVisible(false);
        addressVerEmptyLabel.setVisible(false);

        //invalid values labels
        invalidFirstNameVerLabel.setVisible(false);
        invalidLastNameVerLabel.setVisible(false);
        invalidIdVerLabel.setVisible(false);
        invalidEmailVerLabel.setVisible(false);
        invalidPhoneVerLabel.setVisible(false);
        invalidAddressVerLabel.setVisible(false);
    }

    private void resetVisibleTab4(){
        deliveryAddressEmpty.setVisible(false);
        recipientMailEmpty.setVisible(false);
        invalidEmailAddressLabel.setVisible(false);
    }

    private void setDisable(boolean status){
        deliveryAddressField.setDisable(!status);
        deliveryAddressLabel.setDisable(!status);
        recipientMailLabel.setDisable(!status);
        recipientMailField.setDisable(!status);
    }

    private void setSelected(boolean status){
        sendToAnotherAddRadio.setSelected(status);
        sendToMyAddRadio.setSelected(!status);
    }

    @FXML
    private void selectMyAddRadio() {
        radioStatus = false;
        setSelected(false);
        setDisable(radioStatus);

    }

    @FXML
    private void selectOtherAddRadio() {
        radioStatus = true;
        setSelected(true);
        setDisable(radioStatus);
    }

    @FXML
    void cancel(ActionEvent event) {
        EventBus.getDefault().post(new DashboardSwitchEvent("primary"));
    }

    /**
     * allow change in the personal details.
     * @param event
     */
    @FXML
    void changeDetails(ActionEvent event) {
        firstNameVerField.setDisable(false);
        lastNameVerField.setDisable(false);
        idNumVerField.setDisable(false);
        emailVerField.setDisable(false);
        phoneNumVerField.setDisable(false);
        addressVerField.setDisable(false);
    }

    @FXML
    void goBack(ActionEvent event) {
        SingleSelectionModel<Tab> selectionModel = tabPane.getSelectionModel();
        if(selectionModel.getSelectedIndex()==0){
            EventBus.getDefault().post(new DashboardSwitchEvent("primary"));
        }
        else{
            selectionModel.selectPrevious();
        }
        refresh();

    }

    boolean finalTab (){
        if (tab5.isSelected())
            return true;
        return false;
    }

    boolean firstTab(){
        if(tab1.isSelected())
            return true;
        return false;
    }

    @FXML
    void next(ActionEvent event) {
        SingleSelectionModel<Tab> selectionModel = tabPane.getSelectionModel();
        // If the current tub is the final tub. send the order and go back to the main screen.
        if(finalTab()){
            EventBus.getDefault().post(new DashboardSwitchEvent("primary"));
        }
        else{
            // move to the next tab and enable it.
            selectionModel.selectNext();
            selectionModel.getSelectedItem().setDisable(false);
        }
        refresh();
    }



    @Override
    public void refresh() {
        SingleSelectionModel<Tab> selectionModel = tabPane.getSelectionModel();
        //setting the default to 'send to my address'.
        selectMyAddRadio();
        System.out.println(selectionModel.getSelectedIndex());
        //if(selectionModel.getSelectedIndex() == 0){
        if(firstTab()){
            backButton.setText("Exit");
            cancelButton.setVisible(false);
        }
        else{
            backButton.setText("Back");
            cancelButton.setVisible(true);
        }

        if(selectionModel.getSelectedIndex() == 4){
            nextButton.setText("Send order");
        }
        else{
            nextButton.setText("Next");
        }
    }
}
