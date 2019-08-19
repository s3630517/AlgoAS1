import java.io.PrintWriter;
import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
import java.util.Arrays;
/**
 * Sequential Tree Representation implementation for the {@link BSPTree} interface.
 * <p>
 * Your task is to complete the implementation of this class.
 * You may add methods, but ensure your modified class compiles and runs.
 *
 * @author Jeffrey Chan, 2016.
 * @author Yongli Ren, 2019.
 */
public class SequentialRepresentation<T> implements BSPTree<T> {

    /**
     * Constructs empty graph.
     */ 
	int size = 100;
	T[] treeArray = (T[]) new Object[size];
	T root;
	T left, right;

    public SequentialRepresentation() { 
        // Implement me!
		root = null;
        left = null;
        right = null;
		
		
		for(int i=0; i< treeArray.length;i++){
			treeArray[i] = (T) EMPTY_NODE;
		}
    } // end of SequentialRepresentation()

    @Override
    public void setRootNode(T nodeLabel) {
        // Implement me!
		//String rootNode = (String) nodeLabel;
		//treeArray[0] = rootNode;
		if(root==EMPTY_NODE){
			root = nodeLabel;
			
			System.out.println("testsetrootnode");
		}else{
			System.out.println("rootnodealreadyexists");
		}
		//System.out.println(Arrays.toString(treeArray));
    } // end of setRootNode()

    @Override
    public void splitNode(T srcLabel, T leftChild, T rightChild) {
        // Implement me!
		int j=0;
		boolean found = false;
		for(int i=0; i<treeArray.length; i++) {
			if(treeArray[i].equals(srcLabel)){
				j = (i * 2) + 1;
				treeArray[j]=leftChild;
				treeArray[j+1]=rightChild;
				//System.out.println("testif");
				System.out.println(Arrays.toString(treeArray));
				found = true;
				break;
			}
			//System.out.println(treeArray[i]);
		}
		if (!found) {
			//System.out.println("node not found" + treeArray[i]);
		}
		
    } // end of splitNode

    @Override
    public boolean findNode(T nodeLabel) {
        // Implement me!
		for(int i=0; i<treeArray.length; i++) {
			if(treeArray[i].equals(nodeLabel)){
				//System.out.println("testfind "+treeArray[i]);
				return true;
			}
		}
		
        return false;
    } // end of findNode

    @Override
    public String findParent(T nodeLabel) {
        // Implement me!
		String out = null;
		for(int i=0; i<treeArray.length; i++) {
			if(treeArray[(i * 2) + 1].equals(nodeLabel) || treeArray[(i * 2) + 2].equals(nodeLabel)){
				out = nodeLabel+" "+ treeArray[i];
				return out;
			}
		}
        return null;
    } // end of findParent

    @Override
    public String findChildren(T nodeLabel) {
        // Implement me!
		int j=0;
		String left;
		String right;
		String out;
		for(int i=0; i<treeArray.length; i++) {
			if(treeArray[i].equals(nodeLabel)){
				j = (i * 2) + 1;
				left=(String) treeArray[j];
				right=(String) treeArray[j+1];
				out = nodeLabel+" "+left+" "+right;
				return out;
			}else {
				//System.out.println("node not found" + treeArray[i]);
			}
		}
        return null;
    } // end of findParent
	
	private void preOrder(T test) {
		String in;
		if (test == null) {
			System.out.println("hello test");
			return;
		}
		
		in = findChildren(test);
		String split[] = in.split(" ", 3);
		//if(left.matches("[A-Z]{1}")){
			left = (T)split[1];
			//right =(T)split[2];
			System.out.println("hello test2" + left);
			//preOrder(left);
		//}
		//preOrder(right);
	}
	
    @Override
    public void printInPreorder(PrintWriter writer) {
        // Implement me!
		root= treeArray[0];
		preOrder(root);
		
		for(int i=0; i<treeArray.length; i++) {
			writer.print(treeArray[i]);
		}
		
    } // end of printInPreorder

    @Override
    public void printInInorder(PrintWriter writer) {
        // Implement me!
    } // end of printInInorder

    @Override
    public void printInPostorder(PrintWriter writer) {
        // Implement me!
    } // end of printInPostorder

} // end of class SequentialRepresentation