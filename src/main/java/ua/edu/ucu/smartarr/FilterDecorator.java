package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator{


    MyPredicate myPredicate;
    public FilterDecorator(SmartArray smartArray, MyPredicate myPredicate) {
        super(smartArray);
        this.myPredicate = myPredicate;

    }
    public Object[] itemsFilter(){
        int counter = 0;
        Object[] smart = smartArray.toArray();
        for (Object i : smart){
            if (myPredicate.test(i)){
                counter ++;
            }
        }
        Object[]  newArray = new Object[counter];
        int index = 0;
        for (Object obj : smart){
            if (myPredicate.test(obj)){
                newArray[index] = obj;
                index ++;
            }
        }
        return newArray;
    }

    @Override
    public Object[] toArray() {
        return itemsFilter();
    }

    @Override
    public String operationDescription() {
        return "Filter decorator";
    }

    @Override
    public int size() {
        return itemsFilter().length;
    }
}
