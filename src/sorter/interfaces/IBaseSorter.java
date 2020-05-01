package sorter.interfaces;

public interface IBaseSorter {
    String BASE_PATH = "/users/melis/"; // TODO: No hardcoding

    void sortFiles(String[] fileExtensions, int fileCounter, String destFolderName);
}
