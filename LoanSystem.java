
/**
 * This is the main class used for our Loan Item System.
 * It contains a constructor to initialise the array in which all Loan Items are stored,
 * the main methods as well as methods to manipulate the data. 
 * Those include addItem(), insertItem(), findItem(), delete(), printReport()
 * And the methods used to sort the items sort(), doInsert(), swap()
 *
 * 
 * @1.0.0
 */
public class LoanSystem
{
    protected LoanItems[] itemArray; // <1>
    protected int currentSize;
    private int maximumSize;
    
    // Constructor of LoanSystem
    public LoanSystem(int maximumSize, int currentSize) {
        itemArray = new LoanItems[maximumSize]; // <2>
        this.maximumSize = maximumSize;
        this.currentSize = currentSize;
    }
    
    // the main class
    public static void main(String args[]) { 
       LoanSystem is = new LoanSystem(1000, 0);
       LoanSystemTest ist = new LoanSystemTest(is);
       ist.test(is);
    }
    
    // This methods can be used to add a completely new item to the end of the array
    public void addItem(LoanItems item) {
        if (currentSize < maximumSize) { //<1>
            try { //<2>
                itemArray[currentSize] = item; //<3>
                currentSize += 1; //<4>
            } catch (Exception e) { //<5>
                System.out.println("Could not add another item. Something went wrong."); //<6>
            }
        } else {
            System.out.println("You have reached the maximum number of items"); // <7>
        }
    }
    
    // This method is used to insert a new item at a particular point in the array
    public void insert(LoanItems value, int index) {
        if (currentSize < maximumSize) {
            try {                
                for (int i=currentSize-1; i>=index; i=i-1) {
                  itemArray[i+1]=itemArray[i];
                }
                itemArray[index]=value;
                currentSize = currentSize + 1;
             } catch (Exception e) {
                System.out.println("Could not insert the item into the list. Something went wrong.");
            }
        }
    }
    
    public void delete(String toFind) {
        try {
            int indexToDelete = findItem(toFind); // <1>
            deleteItem(indexToDelete); // <2>
        } catch (Exception e) {
            System.out.println("Could not delete item from the list. Something went wrong.");
        }
    }

    // Look up an item based on the title
    public int findItem (String toFind) {
    
        for (int i = 0; i < currentSize; i += 1) {
            String title = itemArray[i].getTitle(); // <1>
            if (toFind == title) {  // <2>
                return i;
            }
        }
    
        return -1;
    }
    
    // Method used to delete an item from the Loan System based on its index
    public void deleteItem(int index) {
        if (index < 0 || index >= currentSize) { // <1>
            System.out.println("Error in delete: index is out of bounds"); // <2>
            return;
        }

        for (int i=index; i<currentSize; i=i+1) { // <3>
            itemArray[i] = itemArray[i+1]; // <4>
        }
        currentSize = currentSize - 1; // <5>
    }
    
    // Methods used to sort items by LibraryID in ascending order
    public void sort() {
        int a = 0; // <1>
        while (a != currentSize) { // <2>
            int t; // <3>
            t = 0; // <4>
            do {
                doInsert(t);     // <5> for task four this method would have to be replaced with the method doInsertForTaskFour()                        
                t = t + 1; // <6>
            }  while (t != currentSize);    // <7>
            a += 1; // <8>
        }
    }
    
    public void doInsert (int top) { // <1>
        for (int i=0; i<top; i=i+1) { // <2>
            int next = i + 1; // <3>
            int nextItem = itemArray[next].getLibraryID(); // <4>
            int current = itemArray[i].getLibraryID(); // <5>
            if (current > nextItem) { // <6>
                swap (i, next); // <7>
            }    
        }
    }

    public void swap (int i1, int i2) {
        LoanItems temp; // <1>
        
        LoanItems one = itemArray[i1]; // <2>
        LoanItems two = itemArray[i2]; // <3>

        temp = one; // <4>
        itemArray[i1] = two; // <5>
        itemArray[i2] = temp; // <6>
    }
    
    public void doInsertForTaskFour(int top) {
        
        for (int i=0; i<top; i=i+1) {
            
            int next = i + 1; // <1>
            int nextItem = itemArray[next].getLibraryID();
            int current = itemArray[i].getLibraryID();
            int date1 = itemArray[i].getDate();
            int date2 = itemArray[next].getDate();
            boolean lent1 = itemArray[i].getLent();
            boolean lent2 = itemArray[next].getLent();
            boolean hasSwapped = false;
            
            if (!lent1 && lent2 || date1 != 0 && date2 != 0 && date2 < date1) { // <2>
                swap (i, next); // <3>
                hasSwapped = true; // <4>
            }
            
            if (!hasSwapped && date1 == date2 && current > nextItem) { // <5>
                swap (i, next); // <6>
            }
        }
    }

    // Method used to print the report
    public String printReport() {
        String report = "\n This is our report: \n"; // <1>
        
        if ( currentSize <= 0) { // <2>
            report = report + "You currently do not hold any items.";
            return report;
        }
        
        for (int i=0; i<currentSize; i=i+1) { // <3>
              
            LoanItems currentItem = itemArray[i]; // <4>
            int id = currentItem.getLibraryID();
            String type = currentItem.getType();
            String title = currentItem.getTitle();
            int date = currentItem.getDate();
            boolean hasBeenLent = currentItem.getLent();
            String lentOut = "yes"; // <5>
          
            if (!hasBeenLent) { // <6>
                lentOut = "no";
            }
          
            report = report + "Item-" + id + ", " + type + ", " + title + ", " + lentOut + ", " + date; // <7>
            if (i+1<currentSize) { // <8>
              report = report + ",\n";
            }
        }    
        
        System.out.println(report); // <9>

        return report; // <10>
    }
}
