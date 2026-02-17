package Library;

public class Library {
    private Book[] book;

    public Library(Book[] books) {
        this.book = books;
    }

    //หาชื่อ
    public int searchBook(String wantB) {
        for (int i = 0; i < book.length; i++) {
            if (book[i] != null) {
                if (String.valueOf(book[i].getBookID()).equals(wantB))
                    return i;

                if (book[i].getTitle().equalsIgnoreCase(wantB))
                    return i;
            }
        }
        return -1;
    }

    //ยืม
    public void borrowBook(String wantB) {
        int index = searchBook(wantB);

        if (index == -1) {
            System.out.println("Book not found.");
            return;
        }

        if (book[index].getStatus() == 'A') {
            System.out.println("This book can borrow.");
            book[index].updateStatus();
        } else {
            System.out.println("This book is borrowing. Sorry!");
        }
    }

    //คืน
    public void returnBook(String wantB) {
        int index = searchBook(wantB);

        if (index == -1) {
            System.out.println("Book not found.");
            return;
        }

        if (book[index].getStatus() == 'A') {
            System.out.println("This book is not borrowed. Re-input again!");
        } else {
            book[index].updateStatus();
            System.out.println("Thank you, the return successful.");
        }
    }
    //แสดงหนังสือทั้งหมด
    public void showAllBook() {
        for (Book b : book) {
            if (b != null)
                System.out.println(b);


        }
    }
}
