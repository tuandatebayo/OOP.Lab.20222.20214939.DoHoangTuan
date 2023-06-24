package hust.soict.dsai.aims.media;
import java.util.ArrayList;
import java.util.List;
public class Book extends Media {
	
	public Book(int id, String title, String category, float cost) {
		super(id, title, category, cost);
	
	}
	public Book(int id, String title, String category, float cost, List<String> authors) {
		super(id, title, category, cost);
		this.authors = authors;
	}
	public Book(int id, String title, String category, List<String> authors, float cost) {
		super(id, title, category, cost);
		this.authors = authors;
	}
	private List<String> authors = new ArrayList<String>();
	
	public List<String> getAuthors() {
		return authors;
	}


	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}

	
	public void addAuthor(String authorName) {
		if (!authors.contains(authorName)){
			authors.add(authorName);
			System.out.println("The author has been added.");
		}
		else {
			System.out.println("The author has already existed.");
		}
		
	}
	
	public void removeAuthor(String authorName) {
		if (authors.contains(authorName)){
			authors.remove(authorName);
			System.out.println("The author has been removed.");
		}
		else {
			System.out.println("The author has not existed.");
		}
	}
	
	public String toString() {
	    return this.getId()+ " - " + this.getTitle() + " - " + this.getCategory() + ": " + this.getCost() +"$";
	}
}
