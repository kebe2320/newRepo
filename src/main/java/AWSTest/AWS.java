package AWSTest;

import java.util.Arrays;


public class AWS {
    private static final int FILLER_VALUE = Integer.MIN_VALUE; //filler_value has min value
    private int[] values;
    //creating an array variables: values store arrays

    public int[] getValues() {
        return Arrays.copyOf(values, values.length);
    }

    //values is original array, and values.length is the length of a copy of original array (shorten and filled with FALSE)

    public void setValues(int[] values) {
        this.values = Arrays.copyOf(values, values.length);
    }
    // this is a reference variable, storing a reference value of the variable
    //https://java-programming.mooc.fi/part-5/3-primitive-and-reference-variables


    @Override
    public String toString() {
        return "AWSTest.AWS [values=" + Arrays.toString(values) + "]";
    }

    //Arrays.toString returns the value given to it in a string format

    public AWS(int[] values) {
        super();
        setValues(values);
    }


    //super(), a reference variable animal class, dog class example;

    public int remove(int i) {

        int value = FILLER_VALUE;

        if (i >= 0 && i < values.length) {
            value = values[i]; //connecting values (copy array) to filler_value

            for(int index = i; index < values.length - 1; ++index) {
                values[index] = values[index+1];
            }

            values[values.length-1] = FILLER_VALUE; //this line is the one that removes int i from the array, len - 1 = original 9, now length become 9-1 = 8
        }

        //reason why values is a reference variable

        return value; // returning the array item that has been removed
    }


    public void fillAndExpand(int position, int nt) {

        int numberOfTimes = Math.abs(nt); //so number of times isn't negative
        int[] newArray = new int[values.length + numberOfTimes]; //new array with new size will be stored in newArray

        //preparing the new array, with the new size
        for(int i = 0; i <= position; ++i) {
            newArray[i] = values[i];
        }

        //filling the new array from copy
        //above used nt only

        for(int i = position; i <= numberOfTimes + position; ++i) {
            newArray[i] = newArray[position];
        }


        // filling process
        // the <= (less or equal) condition sets the length of position
        // position was first set, then got the size by condition, so whatever was in the position was added to the new size


        // Make examples, so it is easier to visualize your methods
        //   p 1 2
        // a b c
        // a b b b c

        int x = numberOfTimes;

        for(int i = position+1; i < values.length; ++i ) {
            newArray[i+x] = values[i];
        }

        values = newArray;

    }

    /*
     * Create a method removeBiggerThan(int threshold) the AWSTest.AWS class that will
     * remove all values bigger than a threshold that you send and return the number of removed values;
     * use FILLER_VALUE to replace removed values
     */
    public int removeBiggerThan(int threshold) {

        int counter = 0; //starting count

        for (int i = 0; i < values.length; i++) {

            if(values[i] > threshold) {

                values[i] = FILLER_VALUE;

                counter+=1;
            }
        }
        //looping through the array while comparing array elements against the threshold
        //while counting the number of elements that got removed

        return counter;

    }

    /*
     * Create a method stepMultiplier() in the AWSTest.AWS class that will multiply all values less than 10 by 2,
     * and all values that are less than 20 and bigger than 10 by 4, and
     * all values that are less than 100 and bigger than 20 by 100;
     */

    public void stepMultiplier() {

        for (int i = 0; i < values.length; i++) {
            if(values[i] < 10) {
                values[i] = values[i] * 2;
            }

            else if (values[i] < 20 && values[i] > 10) {
                values[i] = values[i] * 4;
            }

            else if (values[i] < 100 && values[i] > 20) {
                values[i] = values[i] * 100;
            }

        }
    }
    //for loop is for iterating through array elements
    //for each array element, we test the condition against the numbers given
    //not returning a value
}
