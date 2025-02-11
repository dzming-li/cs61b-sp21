public class IntList {
	public int first;
	public IntList rest;

	public IntList(int f, IntList r) {
		first = f;
		rest = r;
	}

	/** Return the size of the list using... recursion! */
	public int size() {
	  if (this.rest==null)
		  return 1;
	  else return 1+this.rest.size();
	}

	/** Return the size of the list using no recursion! */
	public int iterativeSize() {
		int size=0;
	  for(IntList p=this;p!=null;p=p.rest)
	    size++;
		return size;
	}

	/** Returns the ith value in this list.*/
	public int get(int i) {
	  if(i==1)
	    return this.first;
	  else return this.rest.get(i-1);
	}
    /** Returns an IntList identical to L, but with
      * each element incremented by x. L is not allowed
      * to change. */
    public static IntList incrList(IntList L, int x) {
        if(L.rest==null)
          return new IntList(L.first+x,null);
        return new IntList(L.first+x,incrList(L.rest,x));        
    }

    /** Returns an IntList identical to L, but with
      * each element incremented by x. Not allowed to use
      * the 'new' keyword. */
    public static IntList dincrList(IntList L, int x) {
        if(L.rest==null)
          return new IntList(L.first-x,null);
        return new IntList(L.first-x,dincrList(L.rest,x));
    }

    public void addAdjacent ( ) {

    }
    
    public static void main(String[] args) {
        IntList L = new IntList(5, null);
        L.rest = new IntList(7, null);
        L.rest.rest = new IntList(9, null);

        System.out.println(incrList(L,5).get(3));
        System.out.println(L.iterativeSize());

	}
} 
