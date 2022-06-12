// this is a cut down version of the interface specifically for the Insert test
// the complete version is in the Library folder on Moodle

public abstract interface SortedADT {
    
    public class NotUniqueException extends Exception{}

    public abstract void insert (Comparable object) throws NotUniqueException;

}
