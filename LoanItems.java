
/**
 * The LoanItems class is the parent class to the specific LoanItems (CDs, Books, Magazines, DVDs)
 *
 *
 * @1.0.0
 */
abstract class LoanItems implements LoanAttributes
{
    private String type; // <1>
    private String title;
    private int libraryID;
    private boolean lent;
    private int date;
    
    // Constructor of class LoanItems
    public LoanItems(String title, int libraryID, boolean lent, int date) { // <2>
        this.title = title;
        this.libraryID = libraryID;
        this.lent = lent;
        this.date = date;
    }
    
    abstract String getName(); // <3>

    public void setType(String newType)
    {
        this.type = newType;
    }
    
    public String getType()
    {
        return this.type;
    }
    
    public void setTitle(String newTitle)
    {
        this.title = newTitle;
    }
    
    public String getTitle()
    {
        return this.title;
    }
    
    public void setLibraryID(int newLibraryID)
    {
        this.libraryID = newLibraryID;
    }
    
    public int getLibraryID()
    {
       return this.libraryID; 
    }
    
    public void setLent(boolean newLent)
    {
        this.lent = newLent;
    }
    
    public boolean getLent()
    {
        return this.lent;
    }
    
    public void setDate(int newDate)
    {
        this.date = newDate;
    }
    
    public int getDate()
    {
        return this.date;
    }
}
