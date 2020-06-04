
public class Category {
	   public String title;
	    public int amount;
	    public int amountUsed;
	    public String creator;
	    public String _id;
	    public Category(String title, int amount, int usedAmount, String creator,String _id) {
	        this.title = title;
	        this.amount = amount;
	        this.amountUsed = usedAmount;
	        this.creator = creator;
	        this._id=_id;
	    }
}
