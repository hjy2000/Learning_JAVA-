package others;

import java.util.Arrays;
import java.util.Scanner;

class TSP1 {
  /*
       金先生必须给 N 位顾客送冰箱。从办公室，他要去拜访所有的客户，然后回到他的家。办公室、他的家和客户的每个位置以整数坐标 (x,y) (0≤x≤100, 0≤y≤100) 的形式给出。
       两个任意位置 (x1, y1) 和 (x2, y2) 之间的距离由 |x1-x2| + |y1-y2|计算，其中 |x|表示 x 的绝对值；例如，|3|=|-3|=3。办公室、他的家和客户的位置都是不同的。
       您应该计划一种最佳方式来访问所有 N 个客户并在所有可能性中返回他。你会得到办公室、金先生家和客户的位置；顾客的数量在 5 到 10 之间。
       编写一个程序，从办公室开始，找到一条访问所有顾客并返回他家的最短路径。您的程序只需要报告（该）最短路径的距离。
       你不必有效地解决这个问题。您可以通过查找所有可能的方法找到答案。如果你能很好地查找所有的可能性，你会得到一个完美的分数。
       [约束]
       5≤N≤10。每个位置(x,y)都在有界网格中，0≤x≤100，0≤y≤100，x,y为整数。
       [输入]
       给你 10 个测试用例。每个测试用例由两行组成；第一行有 N，客户数量，下一行依次列举了办公室、Kim 先生家和客户的位置。每个位置都由坐标 (x,y) 组成，用“x y”表示。
       [输出]
       在 10 行中输出 10 个答案。每条线输出（该）最短路径的距离。每行看起来像“#x answer”，其中 x 是测试用例的索引。 ‘#x’和‘answer’用空格隔开。
       [输入/输出示例]
       输入（共20行。在第一个测试用例中，办公室和家的位置分别是（0, 0）和（100, 100），客户的位置是（70, 40），（30） , 10), (10, 5), (90, 70), (50, 20)。)
     5 ← Starting test case #1
     0 0 100 100 70 40 30 10 10 5 90 70 50 20
     6 ← Starting test case #2
     88 81 85 80 19 22 31 15 27 29 30 10 20 26 5 14
     10 ← Starting test case #3
     39 9 97 61 35 93 62 64 96 39 36 36 9 59 59 96 61 7 64 43 43 58 1 36
     ...

     Output (10 lines in total)
     #1 200
     #2 304
     #3 366
     ...
  */

}

class LCAProblem1 {
  Node node11=new Node("1");

  LCAProblem1()
  {

//    Node node21 = new Node(2);
//    Node node22 = new Node(3);
//    node11.left = node21;
//    node11.right = node22;
//    Node node31 = new Node(4);
//    node21.right = node31;
//    Node node32 = new Node(5);
//    Node node33 = new Node(6);
//    node22.left = node32;
//    node22.right = node33;
//    Node node41 = new Node(7);
//    node31.left = node41;
//    Node node42 = new Node(8);
//    Node node43 = new Node(9);
//    node32.left = node42;
//    node32.right = node43;
//    Node node44 = new Node(10);
//    Node node45 = new Node(11);
//    node33.left = node44;
//    node33.right = node45;
//    Node node51 = new Node(12);
//    node41.left = node51;
//    Node node52 = new Node(13);
//    node45.left = node52;
//    System.out.println("#1 "+this.LCA(node11,node32,node52).val+" "+nodeNumOfSubTree(this.LCA(node11,node32,node52)));
  }
  public void insert()
  {
    Scanner sc=new Scanner(System.in);
    int tag=0;

    for (int i = 0; i < 1; i++) {
      String line1=sc.nextLine();
      String line2=sc.nextLine();
      String []line1item=line1.split(" ");
      String []line2item=line2.split(" ");
      String V= line1item[0];
      String E=line1item[1];
      String a=line1item[2];
      String b=line1item[3];
      for (int j = 0; j < line2item.length; j+=2) {
        Node n=new Node(j+2+"");

      }
      System.out.println(Arrays.toString(line1item));
      System.out.println(Arrays.toString(line2item));

    }
  }
  /*
      您将在二叉树中找到两个顶点的最近共同祖先。例如下图中顶点8和13的共同祖先是顶点3和1。其中，顶点3最接近顶点8和13。而子树的大小（顶点数） 以顶点 3 为根的子树）为 8。
      给定一棵二叉树和两个顶点，编写一个程序，找到最近的共同祖先并计算以最近共同祖先为根的子树的大小。
      如果两个给定顶点之一是另一个顶点的祖先，则不给出输入。 例如，上述树中的“11 和 3”是无效输入。 因此，您的程序不必考虑这种情况。

      [输入]
      给你 10 个测试用例。
      每个测试用例有两行，因此总行数为 20。
      在每个测试用例中，第一行由四个整数组成，V（树中的顶点数）、E（边数）和 两个顶点的索引。
       E 边列在下一行。 每条边由两个顶点表示； 父顶点的索引总是在子顶点的索引之前。
       例如，连接顶点 5 和 8 的边用“5 8”表示，而不是“8 5”。
       没有给出边缘的顺序。 输入中的每个连续整数都用空格分隔。

      给定 10 个测试用例，
      前 4 个测试用例包含少量顶点（每个 3、5、7、10 个）。
      接下来的 6 个测试用例包含相同或大于 50 个顶点。

      顶点的索引是从 1 到 V 的整数，根顶点的索引始终为 1。
      保证父顶点的索引小于子顶点。
      在这个问题中，孩子是父母的左孩子还是右孩子并不重要；所以你可以任意决定。

      [输出]
      在 10 行中输出 10 个答案。每行以“#x”开头，表示测试用例的索引，并在空格后写下答案。答案有两个整数：最近的共同祖先的索引和以最近的共同祖先为根的子树的大小。这两个整数也用空格隔开。

      [输入/输出示例]
      输入（共20行）
      13 12 8 13 ← 第一个输入的开始
      1 2 1 3 2 4 3 5 3 6 4 7 7 12 5 9 5 8 6 10 6 11 11 13
      10 9 1 10 ← 第二个输入的开始
      1 2 2 3 3 4 4 5 5 6 6 7 7 8 8 9 9 10
      …
      输出（共10行）
      #1 3 8
      #2 1 10
  */

