package offer;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : huangdewei
 * Date: 20201707
 * To change this template use File | Settings | File Templates.
 */
public class Offer58reverseWords {
    public String reverseWords(String s) {
        //翻转两次
        String[] arr = s.trim().split(" ");
        StringBuffer stringBuffer = new StringBuffer();
        for(int i=arr.length-1;i>=0;i--){
            if("".equals(arr[i])){
                continue;
            }
            stringBuffer.append(arr[i]).append(" ");
        }
        return stringBuffer.toString().trim();

    }
}
