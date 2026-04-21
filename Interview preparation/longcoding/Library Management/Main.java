import java.util.*;
class Book{
    private int bookId;
    private String title;
    private String author;
    static int totalBooks=0;
    Book(int bookId,String title,String author){
        this.bookId=bookId;
        this.title=title;
        this.author=author;
        totalBooks++;
    }
    void displayBook(){
        System.out.println("Book Id: "+getbookId());
        System.out.println("Title: "+getTitle());
        System.out.println("Author: "+getauthor());
        
    }
    public int getbookId(){
        return bookId;
    }
    public String getTitle(){
        return title;
    }
    public String getauthor(){
        return author;
    }
   
}
class Member{
    static int totalMembers=0;
    private int memberId;
    private String memberName;
    Member(int memberId,String memberName){
        this.memberId=memberId;
        this.memberName=memberName;
        totalMembers++;

    }
    void displayMember(){
        System.out.println("Member Id: "+getMemberId());
        System.out.println("Member Name: "+getMemberName());
        
    }
    public int getMemberId(){
        return memberId;
    }
    public String getMemberName(){
        return memberName;
    }
    public void setMemberId(int memberId){
        this.memberId=memberId;
    }
    public void setMemberName(String memberName){
        this.memberName=memberName;
    }

}

class Library{
    final int LibarayCode;
    static int totalLibrary=0;
    String libraryName;
    Book book;
    Member member;
    ArrayList<Book> books;
    ArrayList<Member> members;
    Library(String libraryName,int LibarayCode){
        this.libraryName=libraryName;
        this.LibarayCode=LibarayCode;
        books=new ArrayList<>();
        members=new ArrayList<>();
        totalLibrary++;
    }
    void addBook(Book b){
        books.add(b);
    }
    void addMember(Member m){
        members.add(m);
    }
    
    void displayLibraryDetails(){
        System.out.println("Library Name:"+libraryName);
        System.out.println("Books in the Library");
        for(Book b : books){
            b.displayBook();
        }
        System.out.println("Members in the Library:");
        for(Member m : members){
            m.displayMember();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Library library=new Library("City Library",101);
        Library library2=new Library("Town Library",102);
        Book book1=new Book(1,"The Great Gatsby","F. Scott Fitzgerald");
        Book book2=new Book(2,"To Kill a Mockingbird","Harper Lee");
        library.addBook(book1);
        library.addBook(book2);
        Member member1=new Member(1,"Alice");
        Member member2=new Member(2,"Bob");
        member1.setMemberName("Alice Smith");
        library.addMember(member1);
        library.addMember(member2);
        
        library.displayLibraryDetails();
        System.out.println("Total Books: "+Book.totalBooks);
        System.out.println("Total Members: "+Member.totalMembers);
        System.out.println("Total Libraries: "+Library.totalLibrary);
    }
}