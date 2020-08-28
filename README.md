1,切碎知识点
2,刻意练习（过5变）
3,反馈



五毒神掌
5-10分钟：读题思考

有思路，自己开始写，不然，马上看题解
默写背诵数量
自己开始写（闭卷）


最大误区，刷题只刷一遍
升维，空间换时间


切题四件套
1.多看几次题目，多确认几次
2.想所有可能的解法，分析时空复杂度，找出最优解
3.写代码
4.写测试用例


五毒神掌
1.刷题第一遍
5-10分钟读题思考;
直接看解法，注意多解法，比较解法优劣;
背诵默写;
2.马上自己写，leetcode提交
多种解法比较，体会，优化
3.过了一天之后，在重复做题
不同的解法的熟练度，专项练习。
4.过了一周之后，在重复做题
5.面试前一两周周恢复性训练

分析 Queue 和 Priority Queue 的源码:
https://www.cnblogs.com/Elliott-Su-Faith-change-our-life/p/7472265.html
递归代码模板
// Java
public void recur(int level, int param) { 


  // terminator 
  if (level > MAX_LEVEL) { 
    // process result 
    return; 
  }


  // process current logic 
  process(level, param); 


  // drill down 
  recur( level: level + 1, newParam); 


  // restore current status 
  }



