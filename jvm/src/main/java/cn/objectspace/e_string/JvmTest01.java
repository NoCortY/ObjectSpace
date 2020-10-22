package cn.objectspace.e_string;

/**
* @Description: 字符串
* @Author: NoCortY
* @Date: 2020/10/22 22:20
*/
public class JvmTest01 {
    /**
     * @Description: 示例
     * @Param: [args]
     * @return: void
     * @Author: NoCortY
     * @Date: 2020/10/22 22:20
     */
    public static void main(String[] args) {
        String s1 = "1";
        String s2 = "1";

        //只生成一个String，这里用到的toString底层是  new String(new char[] {'',''},0,2); 这样创建不会再常量池中留记录
        String s = s1+s2;
        //去常量池中找字符串、有则直接返回，没有则封装String对应的InstanceOopDesc转成StringTable加载到常量池中
        //如果不加这个，拼接后不会在常量池中留记录，所以最后结果为false
        //如果加了这个，因为常量池中没有11 所以会加载到常量池中，所以最后地址都指向常量池。
       // s.intern();

        String s3 = "11";
        System.out.println(s == s3);



        final String s5 = "1";
        final String s6 = "1";
        String s7 = s5+s6;
        String str = "11";

        //true,因为final，s5 s6不可变 所以在编译的时候，就存入了常量池中，因为JVM知道s7=11。
        System.out.println(s7==str);
        //栈中放什么？
        //如果是基本数据类型，则放值。（值传递）
        //如果是对象，放地址。（引用传递  ）
    }
}
