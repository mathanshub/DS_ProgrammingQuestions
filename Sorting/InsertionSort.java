


public class InsertionSort {

    public void InSort(int a[],int n){
        int key=0;
        int j=0;
        for (int i=1;i<n;i++){
            key=a[i];
            j=i-1;
            while((j>=0) && (a[j]>key)){
                a[j+1]=a[j];
                j=j-1;
            }
            a[j+1]=key;
        }
        
        for(int i=0;i<n;i++){
            System.out.println(a[i]);    
        }
    }
    
    public static void main(String[] args) {
        new InsertionSort().InSort(new int[] {66,45,76,12,9,4},6);// Elements and number of elements
    }
}

