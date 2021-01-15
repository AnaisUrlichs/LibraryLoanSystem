
/**
 * Class CDs that inherits the methods from the abstract class LoanItems
 * CDs is a child of LoanItems
 *
 * 
 * @1.0.0
 */
public class CDs extends LoanItems
{
    private String author;
    private String type = "CD";
    
    public CDs(String author, String title, int libraryID, boolean lent, int date) {
        super(title, libraryID, lent, date);
        this.author = author;
        setSuperType();
    }
    
    public void setSuperType(){
        super.setType(this.type);
    }
    
    public void setAuthor(String newAuthor){
        this.author = author;
    }
    
    public String getName(){
        return this.author; 
    }
}
