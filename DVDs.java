
/**
 * Class DVDs that inherits the methods from the abstract class LoanItems
 * DVDs is a child of LoanItems
 *
 * 
 * @1.0.0
 */
public class DVDs extends LoanItems
{
    private String publisher;
    private String type = "DVDs";
    
    public DVDs(String publisher, String title, int libraryID, boolean lent, int date) {
        super(title, libraryID, lent, date);
        this.publisher = publisher;
        setSuperType();
    }
    
    public void setSuperType(){
        super.setType(this.type);
    }
    
    public void setPublisher(String newPublisher){
        this.publisher = newPublisher;
    }
    
    public String getName(){
        return this.publisher;  
    }  
}
