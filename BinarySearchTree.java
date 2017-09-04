class BinarySearchTree<T extends Comparable<T>>{
  private Node<T> root;

  BinarySearchTree(){
    root = null;
  }

  private class Node<T>{
    Node<T> left;
    Node<T> right;
    T data;
    Node(T data){
      this.data = data;
    }
    Node(T data, Node<T> left, Node<T> right){
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

    public boolean isEmpty(){
      return root == null;
    }

    public boolean boolean(T data){
        return contains(data,root)
    }

    private boolean contains(T data, Node<T> obj){
      if(obj == null){
        System.out.println(data + "Is not found in the dictionary");
        return false;
      }

        if(data.compareTo(obj.data) < 0){
          contains(data, obj.left);
        }else if(data.compareTo(obj.data) > 0){
          contains(data, obj.right);
        }else{
          return true;
          }
    }

    public void insert(){

    }
}
