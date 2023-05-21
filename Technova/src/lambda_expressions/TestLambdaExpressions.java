package lambda_expressions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
public class TestLambdaExpressions{
    public static void main (String[] args){
        Area areaOfRectangle = (l,h) -> l*h;
        Area areaOfSquare = (l,h) -> l==h ? l*h : 0;

        System.out.println(areaOfRectangle.getArea(4,5));
        double result = areaOfSquare.getArea(4,4);
        System.out.println(
                result == 0 ?
                        "Squares must have equal length and height" :
                        "The area of the square is " + result);

        SelectionSort array1 = new SelectionSort() {};

        int[] sortedArray = array1.sortedArray(new int[]{5, 4, 3, 2, 1});

        int[] dummyArray =  new SelectionSort(){}.sortedArray(new int[]{8, 5, 0, 2, 5});

        List<Integer> list1 = new LinkedList<>();
        for(int n : dummyArray){
            list1.add(n);
        }

        list1.add(-1);

        Collections.sort(list1);

        list1.forEach(nums -> System.out.print(nums + "\t"));


    }
}