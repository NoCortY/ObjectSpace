package cn.objectspace.a_loadclass;

import java.util.HashMap;
import java.util.Map;

/**
* @Description: oop-klass模型
* @Author: NoCortY
* @Date: 2020/10/18 21:57
*/
public class JvmTest01 {
    String str = "str";
    Map<String,Object> map = new HashMap<>(16);
    /**
     * @Description:  示例
     * @Param: [args]
     * @return: void
     * @Author: NoCortY
     * @Date: 2020/10/18 21:58
     */
    public static void main(String[] args) {
        //开启HSDB：java -cp .\sa-jdi.jar sun.jvm.hotspot.HSDB
        //需要复制jdk/jre/bin目录下的sawindbg.dll文件到jre/bin目录下
        //jps -l 查看本进程的id

        /*
        F:\ProgramsOnline\github\ObjectSpace>jps -l
        11552 sun.tools.jps.Jps
        11112 cn.objectspace.jvmstudy.JvmTest01
        1240
        8632 org.jetbrains.idea.maven.server.RemoteMavenServer36
        5580 org.jetbrains.jps.cmdline.Launcher
         */
        /**
         * 普通的Java类在JVM中对应的是instanceKlass类的实例，再来说下它的三个字类
         * 1. InstanceMirrorKlass：用于表示java.lang.Class，Java代码中获取到的Class对象，实际上就是这个C++类的实例，存储在堆区，学名镜像类
         * 2. InstanceRefKlass(强、弱、虚引用)：用于表示java/lang/ref/Reference类的子类
         * 3. InstanceClassLoaderKlass(类加载器)：用于遍历某个加载器加载的类
         * Java中的数组不是静态数据类型，是动态数据类型，即是运行期生成的，Java数组的元信息用ArrayKlass的子类来表示：
         * 1. TypeArrayKlass：用于表示基本类型的数组
         * 2. ObjArrayKlass：用于表示引用类型的数组
         */
        System.out.println("Hello JVM");
        //在Java中  数组是动态类型  区别于八种静态类型（byte char short int long float double boolean）以外
        //TypeArrayKlass
        int[] arr = new int[1];
        //ObjArrayKlass
        JvmTest01[] arr2 = new JvmTest01[1];
        // InstanceKlass：类的元数据 存储在方法区
        // InstanceMirrorKlass:存放对象 存储在堆区
        // InstanceRefKlass:存放引用 存储在栈区
        JvmTest01 jvmTest01 = new JvmTest01();
        while(true);
    }
}
