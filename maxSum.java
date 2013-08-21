public class maxSum {
	public static void main(String[] args) {
		if(args.length < 1) {
			System.out.println("please give some input, example: -1 0 1 2");
			return;
		}
		//program take array input from command line arguments
		//first parse the array into a int array
		int[] in = new int[args.length];
		for (int i=0; i<args.length; i++) {
			in[i] = Integer.parseInt(args[i]);
		}
		int start = 0;
	    int end = 0;
	    int tmpStart = 0;
	    int maxSum = 0;
	    int tmpMaxSum = 0;
	    int positiveNumCnt = 0;
	    for (int i =0; i < in.length; i++) {
	    	//if it is a positive number
	    	if (in[i] > 0) {
	    		positiveNumCnt++;
	    		//if this is the first one, set it as the start point
	    		if (positiveNumCnt == 1) {
	    			tmpStart = i;
	    		}
	    		//add this value into tmpMaxSum, and compare with max one we have
	    		tmpMaxSum += in[i];
	    		if (tmpMaxSum > maxSum) {
	    			//if greater than former maxSum, reset start and end
	    			maxSum = tmpMaxSum;
	    			end = i;
	    			if (positiveNumCnt == 1) {
	    				start = tmpStart;
	    			}
	    		}
	    	} else {
	    		//if this is a negative value
	    		if (positiveNumCnt > 0) {
	    			tmpMaxSum += in[i];
	    			//first add it into subarray, if it cause sum <0, reset number count and test next one
	    		    if (tmpMaxSum < 0) {
	    		    	tmpMaxSum = 0;
	    		    	positiveNumCnt = 0;
	    		    }   
	    		}
	    	}
	    }
	    int[] subAry = new int[end - start + 1];
	    int outSum = 0;
	    for (int i = 0; i < subAry.length; i++) {
	    	subAry[i] = in[start + i];
	    	System.out.print(subAry[i]+" ");
	    	outSum += subAry[i]; 
	    }
	    System.out.println("Sum = "+outSum);
	}
}