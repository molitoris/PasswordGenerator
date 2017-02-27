/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PW_Gen.view;

import PW_Gen.Letter;
import PW_Gen.PasGen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

/**
 * FXML Controller class
 *
 */
public class MainViewController {

    private final PasGen main;

    public MainViewController() {
        main = new PasGen();
    }

    @FXML
    private CheckBox upperCheck;
    @FXML
    private CheckBox lowerCheck;
    @FXML
    private CheckBox numberCheck;
    @FXML
    private CheckBox punctCheck;
    @FXML
    private TextField additionField;
    @FXML
    private Spinner<Integer> quantitySpin;
    @FXML
    private Spinner<Integer> lengthSpin;
    @FXML
    private Button generateBtn;
    @FXML
    private TextArea outputArea;
    @FXML
    private Label infoLable;

    /**
     * handles the action when the generation button is clicked.
     *
     * @param e
     */
    @FXML
    protected void handleGeneration(ActionEvent e) {

        main.setUsableLetter("");

        if (upperCheck.isSelected()) {
            main.addUsableLetter(Letter.UPPER.get());
        }
        if (lowerCheck.isSelected()) {
            main.addUsableLetter(Letter.LOWER.get());
        }
        if (numberCheck.isSelected()) {
            main.addUsableLetter(Letter.NUMBER.get());
        }
        if (punctCheck.isSelected()) {
            main.addUsableLetter(Letter.PUNCT.get());
        }
        main.addUsableLetter(additionField.getText());

        if (main.isNotEmpty()) {
            main.setCharLength(lengthSpin.getValue());

            outputArea.setText("");
            for (int i = 0; i < quantitySpin.getValue(); i++) {
                outputArea.appendText(String.valueOf(main.genRandomPassword()));
                outputArea.appendText("\n\n");
            }

            infoLable.setText("generated " + quantitySpin.getValue() + " passwords with a length of " + lengthSpin.getValue() + " characters.");
        } else {
            infoLable.setText("Pleace choose a letter which should be used.");
        }
    }
}
