package ap.exercises.midtermProject;

public class Book {
    private String title;
    private String author;
    private int year;
    private int pages;
    private String info;
    public Book(String title,String author, int year, int pages, String info){
        this.title=title;
        this.author=author;
        this.year=year;
        this.pages=pages;
        this.info=info;
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
    public String getInfo(){

        return info;
    }
    public void setInfo(String info){
        this.info=info;
    }
    @Override
    public String toString(){
        return "Book "+title+" from "+author+" written in "+year+" in "+pages+" pages"+info;
    }
}
