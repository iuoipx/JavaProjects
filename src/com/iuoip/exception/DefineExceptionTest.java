package com.iuoip.exception;

public class DefineExceptionTest {
    public static void main(String[] args) {
        int i = -1;
        if(i < 0)
            try{
                throw new DefineException("i can't smaller than zero");
            }catch (DefineException e){
                e.printStackTrace();
            }
    }
}
