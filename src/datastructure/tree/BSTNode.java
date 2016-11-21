package datastructure.tree;

public class BSTNode<T> {
    protected Comparable<T> el;
    protected BSTNode<T> left, right;
    
    public BSTNode() {
        left = right = null;
    }
    
    public BSTNode(Comparable<T> el) {
        this(el,null,null);
    }
    
    public BSTNode(Comparable<T> el, BSTNode<T> lt, BSTNode<T> rt) {
        this.el = el; left = lt; right = rt;
    }
    
    @Override
    public String toString(){
    	if(el==null) return " - ";
    	String l = (left==null)?"-":left.el.toString();
    	String r = (right==null)?"-":right.el.toString();
    	  	return el.toString() + " [" + l + "," + r + " ]" ;
    }
}
