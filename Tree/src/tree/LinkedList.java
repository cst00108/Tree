package tree;

import java.util.Comparator;
//import java.util.List;

class LinkedList implements Iterator, Iteratable{
	private Goody root = null;
	private Goody butt = null;
	private Goody iterator = null;
	
	void add(Comparable failedTreeBulb){
		if(root == null){
			root = butt = new Goody(failedTreeBulb);
		} else {
			butt.goody = new Goody(failedTreeBulb);
			butt = butt.goody;
		}
	}

	
	public Comparable next(){
		if(iterator == null){
			return null;
		}
		
		Comparable toReturn = iterator.failedTreeBulb;
		iterator = iterator.goody;

		return toReturn;
	}
	
	
	public Iterator iterator(){
		iterator = root;
		//System.out.println("XXX LinkedList.iterator:  " + iterator);
		
		return this;
	}
	
	
	public String toString(){
		//Iterator iterator = this.iterator();
		Goody goody = root;
		String toReturn = "";
		
		while(goody != null){
			toReturn += (goody.failedTreeBulb.toString());
			
			goody = goody.goody;
			
			if(goody != null){
				toReturn += "  ===>  ";
			}
		}

		
		return toReturn;
	}
	

	private class Goody{
		Comparable failedTreeBulb = null; 
		Goody goody = null;
		
		private Goody(Comparable failedTreeBulb){
			this.failedTreeBulb = failedTreeBulb;
		}
	}
}
