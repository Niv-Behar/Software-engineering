package View;

import java.awt.TextArea;
import java.util.Observable;
import java.util.Observer;

public class CategoryObserver implements Observer {
    
	private TextArea previewArea;
	
	
	public CategoryObserver(TextArea previewArea) {
		this.previewArea=previewArea;
	}
	
	
	
	public void update(Observable obs, Object obj) {
		
		
		this.previewArea.setText((String) obj);

	}

}
