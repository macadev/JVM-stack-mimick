import java.util.*;
import java.io.*;
//Student:  Daniel Macario
//ID:       260503662


class ProgramFrame {
    int start;
    int stop;
    int PC;
    
    public ProgramFrame(int myStart, int myStop, int myPC) {
    	start=myStart;
    	stop=myStop;
    	PC=myPC;
    }

    // returns a String describing the content of the object
    public String toString() {
    	return "ProgramFrame: start = " + start + " stop = " + stop + " PC = " + PC;
    }
}


class MergeSortNonRecursive {

    static Stack<ProgramFrame> callStack;

    // this implements the merge algorithm.
    public static void merge(int A[], int start, int mid, int stop) {
    	int index1=start;
    	int index2=mid+1;
    	int tmp[]=new int[A.length];
    	int indexTmp=start;
	
    	while (indexTmp<=stop) {
    		if (index1<=mid && (index2>stop || A[index1]<=A[index2])) {
    			tmp[indexTmp]=A[index1];
    			index1++;
    		}else{
    			if (index2<=stop && (index1>mid || A[index2]<=A[index1])) {
    				tmp[indexTmp]=A[index2];
    				index2++;
    			}
    		}
    		indexTmp++;
    	}
    	for (int i=start;i<=stop;i++) A[i]=tmp[i];
    }
    
    
    static void mergeSort(int A[]) {
	
    	callStack = new Stack<ProgramFrame>();  //Declaring the stack and the type being used.
    	
    	// the initial program frame
    	ProgramFrame current = new ProgramFrame(0, A.length-1 ,1); 
    	
    	callStack.push(current);
    	
    	while(!callStack.empty()){
    		
            System.out.println(callStack);
            //System.out.println(Arrays.toString(A));
            //System.out.println(callStack.peek().PC);  //For debugging purposes.

            int mid = (callStack.peek().start + callStack.peek().stop)/2;
    		
            if(callStack.peek().start < callStack.peek().stop){

            	
            
                if(callStack.peek().PC == 1){

                    current = new ProgramFrame(callStack.peek().start,mid,1);
                    callStack.push(current);
                    continue;
                    
                }

                if(callStack.peek().PC == 2){

                    current = new ProgramFrame(mid+1,callStack.peek().stop,1);
                    callStack.push(current);
                    continue;
                    
                }                

                if(callStack.peek().PC == 3){

                  merge(A, callStack.peek().start, mid, callStack.peek().stop);
                  callStack.pop();
                  if(!callStack.isEmpty()){
                	  callStack.peek().PC++;
                  }
                  continue;

                }

 
    		
            }else if(callStack.peek().start == callStack.peek().stop){
            	callStack.pop();
            	if(!callStack.empty()){
            		callStack.peek().PC++;
            	}
            	continue;
            }else{
            	break;
            }
            
            
            
    	}
    	

    }
    

    
    public static void main (String args[]) throws Exception {
	
	// just for testing purposes
	int myArray[] = {4,6,8,1,3,2,9,5,7,6,4,2,1,3,9,8,7,5,345,3,234,53,45,1234,345,2};
	mergeSort(myArray);
	System.out.println("Sorted array is:\n");
	for (int i=0;i<myArray.length;i++) {
	    System.out.print(myArray[i]+" ");
	}
	System.out.println();
    }
}

	