package com.ishangke.edunav.util;

import java.lang.reflect.Constructor;

import org.apache.thrift.TProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import com.ishangke.edunav.manager.exception.ManagerException;
import com.ishangke.edunav.thrift.ErrorCode;

/**
 * Starts and stops thrift server.
 * 
 */
public class ThriftServer {

    private static ApplicationContext applicationContext;
    private int port;
    private TProcessor processor;
    private ServerThread serverThread;

    // max time to check thrift server
    private static final int MAX_SERVER_START_TIME = 5000;
    // interval time to check thrift server
    private static final int INTERVAL_TIME = 100;

    private static final Logger LOGGER = LoggerFactory.getLogger(ThriftServer.class);

    // initial port and processor for thrift server
    public ThriftServer(int port, Class<?> processorClass, Class<?> handlerClass) {
        this.port = port;

        try {
            Constructor<?> constructor = processorClass.getConstructor(handlerClass.getInterfaces()[0]);
            this.processor = (TProcessor) constructor.newInstance(applicationContext.getBean(handlerClass
                    .getInterfaces()[0]));
        } catch (Exception exception) {
            throw new ManagerException("Failed to initialize thrift server.", ErrorCode.SERVICE_CLIENT_ERROR,
                    exception);
        }
    }

    /**
     * Starts thrift server.
     * 
     * @return {@code true} if thrift server success to start, otherwise,
     *         {@code false}
     */
    public boolean startServer() {
        boolean isStarted = true;

        serverThread = new ServerThread(port, processor);
        Thread thread = new Thread(serverThread);
        thread.start();

        long startTime = System.currentTimeMillis();
        // exit the while block until thrift server is serving or after period
        // of seconds.
        while ((serverThread.getServer() == null || !serverThread.getServer().isServing())) {
            if (System.currentTimeMillis() - startTime > MAX_SERVER_START_TIME) {
                isStarted = false;
                break;
            }
            try {
                Thread.sleep(INTERVAL_TIME);
            } catch (InterruptedException e) {
                LOGGER.error("Thread has beeen interrupted", e);
            }
        }
        return isStarted;
    }

    /**
     * Stops started thrift server.
     */
    public void stopServer() {
        if (null != serverThread) {
            serverThread.stopServer();
        }
    }

    public static void setApplicationContext(ApplicationContext applicationContext) {
        ThriftServer.applicationContext = applicationContext;
    };
}
