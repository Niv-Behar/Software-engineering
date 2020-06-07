
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
	String getTitle() {
		return this.title;
	}

	@Override
	int getAmount() {
		return this.amount;
	}

	@Override
	void setTitle(String title) {
		this.title = title;

	}

	@Override
	void setAmount(int amount) {
		this.amount = amount;

	}

}
