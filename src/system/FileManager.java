package system;

import java.io.File;

public class FileManager {

    // Open known Windows folders
    public static void openKnownFolder(String folderName) {
        try {
            String userHome = System.getProperty("user.home");
            File folder = new File(userHome, folderName);

            if (folder.exists() && folder.isDirectory()) {
                Runtime.getRuntime().exec("explorer \"" + folder.getAbsolutePath() + "\"");
            } else {
                System.out.println("Folder not found: " + folderName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Open ANY folder given by full path or relative to user home
    public static void openAnyFolder(String folderName) {
        try {
            File folder = new File(folderName);

            if (!folder.exists()) {
                // Try relative to user home
                folder = new File(System.getProperty("user.home"), folderName);
            }

            if (folder.exists() && folder.isDirectory()) {
                Runtime.getRuntime().exec("explorer \"" + folder.getAbsolutePath() + "\"");
            } else {
                System.out.println("Folder not found: " + folderName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
