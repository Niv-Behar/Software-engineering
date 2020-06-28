package View;

import java.awt.TextArea;
import java.util.Observable;
import java.util.Observer;

public class ExpenseObserver implements Observer{
	
	private TextArea textArea;
	
	public ExpenseObserver(TextArea textArea) {
		this.textArea=textArea;
	}
	
	public void update(Observable obs, Object obj) {
		this.textArea.setText((String) obj);
		
	}

}
