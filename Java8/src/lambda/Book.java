package lambda;

public class Book {
	private String title;
	private String authorFName;
	private String authorLName;
	private int pages;
	
	public Book(String title,String fName,String lName,int page) {
		this.title = title;
		this.authorFName = fName;
		this.authorLName = lName;
		this.pages = page;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthorFName() {
		return authorFName;
	}
	public void setAuthorFName(String authorFName) {
		this.authorFName = authorFName;
	}
	public String getAuthorLName() {
		return authorLName;
	}
	public void setAuthorLName(String authorLName) {
		this.authorLName = authorLName;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public String toString() {
		return getTitle() + " Written by : " + getAuthorFName() + " " + getAuthorLName() + "\n" ;
	}
	public boolean equals(Object book1) {
		if( (book1 instanceof Book) && ((Book)book1).getTitle().equals(this.getTitle())){
			return true;
		}
		return false;
	}
}
