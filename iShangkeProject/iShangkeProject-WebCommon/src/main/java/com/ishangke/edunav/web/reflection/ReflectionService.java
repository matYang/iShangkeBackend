package com.ishangke.edunav.web.reflection;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ishangke.edunav.common.utilities.DateUtility;

public class ReflectionService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReflectionService.class);

    private Field[] fields;
    private Map<String, Field> map;
    private Object c;

    public ReflectionService(Object c) {
        super();
        this.c = c;
        this.fields = c.getClass().getFields();
        setMap();
    }

    private void setMap() {
        map = new HashMap<String, Field>();
        for (Field field : fields) {
            field.setAccessible(true);
            map.put(field.getName(), field);
        }
    }

    public Object getBoFromMap(Map<String, String> kvmap) throws IllegalArgumentException, IllegalAccessException, ParseException {
        for (String f : kvmap.keySet()) {
            Field field = map.get(f);
            field.setAccessible(true);
            Class<?> classType = field.getType();
            try {
                if (kvmap.get(f) != null && !kvmap.get(f).equals("")) {
                    if (Integer.class.isAssignableFrom(classType) || int.class.isAssignableFrom(classType)) {
                        field.set(c, Integer.parseInt(kvmap.get(f)));
                    } else if (String.class.isAssignableFrom(classType)) {
                        field.set(c, kvmap.get(f));
                    } else if (long.class.isAssignableFrom(classType) || Long.class.isAssignableFrom(classType)) {
                        field.set(c, DateUtility.parseDateTimeFromExcelFile((kvmap.get(f))));
                    } else if (Double.class.isAssignableFrom(classType) || double.class.isAssignableFrom(classType)) {
                        field.set(c, Double.parseDouble(kvmap.get(f)));
                    }
                }

            } catch (IllegalArgumentException | IllegalAccessException | ParseException e) {
                LOGGER.debug("出错了: field gets wrong is : " + field.getName());
                throw e;
            }

        }
        return c;
    }

}
