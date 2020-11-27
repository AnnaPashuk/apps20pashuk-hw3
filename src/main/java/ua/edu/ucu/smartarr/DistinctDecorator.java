package ua.edu.ucu.smartarr;

import java.util.ArrayList;
import java.util.Arrays;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator{

    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);

    }

    public Object[] itemsDistinct(){

        int counter = 0;
        Object[] smart = smartArray.toArray();
        for (int i = 0; i < smart.length - 1; i ++){
            for (int j = 1; j < smart.length - 2; j++){
                if ( smart[i].equals(smart[i + j])){
                    smart[i+j] = null;
                    counter ++;
                }
            }
        }
        Object[]  newArray = new Object[smart.length - counter];
        int index = 0;
        for (Object obj : smart){
            if (obj != null){
                newArray[index] = obj;
                index ++;
            }
        }
        return newArray;
    }
    @Override
    public Object[] toArray() {
        return itemsDistinct();
    }

    @Override
    public String operationDescription() {
        return "DistinctDecorator";
    }

    @Override
    public int size() {
        return itemsDistinct().length;
    }
}
