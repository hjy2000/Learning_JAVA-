package learning.day12to13;
// IO分为文件流（外存数据）和缓冲流（内存数据）
// 具体分为转换流、标准IO流、打印流、数据流、对象流（序列化，反序列化）、随机存取文件流(任意位置插入读取)
// 文件字节流其实非常通用 大部分文件都可以转换为二进制再操作

import java.io.*;

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

    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
}

/**
 * @author 奥利弗
 */
public class IO {
  public static void main(String[] args) {
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
      ff.testInputStreamReader(inPath, outPath);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
