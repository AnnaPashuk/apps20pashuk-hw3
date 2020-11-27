package ua.edu.ucu.smartarr;

import java.util.Arrays;

// Base array for decorators
public class BaseArray implements SmartArray{
    private Object[] newArray;
    public BaseArray(Object[] newArray){
        this.newArray = newArray;
    }

    @Override
    public Object[] toArray() {
        return newArray.clone();
    }

    @Override
    public String operationDescription() {
        return null;
    }

    @Override
    public int size() {
        return newArray.length;
    }
}
