package pattern.factory.simple.factory;

import pattern.factory.simple.service.Chart;
import pattern.factory.simple.service.HistogramChart;
import pattern.factory.simple.service.LineChar;
import pattern.factory.simple.service.PieChart;

public class ChartFactory {

    public Chart getChart(String type) {
        Chart chart = null;
        switch (type) {
            case "LineChar" :
                chart =  new LineChar();
                break;
            case "PieChart":
                chart =  new PieChart();
                break;
            case "HIstogramChart" :
                chart =  new HistogramChart();
                break;
            default:
                break;
        }
        return chart;
    }


}
