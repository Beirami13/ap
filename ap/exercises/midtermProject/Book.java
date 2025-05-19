package ap.exercises.midtermProject;

public class Book {
    private String title;
    private String author;
    private int year;
    private int pages;
    public Book(String title,String author, int year, int pages){
        this.title=title;
        this.author=author;
        this.year=year;
        this.pages=pages;
    }
    public String getTitle(){

        return title;
    }
    public String getAuthor(){

        return author;
    }
    public int getYear(){

        return year;
    }
    public int getPages(){

        return pages;
    }
    @Override
    public String toString() {
        return "Book " + title + " from " + author + " written in " + year + " in " + pages + " pages.";
    }
}
