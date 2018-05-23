package com.esther.code.pipeline;


import com.esther.code.schema.service.pipeline.BasicValve;
import com.esther.code.schema.service.pipeline.SecondValve;
import com.esther.code.schema.service.pipeline.StandardPipelineImpl;
import com.esther.code.schema.service.pipeline.ThirdValve;

/**
 * @author esther
 * @create 2017-09-28 19:23
 * 管道模式: 在管道中连接一个或多个阀门，每个阀门负责一部分逻辑处理，数据按规定的顺序往下流。
 * 此模式分解了逻辑处理任务，可方便对某任务单元进行安装拆卸，提高了流程的可扩展性、可重用性、机动性、灵活性。
 * <p>
 * 高内聚，低耦合
 * <p>
 * Pipeline模式的缺点是，每次它对于一个输入（或者一次请求）都必须从链头开始遍历（参考Http Server处理请求就能明白），这确实存在一定的性能损耗。
 * 最后链表是：SecondValve-->ThirdValve-->BasicValve
 */

public class PipelineTest {
    public static void main(String[] args) {
        String handling = "aabb1122zzyy";
        StandardPipelineImpl pipeline = new StandardPipelineImpl();
        BasicValve basicValve = new BasicValve();
        SecondValve secondValve = new SecondValve();
        ThirdValve thirdValve = new ThirdValve();
        basicValve.setNext(secondValve);
        pipeline.setBasic(basicValve);
        pipeline.addValve(secondValve);
        pipeline.addValve(thirdValve);
        pipeline.getFirst().invoke(handling);

        // 责任链模式的写法
        basicValve.setNext(secondValve);
        secondValve.setNext(thirdValve);
        basicValve.invoke(handling);
    }
}
