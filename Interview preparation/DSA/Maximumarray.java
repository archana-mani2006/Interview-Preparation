class Solution {
    public int maxSubArray(int[] nums) {
        
           
        int maxlen=nums[0];
        int sum=0;
        int start=0;
        //int ansstart=0;
        //int ansend=0;
        for(int i=0;i<nums.length;i++){
            
            sum=sum+nums[i];
           
            
            if(sum>maxlen){
                maxlen=sum;
                //ansstart=start;
                //ansend=i;

            }
            if(sum<0){
                sum=0;
                start=i+1;
            }
        }

        return maxlen;
    }
}



        
        /*for(int i=0;i<nums.length;i++){
            int sum=0;
            for(int j=i;j<nums.length;j++){
                sum=sum+nums[j];
                if(sum>maxlen){
                    maxlen=sum;
                }
            }
        }
        return maxlen;
    }
}*/
