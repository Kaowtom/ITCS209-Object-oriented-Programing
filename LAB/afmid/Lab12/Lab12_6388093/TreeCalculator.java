
public class TreeCalculator {

		
	public static int findMax(Node root)
	{	//****YOUR CODE HERE**
		if(root == null) return -1;
		int max = root.id;
		int lMax = findMax(root.left);
		int rMax = findMax(root.right);
		max = root.id;
		lMax = findMax(root.left);
		rMax = findMax(root.right);
		if(lMax > max) {
			max = lMax;
		}
		if(rMax > max) {
			max = rMax;
		}
		return max;
		//*********************
	}
	
	
	public static int findMin(Node root)
	{	//****YOUR CODE HERE**
		if(root == null) {
			return -1;
		}
		int lMin = findMin(root.left);
		int rMin = findMin(root.right);
		int min = root.id;
		
		if(root.left!=null) {
			if(lMin <= min) {
				min = lMin;
			}
		}
		if(root.right != null) {
			if(rMin <= min) {
				min = rMin;
			}
		}
		return min;
		//*********************
	}
	
	//************* BONUS ****************//
	public static double sumTree(Node root)
	{	
		//****YOUR CODE HERE**
		if(root == null) return 0; 
		return root.id+sumTree(root.left)+sumTree(root.right);
		//*********************
	}
	
	public static double avgTree(Node root)
	{
		//****YOUR CODE HERE**
		if(root == null) return 0;
		return sumTree(root)/size(root);
		//*********************
	}
	public static int size(Node root) {
		if(root == null) return 0;
		return size(root.left)+size(root.right)+1;
	}
	
}
