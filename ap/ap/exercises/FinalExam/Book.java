package ap.exercises.FinalExam;

public class Book extends Product {
    private String author;
    private String title;
    public Book(String name, int price, String title,String author){
        super(name, price);
        this.title=title;
        this.author=author;
    }
    public String getAuthor(){
        return author;
    }
    public String getTitle(){
        return title;
    }

    public void setAuthor(String author){
        this.author=author;
    }
    public void setTitle(String title){
        this.title=title;
    }

    @Override
    public String toString() {
        return "Books name is "+getName()+" price is "+getPrice()+" title is " + title + " author is " + author;
    }
}
