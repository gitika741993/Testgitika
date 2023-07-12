package pojo;

public class PostAPIPojo {

	private String id;
	private String title;
	private String author;
	
	
	public PostAPIPojo(String randomNumber, String randomString, String randomString2) {
		// TODO Auto-generated constructor stub
		this.id = randomNumber;
		this.title= randomString;
		this.author= randomString2;
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@Override
	public String toString() {
		return "PostAPIPojo [id=" + id + ", title=" + title + ", author=" + author + "]";
	}
	
	
	
	
	
}