  /**
   *        1
   *     /    \
   *    2      3
   *     \   /   \
   *      4 5     6
   *     / / \   / \
   *    7 8   9 10  11
   *   /            /
   * 12            13
   *
   */

  public Node LCA(Node root,Node a,Node b) {
    if(root==null)
    {return null;}
    if(root==a||root==b)
    {
      return root;
    }
    Node left = LCA(root.left, a, b);
    Node right = LCA(root.right, a, b);
    // If both nodes lie in left or right then their LCA is in left or right,
    // Otherwise root is their LCA
    if (left != null && right != null) {//一左一右 说明祖先就是root
      return root;
    }
    return (left != null) ? left : right;
  }
  int num;
  public int nodeNumOfSubTree(Node root)
  {
    if(root==null)
    {
      return 0;
    }
    if(root.left==null&&root.right==null)
    {
      return 1;
    }
    if(root.left!=null)
    {
      num+=1;
      nodeNumOfSubTree(root.left);
    }
    if(root.right!=null)
    {
      num+=1;
      nodeNumOfSubTree(root.right);
    }
   return num+1;
  }
}

class Samsung_Tires {
  /*
    三星轮胎在推出之前。在其产品推出之前，它将测试轮胎的安全性。为了启动轮胎，轮胎必须总共通过 N 次测试。
  每个测试都由“inflate”和“deflate”构成。每个测试首先以“inflate”开始，然后是“deflate”。
  只要所有N个测试用例都执行完，就可以随机选择测试顺序。三星轮胎的最大气压为K。如果轮胎内部气压超过K或小于0，则轮胎损坏。
  例如，给定最大轮胎气压K=100，初始气压为60，以下两种情况下的轮胎都会损坏。
  给定 N、K 和 N 个测试用例，找出测试顺序，使初始轮胎气压最小。
  打印初始气压值！ （但是，如果没有正确答案，则打印“-1”。）
  例如，假设有 3 个测试用例（N=3），如下所示，最大轮胎气压为 100（K=100）。
  下面显示了测试顺序，以便可以最小化初始轮胎气压，在这种情况下为 15。 （蓝色数字表示“充气”或“放气”后的气压。）
  以下是轮胎损坏的示例，与初始气压和测试顺序无关。
  (N=2, K=100) 答案是“-1”。

  [约束]

  1<=N<=8
  50<=K<=200

  [输入]

  第一行包含一个整数 T——总测试用例的数量。
  从每个测试用例的下一行给出。
  每个测试用例由 3 行组成。
  第一行包含 N、K。
  第二行包含每个测试用例的“inflate”值，第三行包含每个测试用例的“deflate”值。

  [输出]
  打印“#t”（不带引号），留一个空格并打印答案。（T 表示测试用例编号，从 1 开始。）

  输入示例

  5
  3 100
  75 45 80
  30 55 95
  2 100
  65 90
  20 30
  5 150
  35 105 100 45 75
  115 75 55 35 105
  7 150
  70 95 15 65 85 75 55
  105 80 10 90 115 110 45
  8 200
  35 30 50 80 70 15 10 40
  70 20 20 85 65 40 25 50

  输出示例
  #1 15
  #2 -1
  #3 25
  #4 -1
  #5 45
     */

}

class dungeon_master {
  /*
    【题目描述】
  这题是一个三维的迷宫题目，其中用‘.’表示空地，‘#’表示障碍物，‘S’表示起点，‘E’表示终点.
  求从起点到终点的最小移动次数，解法和二维的类似，只是在行动时除了东南西北移动外还多了上下。
  可以上下左右前后移动，每次都只能移到相邻的空位，每次需要花费一分钟，求从起点到终点最少要多久。

  这题用BFS解，每次去队首元素，如果是终点则输出结果移动的次数，否则，从该点开始分别向东南西北上下移动（如果可以走的话）并继续搜，如果到队列为空还没搜到解法，则说明无解。
  【输入】
  多组测试数据。
  一组测试测试数据表示一个三维迷宫：
  前三个数，分别表示层数、一个面的长和宽，后面是每层的平面图。前三个数据为三个零表示结束。
  【输出】
  最小移动次数。

  【输入样例】
  3 4 5
  S....
  .###.
  .##..
  ###.#
  #####
  #####
  ##.##
  ##...
  #####
  #####
  #.###
  ####E
  1 3 3
  S##
  #E#
  ###
  0 0 0
  【输出样例】
  Escaped in 11 minute(s).
  或者
  Trapped!
     */
}

class Node {
  String val;
  Node left;
  Node right;

  Node(String x) {
    this.val = x;
  }
}

public class Samsung_interview_practice {
  public static void main(String[] args) {
    LCAProblem1 l1=new LCAProblem1();
    l1.insert();
  }
}
