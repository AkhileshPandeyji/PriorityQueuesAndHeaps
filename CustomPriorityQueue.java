package prog;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CustomPriorityQueue {

	  public static class PriorityQueue {
	    ArrayList<Integer> data;

	    public PriorityQueue() {
	      data = new ArrayList<>();
	    }
	    public void swap(int i,int j) {
	    	int idata = data.get(i);
	    	int jdata = data.get(j);
	    	
	    	data.set(i, jdata);
	    	data.set(j, idata);
	    }
	    public void upheapify(int ci) {
	    	if(ci == 0) {
	    		return;
	    	}
	    	int pi = (ci-1)/2;
	    	if(data.get(pi) > data.get(ci)) {
	    		swap(pi,ci);
	    		upheapify(pi);
	    	}
	    }
	    public void add(int val) {
	      data.add(val);
	      upheapify(data.size()-1);
	    }
	    public void downheapify(int pi) {
	    	int li = (pi*2)+1;
	    	int ri = (pi*2)+2;
	    	if(li>=data.size()-1 || ri>=data.size()-1) {
	    		return;
	    	}
	    	int lidata = data.get(li);
	    	int ridata = data.get(ri);
	    	if(lidata<data.get(pi) || ridata<data.get(pi)) {
	    		if(lidata<data.get(pi)) {
	    			swap(li,pi);	    			
	    			downheapify(li);
	    		}
	    		else{
	    			swap(ri,pi);
	    			downheapify(ri);
	    		}
	    	}	    	
	    }
	    
	    public void downheapify2(int pi) {
	    	int li = (2*pi)+1;
	    	int ri = (2*pi)+2;
	    	
	    	int minidx = pi;
	    	if(li<data.size() && data.get(li)<data.get(minidx)) {
	    		minidx = li;
	    	}
	    	if(ri<data.size() && data.get(ri)<data.get(minidx)) {
	    		minidx = ri;
	    	}
	    	
	    	if(minidx != pi) {
	    		swap(minidx,pi);
	    		downheapify(minidx);
	    	}
	    }
	    public int remove() {
	      if(this.size() == 0) {
	    	  System.out.println("Underflow");
	    	  return -1;
	      }
	      swap(0,data.size()-1);
	      int rem = data.get(data.size()-1);
	      data.remove(data.size()-1);
	      downheapify2(0);
	      return rem;
	    }

	    public int peek() {
	      if(this.size() == 0) {
	    	  System.out.println("Underflow");
	    	  return -1;
	      }
	      return data.get(0);	      
	    }

	    public int size() {
	      return data.size();
	    }
	  }

	  public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    PriorityQueue qu = new PriorityQueue();

	    String str = br.readLine();
	    while (str.equals("quit") == false) {
	      if (str.startsWith("add")) {
	        int val = Integer.parseInt(str.split(" ")[1]);
	        qu.add(val);
	      } else if (str.startsWith("remove")) {
	        int val = qu.remove();
	        if (val != -1) {
	          System.out.println(val);
	        }
	      } else if (str.startsWith("peek")) {
	        int val = qu.peek();
	        if (val != -1) {
	          System.out.println(val);
	        }
	      } else if (str.startsWith("size")) {
	        System.out.println(qu.size());
	      }
	      str = br.readLine();
	    }
	  }
}
