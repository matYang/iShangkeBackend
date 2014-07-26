package com.ishangke.edunav.thrift;

import java.lang.reflect.Constructor;

import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

public class ThriftClientFactory<T> implements AutoCloseable {

    private T serviceClient;
    private TTransport transport;

    /**
     * Initializes the instance of ThriftClientManager.
     * 
     * @param Host
     *            address
     * @param Port
     * @param Class
     *            of service client
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public ThriftClientFactory(ThriftClientSetting clientSetting) {

        String host = clientSetting.getHost();
        int port = clientSetting.getPort();
        Class<?> clientClass = clientSetting.getClientClass();

        if (host == null || host.isEmpty() || clientClass == null) {
            throw new IllegalArgumentException("Arguments are illegal!");
        }

        transport = new TFramedTransport(new TSocket(host, port));

        try {
            transport.open();

            TProtocol protocol = new TCompactProtocol(transport);
            Constructor<?> constructor = clientClass.getDeclaredConstructor(TProtocol.class);

            serviceClient = (T) constructor.newInstance(protocol);
        } catch (Exception exception) {
            throw new ThriftException("Failed to initialize thrift client.", ErrorCode.SERVICE_CLIENT_ERROR, exception);
        }
    }

    /**
     * Gets service client instance
     * 
     * @return service client
     */
    public T getServiceClient() {
        if (transport == null || serviceClient == null) {
            throw new NullPointerException("transport or serviceClient is null!");
        }

        if (!transport.isOpen()) {
            throw new IllegalStateException("Argument transport is not open!");
        }

        return serviceClient;
    }

    /**
     * Closes transport.
     */
    @Override
    public void close() {
        if (transport != null && transport.isOpen()) {
            transport.close();
        }

        transport = null;
    }

}
