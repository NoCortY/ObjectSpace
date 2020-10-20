package cn.objectspace.c_bytecode;

/**
* @Description: 字节码
* @Author: NoCortY
* @Date: 2020/10/20 21:45
*/
public class JvmTest01 {
    /**
     * @Description: 示例
     * @Param: [args]
     * @return: void
     * @Author: NoCortY
     * @Date: 2020/10/20 21:46
     */
    public static void main(String[] args) {
        /**
         * 大端：高地址存放数字低位，低地址存放数字高位
         * 小端：高地址存放数字高位，低地址存放数字低位
         *
         * 小端从高地址开始读，大端从低地址开始读
         *
         * 内存（主机）是小端模式
         * 网络传输是大端模式
         *
         * class文件的组成
         * 1.魔数：cafe babe
         * 2.主版本号：major  JDK1.8的主版本号是52
         * 3.次版本号：minor  JDK1.8的次版本号是0  用于控制不同JDK版本编译的程序是否能在不同的JDK跑起来
         * 4.常量池：三种  class中的常量池（静态的）   运行时常量池（HSDB 动态的） 字符串常量池（StringTable）
         * 5.类的访问控制权限
         * 6.类名：this_class
         * 7.父类名：super_class
         * 8.实现的接口个数:interface_count  一个类最多能实现65535个接口
         * 9.实现的接口 interface[]
         * 10.属性数量：fields_count
         * 11.属性值：fields_info[]
         * 12.methods_count：方法数量
         * 13.method_info[]:方法值
         * 14.attributes_count:属性数量
         * 15.attributes[]:值
         */
    }
}
