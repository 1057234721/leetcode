package single;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : huangdewei Date: 20201020 To change this template use File | Settings | File Templates.
 */
public class LazyUnSafeSingle {
    /** 优点：懒加载启动快，资源占用小，使用时才实例化，无锁。
     *  缺点：非线程安全。
     */
    private static LazyUnSafeSingle single = null;
    private LazyUnSafeSingle (){
    }
    public static  LazyUnSafeSingle getInstance(){
        if(single == null){
            single = new LazyUnSafeSingle();
        }
        return single;

    }



}
