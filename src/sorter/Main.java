package sorter;

import sorter.filetypes.Documents;
import sorter.filetypes.Music;
import sorter.filetypes.Pictures;
import sorter.filetypes.Videos;

import javax.swing.*;

import java.awt.event.*;
import java.awt.*;

/**
* FileSorter is an application that lets an user choose a folder to sort
 * and then moves files to another locations based on their file extensions.
*
* @author  Melissa Eenmaa
* @version 1.2
* @since   2020-04-04
*/
@SuppressWarnings("serial")
public class Main extends JPanel implements ActionListener {
		String APP_NAME = "FileSorter";
		String DESCRIPTION_LABEL = "This program sorts all picture, music, video and document files within the folder you select.";
		String BROWSE_BUTTON_LABEL = "Browse";
		String SORT_BUTTON_LABEL = "Sort";

		public static JFileChooser chooser;
		JButton browseButton;
		JButton sortButton;
		JFrame frame;

		public Main() {
			JLabel descriptionLabel = new JLabel(DESCRIPTION_LABEL);
			add(descriptionLabel);

			browseButton = new JButton(BROWSE_BUTTON_LABEL);
			browseButton.addActionListener(this);
			add(browseButton);

			sortButton = new JButton(SORT_BUTTON_LABEL);
			sortButton.addActionListener(this);
			add(sortButton);
		}

	/**
	   * This is the main method which creates a window for the user
	   * to interact with the program.
	   *
	   * The window has two buttons so that the user
	   * can choose a folder to sort and then start the file sorting.
	   */
		public static void main(String[] args) {
			Main mainPanel = new Main();
			mainPanel.createWindow(mainPanel);
		}

		public void createWindow(Main mainPanel) {
			frame = new JFrame(APP_NAME);
			frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			frame.getContentPane().add(mainPanel,"Center");
			frame.setSize(new Dimension(700, 150));
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
		}

		/**
		 * This method is used to give the buttons an action to perform after the user has clicked on them.
		 */
		public void actionPerformed(ActionEvent event) {
			Object eventSource = event.getSource();
			if (browseButton.equals(eventSource)) {
				handleBrowseButton();
			} else if (sortButton.equals(eventSource)) {
				handleSortButton();
			}
		}

		private void handleBrowseButton() {
			String CHOOSER_TITLE = "Select a folder to sort";

			chooser = new JFileChooser();
			chooser.setDialogTitle(CHOOSER_TITLE);
			chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			// After clicking 'open' on browsing window
			displaySelectedFileName(chooser);
		}

		private void handleSortButton() {
			String MESSAGE_TYPE_ERROR = "Error";
			String ERROR_NO_FOLDER_SELECTED = "Select a folder first!";

			try {
				sortAllFileTypes();
				displaySortedFileCounts();

			} catch (NullPointerException n) {
				JOptionPane.showMessageDialog(frame,
						ERROR_NO_FOLDER_SELECTED,
						MESSAGE_TYPE_ERROR,
						JOptionPane.WARNING_MESSAGE);
			}
		}

		private void displaySelectedFileName(JFileChooser chooser) {
			String FOLDER_SELECTED_LABEL = "Selected folder: ";
			String FOLDER_NOT_SELECTED_LABEL = "Folder not chosen";
			String SORT_BUTTON_HINT = ". NB: Click 'Sort' to start sorting";

			JLabel label;
			if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
				label = new JLabel(FOLDER_SELECTED_LABEL +  chooser.getSelectedFile() + SORT_BUTTON_HINT);
			} else {
				label = new JLabel(FOLDER_NOT_SELECTED_LABEL);
			}
			add(label);
		}

		private void sortAllFileTypes() {
			new Music().sort();
			new Pictures().sort();
			new Documents().sort();
			new Videos().sort();
		}

		/** Dialog window that says how many files were moved */
		private void displaySortedFileCounts() {
			String MOVED_LABEL = "Moved ";
			String MUSIC_FILES_LABEL = " music files";
			String PICTURE_FILES_LABEL = " picture files";
			String DOCUMENT_FILES_LABEL = " document files";
			String VIDEO_FILES_LABEL = " video files";

			String documentCountAsLabel = Integer.toString(Documents.fileCount);
			String musicCountAsLabel = Integer.toString(Music.fileCount);
			String pictureCountAsLabel = Integer.toString(Pictures.fileCount);
			String videoCountAsLabel = Integer.toString(Videos.fileCount);

			JOptionPane.showMessageDialog(frame,MOVED_LABEL + musicCountAsLabel + MUSIC_FILES_LABEL + "\n"
					+ MOVED_LABEL + pictureCountAsLabel + PICTURE_FILES_LABEL + "\n"
					+ MOVED_LABEL + documentCountAsLabel + DOCUMENT_FILES_LABEL + "\n"
					+ MOVED_LABEL + videoCountAsLabel + VIDEO_FILES_LABEL
			);
		}
}
