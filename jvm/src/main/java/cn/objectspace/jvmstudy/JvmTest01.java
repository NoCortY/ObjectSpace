package cn.objectspace.jvmstudy;

public class JvmTest01 {
    public static void main(String[] args) {
        //开启HSDB：java -cp .\sa-jdi.jar sun.jvm.hotspot.HSDB
        //需要复制jdk/jre/bin目录下的sawindbg.dll文件到jre/bin目录下
        //jps -l 查看本进程的id
        System.out.println("Hello JVM");
        while(true);
    }
}
