package single;

import com.sun.corba.se.impl.orbutil.concurrent.Sync;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : huangdewei
 * Date: 20201020
 * To change this template use File | Settings | File Templates.
 */
public class LazySafeDoubleCheckLockSingle {
    /** 优点：懒加载，线程安全。
     *  缺点：实例必须有 volatile 关键字修饰，其保证初始化完全,（这里体现的是有序性）。
     */
    private volatile static LazySafeDoubleCheckLockSingle single = null;
    private LazySafeDoubleCheckLockSingle(){
    }
    public static  LazySafeDoubleCheckLockSingle getInstance(){
        if(single == null){
            synchronized(LazySafeDoubleCheckLockSingle.class){
                if(single == null){
                    single = new LazySafeDoubleCheckLockSingle();
                }
            }
        }
        return single;
    }
}
