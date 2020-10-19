package cn.objectspace.b_classloader;

import sun.misc.Launcher;

import java.net.URL;
import java.net.URLClassLoader;

/**
* @Description: 类加载器
* @Author: NoCortY
* @Date: 2020/10/19 21:11
*/
public class JvmTest01 {
    /**
     * @Description: 示例：查看不同类加载器加载的路径
     * @Param: [args]
     * @return: void
     * @Author: NoCortY
     * @Date: 2020/10/19 21:11
     */
    public static void main(String[] args) {
        System.out.println("=====================BootStrap ClassLoader=====================");
        String[] urls1 = System.getProperty("sun.boot.class.path").split(":");
        for(String url:urls1){
            System.out.println(url);
        }
        System.out.println();
        URL[] urls2 = Launcher.getBootstrapClassPath().getURLs();
        for(URL url:urls2){
            System.out.println(url);
        }

        System.out.println("=====================Ext       ClassLoader=====================");
        String[] urls3 = System.getProperty("java.ext.dirs").split(":");
        for(String url:urls3){
            System.out.println(url);
        }
        System.out.println();
        ClassLoader classLoader = ClassLoader.getSystemClassLoader().getParent();
        URLClassLoader urlClassLoader = (URLClassLoader) classLoader;
        URL[] urls4 = urlClassLoader.getURLs();
        for(URL url:urls4){
            System.out.println(url);
        }
        System.out.println("=====================App       ClassLoader=====================");

        String[] urls5 = System.getProperty("java.class.path").split(":");
        for(String url:urls5){
            System.out.println(url);
        }
        System.out.println();

        URLClassLoader appUrlClassLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
        URL[] urls6 = appUrlClassLoader.getURLs();
        for(URL url:urls6){
            System.out.println(url);
        }
    }
}
