package cn.objectspace.b_classloader;

import sun.misc.PerfCounter;

/**
* @Description: 打破双亲委派
* @Author: NoCortY
* @Date: 2020/10/19 21:36
*/
public class JvmTest02 {
    /**
     * @Description: 示例
     * @Param: [args]
     * @return: void
     * @Author: NoCortY
     * @Date: 2020/10/19 21:37
     */
    public static void main(String[] args) throws ClassNotFoundException {
        /**
         * 打破双亲委派两种方式：
         * 1.自定义类加载器:继承ClassLoader
         * 2.SPI：一种服务发现机制
         */
        CustClassLoader custClassLoader1 = new CustClassLoader();

        Class<?> jvmTest01Class = custClassLoader1.loadClass("cn.objectspace.b_classloader.JvmTest01");
        System.out.println("jvmTest01Class hascode:"+jvmTest01Class);

        CustClassLoader custClassLoader2 = new CustClassLoader();
        Class<?> jvmTest02Class = custClassLoader2.loadClass("cn.objectspace.b_classloader.JvmTest01");
        System.out.println("jvmTest02Class hascode:"+jvmTest02Class);

        /**
         * 如果不重写loadClass方法， 输出结果：Launcher$AppClassLoader
         * 说明我们自定义的类加载器，把这个类的加载委派给了AppClassLoader
         */
        System.out.println("classloader:"+jvmTest01Class.getClassLoader());

        /**
         * 相等，因为都是由AppClassLoader加载的
         */
        System.out.println(jvmTest01Class==jvmTest02Class);


    }
}
/**
* @Description: 自定义类加载器
* @Author: NoCortY
* @Date: 2020/10/19 22:05
*/
class CustClassLoader extends ClassLoader{
    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException{
        System.out.println("CustClassLoader findClass");

        return null;
    }
    /**
     * @Description:  通过重写loadClass方法，打破双亲委派
     * @Param: [name, resolve]
     * @return: java.lang.Class<?>
     * @Author: NoCortY
     * @Date: 2020/10/19 22:06
     */
    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        /**
         * 如果是双亲委派的classloader，逻辑不是像下面那样，而是像这样:
         *                  try {
         *                     if (parent != null) {
         *                         c = parent.loadClass(name, false);
         *                     } else {
         *                         c = findBootstrapClassOrNull(name);
         *                     }
         *                 } catch (ClassNotFoundException e) {
         *                     // ClassNotFoundException thrown if class not found
         *                     // from the non-null parent class loader
         *                 }
         * 可以看到如果双亲不为空，那么直接通过双亲委派加载类，如果双亲为空，直接通过启动类加载器加载类。
         */
        synchronized (this.getClassLoadingLock(name)){
            //通过自己这个类加载器看看自己的元空间（方法区）中是否存在这个Class
            Class<?> c = this.findLoadedClass(name);
            //如果不存在，那么开始加载
            if(c == null){
                long t0 = System.nanoTime();
                //如果要加载的类全限定名是cn.objectspace开头，那么直接通过重写的findClass找到，不委派
                if(name.startsWith("cn.objectspace")){
                    c = findClass(name);
                }else{
                    //否则  双亲委派
                    c = this.getParent().loadClass(name);
                }
                //如果没有加载到这个类
                if(c == null){
                    long t1 = System.nanoTime();
                    c = this.findClass(name);
                    PerfCounter.getParentDelegationTime().add(t1-t0);
                }
            }
            if(resolve){
                this.resolveClass(c);
            }
            return c;
        }
    }
}