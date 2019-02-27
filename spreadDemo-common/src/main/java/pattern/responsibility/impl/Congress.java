package pattern.responsibility.impl;

import pattern.responsibility.Approver;
import pattern.responsibility.PurchaseRequest;

import java.math.BigDecimal;

/**
 * 董事会审批：处理 20万以上
 */
public class Congress extends Approver {

    public Congress(String name) {
        super(name);
    }

    @Override
    public void process(PurchaseRequest request) {
        if (new BigDecimal(200000).compareTo(request.getAmount()) <= 0) {
            System.out.println("审批单号" + request.getNumber() + ",内容：" + request.getPurpose() + ",审批人：董事会-" + this.name);
        } else {
            //转发请求
            this.approver.process(request);
        }
    }
}
