package Controller;

import javax.swing.JPanel;

public class UtilitiesController {
	
	public static void swapPages(JPanel currentPanel,JPanel nextPanel) {
		currentPanel.setVisible(false);
		nextPanel.setVisible(true);
		
	}

}
