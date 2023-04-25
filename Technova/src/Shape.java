public class Shape {
    public static void main (String[] args){
        int space = 5;
        for (int i=1; i<10; i+=2){
            for(int j=1; j<space; j+=1){
                System.out.print("     ");
            }
            for(int k=0; k<i; k+=1){
                System.out.print("*    ");
            }
            System.out.println();
            space-=1;
        }
    }
}
