package com.freshchat.client;


import com.freshchat.constants.NewrelicConstants;
import com.freshchat.file.PropertyFile;
import com.freshchat.model.NewrelicMetadata;
import com.freshchat.model.NewrelicMetrics;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.FileInputStream;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class NewrelicClient {

    private static Properties prop=  new PropertyFile().loadproperty();

    public NewrelicMetadata getNewrelicMetricsData(List<String> queryStringSet) {
        ObjectMapper mapper = new ObjectMapper();
        NewrelicMetadata newrelicMetadata =null;
        try{
           final String fromTime = prop.getProperty("FROM_TIME");
           final String toTime = prop.getProperty("TO_TIME");
            ApiRequest apiRequest = new ApiRequest.Builder()
                    .endpoint(makeRequestURL(NewrelicConstants.NEWRELIC_METRICS_DATA_URL_SUFFIX))
                    .queryStringSet(queryStringSet)
                    .queryParams(new HashMap() {{
                        put("from",fromTime );
                       put("to",toTime );
                       put("period",constructPeriod(fromTime,toTime));
                    }})
                    .build();
            String responseStr   = makeHttpRequest(apiRequest);
            newrelicMetadata =  mapper.readValue(responseStr, NewrelicMetadata.class);
        }

        catch (Exception e)
        {
            throw new RuntimeException(e.getMessage());
        }
        return newrelicMetadata;

    }

    public NewrelicMetrics getNewrelicMetrics(final int pageId)  {
        ObjectMapper mapper = new ObjectMapper();
        NewrelicMetrics newrelicMetrics = null;
        try{
            ApiRequest apiRequest = new ApiRequest.Builder()
                    .endpoint(makeRequestURL(NewrelicConstants.NEWRELIC_METRICS_URL_SUFFIX))
                    .queryParams(new HashMap() {{
                        put("page", pageId);

                    }})
                    .build();
            String responseStr = makeHttpRequest(apiRequest);

            newrelicMetrics =  mapper.readValue(responseStr, NewrelicMetrics.class);
        }
        catch(Exception e) {
            throw new RuntimeException(e.getMessage());
        }

        return newrelicMetrics;
    }

    private String makeRequestURL(String pattern)
    {
        return prop.getProperty("NEWRELIC_URL") + NewrelicConstants.BACKSLASH + prop.getProperty("APPLICATION_ID") + pattern;
    }

    protected String makeHttpRequest(ApiRequest apiRequest) {
        HttpResponse<String> stringHttpResponse = null;

        String url = generateUrl(apiRequest.getEndpoint(), apiRequest);
        Map<String, String> headers = new HashMap();
        headers.put("X-Api-Key",prop.getProperty("API_KEY"));

        try {
            stringHttpResponse = Unirest.get(url).headers(headers).asString();
        }
        catch (UnirestException e) {
            throw new RuntimeException(e.getMessage());
        }

        return stringHttpResponse.getBody();
    }

    private String generateUrl(String uri, ApiRequest apiRequest) {
        StringBuilder urlStringBuilder = new StringBuilder(uri);
        List<String>  queryStringSet = apiRequest.getQueryStringSet();

        Map<String,Object> queryStringParam = apiRequest.getQueryParams();
        if(queryStringSet.size() > 0 || queryStringParam.size() > 0) {

            urlStringBuilder.append("?");

            if(queryStringSet.size() > 0) {
                for (String queryString : queryStringSet) {
                    urlStringBuilder.append("names[]" + "=" + URLEncoder.encode(queryString) + "&");
                }
            }

            if(queryStringParam.size() > 0) {
                for (Map.Entry<String, Object> entry : queryStringParam.entrySet()) {
                    String k = entry.getKey();
                    String v = entry.getValue().toString();
                    urlStringBuilder.append(k + "=" + v + "&");
                }
            }

            urlStringBuilder.replace(urlStringBuilder.length()-1, urlStringBuilder.length(), "");
        }



        return urlStringBuilder.toString();
    }

    private String constructPeriod(String from , String to)
    {

        long diffInSec=0;
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

            Date fromDate = sdf.parse(from.substring(0,19));
            Date toDate = sdf.parse(to.substring(0,19));

            long diff = toDate.getTime() - fromDate.getTime();

            if(diff <=0)
            {
                throw new RuntimeException("Please check the From and To dates");
            }

            diffInSec = diff / (1000);

        }catch(Exception e)
        {
            throw new RuntimeException(e.getMessage());
        }

        return String.valueOf(diffInSec);
    }
}
