package View;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;

import Model.ConfigService;

public class ConfigObserver implements Observer {
	//
	private ConfigService configService=ConfigService.getInstance();
	//
	private JLabel userMonthlyRevenue;
	private JLabel userWantedSave;
	private JLabel totalSaved;

	public ConfigObserver(JLabel revenue, JLabel wantedSave,JLabel totalSaved) {
		this.userMonthlyRevenue = revenue;
		this.userWantedSave = wantedSave;
		this.totalSaved=totalSaved;
	}

	public void update(Observable obs, Object obj) {
		this.userMonthlyRevenue.setText("Monthly Revenue: "+configService.getMonthlyRevenue());
		this.userWantedSave.setText("This Month's Goal: "+configService.getWantedSaveValue());
		this.totalSaved.setText("Money Saved So Far: "+configService.getTotalSaved());
	}
}
