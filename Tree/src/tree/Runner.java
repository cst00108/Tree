/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree;

/**
 *
 * @author jay
 */
public class Runner {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		// TODO code application logic here
				
		Tree tree = new Tree();

		tree.add("butt");
		tree.add("Jason");
		tree.add("other private parts");
		tree.add("bb");
		tree.add("bachlor");
		
		System.out.println("Finished adding");
				
		System.out.println("Array:");
		Comparable[] c = tree.toArray();
		for(int index=0; index<c.length; index++){
			System.out.println("\t" + c[index]);
		}

		System.out.println("Iterator:");
		Iterator iterator = tree.iterator();
		Comparable juice = null;
		while((juice=iterator.next()) != null){
			System.out.println("\t" + juice);
		}
	}
	
}
