public class ArrayInsertTest {
    public static void main(String[] args){
        SortedADT sorted = new SortedArray(5);
        Integer value;
        do{
            value = Input.getInteger("value: ");
            try {
                sorted.insert(value);
                System.out.println("inserted");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("insert invalid - array full");
            } catch (SortedADT.NotUniqueException e) {
                System.out.println("insert invalid - value not unique");
            }
            System.out.println(sorted);
        }while(Repeat.repeat());
    }
}
