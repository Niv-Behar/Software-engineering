
public class Expense extends Operation {
	
	private String creator;
	private String _id;
	private String categoryId;
	
	public Expense(String title,int amount,String creator,String _id,String categoryId) {
		super(title,amount);
		this.creator=creator;
		this._id=_id;
		this.categoryId=categoryId;
	}
	public String getCreator() {
		return creator;
	}
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
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
}
