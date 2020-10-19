package cn.objectspace.a_loadclass;

/**
* @Description: oop-klass模型
* @Author: NoCortY
* @Date: 2020/10/18 21:57
*/
public class JvmTest01 {
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
