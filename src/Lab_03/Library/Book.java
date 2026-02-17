package Library;


public class Book {
    private String bookID;
    private String title;
    private String author;
    private char status;

    public Book(String bookID, String title, String author) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.status = 'A';
    }

    public String getBookID(){
        return bookID;
    }
    public char getStatus(){
        return status;

    }
    public String getTitle() {
        return title;
    }

    public void updateStatus() {
        if (status == 'A') {
            status = 'U';
        } else {
            status = 'A';
        }
    }

    public String checkStatus(){
        if (status == 'A') {
            return "Available";
        } else {
            return "Unavailable";
        }
    }

    public String toString(){
        return "ID : " + bookID +
                " Title : " + title +
                " Author : " + author +
                " Status : " + checkStatus();
    }
}

