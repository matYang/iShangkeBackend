package com.ishangke.edunav.util;

import org.apache.thrift.TProcessor;
import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.TThreadedSelectorServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TTransportException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServerThread implements Runnable {

    private int port;
    private TProcessor processor;
    private volatile TThreadedSelectorServer server;

    private static final Logger LOGGER = LoggerFactory.getLogger(ThriftServer.class);

    public ServerThread(int port, TProcessor processor) {
        this.port = port;
        this.processor = processor;
    }

    @Override
    public void run() {
        try {
            startThreadedSelectorServer();
        } catch (Exception e) {
            LOGGER.error("Failed to start thrift server", e);
        }
    }

    /**
     * Stops thrift server
     */
    public void stopServer() {
        if (null != server && server.isServing()) {
            server.stop();
        }
    }

    /**
     * Starts thrift server.
     * 
     * @throws TTransportException
     */
    private void startThreadedSelectorServer() throws TTransportException {
        TNonblockingServerSocket socket = new TNonblockingServerSocket(port);
        TThreadedSelectorServer.Args arg = new TThreadedSelectorServer.Args(socket);

        arg.protocolFactory(new TCompactProtocol.Factory());
        arg.transportFactory(new TFramedTransport.Factory());
        arg.processorFactory(new TProcessorFactory(processor));

        server = new TThreadedSelectorServer(arg);

        server.serve();
    }

    public TThreadedSelectorServer getServer() {
        return server;
    }

    public void setServer(TThreadedSelectorServer server) {
        this.server = server;
    }
}
