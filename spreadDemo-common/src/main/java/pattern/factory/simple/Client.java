package pattern.factory.simple;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import pattern.factory.simple.factory.ChartFactory;
import pattern.factory.simple.service.Chart;

import java.io.IOException;
import java.util.Properties;


public class Client {

    /*
    UML图见 https://www.processon.com/diagraming/5b70fc0ee4b053a09c30f64b
     */

    private static final Logger LOGGER = LogManager.getLogger();
    public static void main(String[] args) throws IOException {
        ChartFactory chartFactory = new ChartFactory();
        Properties properties = PropertiesLoaderUtils.loadProperties(new ClassPathResource("properties/test.properties"));
        String type = properties.getProperty("chart.type", "PieChart");
        Chart pieChart = chartFactory.getChart(type);pieChart.display();
        LOGGER.info("end");

    }
}
