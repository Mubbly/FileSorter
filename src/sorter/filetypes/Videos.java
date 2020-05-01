package sorter.filetypes;

import sorter.base.BaseSorter;
import sorter.interfaces.IFileType;

@SuppressWarnings("serial")
public class Videos extends BaseSorter implements IFileType {
	String[] videoFileExtensions = {".mp4", ".avi", ".mkv"};
	String VIDEOS_FOLDER_NAME = "Videos";

	public static int fileCount;

	 /**
	  * This method makes sure which and how many files are Videos
	  * based on their file extension (.mp4, .avi, .mkv)
	  * and moves them to the "Videos" folder.
	  */
	@Override
	public void sort() {
		sortFiles(videoFileExtensions, fileCount, VIDEOS_FOLDER_NAME);
	}
}
