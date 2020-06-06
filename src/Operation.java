
public abstract class Operation {
	protected String title;
	protected int amount;
	
	
	public Operation(String title,int amount) {
	   this.title=title;
	   this.amount=amount;
	}

	public final String getTitle() {
		return title;
	}

	public final int getAmount() {
		return amount;
	}
	
	public final void setTitle(String title) {
		this.title = title;
	}
	public final void setAmount(int amount) {
		this.amount = amount;
	}
}
