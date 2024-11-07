package org.example.cryptoanalyzer;

import javafx.stage.FileChooser;

import java.io.File;
import java.nio.file.Path;

public class OpenFileToRead {

    public static Path pathFileRead;


    public static String openFileRead() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("TXT Files", "*.txt"));
        File file = fileChooser.showOpenDialog(null);
        pathFileRead = Path.of(file.getAbsolutePath());
        return file.getAbsolutePath();
    }

}
