package Model;

public class Category extends Operation {
	public int amountUsed;
	private String creator;

	// public String _id;
	public Category(String title, int amount, int usedAmount, String creator, String _id) {
		super(title, amount, _id);
		this.amountUsed = usedAmount;
		this.creator = creator;
	}

	@Override
	public String toString() {
		return title+"   |   Amount:"+amount+"   |   Used:"+amountUsed;
	}

	@Override
	public String getTitle() {
		return this.title;
	}

	@Override
	public String getId() {
		return this._id;
	}

	@Override
	public int getAmount() {
		return this.amount;
	}

	@Override
	public void setTitle(String title) {
		this.title = title;

	}

	@Override
	public void setAmount(int amount) {
		this.amount = amount;

	}

	@Override
	public void setId(String _id) {
		this._id = _id;

	}

	public String getCreator() {
		return this.creator;
	}

}
