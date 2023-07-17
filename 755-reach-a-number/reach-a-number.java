class Solution {
    public int reachNumber(int target) {
        int sum=0; int steps=0;
        target=Math.abs(target);
        if(target==0){
            return 0;
        }

        while(sum<target){
            steps++;
            sum=sum+steps;
        }

        while((sum-target)%2!=0){
            steps++;
            sum=sum+steps;
        }

        return steps;
    }
}