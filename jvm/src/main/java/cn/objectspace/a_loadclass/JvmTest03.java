package cn.objectspace.a_loadclass;

import java.util.UUID;

/**
* @Description: 何时加载，加载方式
* @Author: NoCortY
* @Date: 2020/10/18 22:28
*/
public class JvmTest03 {
    /**
     * @Description: 示例
     * @Param: [args]
     * @return: void
     * @Author: NoCortY
     * @Date: 2020/10/18 22:28
     */
    public static void main(String[] args) {
        /**
         * JVM使用懒加载的方式加载class
         * 这里输出：
         * A Static Block
         * A str
         * 因为只需要用到A类的str，所以需要创建A类，且str是静态字段，并且B类没有创建对象，，所以B根本没必要进行加载
         * 这里静态字段是在父类中，如果静态字段在子类中，子类会被初始化，那么父类也会随即被初始化。
         * 结论：类只有在“使用”的时候，才会去加载（用本类反射加载其他类，本类也会加载）
         */
        System.out.println(Test_31_B.str);
        System.out.println();

        /**
         * new了D，所以D一定会加载，结果为：
         * C Static Block
         * D Static Block
         * C str
         */
        System.out.println(new Test_31_D().str);
        System.out.println();
        /**
         * 结果为：
         * E Static Block
         * F Static Block
         * F str
         * 虽然这里看似只用到了F类，但是F类继承E类，建立F类对象时，父类必然被创建
         */
        System.out.println(new Test_31_F().str);
        System.out.println();

        /**
         * 结果为：
         * final G str
         * 只打印了字符串，但是没有加载G类
         * 因为这里的字符串是常量
         * 常量会直接加载到我们 JvmTest03 这个主类的常量池中
         * 不需要加载G类
         */
        System.out.println(Test_31_G.str);
        System.out.println();

        /**
         * 结果为：
         * H Static Block
         * 958dc029-9b1b-4ad6-98ad-2b67f5045e1f
         *
         * 如果常量赋值需要动态生成，那么类会加载
         */
        System.out.println(Test_31_H.str);
    }
}
class Test_31_A{
    public static String str = "A str";

    static {
        System.out.println("A Static Block");
    }
}
class Test_31_B extends Test_31_A{
    static{
        System.out.println("B Static Block");
    }
}

class Test_31_C{
    public String str = "C str";

    static {
        System.out.println("C Static Block");
    }
}

class Test_31_D extends Test_31_C{
    static {
        System.out.println("D Static Block");
    }
}

class Test_31_E{
    static {
        System.out.println("E Static Block");
    }
}

class Test_31_F extends Test_31_E{
    public String str = "F str";

    static {
        System.out.println("F Static Block");
    }
}

class Test_31_G{
    public static final String str = "final G str";

    static{
        System.out.println("G Static Block");
    }
}

class Test_31_H{
    public static final String str = UUID.randomUUID().toString();

    static {
        System.out.println("H Static Block");
    }
}
