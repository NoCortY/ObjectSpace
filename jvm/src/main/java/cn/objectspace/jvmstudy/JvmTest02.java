package cn.objectspace.jvmstudy;

/**
* @Description: 类加载过程
* @Author: NoCortY
* @Date: 2020/10/18 21:58
*/
public class JvmTest02 {

    //定义static（静态属性或静态代码段） JVM会生成一个clint方法

    //直接赋值
    public static final int a = 10;
    //先赋初值再赋值
    //生成的clint方法代码顺序跟定义的顺序保持一致
    /**
      bipush 10
      putstatic #2 <cn/objectspace/jvmstudy/JvmTest02.b>
      bipush 20
      putstatic #3 <cn/objectspace/jvmstudy/JvmTest02.c>
      return
     */
    public static int b = 10;
    public static int c = 20;
    /**
     * @Description: 示例
     * @Param: [args]
     * @return: void
     * @Author: NoCortY
     * @Date: 2020/10/18 21:59
     */
    public static void main(String[] args) {
        //准备阶段：赋初值，例如:int 赋值 0、引用类型赋值null，如果是final修饰的，直接赋值，没有赋初值一说。


        /*
          结果应该为1 2
          因为clint方法代码顺序和我们定义的static顺序保持一致
          先执行val1的赋初值,再执行val2的赋值，再执行构造方法
          所以val1 = 0 val2 = 1
          然后执行构造方法，val1 = 1 val2 = 2
        */
        Test_21_A test_21_a = Test_21_A.getInstance();
        System.out.println(Test_21_A.val1);
        System.out.println(Test_21_A.val2);

        /*
          结果应该为 1 1
          因为clint方法代码顺序和我们定义的static顺序保持一致
          先执行val1赋初值，再执行构方法(val1 = 1,val2 = 1)
          最后执行val2 = 1
          所以最后结果为 1 1
         */
        Test_21_B test_21_b = Test_21_B.getInstance();
        System.out.println(Test_21_B.val1);
        System.out.println(Test_21_B.val2);
    }
}
class Test_21_A{
    public static int val1;
    public static int val2 = 1;

    public static Test_21_A instance = new Test_21_A();

    Test_21_A(){
        val1++;
        val2++;
    }
    public static Test_21_A getInstance(){
        return instance;
    }
}

class Test_21_B{
    public static int val1;

    public static Test_21_B instance = new Test_21_B();

    Test_21_B(){
        val1++;
        val2++;
    }
    public static int val2 = 1;

    public static Test_21_B getInstance(){
        return instance;
    }
}
