# Breadth First Search
``` 
* Breadth first search is a pattern involving tree level-by-level order tree traversal.
  * It uses a queue in order to perform this
  * the space complexity is O(W), where W is the maximum number of nodes on any level
```

# Binary Tree Level Order Traversal

```
Given a binary tree, populate an array to represent its level-by-level traversal. You should populate the values of all nodes of each level from left to right in separate sub-arrays.
```

```java
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

```

**Time Complexity**: O(N), where N is the total number of nodes in the tree

**Space Complexity**: O(N) because we need to return a list containing the level order traversal. At the lowest level, we need a queue with N/2 capacity. This means it is O(N).


# Reverse Level Order Traversal
```
Given a binary tree, populate an array to represent its level-by-level traversal in reverse order, i.e., the lowest level comes first. You should populate the value of all nodes in each level from left to right in separate arrays.
```

## Solution
```
The main trick: append the beginning of the traversal to the end of the result list. Reversing a queue typically involves counterintuitively adding to the beginning of the queue instead of adding to the end of queue.
Change appending to the queue to append to the beginning of the list during every iteration.
```
This involves changing

<code>
result.add(currentLevel); //appends to the end of the queue
</code> <br>
to <br>
<code>
result.add(0,currentLevel);
</code>


**Time Complexity**: O(N), where N is the total number of nodes in the tree

**Space Complexity**: O(N) because we need to return a list containing the level order traversal. At the lowest level (the first level this time), we need a queue with N/2 capacity. This means it is O(N).


# Zig Zag Traversal
```
Given a binary tree, populate an array to represent its zigzag level order traversal. You should populate the values of all nodes of the first level from left to right, then right to left for the next level and keep alternating in the same manner for the following levels.
```


## Solution
```
The main trick: 
- keep an odd/even tracker and alternate adding left or right node first.
- alternatively, you can store a boolean value that is switched every iteration.
```

```java
boolean leftToRight=true;
for(int i =0;i<levelSize;i++){
      TreeNode currentNode = queue.poll();

      //add the node to the current level based on the traverse direction
      if(leftToRight)
        currentLevel.add(currentNode.val);
      else
        currentLevel.add(0,currentNode.val); //reverse = always adding to the beginning instead of end
      
      //insert the children of the node into the queue
      if(currentNode.left!=null)
        queue.offer(currentNode.left);
      if(currentNode.right!=null)
        queue.offer(currentNode.right);

    }
```

