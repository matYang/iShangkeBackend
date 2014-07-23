package com.ishangke.edunav.web.tree;

/**
 * This exception is used for tree parser to indication violation of hierarchical structure
 */
public class HierarchyException extends Exception{
    private static final long serialVersionUID = 1L;
    private String msg;
    public HierarchyException(String message) {
        super();
        this.msg = message;
    }
    @Override
    public String getMessage() {
        return this.msg;
    }
}
