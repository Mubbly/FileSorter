package sorter.base;

import sorter.Main;
import sorter.interfaces.IBaseSorter;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;

public class BaseSorter extends Main implements IBaseSorter {

    @Override
    public void sortFiles(String[] fileExtensions, int fileCounter, String destFolderName) {
        File selectedFolder = chooser.getSelectedFile();
        File dest = new File(BASE_PATH);
        // Look through all files in selected folder
        for(File file: Objects.requireNonNull(selectedFolder.listFiles())) {
            String fileName = file.getName();
            if (doesFileHaveExtension(fileName, fileExtensions)) {
                // Counts how many document files there are and converts the number into string
                fileCounter++;
                // Create destination directory if it does not exist
                createFolder(dest, destFolderName);
                // Move selected file
                moveFile(file, selectedFolder, dest, destFolderName);
            }
        }
    }

    private boolean doesFileHaveExtension(String fileName, String[] fileExtensions) {
        return Arrays.stream(fileExtensions).anyMatch(fileName.toLowerCase()::endsWith);
    }

    private void createFolder(File baseFolder, String newFolderName) {
        File destFolder = new File(baseFolder + "/" + newFolderName + "/");
        if (!destFolder.exists()) {
            destFolder.mkdir();
        }
    }

    private void moveFile(File selectedFile, File sourceFolder, File baseFolder, String destFolderName) {
        String initialFilePath = sourceFolder + "/" + selectedFile.getName();
        String newFilePath = baseFolder + destFolderName + selectedFile.getName();
        File targetFile = new File(initialFilePath);
        targetFile.renameTo(new File(newFilePath));
    }
}
