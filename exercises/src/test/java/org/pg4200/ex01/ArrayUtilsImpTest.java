package org.pg4200.ex01;

public class ArrayUtilsImpTest extends ArrayUtilsTestTemplate{
    @Override
    protected ArrayUtils getNewInstance() {
        ArrayUtils arrayUtils =  new ArrayUtilsImp();
        return arrayUtils;
    }
}
