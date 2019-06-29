package view;

import control.ChartControl;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;

/**
 * @author Zi10ng
 * @date 2019年6月16日16:39:36
 * 学生成绩柱状图
 */
class AnalysisPanel extends JPanel {
     AnalysisPanel(){
         ChartPanel chartPanel = new ChartPanel(setChart(setDataset()));
         add(chartPanel);
         init();
    }
    private void init(){
        setBounds(-7, -32, 700, 450);
        setOpaque(false);
    }
    private DefaultCategoryDataset setDataset(){
        ChartControl chartControl = new ChartControl();
        chartControl.chart();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(chartControl.java1FailRate,"java不及格","一班");
        dataset.setValue(chartControl.java2FailRate,"java不及格","二班");
        dataset.setValue(chartControl.db1FailRate,"数据库不及格","一班");
        dataset.setValue(chartControl.db2FailRate,"数据库不及格","二班");
        dataset.setValue(chartControl.ci1FailRate,"计网不及格","一班");
        dataset.setValue(chartControl.ci2FailRate,"计网不及格","二班");
        dataset.setValue(chartControl.gpa1MinRate,"GPA低于2.0","一班");
        dataset.setValue(chartControl.gpa2MinRate,"GPA低于2.0","二班");
        dataset.setValue(chartControl.gpa1MaxRate,"满绩点","一班");
        dataset.setValue(chartControl.gpa2MaxRate,"满绩点","二班");
         return dataset;
    }
    private JFreeChart setChart( DefaultCategoryDataset dataset){
        JFreeChart chart = ChartFactory.createBarChart("17软卓成绩分析图", "17软卓成绩分析图",
                "占小数比", dataset, PlotOrientation.VERTICAL, true, true, false);
        //获得图标中间部分，即plot
        CategoryPlot plot=(CategoryPlot)chart.getPlot();
        //获得横坐标
        CategoryAxis categoryAxis=plot.getDomainAxis();
        //设置横坐标字体
        categoryAxis.setLabelFont(new Font("微软雅黑",Font.BOLD,12));
        return chart;
    }
}
