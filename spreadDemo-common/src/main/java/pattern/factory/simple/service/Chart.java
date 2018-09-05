package pattern.factory.simple.service;

public interface Chart {

    void display();

//    default  Chart getChart(String type) {
//        Chart chart = null;
//        switch (type) {
//            case "LineChar" :
//                chart =  new LineChar();
//                break;
//            case "PieChart":
//                chart =  new PieChart();
//                break;
//            case "HIstogramChart" :
//                chart =  new HistogramChart();
//                break;
//            default:
//                break;
//        }
//        return chart;
//    }
}
