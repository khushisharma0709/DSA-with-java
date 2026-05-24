class Partition{
    public static int jumb(int[] arr){
        int n =arr.length;
        int totalsum=0;
        for(int i:arr){
            totalsum+=i;
        }
        int W=totalsum/2;
        int[][] dp=new int[n+1][W+1];

    //bottom up approach
    for(int i=1;i<n+1;i++){
        for(int j=1;j<W+1;j++){
            if(arr[i-1]<=j){//valid
                dp[i][j]=Math.max(arr[i-1]+dp[i-1][j-arr[i-1]],dp[i-1][j]);
            }else{
                dp[i][j]=dp[i-1][j];
            }
        }
    }
    int sum1=dp[n][W];
    int sum2=totalsum-sum1;
    return Math.abs(sum1-sum2);
    }
    public static void main(String[] args){
        int[] arr={1,6,11,5};
        System.out.println(jumb(arr));
    }
}