public class Main_11_07_2 {
    //求数组中的逆序对
    public static void main(String[] args) {
        int []A= {1,2,3,4,5,6,7,0};
        System.out.println(count(A,8));
    }

    private static int count(int[] A, int n) {
        if(A==null || n==0){
            return 0;
        }
        return mergeSortRecursion(A,0,n-1);
    }

    //递归实现归并排序
    private static int mergeSortRecursion(int[] arr, int l, int r) {
        //当待排序数组长度为1的时候，递归开始回溯，进行merge操作
        if(l == r){
            return 0;
        }
        int mid = (l+r)/2;
        //逆序对的总数 = 左边数组中的逆序对+右边数组的逆序对+左右合成新的顺序数组时出现的逆序对数量
        return mergeSortRecursion(arr,l,mid)+mergeSortRecursion(arr,mid+1,r)+merge(arr,l,mid,r);
    }
    //合并两个有序数组s[left...mid],s[mid+1....right]
    private static int merge(int[] arr, int left, int mid, int right) {
        //辅助存储空间
        int []temp = new int[right-left+1];
        int index = 0;
        int i = left;
        int j = mid+1;
        //新增，用来累加数组的逆序对
        int inverseNum = 0;
        while(i <= mid && j <= right){
            if(arr[i]<=arr[j]){
                temp[index++] = arr[i++];
            }else{
                //当前一个数组元素大于后一个数组元素时候，累加逆序对
                //s[i]>s[j]推导出 s[i]...s[mid]>s[j]
                inverseNum += (mid-i+1);
                temp[index++] = arr [j++];
            }
        }
        while(i<=mid)
            temp[index++] = arr [i++];
        while(j<=right){
            temp[index++] = arr [j++];
        }
        for(int k = 0 ; k <temp.length ; k++){
            arr[left++] = temp[k];
        }
        return inverseNum;
    }
}
