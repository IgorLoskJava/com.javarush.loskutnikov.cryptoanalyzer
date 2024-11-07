package org.example.cryptoanalyzer;

public class KeyValidate {
    private static int keyValidate;

    public static int getKeyValidate() {
        return keyValidate;
    }

    public static void setKeyValidate(int keyValidate) {
        KeyValidate.keyValidate = keyValidate;
    }

    public static int keyValidate(String keyText) {
        int correctKey = Integer.parseInt(keyText);
        if (correctKey >= 0 && correctKey <= 20) {
            keyValidate = correctKey;
            return keyValidate;
        }

        return 0;
    }

}


