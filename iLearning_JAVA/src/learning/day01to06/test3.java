package learning.day01to06;

public class test3 {}

class javabeanTest {
  private int age;
  private String name;
  // 写好属性之后 直接点生成即可 javabean初体验..
  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
