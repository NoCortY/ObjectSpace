package cn.objectspace.jvmstudy;

/**
* @Description: 读取静态变量的底层实现
* @Author: NoCortY
* @Date: 2020/10/18 22:49
*/
public class JvmTest04 {
    /**
     * @Description: 示例
     * @Param: [args]
     * @return: void
     * @Author: NoCortY
     * @Date: 2020/10/18 22:50
     */
    public static void main(String[] args) {
        /**
         * B类读取A类静态字段思路:
         *
         * 1.先去Test_1_B的镜像类中去取，如果有直接返回；如果没有，
         * 会沿着继承链将请求往上抛。很明显，这种算法的性能随继承链的death而上升，算法复杂度为O(n)
         *
         * 2.通过K V的方式，获取到静态变量，算法复杂度为O(1)\
         *
         * Hotspot就是使用的第二种方式，借助另外的数据结构ConstantPoolCache，
         * 常量池类ConstantPool中有个属性_cache指向了这个结构。
         * 每一条数据对应一个类ConstantPoolCacheEntry。
         */
        System.out.println(Test_41_B.str);
        while(true);
    }
}

class Test_41_A{
    /**
     * 静态属性是只存放在mirror中
     */
    public static String str = "A str";

    static{
        System.out.println("A Static Block");
    }
}

class Test_41_B extends Test_41_A{
    static {
        System.out.println("B Static Block");
    }
}
