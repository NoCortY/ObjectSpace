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
         * 1.u4魔数：cafe babe  加载class时校验是否存在魔数，判断是否是正常class文件
         * 2.u2主版本号：major  JDK1.8的主版本号是52
         * 3.u2次版本号：minor  JDK1.8的次版本号是0  用于控制不同JDK版本编译的程序是否能在不同的JDK跑起来
         * 4.u2常量池(最小index是1所以最终数量需要减一)：三种  class中的常量池（静态的）   运行时常量池（HSDB 动态的） 字符串常量池（StringTable）
         * 5.!常量池
         * 6.u2类的访问控制权限
         * 7.u2类名：this_class
         * 8.u2父类名：super_class
         * 9.u2实现的接口个数:interface_count  一个类最多能实现65535个接口
         * 10.!实现的接口 interface[]
         * 11.u2成员属性数量：fields_count
         * 12.!成员属性值：fields_info[]
         * 13.u2方法数量:umethods_count
         * 14.！方法值:method_info[]
         * 15.u2类属性的属性数量：attributes_count
         * 16.类属性的属性值：attributes[]
         */
    }
}
