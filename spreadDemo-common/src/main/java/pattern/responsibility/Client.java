package pattern.responsibility;

import pattern.responsibility.impl.Congress;
import pattern.responsibility.impl.Director;
import pattern.responsibility.impl.President;
import pattern.responsibility.impl.VicePresident;

import java.math.BigDecimal;

public class Client {


    public static void main(String[] args) {
        Approver zhangwuji,guojing,yangguo,congress;

        zhangwuji = new Director("张主任");
        guojing = new VicePresident("郭某");
        yangguo = new President("杨某");
        congress = new Congress("party");

        zhangwuji.setApprover(guojing);
        guojing.setApprover(yangguo);
        yangguo.setApprover(congress);

        PurchaseRequest request1 = new PurchaseRequest("4万元大订单",new BigDecimal("45000"),001);
        PurchaseRequest request2 = new PurchaseRequest("7万元大订单",new BigDecimal("75000"),002);
        PurchaseRequest request3 = new PurchaseRequest("12万元大订单",new BigDecimal("120000"),003);
        PurchaseRequest request4 = new PurchaseRequest("30万元大订单",new BigDecimal("300000"),004);
        PurchaseRequest request5 = new PurchaseRequest("80万元大订单",new BigDecimal("800000"),005);

        zhangwuji.process(request1);
        zhangwuji.process(request2);
        zhangwuji.process(request3);
        zhangwuji.process(request4);
        zhangwuji.process(request5);


    }
}
