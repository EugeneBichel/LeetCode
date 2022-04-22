# Tree

Definition
 A Tree is:
    - empty, or
    - a node with:
     - a key, and
     - a list of child trees

## Trees

- Syntax Tree for a Sentence (I ate the cake)
- Syntax Tree for an Expression (2sin(3z - 7))
- Geography Hierarchy, Animal Kingdom
- Abstract Syntax Tree for Code
 `while x < 0:
    x = x + 2
    foo(x)`
- Binary Search Tree
- Simple Tree 
    - Empty tree:
    - Tree with one node: Fred
    - Tree with two nodes: Fred - Sally
    
## Walking a Tree
 visit the nodes of a tree in a particular order.
 - Depth-first: we completely traverse one sub-tree before
  exploring a sibling sub-tree
 - Breadth-first: we traverse all nodes at one level 
  before progressing to the next level
  
  
  #### Breadth-first traversal:
   - LevelTraversal(tree)
    `if tree == nil
        return;
     Queue q;
     q.Enqueue(tree)
     while not q.Empty():
        node <- q.Dequeue()
        Print(node)
        if node.left != nil:
            q.Enqueue(node.left)
        if node.right != nil:
            q.Enqueue(node.right)`
  
  ### Walking a binary search tree
  - InOrderTraversal(tree)
   `if tree == nil:
        return;
    InOrderTraversal(tree.left)
    Print(tree.key)
    InOrderTraversal(tree.right)`
    
  - PreOrderTraversal(tree)
  `if tree == nil
        return;
   Print(tree.key)
   PreOrderTraversal(tree.left)
   PreOrderTraversal(tree.right)` 
   
  - PostOrderTraversal(tree)
  `if tree == nil
        return;
   PostOrderTraversal(tree.left)
   PostOrderTraversal(tree.right)
   Print(tree.key)` 