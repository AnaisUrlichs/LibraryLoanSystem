
/**
 * All shared atrributes between the items that are loanable.
 * This interface is implemented by LoanItems.
 * 
 * @1.0.0
 */
public interface LoanAttributes
{
    public void setTitle(String title);
    public String getTitle();
    
    public void setLibraryID(int libraryID);
    public int getLibraryID();
    
    public void setLent(boolean lent);
    public boolean getLent();
    
    public void setDate(int date);
    public int getDate(); 
}
