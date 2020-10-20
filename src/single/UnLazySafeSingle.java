package single;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : huangdewei
 * Date:20201020
 * To change this template use File | Settings | File Templates.
 */
public class UnLazySafeSingle {
    /** 优点：饿汉模式天生是线程安全的，使用时没有延迟。
     *  缺点：启动时即创建实例，启动慢，有可能造成资源浪费。
     */
    private static UnLazySafeSingle single = new UnLazySafeSingle();
    private UnLazySafeSingle(){
    };
    public static UnLazySafeSingle getInstance(){
        return single;
    }


}
