package eci.arep;

import java.util.ArrayList;

public class LucasSequence {

    public static void main(String[] args) {
        System.out.println(calculateSequence(13));
    }

    public static int calculateSequence(int sequenceNumber){
        if(sequenceNumber== 0){
            return 2;
        } else if (sequenceNumber==1) {
            return 1;
        } else{
            return (calculateSequence(sequenceNumber-1)+calculateSequence(sequenceNumber-2));
        }
    }
}
