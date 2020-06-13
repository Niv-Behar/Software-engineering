package View;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;

public class ConfigObserver implements Observer {
	private JLabel userMonthlyRevenue;
	private JLabel userWantedSave;

	public ConfigObserver(JLabel revenue, JLabel wantedSave) {
		this.userMonthlyRevenue = revenue;
		this.userWantedSave = wantedSave;
	}

	public void update(Observable obs, Object obj) {
		this.userMonthlyRevenue.setText("Monthly Revenue: ");
		this.userWantedSave.setText("This Month's Goal: ");
	}
}
