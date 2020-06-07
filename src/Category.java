
public class Category extends Operation{
	    public int amountUsed;
	    private String creator;
	  //  public String _id;
	    public Category(String title, int amount, int usedAmount, String creator,String _id) {
	    	super(title,amount,_id);
	        this.amountUsed = usedAmount;
	        this.creator = creator;
	    }
		@Override
		public String toString() {
			return "Category [title=" + title + ", amount=" + amount + ", amountUsed=" + amountUsed + "]";
		}
		@Override
		String getTitle() {
			return this.title;
		}
		@Override
		String getId() {
			return this._id;
		}
		@Override
		int getAmount() {
			return this.amount;
		}
		@Override
		void setTitle(String title) {
			this.title=title;
			
		}
		@Override
		void setAmount(int amount) {
			this.amount=amount;
			
		}
		@Override
		void setId(String _id) {
			this._id=_id;
			
		}
		
		String getCreator() {
			return this.creator;
		}
		

}
