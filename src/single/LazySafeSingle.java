package single;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : huangdewei
 * Date: 20201020
 * To change this template use File | Settings | File Templates.
 */
public class LazySafeSingle {
    /** 优点：懒加载启动快，资源占用小，使用时才实例化，加锁。
     *  缺点：synchronized 为独占排他锁，并发性能差。即使在创建成功以后，获取实例仍然是串行化操作。
     */
    private static LazySafeSingle single = null;
    private LazySafeSingle(){

    }
    public static  synchronized LazySafeSingle getInstance(){
        if (single == null){
            single = new LazySafeSingle();
        }
        return single;
    }
}
