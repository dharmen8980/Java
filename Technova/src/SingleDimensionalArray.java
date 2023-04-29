import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class SingleDimensionalArray {
    public static void main (String[] args){
        int[] arr = InputArray();
        System.out.println(LargestElement(arr));
        FindElement(4);
        ReverseArray(arr);
        System.out.println(Arrays.toString(AscendingSort(arr)));
//        System.out.println(SecondLargest(arr));
    }

    public static int[] InputArray (){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the length of your array: ");
        int arrayLength = input.nextInt();
        int[] array = new int[arrayLength];

        for(int i=0; i<arrayLength; i++){
            array[i] = input.nextInt();
        }

        return array;
    }
    public static int SwapElements(int first, int second){
        int temp = second;
        return first = temp;
    }

    public static int LargestElement (int[] arr){
        int maxNum = arr[0];
        for (int element : arr){
            if(element > maxNum)
                maxNum = element;
        }
        return  maxNum;
    }

    public static void  FindElement (int toBeFound){
        boolean found = false;
        int[] arr = InputArray();

        for(int element : arr){
            if(element == toBeFound){
                found = true;
                break;
            }
        }
        if(found)
            System.out.println(toBeFound + " exists");
    }

    public static int[] AscendingSort (int[] array){
        boolean swapped = true;
        while(swapped){
            swapped = false;
            for(int i=0; i<array.length-1; i++){
                if(array[i]>array[i+1]){
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    swapped = true;
                }
            }
        }
        System.out.println();
        return array;
    }

    public static void ReverseArray(int[] arr){
        Stack <Integer> elementHolder = new Stack<>();

        for(int element: arr){
            elementHolder.push(element);
        }

        int[] newArray = new int[arr.length];

        for(int i=0; i<arr.length; i++){
            newArray[i] = elementHolder.pop();
        }

        for(int element: newArray){
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static int SecondLargest (int[] arr) {
        int largestNum = LargestElement(arr);
        int[] sortedArray = AscendingSort(arr);
        int indexOfLargestNum = Arrays.binarySearch(sortedArray, largestNum);
        return sortedArray[indexOfLargestNum-1];
    }
}
