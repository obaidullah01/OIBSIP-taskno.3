import java.util.ArrayList;
import java.util.List;

public class LibraryDatabase {
    private List<Book> books;
    private List<Member> members;

    public LibraryDatabase() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public Book findBookById(String bookId) {
        for (Book book : books) {
            if (book.getBookId().equals(bookId)) {
                return book;
            }
        }
        return null;
    }

    public Member findMemberById(String memberId) {
        for (Member member : members) {
            if (member.getMemberId().equals(memberId)) {
                return member;
            }
        }
        return null;
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public List<Member> getAllMembers() {
        return members;
    }

    public void updateBook(Book updatedBook) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getBookId().equals(updatedBook.getBookId())) {
                books.set(i, updatedBook);
                break;
            }
        }
    }

    public void deleteBook(String bookId) {
        books.removeIf(book -> book.getBookId().equals(bookId));
    }

    public void updateMember(Member updatedMember) {
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getMemberId().equals(updatedMember.getMemberId())) {
                members.set(i, updatedMember);
                break;
            }
        }
    }

    public void deleteMember(String memberId) {
        members.removeIf(member -> member.getMemberId().equals(memberId));
    }


}
