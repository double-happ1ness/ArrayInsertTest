// this is a cut down version of the class specifically for the Insert test
// the complete version is in the Library folder on Moodle

public class SortedArray implements SortedADT {

    private Comparable[] objects;
    private Integer objectCount;

    public SortedArray(Integer arraySize) {
        this.objects = new Comparable[arraySize];
        this.objectCount = 0;
    }

    public String toString() {
        String arrayDetails = new String();
        if (this.objectCount != 0) {
            for (Integer index = 0; index < this.objectCount; index++) {
                arrayDetails += objects[index] + "\n";
            }
        } else {
            arrayDetails += "array is empty";
        }
        return arrayDetails;
    }

    public void insert(Comparable object) throws NotUniqueException {
        /* algorithm
            if no space available then
                throw array full exception
            end if
            if array empty then
                add new object at the start of the array
            else
                set current position to start of array
                while insertion position not yet found loop
                    if new object matches object at the current position then
                        throw not unique exception
                    end if
                    if new object is less than object at current position then
                        for each object from last object in array to the insertion position
                            copy from object position to next position in the array
                        end loop
                        add new object at insertion position
                    else
                        move to next position in the array
                        if no more objects to check then
                            add new object after the last occupied slot
                        end if
                    end if
                end loop
            end if
            update the object count
         */
        // check space available
        if (this.objectCount == this.objects.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (this.objectCount == 0) {
            // insert into an empty array
            this.objects[this.objectCount] = object;
        } else {
            Integer currentPosition = 0;
            Boolean insertionPositionFound = false;
            Integer insertionPosition;
            while (!insertionPositionFound) {
                if (object.compareTo(this.objects[currentPosition]) == 0) {
                    throw new NotUniqueException();
                }
                if (object.compareTo(this.objects[currentPosition]) < 0) {
                    // insert before current position
                    insertionPosition = currentPosition;
                    insertionPositionFound = true;
                    // shuffle remaining objects up one place
                    for (currentPosition = this.objectCount - 1; currentPosition >= insertionPosition; currentPosition--) {
                        this.objects[currentPosition + 1] = this.objects[currentPosition];
                    }
                    this.objects[insertionPosition] = object;

                } else {
                    currentPosition++;
                    if (currentPosition == this.objectCount) {
                        // insert after last object
                        insertionPositionFound = true;
                        this.objects[this.objectCount] = object;
                    }
                }
                
            }
        }
        this.objectCount++;
    }

}
