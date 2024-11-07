package org.example.cryptoanalyzer;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import javax.swing.text.html.ImageView;
import java.net.URL;
import java.nio.file.Path;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Button confirmChoiceBtn;

    @FXML
    private ChoiceBox<String> menuChoiceBox;

    @FXML
    private TextField keyEntryField;

    @FXML
    private Button openFileBtn;

    @FXML
    private Button writeFileBtn;

    @FXML
    private TextArea displayText;

    @FXML
    private Button startBtn;

    @FXML
    private Label okLabel1;

    @FXML
    private Label okLabel2;

    @FXML
    private Button brutForceBtn;

    @FXML
    private Button brutForceFitsBtn;

    @FXML
    private TextArea textBrutForce;

    @FXML
    private Button chekBfBtn;

    @FXML
    private Button brutForceCorrectKey;

    @FXML
    private TextArea brutForceFieldNum;



    private int menuSelectChoice = 0;
    private int correctKey;
    private Path readFile;
    private Path writeFile;
    private Path readFileBf;
    private int chekKey = 1;

    @FXML
    void keyConfirm(MouseEvent event) {
        displayText.setText("First, enter the key");
        if (keyEntryField.getText() != "") {
            correctKey = KeyValidate.keyValidate(keyEntryField.getText());
            if (correctKey == 0) {
                displayText.setText("Invalid key entered");
            } else {
                displayText.setText("The key is correct");
                openFileBtn.setText("1. Choose FILE to READ");
            }
        }
    }

    @FXML
    void menuSelect(MouseEvent event) throws InterruptedException {
        String menuChoice = menuChoiceBox.getSelectionModel().getSelectedItem();
        keyEntryField.setVisible(true);
        if (menuChoice.equals("Encrypt FILE")) {
            confirmChoiceBtn.setVisible(false);
            displayText.setText("Input KEY in the entry field");
            menuSelectChoice = 1;
        } else if (menuChoice.equals("Decrypt FILE")) {
            confirmChoiceBtn.setVisible(false);
            displayText.setText("Input KEY in the entry field");
            menuSelectChoice = 2;
        } else if (menuChoice.equals("EXIT")) {
            System.exit(0);
        } else if (menuChoice.equals("BRUTE FORCE")) {
            confirmChoiceBtn.setVisible(false);
            keyEntryField.setVisible(false);
            brutForceBtn.setVisible(true);
            chekBfBtn.setVisible(true);
            brutForceFieldNum.setVisible(true);
            brutForceCorrectKey.setVisible(true);
            okLabel1.setText("");
            okLabel2.setText("");

        }

    }

    @FXML
    void openFileFead(MouseEvent event) {
        if (menuSelectChoice == 1 || menuSelectChoice == 2) {
            readFile = Path.of(OpenFileToRead.openFileRead());
            displayText.setText("The file is selected: " + String.valueOf(readFile));
            writeFileBtn.setText("2. Choose File to WRITE");
            okLabel1.setText("Continue next step");
        }

    }

    @FXML
    void openFileWrite(MouseEvent event) {
        if (menuSelectChoice == 1) {
            writeFile = Path.of(OpenFileToWrite.openFileWrite());
                displayText.setText("The file will be recorded: " + String.valueOf(writeFile));
            startBtn.setText("3. ENCRYPT");
            okLabel2.setText("Continue next step");
        } else if (menuSelectChoice == 2) {
            writeFile = Path.of(OpenFileToWrite.openFileWrite());
            displayText.setText("The file will be recorded: " + String.valueOf(writeFile));
            startBtn.setText("3. DECRYPT");
            okLabel2.setText("Continue next step");
        }

    }

    @FXML
    void startCrypting(MouseEvent event) {
        if (menuSelectChoice == 1) {
            EncryptFile.encryptFile(correctKey, readFile, writeFile);
            displayText.setText("The file has been successfully \"Encrypted\"\n\nIs there anything else you want to do?");
            confirmChoiceBtn.setVisible(true);
            keyEntryField.setText("");
            openFileBtn.setText("");
            writeFileBtn.setText("");
            startBtn.setText("");
            keyEntryField.setVisible(false);

        }
        if (menuSelectChoice == 2) {
            DecryptFile.decrypteFile(correctKey, readFile, writeFile);
            displayText.setText("The file has been successfully \"Decrypted.\"\n\nIs there anything else you want to do?");
            confirmChoiceBtn.setVisible(true);
            keyEntryField.setText("");
            openFileBtn.setText("");
            writeFileBtn.setText("");
            startBtn.setText("");
            keyEntryField.setVisible(false);

        }
    }

    @FXML
    void brutForcePush(MouseEvent event) {
        readFileBf = Path.of(OpenFileToRead.openFileRead());


    }

    @FXML
    void checkString(MouseEvent event) {
        StringBuilder itogString = new StringBuilder();
        brutForceFieldNum.setText(chekKey + "");
        String proverka = BrutForce.brutForce(itogString, chekKey, readFileBf);
        displayText.setText(proverka);
        chekKey++;
    }

    @FXML
    void brutForceCorrectKeyPush(MouseEvent event) {
        displayText.setText("File can be Encrypt whith Key " + (chekKey - 1) + " !");
        confirmChoiceBtn.setVisible(true);

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        keyEntryField.setVisible(false);
        brutForceBtn.setVisible(false);
        chekBfBtn.setVisible(false);
        brutForceFieldNum.setVisible(false);
        brutForceCorrectKey.setVisible(false);
        menuChoiceBox.getItems().addAll("Encrypt FILE", "Decrypt FILE", "BRUTE FORCE", "EXIT");
    }
}
