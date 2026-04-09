package com.hrbu.meditalk.tools;

import dev.langchain4j.agent.tool.P;
import dev.langchain4j.agent.tool.Tool;
import org.springframework.stereotype.Component;

@Component
public class CalculatorTools {
    /*
    * 加法
    * */
    @Tool(name = "add",value = "两个数相加")
    public double sum(@P(value = "参数1",required = true) double a,
                      @P(value = "参数2",required = true)double b){
        System.out.println("调用加法运算");
        return a+b;
    }

    /*
    * 平方根
    * */
    @Tool(name = "sqrt",value = "计算一个数的平方根")
    public double squareRoot(@P(value = "参数1",required = true) double x){
        System.out.println("调用平方根运算");
        return Math.sqrt(x);
    }
}
