package com.freshchat.main;

import com.freshchat.client.NewrelicClient;
import com.freshchat.file.PropertyFile;
import com.freshchat.model.*;

import java.io.FileInputStream;
import java.net.Inet4Address;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class NewrelicMain {

    public static  NewrelicClient client = new NewrelicClient();
    private static Properties prop=  new PropertyFile().loadproperty();

    public static void main(String[] arg)
    {
        try{

            System.out.println("Started collecting Newrelic Metrics for "+ NewrelicEnvEnum.getEnvName(Integer.parseInt(prop.getProperty("APPLICATION_ID"))));
            System.out.println();
            List<String> queryStringList = getNewrelicMetricsname();
            List<NewrelicReport> reports = getNewrelicMetricsdata(queryStringList);

            Collections.sort(reports);
            System.out.println("Response" + " " + "Transaction");
            System.out.println();
            String[] ignorePatterns = prop.getProperty("IGNORE_PATTERN").split(":");
            List<String> ignorePatternsList = new ArrayList(Arrays.asList(ignorePatterns));

               for (NewrelicReport report : reports) {
                   float responseTime = Float.parseFloat(report.getAverageResponseTime());
                   String trimmedUrl = report.getName().replaceAll("WebTransactionTotalTime/WebServletPath|WebTransactionTotalTime/RestWebService|WebTransactionTotalTime", "");

                   if(!ignorePatternsList.contains(trimmedUrl) && trimmedUrl.length() > 0 && responseTime > Integer.parseInt(prop.getProperty("MIN_RESPONSE_TIME")))
                   {
                       System.out.println(report.getAverageResponseTime() +"\t" + trimmedUrl);
                   }

               }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    private static List<String> getNewrelicMetricsname()
    {
        List<String> queryStringList = new ArrayList<String>();

        for(int i =1 ;i<= Integer.parseInt(prop.getProperty("PAGES")) ;i++) {

            NewrelicMetrics metrics = client.getNewrelicMetrics(i);

            if(metrics != null) {
                Set<NewrelicMetricsData> metricsDataSet = metrics.getMetrics();

                for (NewrelicMetricsData metricsData : metricsDataSet) {
                    String metricsname = metricsData.getName();
                    if (metricsname.startsWith("WebTransactionTotalTime")) {
                        queryStringList.add(metricsname);
                    }
                }
            }

        }
        return queryStringList;
    }

    private static List<NewrelicReport> getNewrelicMetricsdata( List<String> queryStringList )
    {
        List<NewrelicReport> reports = new ArrayList<NewrelicReport>();
        int queryStringSize = queryStringList.size();
        int count =  queryStringSize !=0 ? (queryStringSize/100 +1) :0;
        int first=0;
        int last =0;
        for(int i =1 ;i<=count ;i++) {

            if(i!=count)
            {
                last = 100 * i;
            }
            else
            {
                last = last + queryStringSize %100;
            }

            List<String> metricsSubList = queryStringList.subList(first,last);


            NewrelicMetadata newRelicMetrics = null;
            newRelicMetrics = client.getNewrelicMetricsData(metricsSubList);
            if(newRelicMetrics != null)
            {
                Set<NewrelicMetricsData> metricsDataResultSet = newRelicMetrics.getMetricData().getMetrics();
                for (NewrelicMetricsData metricsData : metricsDataResultSet) {
                    NewrelicReport report = new NewrelicReport();
                    report.setName(metricsData.getName());
                    report.setCallCount(metricsData.getTimeslices().iterator().next().getValues().getCallCount());
                    report.setAverageResponseTime(metricsData.getTimeslices().iterator().next().getValues().getAverageResponseTime());

                    reports.add(report);
                }
            }

            first=last;

        }
            return reports;
    }
}
