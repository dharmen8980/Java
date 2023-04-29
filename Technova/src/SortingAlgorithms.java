import java.lang.reflect.Array;

public class SortingAlgorithms {
    public static void main (String[] args){
        int[] arr = {2,8,3,9,11,15};

        BubbleSort(arr);
        SelectionSort(arr);
        String[][] attendance = {
                {"John", "present", "present", "present", "absent"},
                {"Bob","absent", "present", "absent", "present"},
                {"Peter","absent", "absent", "absent", "present"}};

        Attendance(attendance);
    }

    public static void BubbleSort (int[] arr){
        boolean swapped = true;

        while(swapped){
            swapped = false;
            for(int i=0; i<arr.length-1; i++){
                if(arr[i]>arr[i+1]){
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    swapped=true;
                }
            }
        }
        System.out.print("Result from Bubble sort: ");
        for (int elements : arr){
            System.out.print(elements + " ");
        }
        System.out.println();
    }

    public static void SelectionSort (int[] arr) {
        for(int i = 0; i<arr.length; i++){
            int minIndex = i;
            for ( int j = i+1; j< arr.length; j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            arr[i] = arr[minIndex];
        }

        System.out.print("Result from Selection sort: ");
        for (int elements : arr){
            System.out.print(elements + " ");
        }
        System.out.println();

    }

    public static void Attendance(String[][] attendance){
        String bestEmployee = "";
        int score = 0;

        for(int i=0; i<attendance.length; i++){
            int count = 0;
            for( int j = 1; j<attendance[i].length; j++){
                if(attendance[i][j].equals("present")){
                    count += 1;
                }
            }
            if(count > score){
                score = count;
                bestEmployee = attendance[i][0];
            }
        }
        System.out.println(bestEmployee + " is the best employee with the most attendance.");
    }
}
