package Model;

public abstract class Operation {
	protected String title;
	protected int amount;
	protected String _id;

	public Operation(String title, int amount, String _id) {
		this.title = title;
		this.amount = amount;
		this._id = _id;
	}

	abstract String getTitle();

	abstract String getId();

	abstract int getAmount();

	abstract void setTitle(String title);

	abstract void setAmount(int amount);

	abstract void setId(String _id);
}
