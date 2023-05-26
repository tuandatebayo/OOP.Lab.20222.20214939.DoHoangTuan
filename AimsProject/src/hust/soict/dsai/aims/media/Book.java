package hust.soict.dsai.aims.media;
import java.util.ArrayList;
import java.util.List;
public class Book extends Media {
	
	public Book(String title, String category, float cost) {
		super(title, category, cost);
	
	}

	private List<String> authors = new ArrayList<String>();
	
	public List<String> getAuthors() {
		return authors;
	}


	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}

	
	public void addAuthor(String authorName) {
		if (authors.contains(authorName)){
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
	
}
