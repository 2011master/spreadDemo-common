package pattern.observer.demo;

import java.util.List;

public class StockOne extends AbstractStock {

    public StockOne(String stockNum) {
        super(stockNum);
    }

    @Override
    public void notity() {
        users.forEach(item ->{
            item.dosometiing(stockNum);
        });
    }
}
