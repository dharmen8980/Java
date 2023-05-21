package lambda_expressions;

public interface SelectionSort {
    default int[] sortedArray(int[] arr){

        for(int i = 0; i<arr.length; i++){
            int minIndex = i;
            for ( int j = i+1; j< arr.length; j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        return arr;
    };
}
