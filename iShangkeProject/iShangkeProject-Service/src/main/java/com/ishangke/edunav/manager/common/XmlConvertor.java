package com.ishangke.edunav.manager.common;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.ishangke.edunav.manager.exception.ManagerException;

public class XmlConvertor {
    /**
     * Converts object to xml string
     * 
     * @param object
     *            source object
     * @return Xml string
     * @throws JAXBException
     */
    public static <T> String objectToXml(T object) {

        String xml = null;

        OutputStream outputStream = new ByteArrayOutputStream();

        try {
            JAXBContext ctx = JAXBContext.newInstance(object.getClass());
            Marshaller mashaller = ctx.createMarshaller();
            mashaller.marshal(object, outputStream);
        } catch (JAXBException exception) {
            String errorMessage = String.format(
                    "Failed to convert %s object to xml", object.getClass()
                            .getName());
            throw new ManagerException(errorMessage, exception);
        }

        xml = outputStream.toString();

        return xml;
    }

    /**
     * Converts xml string to object.
     * 
     * @param clazz
     *            The type of target object
     * @param xml
     *            Xml string
     * @return The target object
     * @throws JAXBException
     */
    @SuppressWarnings("unchecked")
    public static <T> T xmlToObject(Class<T> clazz, String xml) {

        T object = null;

        InputStream inputStream = new ByteArrayInputStream(xml.getBytes());

        try {
            JAXBContext ctx = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = ctx.createUnmarshaller();
            object = (T) unmarshaller.unmarshal(inputStream);
        } catch (JAXBException exception) {
            String errorMessage = String.format(
                    "Failed to convert xml to %s object", clazz.getName());
            throw new ManagerException(errorMessage, exception);
        }

        return object;
    }

}
