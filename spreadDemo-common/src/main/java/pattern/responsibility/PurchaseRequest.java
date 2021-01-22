package pattern.responsibility;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class PurchaseRequest {

    private String purpose;
    private BigDecimal amount;
    private int number;


}
