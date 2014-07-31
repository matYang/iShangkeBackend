package com.ishangke.edunav.sms;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.junit.Assert;
import org.junit.Test;

import com.ishangke.edunav.common.enums.SMSEnums.Event;
import com.ishangke.edunav.manager.async.ExecutorProvider;
import com.ishangke.edunav.manager.async.dispatcher.SMSDispatcher;
import com.ishangke.edunav.manager.async.task.SMSTask;
import com.ishangke.edunav.manager.common.Flag;

/**
 * basic test of sms functionalities
 * @author Matthew
 */
public class BasicSMSTest {

    @Test
    public void testBasic() throws InterruptedException, ExecutionException {
        String cellNum = "18662241356";
        String payload = "验证码为: 254239";
        SMSTask task = new SMSTask(Event.USER_CELLVERIFICATION, cellNum, payload);
        Future<Boolean> result = ExecutorProvider.executeRelay(task);
    
        Assert.assertTrue(result.get());
    }
    
    @Test
    public void testSimpleDispatch() throws InterruptedException, ExecutionException{
        //must must set flag true, othterwise sms will not be sent
        if (!Flag.shouldSMS()) {
            Flag.setSMS(true);
        }
        
        String cellNum = "18662241356";
        String authCode = "254239";
        Future<Boolean> result = SMSDispatcher.sendUserCellVerificationSMS(cellNum, authCode);
        
        Assert.assertTrue(result.get());
    }
    
    @Test
    public void testForgetPasswordDispatch() throws InterruptedException, ExecutionException {
       //must must set flag true, or I will personally kill you
        if (!Flag.shouldSMS()) {
            Flag.setSMS(true);
        }
        
        String cellNum = "18662241356";
        String authCode = "245815";
        Future<Boolean> result = SMSDispatcher.sendUserForgetPasswordSMS(cellNum, authCode);
        
        Assert.assertTrue(result.get());
    }
    

}
