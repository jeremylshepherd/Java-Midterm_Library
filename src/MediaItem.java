
public class MediaItem {
	
	private String title, format, borrower, dateLoaned;
	private boolean onLoan;
	
	public MediaItem() {
		title = null;
		format = null;
		borrower = null;
		dateLoaned = null;
		onLoan = false;
	}
	
	public MediaItem(String title, String format) {
		this.title = title;
		this.format = format;
		System.out.println("Item added");
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setFormat(String format) {
		this.format = format;
	}
	
	public void setBorrower(String person) {
		this.borrower = person;
	}
	
	public void setDateLoaned(String dateLoaned) {
		this.dateLoaned = dateLoaned;
	}
	
	public void setOnLoan(boolean condition) {
		this.onLoan = condition;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getFormat() {
		return format;
	}
	
	public String getBorrower() {
		return borrower;
	}
	
	public String getDateLoaned() {
		return dateLoaned;
	}
	
	public boolean getOnLoan() {
		return onLoan;
	}
	
	public void markOnLoan(String name, String date) {
		if(this.onLoan) {
			System.out.println("Error: " + this.title + " is already on loan to " + this.borrower);
		} else {
			this.borrower = name;
			this.dateLoaned = date;
			this.onLoan = true;
			System.out.println("Loan recorded");
		}
	}
	
	public void markReturned() {
		if(!this.onLoan) {
			System.out.println("Error: " + this.title + " is not currently on loan");
		} else {
			this.borrower = null;
			this.dateLoaned = null;
			this.onLoan = false;
			System.out.println("Loan returned");
		}
	}

}
 