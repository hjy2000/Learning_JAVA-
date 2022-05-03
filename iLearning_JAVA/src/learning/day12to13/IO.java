package learning.day12to13;
// IO分为文件流（外存数据）和缓冲流（内存数据）
// 具体分为转换流、标准IO流、打印流、数据流、对象流（序列化，反序列化）、随机存取文件流(任意位置插入读取)
// 文件字节流其实非常通用 大部分文件都可以转换为二进制再操作

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

class File1 {
  public void test() {
    File f = new File("G:\\Java projects\\iLearning_JAVA\\src\\learning\\day12to13\\t.txt");
    // 这里用/可以（unix写法） 或者\\转义也可以（win写法）
    File f1 = new File("src/learning/day12to13", "ttt.txt");
    File f3 = new File("./");
    //        File f2=new File(File.separator); //可以用File.separator做分隔符
    // File类只能操作文件 不能操作文件内容
    System.out.println(f.getName()); // 获取当前文件名
    System.out.println(f3.getName()); // 获取当前目录
    System.out.println(f.getPath()); // 获取当前路径
    System.out.println(f.getAbsolutePath()); // 获取绝对路径
    System.out.println(f.getAbsoluteFile()); // 绝对路径构建的File类对象
    System.out.println(f.getParent()); // 父级路径
    //        f.renameTo(new File("G:\\Java
    // projects\\iLearning_JAVA\\src\\learning\\day12to13\\ttt.txt"));//重命名
    //        f1.renameTo(new File("src/learning/day12to13/123.txt"));//相对路径 同级是项目根目录
    System.out.println(f.exists()); // 文件或文件夹是否存在
    System.out.println(f.canRead()); // 是否可读
    System.out.println(f.canWrite()); // 是否可写
    System.out.println(f.isFile()); // 是否为文件
    System.out.println(f.isDirectory()); // 是否为文件夹
    System.out.println(f.lastModified()); // 获取最后修改时间（毫秒）
    System.out.println(f.length()); // 文件长度 字节数
  }

  public void test1() {
    File f = new File("src/app/app.py");
    if (!f.exists()) {
      try {
        f.createNewFile(); // 新建文件并捕获异常
      } catch (IOException e) {
        e.printStackTrace();
        throw new RuntimeException(e);
      }
    }
    //        f.delete();//删除文件
  }

  public void test2() {
    File f = new File("src/learning/day12to13/ccc");
    File f1 = new File("src/learning/day12to13/a/b/c");
    f.mkdir(); // 创建单层目录 目录多层就要执行多次
    f1.mkdirs(); // 创建多层目录
  }

  public void test3() {
    File f = new File("src/learning/day12to13");
    String[] l = f.list(); // 输出当前目录下所有文件和文件夹
    for (String s : l) {
      System.out.println(s);
    }

    File[] ll = f.listFiles(); // 返回当前目录下所有文件和文件夹对象的数组
    for (File s : ll) {
      System.out.println(s);
    }
  }

  public void test4(File f) {
    // 递归遍历目录下所有文件和文件夹 无论层级多深
    if (f.isFile()) {
      System.out.println(f.getAbsolutePath() + "  是文件");
    } else {
      System.out.println(f.getAbsolutePath() + "  是文件夹");
      File[] fs = f.listFiles(); // 拿到目录下所有文件和文件夹的对象
      if (fs != null && fs.length > 0) {
        for (File f1 : fs) {
          test4(f1);
        }
      }
    }
  }

