package tree;

public class Tree implements Iterator, Iteratable{
	private Branch root = null;
	private Iterator iterator = null;
	private int xmasBulbs = 0;
	
	
	public void remove(Comparable xmasBulb){
		
	}
	
	
	//both branches are full
	private Branch removeFullBranch(Branch remove){
		remove.right
		Branch move = removeLeftest()
	} 
	
	//removes branch with 0 or 1 children
	private Branch removeNotFullBranch(
			Branch remove, Branch parent, boolean isLeftBranch){

		Branch child;
		
		//dont really give a crap if 'remove' has no children
		if(remove.left != null){
			child = remove.left;
		} else { 
			child = remove.right;
		}
		
		if(isLeftBranch){
			parent.left = child;
		} else {
			parent.right = child;
		}
		
		return remove;
	}
	
	private static boolean isFull(Branch branch){
		if(branch.left != null && branch.right != null) return true;
		
		return false;
	}
	
	//if both branches are full
	private void removeFromFull(Branch remove){
		Branch parent = remove;
		Branch move = parent.right; //
		
		while(move.left != null){
			parent = move;
			move = move.left;
		}
		
		parent.left = move.right; //remove 'move' and re-attach tree if there
		
		//replace removed branch
		move.left = remove.left;
		move.right = remove.right;
	}
	
	public void add(Comparable xmasBulb){
		if(root == null){
			root = new Branch(xmasBulb);
			xmasBulbs++;
		} else {
			add(xmasBulb, root, 1);
		}
	}
	

	public void add(Comparable xmasBulb, Branch parent, int recLevel){
		int parentCompare = xmasBulb.compareTo(parent.xmasBulb);
		
		if(parentCompare < 0){
			if(parent.left == null){
				parent.left = new Branch(xmasBulb);
				xmasBulbs++;

				//System.out.println(recLevel + "  adding to left");
			} else{
				//System.out.println(recLevel + "  recursing left");
				add(xmasBulb, parent.left, recLevel+1);
			}
		} else if(parentCompare > 0){
			if(parent.right == null){
				parent.right = new Branch(xmasBulb);
				xmasBulbs++;

				//System.out.println(recLevel + "  adding to right");
			} else{
				//System.out.println(recLevel + "  recursing right");
				add(xmasBulb, parent.right, recLevel+1);
			}
		}
		
		//otherwise, get out of here.  its the same.
	}
	
	
	public Comparable[] toArray(){
		Comparable[] toReturn = new Comparable[xmasBulbs];
		
		getArray(toReturn, 0, root);
		
		return toReturn;
	}
	
	
	public int getArray(Comparable[] toReturn, int filled, Branch parent){
		if(parent.left != null){
			filled = getArray(toReturn, filled, parent.left);
		}
		
		toReturn[filled] = parent.xmasBulb;
		filled++;
		
		if(parent.right != null){
			filled = getArray(toReturn, filled, parent.right);
		}
		
		return filled;
	}
		
	
	public Comparable next(){
		return iterator.next();
	}
	
	
	public Iterator iterator(){
		iterator = getIterator(new LinkedList(), root).iterator();
		
		return iterator;
	}
	
	
	private LinkedList getIterator(LinkedList list, Branch branch){
		if(branch.left != null){
			getIterator(list, branch.left);
		}
		
		list.add(branch.xmasBulb);
		//System.out.println("Tree.getIterator():  " + list);
		
		if(branch.right != null){
			getIterator(list, branch.right);
		}
		
		return list;
	}
		
	
	private class Branch{
		Comparable xmasBulb = null;
		Branch left = null;
		Branch right = null;
		
		private Branch(Comparable xmasBulb){
			this.xmasBulb = xmasBulb;
		}

/*		private Branch() {
			//do nothing but create null instance variables
		}
		
		private Branch add(Comparable xmasBulb){
				this.xmasBulb = xmasBulb;
				
				return this;
		}
		
		private int compareTo(Branch branch){
			return this.xmasBulb.compareTo(branch.xmasBulb);
		}
*/	}
}
