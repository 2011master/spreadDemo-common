package pattern.responsibility.impl;

import pattern.responsibility.Approver;
import pattern.responsibility.PurchaseRequest;

import java.math.BigDecimal;

/**
 * 副董审批：处理 5~10万以下
 */
public class VicePresident extends Approver {

    public VicePresident(String name) {
        super(name);
    }

    @Override
    public void process(PurchaseRequest request) {
        if (new BigDecimal(100000).compareTo(request.getAmount()) >= 0) {
            System.out.println("审批单号" + request.getNumber() + ",内容：" + request.getPurpose() + ",审批人：副董-" + this.name);
        } else {
            //转发请求
            this.approver.process(request);
        }
    }
}
