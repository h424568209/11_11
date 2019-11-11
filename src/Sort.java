import java.util.Arrays;

public class Sort {
    //归并排序
    //O(N*logN)  空间 O(N)
    //稳定
    public static  void mergeSort(int []array){
        mergeSortInternal(array,0,array.length);
    }

    private static void mergeSortInternal(int[] array, int low, int high) {
        if(low-1>=high){
            return;
        }
        int mid = (low +high)/2;
        mergeSortInternal(array,low,mid);
        mergeSortInternal(array,mid,high);
        merge(array,low,mid,high);
    }

    public  static void merge(int []array,int low ,int mid ,int high){
        int i = low;
        int j = mid;
        int legth = high-low;
        int []extra = new int[legth];
        int k = 0;
        while(i<mid && j<high){
            if(array[i]<=array[j]){
                extra[k++] = array[i++];
            }else{
                extra[k++] = array[j++];
            }
        }
        while(i<mid){
            extra[k++] =array[i++];
        }
        while(j<high){
            extra[k++] = array[j++];
        }
        for(int t = 0 ; t <legth ; t++){
            array[low+t] = extra[t];
        }
    }
    //快排
    //O(N*logN) o(n^2)  空间O(LogN) o(n)
    //不稳定
    public static void quickSort(int []array){
        quickSortInternal(array,0,array.length-1);
    }

    private static void quickSortInternal(int[] array, int left, int right) {
        if(left ==right){
            return;
        }
        if(left>right){
            return;
        }
        int pivotindex = patition(array,left,right);
        quickSortInternal(array,left,pivotindex-1);
        quickSortInternal(array,pivotindex+1,right);
    }

    private static int patition(int[] array, int left, int right) {
        int i = left;
        int j = right;
        int pivot = array[left];
        while (i<j){
            while(i<j && array[j]>=pivot){
                j--;
            }
            while(i<j && array[i]<=pivot){
                i++;
            }
            swap(array,i,j);
        }
        swap(array,i,left);
        return i;
    }

    //冒泡排序
    //O(N) O(N^2)
    //稳定
    public static void bubbleSort(int []array){
        for(int i =0 ; i <array.length-1 ;i++){
            for(int j = 0 ; j<array.length-1-i ;j++){
                if(array[j]>array[j+1]){
                    swap(array,j,j+1);
                }
            }
        }
    }
    //堆排序
    //O(N*LogN)
    //不稳定
    public static void heapSort(int []array){
        createHeap(array);
        for(int i = 0 ; i <array.length; i++){
            //交换前
            //无序区间 [0,array.length-i]
            //有序区间[array.length-i,array.length]
            swap(array,0,array.length-1);
            //交换后
            //无序区间 [0,array.length-i-1]
            //有序区间[array.length-i-1,array.length]
            //无序区间长度 array.length -i -1
            shiftDown(array,array.length-i-1,0);
        }
    }

    private static void shiftDown(int[] array, int size, int index) {
        int left = 2*index + 1;
        while(left<size){
            int max = left;
            int right = 2*index+2;
            if(right<size){
                if(array[right]>array[left]){
                    max = right;
                }
            }
            if(array[index] >=array[max]){
                break;
            }
            swap(array,index,max);
            index= max;
            left = 2*index+1;
        }
    }

    private static void createHeap(int[] array) {
        for(int i = (array.length-1)/2 ; i>=0 ; i--){
            shiftDown(array,array.length-1,i);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int t = array[i];
        array[i] =array[j];
        array[j] = t;
    }

    //插入排序  无序区间选择最大的一个放到无序区间的最后
    //O<N^2> 不稳定
    public static void selectSort(int []array){
        for(int i = 0 ; i <array.length ; i++) {
            int max = 0;
            for(int j = 1 ; j<array.length-i ; j++){
                if(array[max] < array[j]){
                    max = j;
                }
            }
            int tem = array[max];
            array[max] = array[array.length - 1 -i];
            array[array.length-i-i] = tem;
        }
    }
    //希尔排序
    //最好O（n） 平均O(N^1.3) 最差o(N^2)
    //不稳定
    public static void shellSort(int []array){
        int gap = array.length;
        while(gap>1){
            inserSortGap(array,gap);
            gap =(gap/3)-1;
        }
        inserSortGap(array,1);
    }

    private static void inserSortGap(int[] array, int gap) {
        for(int i = 0 ; i < array.length ; i++){
            int v = array[i];
            int j = i-gap;
            for(; j>=0&& array[j]>v ;j-=gap){
                array[j+gap] = array[j];
            }
            array[j+gap] = v ;
        }
    }

    //直接插入排序
    //选择无序区间的第一个元素，在有序区间原则合适的位置进行插入
    //最好O(N) 平均/最差O(N^2)  稳定
    public static void insertSort(int []array){
        for(int i = 0 ; i<array.length; i++){
           int v = array[i];
           int j = i-1;
           //已经保存了arr[i] 所以直接向后进行覆盖 然后进行元素插入
           for(;j>=0 && array[j]>v;j--){
               array[j+1] = array[j];
           }
           //合适的位置
           array[j+1] = v;
        }
    }

    public static void main(String[] args) {
        int []array = {2,3,1,4,5,0};
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }
}
