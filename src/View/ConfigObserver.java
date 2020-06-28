package View;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;

import Model.CategoryService;
import Model.ConfigService;

public class ConfigObserver implements Observer {
	//
	private ConfigService configService=ConfigService.getInstance();
	private CategoryService categoryService=CategoryService.getInstance();
	//
	private JLabel userMonthlyRevenue;
	private JLabel userWantedSave;
	private JLabel totalSaved;
    private JLabel userTotalSpendMonthly;
    private JLabel userLeftToSpend;
    
	public ConfigObserver(JLabel revenue, JLabel wantedSave,JLabel totalSaved,JLabel userTotalSpendMonthly,JLabel userLeftToSpend) {
		this.userMonthlyRevenue = revenue;
		this.userWantedSave = wantedSave;
		this.totalSaved=totalSaved;
		this.userTotalSpendMonthly=userTotalSpendMonthly;
		this.userLeftToSpend=userLeftToSpend;
	}

	public void update(Observable obs, Object obj) {
		this.userMonthlyRevenue.setText("Monthly Revenue: "+configService.getMonthlyRevenue());
		this.userWantedSave.setText("Monthly Saving Goal: "+configService.getWantedSaveValue());
		this.totalSaved.setText("Money Saved So Far: "+configService.getTotalSaved());
		int totalSpent=categoryService.spentThisMonth();
		this.userTotalSpendMonthly.setText("Total Spent This Month: "+totalSpent);
		this.userLeftToSpend.setText("Monthly Budget Left: "+(configService.getMonthlyRevenue()-configService.getWantedSaveValue()-totalSpent));
		if(totalSpent>configService.getMonthlyRevenue()-configService.getWantedSaveValue()) {
			this.userWantedSave.setForeground(Color.RED);
			this.userTotalSpendMonthly.setForeground(Color.RED);
			this.userLeftToSpend.setForeground(Color.RED);
		}else {
			this.userWantedSave.setForeground(Color.GREEN);
			this.userTotalSpendMonthly.setForeground(Color.GREEN);
			this.userLeftToSpend.setForeground(Color.GREEN);
		}
		this.totalSaved.setForeground(configService.getTotalSaved()>0?Color.GREEN:Color.RED);
	}
}
