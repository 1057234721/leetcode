package offer;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : huangdewei
 * Date: 20201210
 * To change this template use File | Settings | File Templates.
 */
public class Offer67StrToInt {
    public static  int strToInt(String str) {
        //符号
        //空格
        //溢出
        //非数字
        char[] arr =str.trim().toCharArray();
        if (arr.length==0){
            return 0;
        }
        int start = 0;
        int flag = 1;
        int result= 0;
        if(arr[0] == '-'){
            start++;
            flag=-1;
        }
        if(arr[0] == '+'){
            start++;
        }
        int div = Integer.MAX_VALUE/10;
        int b = Integer.MAX_VALUE%10;

        for(int i=start;i<arr.length;i++){
            if(arr[i]<'0'||arr[i]>'9'){
                break;
            }
            //越界
            if(result>div || (result == div && arr[i]>('0'+b))){
                result = flag== 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                break;

            }
            result =result*10 + arr[i]-'0';

        }

        return flag* result;


    }

  public static void main(String[] args) {
    //
    System.out.println(strToInt("42"));
  }
}
