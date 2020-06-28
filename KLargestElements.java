package prog;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class KLargestElements {
	 public static void solver(int[] arr,int k) {
		 PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		 for(int val:arr) {
			 pq.add(val);
		 }
		 int c = 0;
		 int sol[] = new int[k];
		 while(c<k) {
			 sol[c] = pq.remove();
			 c++;
		 }
		 for(int i=sol.length-1;i>=0;i--) {
			 System.out.println(sol[i]);
		 }
	 }	 
	 public static void solver2(int[] arr,int k) {
		 PriorityQueue<Integer> pq = new PriorityQueue<>();
		 for(int i=0;i<k;i++) {
			 pq.add(arr[k]);
		 }
		 for(int i=k;i<arr.length;i++) {
			 if(arr[i]>pq.peek()) {
				 pq.remove();
				 pq.add(arr[i]);
			 }
		 }
		 
		 while(pq.size()>0) {
			 System.out.println(pq.remove());
		 }
		 
	 }
	   public static void main(String[] args) throws Exception {
	      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	      int n = Integer.parseInt(br.readLine());
	      int[] arr = new int[n];

	      for (int i = 0; i < n; i++) {
	         arr[i] = Integer.parseInt(br.readLine());
	      }

	      int k = Integer.parseInt(br.readLine());
	      
	      solver2(arr,k);
	    }
}
