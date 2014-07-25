package com.ishangke.edunav.web.common;

import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;

public class ThriftClientManager {

    private String host;
    private int port;
    private Class<?> clientClass;
    private final static ConcurrentHashMap<Object, TFramedTransport> TRANSPORTMAP = new ConcurrentHashMap<Object, TFramedTransport>();

    /**
     * Initializes the instance of ThriftClientManager.
     * 
     * @param Host
     *            address
     * @param Port
     * @param Class
     *            of service client
     */
    public ThriftClientManager(String host, int port, Class<?> clientClass) {
        if (host == null || clientClass == null) {
            throw new IllegalArgumentException("Arguments are illegal!");
        }

        this.host = host;
        this.port = port;
        this.clientClass = clientClass;

    }

    /**
     * Initializes the service client.
     * 
     * @return Client object.
     * @throws Exception
     */
    public Object initializeClient() throws Exception {

        TFramedTransport transport = new TFramedTransport(new TSocket(host, port));
        transport.open();

        TProtocol protocol = new TCompactProtocol(transport);
        Constructor<?> constructor = clientClass.getDeclaredConstructor(TProtocol.class);
        Object client = constructor.newInstance(protocol);
        TRANSPORTMAP.put(client, transport);
        return client;
    }

    /**
     * Finalizes the service client.
     * 
     * @param The
     *            client initialized.
     * @throws Exception
     */
    public void finalizeClient(Object client) throws Exception {
        if (client == null) {
            throw new IllegalArgumentException("clientClass is null!");
        }

        TFramedTransport transport = TRANSPORTMAP.get(client);

        if (transport != null) {
            transport.close();

            TRANSPORTMAP.remove(client);
        }
    }

}
