package com.ishangke.edunav.manager.async.task;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ishangke.edunav.common.enums.SMSEnums.Event;

public class SMSTask implements AsyncTask {
    private static final Logger LOGGER = LoggerFactory.getLogger(SMSTask.class);

    private final Event event;
    private final String cellNum;
    private final String payload;

    public SMSTask(final Event event, final String cellNum, final String payload) {
        this.cellNum = cellNum;
        this.event = event;
        this.payload = payload;
    }

    @Override
    public boolean execute() {
        return this.send();
    }

    private boolean send() {
        if (this.cellNum.contains("DONOTSEND")) {
            return true;
        }

        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost("http://gbk.sms.webchinese.cn");

        List<BasicNameValuePair> nvps = new ArrayList<BasicNameValuePair>();
        nvps.add(new BasicNameValuePair("Uid", "routea"));
        nvps.add(new BasicNameValuePair("Key", "a221a629eacbddc0720c"));
        nvps.add(new BasicNameValuePair("smsMob", this.cellNum));
        nvps.add(new BasicNameValuePair("smsText", this.payload));

        try {
            post.setEntity(new UrlEncodedFormEntity(nvps, "gbk"));
            post.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=gbk");
            HttpResponse response = client.execute(post);

            LOGGER.debug("SMSTask:  SMS to: " + this.cellNum + " under event: " + this.event.toString()
                    + " returned with statusCode: " + response.getStatusLine().getStatusCode());
        } catch (IOException e) {
            LOGGER.debug("SMS ERR", e);
            return false;
        } finally {
            post.releaseConnection();
        }

        return true;
    }
}