package sorter.filetypes;

import sorter.base.BaseSorter;
import sorter.interfaces.IFileType;

@SuppressWarnings("serial")
public class Documents extends BaseSorter implements IFileType {
	String[] documentFileExtensions = {".docx", ".xlsx", ".pdf", ".pptx", ".txt"};
	String DOCUMENTS_FOLDER_NAME = "Documents";

	public static int fileCount;

	/**
	 * This method makes sure which and how many files are Documents
	 * based on their file extension (.docx, .xlsx, .pdf, .pptx)
	 * and moves them to the "Documents" folder.
	 */
	@Override
	public void sort() {
		sortFiles(documentFileExtensions, fileCount, DOCUMENTS_FOLDER_NAME);
	}
}
