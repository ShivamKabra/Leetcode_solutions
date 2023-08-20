class Solution {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        int[] arr = new int[numOnes+numZeros+numNegOnes];
        int c=0;
        while(numOnes!=0){
            arr[c] = 1;
            numOnes--;
            c++;
        }

        while(numZeros!=0){
            arr[c]=0;
            numZeros--;
            c++;
        }

        while(numNegOnes!=0){
            arr[c]=-1;
            numNegOnes--;
            c++;
        }
        int sum=0;
        for(int i=0;i<k;i++){
            sum+=arr[i];
        }

        return sum;
       
    }
}