public class RecordHashTable {

    //Count of elements
    int size;
    Record[] hashTable;
    //Record Hash table constructor
    public RecordHashTable(int capacity) {
        hashTable = new Record[capacity];
        size = 0;
    }

    //Hash Function hashFunction(Record R)
    public int hashFunction(Record r) {
        //Calculating an index int
        //First get Title
        String title = r.getTitle();
        //Create a running total
        int sum = 0;
        //Loop through characters
        for(int i = 0; i < title.length(); i++) {
            //Checks each letter then adds them to sum
            sum += title.charAt(i);
        }
        //Apply modulo math
        int index = sum % hashTable.length;
        //Returns index
        return index;
    }

    //put record into the Hash Table using folding hash function (hashFunction)
    public void put(Record r) {
        //Get starting index
        int index = hashFunction(r);
        //Check if the slot is empty or not
        while(hashTable[index] != null) {
           //Keep moving till you find a empty slot
            index = (index + 1) % hashTable.length;
        }
        //Found free spot
        hashTable[index] = r;
        //Update size
        size++;
    }

    //Contains returns true if the record r is in the hash table (False otherwise)
    public boolean contains(Record r) {
        //Get starting index
        int index = hashFunction(r);

        //check if the slot is empty or not
        while(hashTable[index] != null) {
            Record storedRecord = hashTable[index];

            //Check if titles match (key comparison)
            if (storedRecord.getTitle().equals(r.getTitle())) {
                return true;
            }
            //Keep moving till you find an empty slot after checking
            index = (index + 1) % hashTable.length;
        }
        //If not contained return false
        return false;
    }

    //Already maintain size in put so just return size
    public int size() {
        return size;
    }

    //Check if empty and if so return true, else false. 
    public boolean isEmpty() {
        return size == 0;
    }

}
