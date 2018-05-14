package com.wlmiao.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * HTTP调用工具类
 */
public class HttpClientUtil {

    private static Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);

    private final static int BUFFER = 1024;

    public static String doPost(String url, Map<String, String> map, String code) {
        CloseableHttpClient httpclient = HttpClients.createDefault();

        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(1800000).setConnectTimeout(1800000)
            .build();//设置请求和传输超时时间

        HttpPost httppost = new HttpPost(url);
        httppost.setConfig(requestConfig);

        Header header = new BasicHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        httppost.setHeader(header);

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        Set<String> set = map.keySet();
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            String name = it.next();
            params.add(new BasicNameValuePair(name, map.get(name)));
        }

        String result = null;
        try {
            httppost.setEntity(new UrlEncodedFormEntity(params, code));
            HttpResponse response = httpclient.execute(httppost);

            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    result = EntityUtils.toString(entity, code);
                    logger.debug(url + "=> response =>" + result);
                }
            } else {
                logger.error(url + "=> response =>" + response.getStatusLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                httppost.releaseConnection();
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static String doPost(String url, String content, String code) {
        CloseableHttpClient httpclient = HttpClients.createDefault();

        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(1800000).setConnectTimeout(1800000)
            .build();//设置请求和传输超时时间

        HttpPost httppost = new HttpPost(url);
        httppost.setConfig(requestConfig);

        Header header = new BasicHeader(HttpHeaders.CONTENT_TYPE, "text/plain");
        httppost.setHeader(header);

        String result = null;
        try {
            httppost.setEntity(new StringEntity(content, ContentType.create("text/plain", code)));
            HttpResponse response = httpclient.execute(httppost);

            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    result = EntityUtils.toString(entity, code);
                    logger.debug(url + "=> response =>" + result);
                }
            } else {
                logger.error(url + "=> response =>" + response.getStatusLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                httppost.releaseConnection();
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static String doURLEncodePost(String url, Map<String, String> map, String code) {
        CloseableHttpClient httpclient = HttpClients.createDefault();

        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(1800000).setConnectTimeout(1800000)
            .build();//设置请求和传输超时时间

        HttpPost httppost = new HttpPost(url);
        httppost.setConfig(requestConfig);

        Header header = new BasicHeader(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded");
        httppost.setHeader(header);

        List<NameValuePair> params = new ArrayList<NameValuePair>();
        Set<String> set = map.keySet();
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            String name = it.next();
            params.add(new BasicNameValuePair(name, map.get(name)));
        }

        String result = null;
        try {
            httppost.setEntity(new UrlEncodedFormEntity(params, code));
            HttpResponse response = httpclient.execute(httppost);

            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    result = EntityUtils.toString(entity, code);
                    logger.debug(url + "=> response =>" + result);
                }
            } else {
                logger.error(url + "=> response =>" + response.getStatusLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                httppost.releaseConnection();
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static String doJSONPost(String url, String params, String code) {
        CloseableHttpClient httpclient = HttpClients.createDefault();

        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(1800000).setConnectTimeout(1800000)
            .build();//设置请求和传输超时时间

        HttpPost httppost = new HttpPost(url);
        httppost.setHeader("Connection", "close");
        httppost.setHeader("content-type", "application/json");
        httppost.setConfig(requestConfig);

        String result = null;
        try {
            httppost.setEntity(new StringEntity(params, code));
            HttpResponse response = httpclient.execute(httppost);

            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    result = EntityUtils.toString(entity, code);
                    logger.debug(url + " => response => " + result);
                }
            } else {
                logger.error(url + " => response => " + response.getStatusLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                httppost.releaseConnection();
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static String doGet(String url, Map<String, String> map, String code) {
        CloseableHttpClient httpclient = HttpClients.createDefault();

        HttpGet httpGet = new HttpGet(url);

        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(1800000).setConnectTimeout(1800000)
            .build();//设置请求和传输超时时间
        httpGet.setConfig(requestConfig);

        Set<String> set = map.keySet();
        Iterator<String> it = set.iterator();
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        while (it.hasNext()) {
            String name = it.next();
            params.add(new BasicNameValuePair(name, map.get(name)));
        }
        String result = null;
        try {
            String strParams = EntityUtils.toString(new UrlEncodedFormEntity(params, code));
            httpGet.setURI(new URI(url + "?" + strParams));
            HttpResponse response = httpclient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    result = EntityUtils.toString(entity, code);
                    logger.debug(url + " => response => " + result);
                }
            } else {
                logger.error(url + " => response => " + response.getStatusLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                httpGet.releaseConnection();
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }


    public static String doGet(String url, String code) {
        CloseableHttpClient httpclient = HttpClients.createDefault();

        HttpGet httpGet = new HttpGet(url);

        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(1800000).setConnectTimeout(1800000)
            .build();//设置请求和传输超时时间
        httpGet.setConfig(requestConfig);
        String result = null;
        try {
            httpGet.setURI(new URI(url));
            HttpResponse response = httpclient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    result = EntityUtils.toString(entity, code);
                    logger.debug(url + " => response => " + result);
                }
            } else {
                logger.error(url + " => response => " + response.getStatusLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                httpGet.releaseConnection();
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }


    public static boolean downloadFile(String url, String filepath) {
        CloseableHttpClient httpclient = HttpClients.createDefault();

        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(1800000).setConnectTimeout(1800000)
            .build();//设置请求和传输超时时间

        HttpGet httpGet = new HttpGet(url);
        httpGet.setConfig(requestConfig);

        boolean isSuccess = false;
        try {
            httpGet.setURI(new URI(url));
            HttpResponse response = httpclient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == 200) {

                HttpEntity entity = response.getEntity();
                InputStream in = entity.getContent();
                File file = new File(filepath);

                //判断目标文件所在的目录是否存在
                if (!file.getParentFile().exists()) {
                    //如果目标文件所在的目录不存在，则创建父目录
                    if (file.getParentFile().mkdirs()) {
                        logger.debug("mkdir success!");
                    } else {
                        throw new IOException("mkdir failed!");
                    }
                }

                FileOutputStream fout = new FileOutputStream(file);
                int l = -1;
                byte[] tmp = new byte[BUFFER];
                while ((l = in.read(tmp)) != -1) {
                    fout.write(tmp, 0, l);
                    // 注意这里如果用OutputStream.write(buff)的话，图片会失真，大家可以试试
                }
                fout.flush();
                fout.close();
                logger.debug("create file {} success! ", filepath);
                isSuccess = true;
                in.close();
            } else {
                logger.debug(url + " => response => " + response.getStatusLine());
            }
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                httpGet.releaseConnection();
                httpclient.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return isSuccess;
    }
}
