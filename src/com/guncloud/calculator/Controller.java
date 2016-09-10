package com.guncloud.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

    @FXML
    private Label result;
    private long numberX = 0;
    private String operator = "";
    private boolean start = true;

    @FXML
    public void processNumbers(ActionEvent event){
        if(start){
            result.setText("");
            start = false;
        }

        String value = ((Button)event.getSource()).getText();
        result.setText(result.getText()+value);
    }

    @FXML
    public void processOperators(ActionEvent event){
        String value = ((Button)event.getSource()).getText();

        if(!value.equals("=")){
            if(!operator.isEmpty()){
                return;
            }
            operator = value;
            numberX = Long.parseLong(result.getText());
            result.setText("");
        }else{
            if(operator.isEmpty()){
                return;
            }
            long numberY = Long.parseLong(result.getText());
            Model model = new Model();
            float output = model.calculate(numberX, numberY, operator);
            result.setText(String.valueOf(output));
            operator = "";
            start = true;
        }
    }
}
