package org.example.cryptoanalyzer;

import javafx.stage.FileChooser;

import java.io.File;
import java.nio.file.Path;

public class OpenFileToWrite {

    public static Path pathFileWrite;


    public static String openFileWrite() {
        FileChooser fileChooser = new FileChooser();
        //fileChooser.setInitialDirectory(new File(System.getProperty("user.home") + "/Desktop"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text file", "*.txt"));
        fileChooser.setInitialFileName("Untitled");
        File selectedFile = fileChooser.showSaveDialog(null);
        pathFileWrite = Path.of(selectedFile.getAbsolutePath());

        return selectedFile.getAbsolutePath();

    }
}
