package pattern.responsibility;

import lombok.Getter;
import lombok.Setter;

/**
 * 抽象审批类
 */
public abstract class Approver {

    protected Approver approver;
    @Getter@Setter
    protected String name;
    public abstract void process(PurchaseRequest request);

    public Approver(String name) {
        this.name = name;
    }

    /**
     * 设置后续者
     * @param approver
     */
    public void setApprover(Approver approver) {
        this.approver = approver;
    }
}
