
public class Expense extends Operation {
	
	private String creator;
	private String _id;
	
	public Expense(String title,int amount,String creator,String _id) {
		super(title,amount);
		this.creator=creator;
		this._id=_id;
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
     
}
