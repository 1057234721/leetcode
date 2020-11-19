package offer;

/**
 * Created by IntelliJ IDEA.
 *
 * @author : huangdewei
 * Date: 20201116
 * To change this template use File | Settings | File Templates.
 */
public class Offer15HammingWeight {
  public static int hammingWeight(int n) {
    int sum = 0;
//    //int会越界，
//    long j = 1;
//    for (int i = 0; i < 32; i++) {
//        System.out.println(n & j);
//      if ((n & j) != 0) {
//        sum++;
//      }
//      j <<= 1;
//    }
      while (n != 0){
          n = n&(n-1);
          sum++;
      }
    return sum;
  }

  public static void main(String[] args) {
   int result =   hammingWeight(0b11111111111111111111111111111101);
    System.out.println(result);
    //
  }
}
