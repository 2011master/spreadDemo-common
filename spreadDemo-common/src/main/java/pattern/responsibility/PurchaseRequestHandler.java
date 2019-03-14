package pattern.responsibility;

import java.math.BigDecimal;

/**
 * 采购单处理类
 */
public class PurchaseRequestHandler {
    //递交采购单给主任  
    public void sendRequestToDirector(PurchaseRequest request) {  
        if (request.getAmount().compareTo(new BigDecimal(50000)) < 0) {
            //主任可审批该采购单  
            this.handleByDirector(request);  
        }  
        else if (request.getAmount().compareTo(new BigDecimal(100000)) <0 ) {
            //副董事长可审批该采购单  
            this.handleByVicePresident(request);  
        }  
        else if (request.getAmount().compareTo(new BigDecimal(500000)) < 0) {
            //董事长可审批该采购单  
            this.handleByPresident(request);  
        }  
        else {  
            //董事会可审批该采购单  
            this.handleByCongress(request);  
        }  
    }  
      
    //主任审批采购单  
    public void handleByDirector(PurchaseRequest request) {  
        //代码省略  
    }  
      
    //副董事长审批采购单  
    public void handleByVicePresident(PurchaseRequest request) {  
        //代码省略  
    }  
      
    //董事长审批采购单  
    public void handleByPresident(PurchaseRequest request) {  
        //代码省略  
    }  
      
    //董事会审批采购单  
    public void handleByCongress(PurchaseRequest request) {  
        //代码省略  
    }  
}  