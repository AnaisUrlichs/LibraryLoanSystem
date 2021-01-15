
/**
 * Class Books that inherits the methods from the abstract class LoanItems
 * Books is a child of LoanItems
 *
 * 
 * @1.0.0
 */
public class Books extends LoanItems
{
    private String author;
    private String type = "Book";
    
    public Books(String author, String title, int libraryID, boolean lent, int date) {
        super(title, libraryID, lent, date); // <1>
        this.author = author;
        setSuperType(); 
    }
    
    public void setSuperType() { // <2>
        super.setType(this.type);
    }
    
    public void setAuthor(String newAuthor) {
        this.author = author;
    }
    
    public String getName() { // <3>
        return this.author; 
    }
}
