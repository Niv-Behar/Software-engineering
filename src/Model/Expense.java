package Model;

public class Expense extends Operation {

	private String creator;
	private String categoryId;

	public Expense(String title, int amount, String creator, String _id, String categoryId) {
		super(title, amount, _id);
		this.creator = creator;
		this.categoryId = categoryId;
	}

	public String getCreator() {
		return creator;
	}

	@Override
	public String getId() {
		return _id;
	}

	@Override
	public void setId(String _id) {
		this._id = _id;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String getTitle() {
		return this.title;
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
	public String toString() {
		return this.title+" "+this.amount;
	}

}
