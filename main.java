import java.util.*;
import java.io.*;
import java.lang.Math;

class main{
  public static void main(String[] args) {
    int depthCurrent = 0;
    String file = "dictionary.txt";
    BinarySearchTree<String> tree = new BinarySearchTree<String>();
    PrintWriter output = null;
    Scanner in = new Scanner(System.in);
    try{
    Scanner scan = new Scanner(new File(file));

    while(scan.hasNextLine()){
        tree.insert(scan.nextLine());
    }

  }catch(FileNotFoundException e){
      System.out.println("file not found");
      e.printStackTrace();
      System.exit(1);
    }
    try{
        output = new PrintWriter("Statistics.txt", "UTF-8");

    String input = "";
    while(!(input.equalsIgnoreCase("Q"))){
      System.out.println("\n-----------------------------");
      System.out.println("What do you want to do?");
      System.out.println("1: Insert a word");
      System.out.println("2: seach for a word");
      System.out.println("3: Remove a word");
      System.out.println("Q: Quit");
      System.out.println("-----------------------------\n");
      input = in.nextLine().toLowerCase();
      switch (input) {
        case "1": System.out.println("What word would you like to insert?");
                  input = in.nextLine().toLowerCase();
                  tree.insert(input);
                  break;
        case "2": System.out.println("what word are you searching for?");
                  input = in.nextLine().toLowerCase();
                  boolean found = tree.searchWord(input);
                  String msg = (found) ? input + " was found in dictionary\n" : "sorry " + input + " was not found in the dictionary\n";
                  System.out.println(msg);
                  if(!found){
                    System.out.println("searching for similar words...\n");
                    SimilarWords sim = new SimilarWords(input);
                    String[] words = sim.similarList();
                      for (int i = 0; i < words.length; i++ ) {
                        if (words[i] == null) {
                          break;
                        }
                        boolean tru = tree.searchWord(words[i]);
                        if(tru){
                          System.out.println("");
                          System.out.println("Did you mean " + words[i] + " instead?");
                          output.printf("-----Similar words----- \n");
                          output.printf("Did you mean " + words[i] + " instead?\n");
                        }
                      }
                  }
                  break;
        case "3": System.out.println("what word would you like to remove?");
                  input = in.nextLine().toLowerCase();
                  tree.delete(input);
                  break;
        case "q": System.out.println("First alphabetically word: " + tree.min());
                  System.out.println("Last alphabetically word: " + tree.max());
                  System.out.println("depth of Tree: " + tree.findDepth());
                  System.out.println("average Depth of all nodes: " + (tree.sumDepth()/tree.sumOfNodes()));
                  System.out.println("Nodes per depth:");
                  for (int number : tree.getDepthByNode()){System.out.println( depthCurrent +": " + number + " nodes"); depthCurrent++;}
                  output.printf("First alphabetically word: " + tree.min() + "\n");
                  output.printf("Last alphabetically word: " + tree.max() + "\n");
                  output.printf("depth of Tree: " + tree.findDepth() + "\n");
                  output.printf("average Depth of all nodes: " + (tree.sumDepth()/tree.sumOfNodes()) + "\n");
                  depthCurrent = 0;
                  for (int number : tree.getDepthByNode()){output.printf( depthCurrent +": " + number + " nodes \n"); depthCurrent++;}

                  break;
        default:  System.out.println("not a valid input");
                  break;
      }
    }
  }catch(IOException e){
    System.out.println("could not write to file");
    e.printStackTrace();
  } finally{
    output.close();
  }
  }
}
