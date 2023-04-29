import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class SingleDimensionalArray {
    public static void main (String[] args){
        int[] arr = InputArray();
        System.out.println("The largest Number is: " + LargestElement(arr));
        FindElement(arr,4);
        ReverseArray(arr);
        System.out.println("Ascending order of your array is: " + Arrays.toString(AscendingSort(arr)));
        System.out.println("The second largest number of your array is: " + SecondLargest(arr));
        System.out.println("Second largest number without sorting: " + SecondLargestWithoutSorting(arr));
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

    public static int LargestElement (int[] arr){
        int maxNum = arr[0];
        for (int element : arr){
            if(element > maxNum)
                maxNum = element;
        }
        return  maxNum;
    }

    public static void  FindElement (int[] arr, int toBeFound){
        boolean found = false;
        for(int element : arr){
            if(element == toBeFound){
                found = true;
                break;
            }
        }
        if(found)
            System.out.println("Your number " + toBeFound + " exists in the given array");
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

        System.out.print("Reverse order of your array is: ");
        System.out.println(Arrays.toString(newArray));
    }

    public static int SecondLargest (int[] arr) {
        int largestNum = LargestElement(arr);
        int[] sortedArray = AscendingSort(arr);
        int indexOfLargestNum = Arrays.binarySearch(sortedArray, largestNum);
        return sortedArray[indexOfLargestNum-1];
    }

    public static int SecondLargestWithoutSorting (int[] arr){
        int largestNum = LargestElement(arr);
        int secondLargestNum = 0;

        for(int num : arr){
            if(num > secondLargestNum && num<largestNum)
                secondLargestNum = num;
        }
        return secondLargestNum;
    }
}
