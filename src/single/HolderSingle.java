package single;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : huangdewei
 * Date: 20201020
 * To change this template use File | Settings | File Templates.
 */
public class HolderSingle {
    /**
     * 优点：将懒加载和线程安全完美结合的一种方式（无锁）
     * 类级的内部类，也就是静态的成员式内部类，该内部类的实例与外部类的实例，没有绑定关系，而且只有被调用到才会装载，从而实现了延迟加载
     */
    private HolderSingle() {}

    private static  class Holder{
        /**
         * 静态初始化器，由JVM来保证线程安全
         */
        private static  HolderSingle single = new HolderSingle();

    }
    public static HolderSingle  getInstance(){
        return Holder.single;
    }
}
