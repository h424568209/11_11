import java.util.ArrayList;
import java.util.List;

public class LeeCode {
    /**
     * 跳跃游戏
     * 从最后一个下标开始 将能到达最后一个下标的位置设置为最后一个元素的索引
     * @param nums 数组
     * @return 经过数组中元素的跳跃 可否到达最后一个元素
     */
    public boolean canJump(int[] nums) {
        //pos记录下标
        int lastPos = nums.length-1;
        for(int i = nums.length-1 ; i>=0 ;i--){
            if(i+nums[i]>=lastPos){
                lastPos = i;
            }
        }
        return lastPos==0;
    }
    /**
     * 螺旋矩阵
     * @param matrix 二维数组
     * @return 螺旋遍历后的链表
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if(matrix.length == 0){
            return list;
        }
        int l = 0;
        //每一行的长度
        int r = matrix[0].length-1;
        int u  =0;
        //数组的长度
        int d = matrix.length-1;
        while(l<=r && u <=d){
            for(int i = l ; i <= r ;i++){
                list.add(matrix[u][i]);
            }
            u++;
            for(int i = u ; i <= d ;i++){
                list.add(matrix[i][r]);
            }
            r--;
            for(int i = r ; i>=l && u<=d;i--){
                list.add(matrix[d][i]);
            }
            d--;
            for(int i = d ; i >=u && l<=r ;i--){
                list.add(matrix[i][l]);
            }
            l++;
        }
        return list;
    }
    /**
     * 数组的最大子序列
     * @param nums 数组
     * @return 数组最大子序列的和
     */
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for(int num :nums){
            if(sum>0){
                sum+=num;
            }else {
                sum = num;
            }
            res = Math.max(res,sum);
        }
        return res;
    }
    /**
     * 旋转一个二维数组
     * 从外圈开始逐渐向内圈缩小进行旋转
     * @param matrix 二位数组
     */
    public void rotate(int[][] matrix) {
        int p = 0;
        int q = matrix.length-1;
        while(p<=q){
            int p1 = p;
            int q1 = q;
            while(p1!=q){
                int tem = matrix[p][p1];
                matrix[p][p1] = matrix[q1][p];
                matrix[q1][p] = matrix[q][q1];
                matrix[q][q1] = matrix[p1][q];
                matrix[p1][q] = tem;
                p1++;
                q1--;
            }
            p++;
            q--;
        }
    }
    /**
     *
     * @param nums 随机的数组
     * @return 返回数组缺失的第一个正数
     */
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for(int i = 0 ; i< len ; i++){
            //在指定范围内、且没有放在指定的位置才进行交换
            //nums[nums[i]-1]!= nums[i] 判断是否在指定的位置  比如2 应该放在索引1上  1 应该放在索引0上
            //使用while可以避免交换后现在位置不正确的问题
            while(nums[i] > 0 && nums[i]<len && nums[nums[i] -1] != nums[i]){
                swap(nums,i,nums[i]-1);
            }
        }
        for(int i = 0 ; i < len ; i++){
            //如果当前位置的数和当前位置不符，就返回当前的位置 就是最大的正数
            if(nums[i]!= i+1)
                return i+1;
        }
        //都正确返回数组的长度就是最大的正数
        return nums.length+1;
    }

    private void swap(int[] nums, int i, int j) {
        int tem = nums[i];
        nums[i] = nums[j];
        nums[j] = tem;
    }

    public static void main(String[] args) {
        int[]nums = {1};
        LeeCode l = new LeeCode();
        System.out.println(l.firstMissingPositive(nums));

    }
}
