package sorter.filetypes;

import sorter.base.BaseSorter;
import sorter.interfaces.IFileType;

@SuppressWarnings("serial")
public class Pictures extends BaseSorter implements IFileType {
	String[] pictureFileExtensions = {".jpg", ".jpeg", ".png", ".gif"};
	String PICTURES_FOLDER_NAME = "Documents";

	public static int fileCount;

	 /**
	  * This method makes sure which and how many files are Pictures
	  * based on their file extension (.jpg, .jpeg, .png, .gif)
	  * and moves them to the "Pictures" folder.
	  */
	@Override
	public void sort() {
		sortFiles(pictureFileExtensions, fileCount, PICTURES_FOLDER_NAME);
	}
}
