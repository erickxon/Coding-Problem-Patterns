import java.util.*;

class TreeNode{
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x){
    val = x;
  }
  
}

class LevelOrderTraversal{
  public static List<List<Integer>> traverse(TreeNode root){
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if(root==null)
      return result;
    
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while(!queue.isEmpty()){
      int levelSize = queue.size();
      List<Integer> currentLevel = new ArrayList<>(levelSize);
      for(int i=0;i < levelSize;i++){
        TreeNode currentNode = queue.poll();
        //add the node to the current level
        currentLevel.add(currentNode.val);
        //insert the children of the current node in the queue
        if(currentNode.left!=null)
          queue.offer(currentNode.left);
        if(currentNode.right!=null)
          queue.offer(currentNode.right);
      }
    result.add(currentLevel);
    }
   return result; 
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    List<List<Integer>> result = LevelOrderTraversal.traverse(root);
    System.out.println("Level order traversal: " + result);
  }
}