package com.ishangke.edunav.web.tree;

import java.util.ArrayList;

import com.ishangke.edunav.web.response.JsonResponse;

public class HierarchyData extends JsonResponse {
    protected String name;

    protected String value;

    protected ArrayList<HierarchyData> children;

    protected HierarchyData() {
        this.name = "";
        this.value = "";
        this.children = new ArrayList<HierarchyData>();
    }

    public String getValue() {
        return this.value;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<HierarchyData> getChildren() {
        return this.children;
    }

    public HierarchyData getChild(int index) {
        if (this.children == null || this.children.size() <= index) {
            return null;
        }
        return this.children.get(index);
    }

    // this function is not a test and set function
    // child added in is excepted to be valid in the first place
    public void addChild(HierarchyData pendingChild) throws HierarchyException {
        if (pendingChild == null) {
            throw new HierarchyException("Pengding child null");
        }
        int curValLength = this.value.length();
        int targetValLength = pendingChild.value.length();

        if ((curValLength + 2) != targetValLength) {
            throw new HierarchyException("Value length not matched, cur length: " + curValLength + " target length: "
                    + targetValLength);
        }
        if (!this.value.equals(pendingChild.value.substring(0, curValLength))) {
            throw new HierarchyException("Prefix not match, cur value: " + this.value + " target prefix: "
                    + pendingChild.value.substring(0, curValLength));
        }
        int targetIndex = Integer.parseInt(pendingChild.value.substring(curValLength));
        // make sure initialized
        if (this.children == null) {
            this.children = new ArrayList<HierarchyData>();
        }
        // fill in null as place holders, fast, and if error occurs, null
        // pointer exception tells us asap
        for (int i = this.children.size(); i < targetIndex + 1; i++) {
            this.children.add(null);
        }
        this.children.set(targetIndex, pendingChild);
    }
}
