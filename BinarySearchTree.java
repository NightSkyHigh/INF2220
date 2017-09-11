class BinarySearchTree<T extends Comparable<? super T>>{

  private static class Node<T>{
    Node<T> left;
    Node<T> right;
    T data;
    Node(T data){
      this(data, null, null);
    }
    Node(T data, Node<T> left, Node<T> right){
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

  private Node<T> root;

  BinarySearchTree(){
    root = null;
  }

    public boolean isEmpty(){
      return root == null;
    }

    public boolean searchWord(T word){
        return searchWord(word, root);
    }

    private boolean searchWord(T word, Node<T> obj){

      if(obj == null){
        return false;
      }

      int res = word.compareTo( obj.data );

        if(res < 0){
          return searchWord(word, obj.left);
        }else if(res > 0){
          return searchWord(word, obj.right);
        }
          return true;
    }

    public void insert(T word){
      root = insert(root, word);
    }

    public Node<T> insert(Node<T> n, T word){
      if(n == null){
        return new Node<T>(word, null, null);
      }

      int res = word.compareTo(n.data);

      if((res < 0)){
        n.left = insert(n.left, word);
      } else if(res > 0){
        n.right = insert(n.right, word);
      }else{}
      return n;
    }
public T min(){
  if(isEmpty()){
    System.out.println("tree empty");
    return null;
  }
  return min(root).data;
}

public Node<T> min(Node<T> t){
    if(t == null){
      return null;
    } else if(t.left == null){
      return t;
    }
    return min(t.left);
  }

  public T max(){
    if(isEmpty()){
      System.out.println("tree empty");
      return null;
    }
    return max(root).data;
  }



  private Node<T> max(Node<T> t){
    if(t == null){
      return null;
    } else if (t.right == null){
      return t;
    }
    return max(t.right);
  }

    public void delete(T word){
      root = delete(root, word);
    }
    private Node<T> delete(Node<T> n, T word){
      if(n == null){
        System.out.println(word + " doesn't exist in this dictionary");
        return null;
      }
      int res = word.compareTo(n.data);

      if(res < 0){
        n.left = delete(n.left, word);
      }else if(res > 0){
        n.right = delete(n.right, word);
      } else if(n.right != null && n.left != null){
        n.data = min(n.right).data;
        n.right = delete(n.right, n.data);
      } else{
        if (n.left != null) {
          n = n.left;
        } else{
        n = n.right;
        }
      }
      return n;
    }

    public int findDepth(){
      return findDepth(root);
    }

    private int findDepth(Node<T> n){
      if(n == null){return 0;}
      int leftD = findDepth(n.left);
      int rightD = findDepth(n.right);
      int depth = (leftD > rightD) ? (leftD + 1) : (rightD + 1);
      return depth;
    }
    public float averageNodes(){
      return averageNodes(root, 0);
    }
    private float averageNodes(Node<T> n, float depth){
      if(n == null){return 0;}
      return depth + averageNodes(n.left, depth + 1) + averageNodes(n.right, depth + 1);
    }

    public int sumOfNodes(){
      return sumOfNodes(root);
    }
    private int sumOfNodes(Node<T> n){
      if(n == null){return 0;}
      return 1 + sumOfNodes(n.left) + sumOfNodes(n.right);
    }
  //  int index = 0;
  //  public float findMedian(){
  //    return findMedian(root);
  //  }
//    private float findMedian(Node<T> n){
//      if (n == null){
//        return null;
//      }
//      t = findMedian(n.left);
//      if(t != null){
//        return t;
//      }
//    }

}
