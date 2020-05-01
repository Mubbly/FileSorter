package sorter.filetypes;

import sorter.base.BaseSorter;
import sorter.interfaces.IFileType;

@SuppressWarnings("serial")
public class Music extends BaseSorter implements IFileType {
	String[] musicFileExtensions = {".mp3", ".flac", ".wav"};
	String MUSIC_FOLDER_NAME = "Music";

	public static int fileCount;

	 /**
	  * This method makes sure which and how many files are Music
	  * based on their file extension (.mp3, .flac, .wav)
	  * and moves them to the "Music" folder.
	  */
	@Override
	public void sort() {
		sortFiles(musicFileExtensions, fileCount, MUSIC_FOLDER_NAME);
	}
}
