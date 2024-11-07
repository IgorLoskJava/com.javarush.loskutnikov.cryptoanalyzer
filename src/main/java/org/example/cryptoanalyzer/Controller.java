package org.example.cryptoanalyzer;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

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

    private int menuSelectChoice = 0;
    private int correctKey;
    private Path readFile;
    private Path writeFile;

    @FXML
    void keyConfirm(MouseEvent event) {
        displayText.setText("Сначала введите ключ");
        if (keyEntryField.getText() != "") {
            correctKey = KeyValidate.keyValidate(keyEntryField.getText());
            if (correctKey == 0) {
                displayText.setText("Введен неверный ключ");
            } else {
                displayText.setText("Ключ подходит");
                openFileBtn.setText("Choose FILE to Encrypt");
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
        } else if (menuChoice.equals("BRUT FORCE")) {

        }

    }

    @FXML
    void openFileFead(MouseEvent event) {
        if (menuSelectChoice == 1 || menuSelectChoice == 2) {
            readFile = Path.of(OpenFileToRead.openFileRead());
            displayText.setText("Выбран файл: " + String.valueOf(readFile));
            writeFileBtn.setText("Choose File to WRITE");
            okLabel1.setText("Continue next step");
        }

    }

    @FXML
    void openFileWrite(MouseEvent event) {
        if (menuSelectChoice == 1) {
            writeFile = Path.of(OpenFileToWrite.openFileWrite());
            displayText.setText("Выбран для записи: " + String.valueOf(writeFile));
            startBtn.setText("ENCRYPT");
            okLabel2.setText("Continue next step");
        } else if (menuSelectChoice == 2) {
            writeFile = Path.of(OpenFileToWrite.openFileWrite());
            displayText.setText("Выбран для записи: " + String.valueOf(writeFile));
            startBtn.setText("DECRYPT");
        }

    }

    @FXML
    void startCrypting(MouseEvent event) {
        if (menuSelectChoice == 1) {
            EncryptFile.encryptFile(correctKey, readFile, writeFile);
            displayText.setText("The file has been successfully \"Encrypted\"");
            confirmChoiceBtn.setVisible(true);
            keyEntryField.setText("");
            openFileBtn.setText("");
            writeFileBtn.setText("");
            startBtn.setText("");
            keyEntryField.setVisible(false);

        }
        if (menuSelectChoice == 2) {
            DecryptFile.decrypteFile(correctKey, readFile, writeFile);
            displayText.setText("The file has been successfully \"Decrypted\"");
            confirmChoiceBtn.setVisible(true);
            keyEntryField.setText("");
            openFileBtn.setText("");
            writeFileBtn.setText("");
            startBtn.setText("");
            keyEntryField.setVisible(false);

        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        keyEntryField.setVisible(false);
        menuChoiceBox.getItems().addAll("Encrypt FILE", "Decrypt FILE", "BRUT FORCE", "EXIT");
    }
}
