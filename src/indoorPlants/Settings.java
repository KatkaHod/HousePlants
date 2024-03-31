package indoorPlants;

public class Settings {
    private static final String FILENAME = "resources/kvetiny.txt";
    private static final String FILENAME_OUT = "resources/kvetinyOutput.txt";
    private static final String DELIMITER = "\t";

    public static String getFileName() {
        return FILENAME;
    }

    public static String getFileNameOut() {
        return FILENAME_OUT;
    }

    public static String getDelimiter() {
        return DELIMITER;
    }
}
