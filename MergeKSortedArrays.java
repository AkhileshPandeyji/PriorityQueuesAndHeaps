package prog;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKSortedArrays {
		static class Pair implements Comparable<Pair>{
			int li;
			int di;
			int val;
			Pair(int li,int di,int val){
				this.li = li;
				this.di = di;
				this.val = val;
			}
			public int compareTo(Pair obj) {
				return this.val - obj.val;
			}
		}
	   public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists){
		      ArrayList<Integer> rv = new ArrayList<>();
		      PriorityQueue<Pair> pq = new PriorityQueue<>();	
		      
		      for(int listidx = 0;listidx<lists.size();listidx++) {
		    	  ArrayList<Integer> list = lists.get(listidx);
		    	  int val = list.get(0);
		    	  pq.add(new Pair(listidx,0,val));
		      }
		      
		      while(pq.size()>0) {
		    	  Pair rem = pq.remove();
		    	  
		    	  rv.add(rem.val);
		    	  rem.di++;
		    	  
		    	  if(rem.di<lists.get(rem.li).size()) {
		    		  int val = lists.get(rem.li).get(rem.di);
		    		  pq.add(new Pair(rem.li,rem.di,val));
		    	  }
		      }
		      return rv;
		   }

		   public static void main(String[] args) throws Exception {
		      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		      int k = Integer.parseInt(br.readLine());
		      ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
		      for(int i = 0; i < k; i++){
		         ArrayList<Integer> list = new ArrayList<>();

		         int n = Integer.parseInt(br.readLine());
		         String[] elements = br.readLine().split(" ");
		         for(int j = 0; j < n; j++){
		            list.add(Integer.parseInt(elements[j]));
		         }

		         lists.add(list);
		      }

		      ArrayList<Integer> mlist = mergeKSortedLists(lists);
		      for(int val: mlist){
		         System.out.print(val + " ");
		      }
		      System.out.println();
		   }

}
