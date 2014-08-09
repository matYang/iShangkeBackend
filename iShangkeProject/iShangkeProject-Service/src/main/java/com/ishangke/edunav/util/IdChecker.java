package com.ishangke.edunav.util;

/**
 *  why on earth do we NOT set id to null in converters!!
 *  oh yeh I am a fucking genius
 * @author matthew
 */
public class IdChecker {

    /**
     * using Object here to avoid null pointers in auto-boxing
     * oh yeh I am a fucking genius
     */
    public static boolean isNull(Integer id) {
        return id == null || id <= 0;
    }
    
    /*
     * calling !isNull(Integer id)
     * simply because I do not want to write '!'  or worrying about forggeting to write '!' every time
     * oh yeh I am a fucking genius
     */
    public static boolean notNull(Integer id) {
        return !isNull(id);
    }
    
    
    /**
     * using Object here to avoid null pointers in auto-boxing
     * oh yeh I am a fucking genius
     */
    public static boolean isNull(Long id) {
        return id == null || id <= 0;
    }
    
    /*
     * calling !isNull(Long id)
     * simply because I do not want to write '!'  or worrying about forggeting to write '!' every time
     * oh yeh I am a fucking genius
     */
    public static boolean notNull(Long id) {
        return !isNull(id);
    }
    
    
    /**
     * using Object here to avoid null pointers in auto-boxing
     * oh yeh I am a fucking genius
     */
    public static boolean isEqual(Integer id_a, Integer id_b) {
        //object equality, also covers the both null case
        if (id_a == id_b) {
            return true;
        }
        if (id_a == null || id_b == null) {
            return false;
        }
        //use intValue() is more effieicnt because .equals() needs to check type (and this really should not matter..)
        return id_a.intValue() == id_b.intValue();
    }
    
    /*
     * calling !isEqual(Integer id_a, Integer id_b)
     * simply because I do not want to write '!'  or worrying about forggeting to write '!' every time
     * oh yeh I am a fucking genius
     */
    public static boolean notEqual(Integer id_a, Integer id_b) {
        return !isEqual(id_a, id_b);
    }
    
    
    /**
     * using Object here to avoid null pointers in auto-boxing
     * oh yeh I am a fucking genius
     */
    public static boolean isEqual(Long id_a, Long id_b) {
        //object equality, also covers the both null case
        if (id_a == id_b) {
            return true;
        }
        if (id_a == null || id_b == null) {
            return false;
        }
        return id_a.longValue() == id_b.longValue();
    }
    
    /*
     * calling !isEqual(Long id_a, Long id_b))
     * simply because I do not want to write '!'  or worrying about forggeting to write '!' every time
     * oh yeh I am a fucking genius
     */
    public static boolean notEqual(Long id_a, Long id_b) {
        return !isEqual(id_a, id_b);
    }

    
}
