
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * The test class LoanSystemTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class LoanSystemTest
{
    /**
     * Default constructor for test class LoanSystemTest
     */
    
    public LoanSystemTest(LoanSystem is) {
        LoanItems b1 = new Books("J. R. R. Tolkien", "The Hobbit", 1, false, 0);
        is.addItem(b1);
        LoanItems b2 = new Books("F. Scott Fitzgerald", "The Great Gatsby", 3, true, 210215);
        is.addItem(b2);
        LoanItems b3 = new Books("John Steinbeck", "The Grapes of Wrath", 2, true, 210215);
        is.addItem(b3);
        LoanItems b4 = new Books("George Orwell", "Nineteen Eighty-Four", 5, false, 0);
        is.addItem(b4);
        LoanItems b5 = new Books("Harper Lee", "To Kill a Mockingbird", 6, true, 210215);
        is.addItem(b5);
        
        LoanItems c1 = new CDs("Somebody", "Greatest Hits", 4, true, 210215);
        is.addItem(c1);
        LoanItems c2 = new CDs("ABBA", "Waterloo", 8, true, 210215);
        is.addItem(c2);
        LoanItems c3 = new CDs("Beethoven", "Complete Works", 10, false, 0);
        is.addItem(c3);
        LoanItems c4 = new CDs("Ludovico Einaudi", "Greatest Hits", 9, true, 210215);
        is.addItem(c4);
        LoanItems c5 = new CDs("P!nk", "Beautiful Trauma", 7, true, 210215);
        is.addItem(c5);
        
        LoanItems d1 = new DVDs("Johnson", "Pride and Prejudice", 11, true, 210210);
        is.addItem(d1);
        LoanItems d2 = new DVDs("Christopher Nolan", "Interstellar", 12, false, 0);
        is.addItem(d2);
        LoanItems d3 = new DVDs("Saul Dibb", "The Duchess", 13, true, 220110);
        is.addItem(d3);
        LoanItems d4 = new DVDs("Multiple", "The Avengers", 16, true, 210415);
        is.addItem(d4);
        LoanItems d5 = new DVDs("Ryan Fleck", "Captain Marvel", 14, true, 210215);
        is.addItem(d5);
        
        LoanItems m1 = new Magazines("Pole Star Publications Ltd", "Astronomy Now", 15, true, 210210);
        is.addItem(m1);
        LoanItems m2 = new Magazines("Sigma Xi", "American Scientist", 19, true, 210215);
        is.addItem(m2);
        LoanItems m3 = new Magazines("Gail MacCallum and Ian Connellan", "Cosmos", 18, true, 210201);
        is.addItem(m3);
        LoanItems m4 = new Magazines("Bonnie Dwyer", "Spectrum", 17, true, 210505);
        is.addItem(m4);
        LoanItems m5 = new Magazines("Elsevier", "Plant Science", 20, true, 210215);
        is.addItem(m5);      
    }
    
    // ensure that all items have been added to the array
    public void testSize(LoanSystem is) {
        int actualLength = is.currentSize; // holds the current size of the array 
        int expectedSize = 20;
        
        // these assertations will not work for task four. The assertion makes sure that 
        //the expected size of the array and its actual size is the same
        assertEquals( expectedSize, actualLength );
        
        // provides a "report" for the developer
        System.out.println("\n Test 1: The expected size of the array is " + expectedSize + " and the actual size is " + actualLength); 
    }
    
    public void testSort(LoanSystem is) { 
        is.sort(); // call the sort() method in the instance of the LoanSystem class
        LoanItems li = is.itemArray[4]; // access the fifth item of the array 
        
        // after sorting the array by libraryID, access the libraryID of the fifth item
        int libraryIDOfFirthItem = li.getLibraryID();
        int expectedID = 5;
        
        // these assertations will not work for task four. This assertation is responsible for testing that the array of dummy data has been sorted.
        assertEquals( expectedID, libraryIDOfFirthItem ); 
        System.out.println("\n Test 2: The expected ID of the fifth item after sorting the array is " + expectedID + " and the actual ID is " + libraryIDOfFirthItem);
    }
    
    public void testPrintReport(LoanSystem is) {
        is.printReport();
    }
    
    public void testDelete(LoanSystem is) {
        String deleteItem = "Plant Science"; // <1>
        is.delete(deleteItem);  // <2>
        int newSize = is.currentSize; // <3>
        
        assertEquals( 19, newSize ); // these assertations will not work for task four
        System.out.println("\n Test 3: The expected size of the array after deleting " + deleteItem + " is " + newSize + " and the actual size is " + is.currentSize);
    }
    
    // This test should only be used if the search option of task four is used in the sort method
    public void testTaskFour(LoanSystem is) {
        
        int count = 0;
                
        for (int i=0; i< is.currentSize; i=i+1) {
            LoanItems li = is.itemArray[i]; 
            boolean bool1 = li.getLent();
            int id = li.getLibraryID();
            if (!bool1 && i == 16 || i == 17 || i == 18 || i == 19) {
                count ++;
            }    
        }
        
        int expectedIDNum = 4;
        
        assertEquals( expectedIDNum, count );
        System.out.println("\n Test 5: The expected number of items not lent is " + expectedIDNum + " and the actual size is " + count);
    }
    
    public void testAddItem(LoanSystem is) {
        LoanItems d6 = new DVDs("Jon Favreau", "The Lion King", 21, false, 0); // creating a new object d6 of type LoanItems that holds a DVD object
        is.addItem(d6); // calling the addItem() method from the LoanSystem class
        int newSize = 20; // the int value of the length that the array should be after adding d6
        
        // these assertations will not work for task four. It ensures that the new size of the array is the expected size
        assertEquals( newSize, is.currentSize ); 
        System.out.println("\n Test 4: The expected size of the array is " + newSize + " and the actual size is " + is.currentSize);
    }
 
    @Test
    public void test(LoanSystem is) {
        testSize(is);
        testSort(is);
        // testTaskFour(is);  // This test should only be used if the search option of task four is used in the sort method
        testPrintReport(is);
        testDelete(is);
        testPrintReport(is);
        testAddItem(is);
        testPrintReport(is);
    }
}
