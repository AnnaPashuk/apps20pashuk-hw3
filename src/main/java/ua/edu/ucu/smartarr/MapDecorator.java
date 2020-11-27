package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator{


    MyFunction myFunction;
    public MapDecorator(SmartArray smartArray, MyFunction myFunction) {
        super(smartArray);
        this.myFunction = myFunction;
    }

    public Object[] itemsMap(){
        int counter = 0;
        Object[] smart = smartArray.toArray();
        Object[]  newArray = new Object[smart.length];
        for (Object i : smart){
            newArray[counter] = myFunction.apply(i);
            counter ++;
        }
        return newArray;
    }

    @Override
    public Object[] toArray() {
        return itemsMap();
    }

    @Override
    public String operationDescription() {
        return "Map Decorator";
    }

    @Override
    public int size() {
        return itemsMap().length;
    }
}
