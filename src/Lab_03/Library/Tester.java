package Library;


import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        Book[] books = new Book[5];

        books[0] = new Book("100", "Programming", "John");
        books[1] = new Book("200", "Object-Oriented Programming", "May");
        books[2] = new Book("300", "Graphic", "Marry");
        books[3] = new Book("400", "Statistics", "Martin");
        books[4] = new Book("500", "Database", "John");

        Library lib = new Library(books);

        lib.showAllBook();

        while (true) {
            System.out.println("\n<=== Enter the number what do you want to do ===>");
            System.out.println("1. Borrow a book.");
            System.out.println("2. Return a book.");
            System.out.println("3. Search a book.");
            System.out.println("q. Quit the system.");
            System.out.print("Select = ");

            String select = kb.nextLine();

            if (select.equals("q"))
                break;

            switch (select) {
                case "1":
                    System.out.print("Enter book ID or title: ");
                    lib.borrowBook(kb.nextLine());
                    break;

                case "2":
                    System.out.print("Enter book ID or title: ");
                    lib.returnBook(kb.nextLine());
                    break;

                case "3":
                    System.out.print("Enter book ID or title: ");
                    String want = kb.nextLine();
                    int idx = lib.searchBook(want);
                    if (idx == -1)
                        System.out.println("Book not found.");
                    else
                        System.out.println(books[idx]);
                    break;

                default:
                    System.out.println("Invalid menu.");
            }
        }

        kb.close();
    }
}
