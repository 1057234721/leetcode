package offer;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : huangdewei
 * Date: 20201022
 * To change this template use File | Settings | File Templates.
 */
public class Offer05ReplaceSpace {
    public String replaceSpace(String s) {
        //如果是c语言，可变字符，可以先把长度扩大字空格数量*2，在倒序，时间复杂度O(n),空间复杂度O(1)，
        //java需要而外的内存空间
        StringBuffer stringBuffer = new StringBuffer();
        for(Character c : s.toCharArray()){
            if(c == ' '){
                stringBuffer.append("%20");
            }else {
                stringBuffer.append(c);
            }
        }
        return stringBuffer.toString();

    }
}
