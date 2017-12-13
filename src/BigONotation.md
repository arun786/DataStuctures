# Big O Notation

Example of Big O(1)

        /**
         * Big O notation for O(1)
         */

        BigONotation O1 = new BigONotation(10);
        O1.addItemToArray(10);
        
Example of Big O(n)

Linear Search

    /**
     * Example of Big O(n), is linear search
     */

    public boolean linearSearch(int number) {

        startTime = System.currentTimeMillis();
        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (intArray[i] == number) {
                found = true;
                break;
            }
        }
        endTime = System.currentTimeMillis();
        System.out.println("time taken is " + (endTime - startTime));
        return found;
    }
        