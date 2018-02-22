import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * Class ClientPlotPanel
 * Will maintain a plotting area using recieved data
 *
 * @author team02
 * @see javax.swing.JPanel
 */
public class ClientPlotPanel {

    private static ChartPanel chartPanel;

    private static DefaultCategoryDataset dataset;

    /**
     * Constructor
     */
    ClientPlotPanel(){
        //Create new dataset
        dataset = new DefaultCategoryDataset();

        //Create Line Chart
        JFreeChart lineChart = ChartFactory.createLineChart(
          "test",
          "Time", "Value",
           dataset,
           PlotOrientation.VERTICAL,
           true,
           true,
           false
        );

        //save it into chartPanel
        chartPanel = new ChartPanel(lineChart);
    }

    /**
     * Create a temporary dataset to test the functionality of plot panel.
     */
    /*
    private DefaultCategoryDataset createDataset(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        //Randomly generate 20 test data
        //Generate current time
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");

        Random rand = new Random();

        for(int i = 0; i < 20; i++){
            //Add 1s for each value's time
            cal.add(Calendar.SECOND, 5);
            //Generate a random value
            dataset.addValue(rand.nextInt(200) + 1, "Channel 1", String.valueOf(sdf.format(cal.getTime())));
        }

        return dataset;
    }*/

    /**
     * Every time we get data from server, should call this method to add channel data inside dataset.
     *
     * @param
     *       Date date: time when client recieved data.
     *       int channelNumber: channel number of current data.
     *       int value: data value
     * @see Date
     */
    public void addData(Date date, int channelNumber, int value){

        SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");

        dataset.addValue(value, "Ch " + channelNumber, sdf.format(date));

        System.out.println("" + sdf.format(date) + " Ch: " + channelNumber + " Value: " + value);
    }

    /**
     * Entry point to get chartPanel
     * @return ChartPanel created
     */
    public ChartPanel getChartPanel(){
        return chartPanel;
    }

}