  public void test5() {
    // 文件字节输入流
    try {
      FileInputStream f =
          new FileInputStream("G:\\Java projects\\iLearning_JAVA\\src\\learning\\day12to13\\t.txt");
      byte[] b = new byte[100];
      int len = 0;
      while ((len = f.read(b)) != -1) {
        //                f.read(b);
        // read方法返回值是读取文件的长度 到达文件尾后再向后读一位就是返回-1
        System.out.println(new String(b, 0, len)); // 逐步读取 第一个是缓冲数据的数组 第二个参数是偏移量 第三个是文件长度
      }
      f.close(); // 流要关闭
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void test6() {
    // 文件字节输出流
    try {
      // 追加模式
      FileOutputStream f =
          new FileOutputStream(
              "G:\\Java projects\\iLearning_JAVA\\src\\learning\\day12to13\\t123.txt", true);
      String s = "zztztztztztztztzt";
      f.write(s.getBytes()); // 将字节流写进内存
      f.flush(); // 写进文件
      f.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void copy() {
    // 字节流复制文件
    try {
      FileInputStream fin =
          new FileInputStream(
              "G:\\Java projects\\iLearning_JAVA\\src\\learning\\day12to13\\t123.txt");
      FileOutputStream fout =
          new FileOutputStream(
              "G:\\Java projects\\iLearning_JAVA\\src\\learning\\day12to13\\t123_copy.txt");
      byte[] b = new byte[50];
      int len;
      while ((len = fin.read(b)) != -1) {
        fout.write(b, 0, len);
      }
      fout.flush();
      fout.close();
      fin.close();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void fReader(String inPath) // 字符输入流
      {
    try {
      FileReader f = new FileReader(inPath); // 文件字符输入流对象
      char[] c = new char[20];
      int len = 0;
      while ((len = f.read(c)) != -1) {
        System.out.println(new String(c, 0, len));
      }
      f.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void fWriter(String text, String outPath) // 字符输出流
      {
    try {
      // 追加模式
      FileWriter f = new FileWriter(outPath, true);
      f.write(text); // 这里不需要getBytes()
      f.flush();
      f.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void fCharCopy(String inPath, String outPath) // 字符流拷贝文件 只适用于字符文件
      {
    try {
      FileReader fr = new FileReader(inPath);
      FileWriter fw = new FileWriter(outPath);
      int len = 0;
      char[] c = new char[30];
      while ((len = fr.read(c)) != -1) {
        fw.write(c, 0, len);
      }
      fw.flush();
      fw.close();
      fr.close();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  // 字节和字符流操作外存
  // 下面的缓冲流操作内存 速度快
  public void bInputStream(String inPath) throws Exception {
    try {
      FileInputStream fis = new FileInputStream(inPath);
      BufferedInputStream fbs = new BufferedInputStream(fis); // 将文件字节输入流放进缓存字节输入流中
      int len = 0;
      byte[] b = new byte[30];
      while ((len = fbs.read(b)) != -1) {
        System.out.println(new String(b, 0, len));
      }
      fbs.close();
      fis.close();
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
  }

  public void bOutputStream(String outPath) throws Exception {
    FileOutputStream fos = null;
    try {
      fos = new FileOutputStream(outPath);
      BufferedOutputStream bos = new BufferedOutputStream(fos);
      String s = "helloworld";
      // String就要加getbytes()函数
      bos.write(s.getBytes());
      bos.flush();
      bos.close();
      fos.close();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public void bCopyStream(String inPath, String outPath) {
    try {
      FileInputStream f1 = new FileInputStream(inPath);
      BufferedInputStream bf1 = new BufferedInputStream(f1);
      FileOutputStream f2 = new FileOutputStream(outPath);
      BufferedOutputStream bf2 = new BufferedOutputStream(f2);
      int len = 0;
      byte[] b = new byte[20];
      while ((len = bf1.read(b)) != -1) {
        bf2.write(b, 0, len);
      }
      bf2.flush();
      bf2.close();
      f2.close();
      bf1.close();
      f1.close();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public void testInputStreamReader(String inPath, String outPath) throws Exception {
    // UTF-8为汉字常用编码，操作字符文件时，字节流转换为字符流操作更高效
    try {
      FileInputStream fs = new FileInputStream(inPath);
      // 字节流转换为字符流
      InputStreamReader isr = new InputStreamReader(fs, StandardCharsets.UTF_8);
      char[] c = new char[20];
      int len;
      while ((len = isr.read(c)) != -1) {
        System.out.println(new String(c, 0, len));
      }
      isr.close();
      fs.close();
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
  }

  /** 标准输入输出流 输入是键盘 输出到显示器 */
  public void stdin() throws IOException {
    // 创建接收键盘输入的字符输入流
    InputStreamReader in = new InputStreamReader(System.in);
    // 将输入流放入缓冲流
    BufferedReader bf = new BufferedReader(in);
    String s = "";
    while ((s = bf.readLine()) != null) {
      System.out.println(s);
    }
    bf.close();
    in.close();
  }

  /**
   * @throws IOException 标准输出流
   */
  public void stdout(String outPath) throws IOException {
    // 创建接收键盘输入的字符输入流
    InputStreamReader in = new InputStreamReader(System.in);
    // 将输入流放入缓冲流
    BufferedReader bf = new BufferedReader(in);
    FileOutputStream f2 = new FileOutputStream(outPath);
    //    OutputStreamWriter out=new OutputStreamWriter(System.out);
    String s = "";
    while ((s = bf.readLine()) != null) {
      if (s.equals("over")) {
        break;
      }
      System.out.println(s);
      f2.write(s.getBytes());
    }
    bf.close();
    in.close();
  }

  public void ioTest() {
    System.out.println("请输入：");
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = null;
    try {
      str = br.readLine();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    System.out.println(str);

    System.out.println("请输入：");
    Scanner sc = new Scanner(System.in);
    String name = sc.next(); // next()读取String类型的值
    int age = sc.nextInt(); // nextInt()读取int类型的值
    double weight = sc.nextDouble(); // nextDouble()读取double类型的值
    System.out.println("姓名：" + name + ", 年龄：" + age + ", 体重：" + weight);
  }

  // 数据输出流 DataInputStream（输出基本数据类型）输出到文件是乱码的你看不到 但是用数据输入流读取其实是可以的
  // 写的时候writedouble 读取的时候就要readdouble 数据类型要对应 了解即可

  public void objIn(String inPath) {
    // 将对象流反序列化 然后访问对象
    try {
      ObjectInputStream in = new ObjectInputStream(new FileInputStream(inPath));
      Object obj = in.readObject(); // 读取对象向上转型
      p p1 = (p) obj; // 向下转型
      System.out.println(p1.age);
    } catch (IOException | ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }

  public void objOut(String outPath) {
    try {
      // 定义一个对象 将它序列化后放入文件中
      p p1 = new p();
      p1.age = 16;
      p1.name = "hjyy";
      ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(outPath));
      out.writeObject(p1);
      out.flush();
      out.close();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /** 文件随机读写类 RandomFileAccess类 构造器可以接收File对象或者String（文件名）对象 */
  public void randomFileIn(String inPath) {
    // 随机读
    try {
      // 第一个参数是文件路径 第二个参数是工作模式 常见的有r，rw，rwd，rws
      // r:只读 rw:读写 rwd:读写并同步文件内容 rws:读写并同步文件内容和元数据
      RandomAccessFile r = new RandomAccessFile(inPath, "r");
      // 设置文件读取起始位置 注意 换行符是两个字节
      r.seek(3);
      byte[] b = new byte[1024];
      int len;
      while ((len = r.read(b)) != -1) {
        System.out.println(new String(b, 0, len));
      }
      r.close();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public void randomFileOut(String outPath) {
    // 随机写
    try {
      RandomAccessFile r = new RandomAccessFile(outPath, "rw");
      String s = new Scanner(System.in).next();
      r.seek(0); // 如果是从文件中间写 就会覆盖等长的内容
      r.seek(r.length()); // 这样就是追加 文件末尾写
      r.write(s.getBytes());
      r.close();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}

class p implements Serializable {
  /**
   * 无论是将对象保存到硬盘上还是网络通信传输 都需要将对象转换为二进制流 对象持久化 对象序列化 写（OUTPUT） 而接受信息读取对象需要将二进制流转换为对象才能继续使用 对象反序列化
   * 读（INPUT） 序列化与反序列化只能对对象进行 static修饰的类属性 transient修饰的不能用
   * 不希望在网络操作（主要涉及到序列化操作，本地序列化缓存也适用）中被传输，这些信息对应的变量就可以加上transient关键字。换句话说，这个字段的生命周期仅存于调用者的内存中而不会写到磁盘里持久化。
   * transient关键字为我们提供了便利，你只需要实现Serilizable接口，将不需要序列化的属性前添加关键字transient，序列化对象的时候，这个属性就不会序列化到指定的目的地中。
   * 要实现某个类的对象可序列化，需要实现Serilizable或者Externalizable接口之一 序列化与反序列化使用的类的包名 类名 类结构都要一致 即使是结构一样 public情况下
   * 不同包也是不行的
   */
  private static final long SERILIZABLE_VERSIONUID = 1L;

  String name;
  int age;
}
/**
 * @author 奥利弗
 */
public class IO {
  public static void main(String[] args) {
    String inPath1 = "G:\\Java projects\\iLearning_JAVA\\src\\learning\\day12to13\\t.txt";
    String inPath = "G:\\Java projects\\iLearning_JAVA\\src\\learning\\day12to13\\t123.txt";
    String outPath = "G:\\Java projects\\iLearning_JAVA\\src\\learning\\day12to13\\t123_copy.txt";
    File1 ff = new File1();
    try {
      //        ff.test2();
      //        ff.test3();
      //        ff.test4(new File("src"));
      //        ff.test5();
      //        ff.test6();
      //           ff.copy();
      //        ff.fReader(inPath);
      //        ff.fWriter("hello",inPath);
      //        ff.fCharCopy(inPath,outPath);
      //            ff.bOutputStream(outPath);
      //            ff.bCopyStream(inPath,outPath);
      //      ff.testInputStreamReader(inPath1, outPath);
      //      ff.stdin();
      //      ff.stdout(outPath);
      //      ff.ioTest();
      //      ff.objOut(outPath);
      //      ff.objIn(outPath);
      //      ff.randomFileIn(inPath);
      ff.randomFileOut(outPath);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
