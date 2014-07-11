package com.ishangke.edunav.dataaccess.common;

public class PaginationEntity {
    private int size;
    private int offset;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}
