import LibraryManagement.Book;
import LibraryManagement.Member;
public class LibrarySystem {
    public static void main(String[] args) {
        Book book1 = new Book("Java Programming", "James Gosling", "12345");
        Member member1 = new Member("Tanvi Kodoli", 146);
        System.out.println("---- Library Details ----");
        book1.displayBook();
        System.out.println();
        member1.displayMember();
    }
}