
public class Category extends Operation{
	    public int amountUsed;
	    public String creator;
	    public String _id;
	    public Category(String title, int amount, int usedAmount, String creator,String _id) {
	    	super(title,amount);
	        this.amountUsed = usedAmount;
	        this.creator = creator;
	        this._id=_id;
	    }
		@Override
		public String toString() {
			return "Category [title=" + title + ", amount=" + amount + ", amountUsed=" + amountUsed + "]";
		}
	    
}
