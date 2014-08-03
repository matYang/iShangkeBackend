package com.ishangke.edunav.web.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Matthew A static tree parset that produces a list of hierarchy data
 *         ready for JSON to consume Benchmark results are not entirely
 *         safisfactory 200 element parsing require an average around 5-6ms
 *         however, the redundancy that slowed the process down helps to catch
 *         errors, efficiency analysis: this parsing function has O(n) thanks to
 *         the sink this parsing function behaves most efficiently when sorted,
 *         eg no null fills, no sinks, fast a Collections.sort can really help a
 *         lot, but do not run sort every time, as sort costs a lot O(nlogn)
 *         benchmarks show an average of 30%-40% decrease in performance when
 *         cost of sorting is considered performance degrade when sorting is
 *         concerned is directly proportional to data size
 */
public class TreeParser {

    // please do use array list here..do not use fucking linked list, or I will
    // personally kill you
    public static List<? extends HierarchyData> parse(List<? extends HierarchyData> flatData) throws HierarchyException {
        List<HierarchyData> treeTop = new ArrayList<HierarchyData>();
        Map<String, ArrayList<HierarchyData>> sink = new HashMap<String, ArrayList<HierarchyData>>();

        for (HierarchyData data : flatData) {
            String value = data.getValue();
            if (value.length() > 0 && value.length() % 2 == 0) {
                int topIndex = Integer.parseInt(value.substring(0, 2));
                // null fill, will not be called if topIndex within range
                for (int i = treeTop.size(); i < topIndex + 1; i++) {
                    treeTop.add(null);
                }
                // length == 2, top level node
                if (value.length() == 2) {
                    treeTop.set(topIndex, data);
                    drainSink(data, sink);
                } else {
                    addChild(treeTop.get(topIndex), data, sink);
                }
            } else {
                throw new HierarchyException("Value format error, current value: " + value);
            }
        }
        if (sink.size() > 0) {
            throw new HierarchyException("Sink not emptied, elements: " + sink.size());
        }
        return treeTop;
    }

    private static void addChild(HierarchyData top, HierarchyData data, Map<String, ArrayList<HierarchyData>> sink) throws HierarchyException {
        String value = data.getValue();
        if (top == null) {
            // if parent not inserted, place the object in the sink, parent
            // inserted in the future will trigger sink drain
            addToSink(data, sink);
        }

        String sufix = value.substring(2);
        HierarchyData parent = top;
        while (sufix.length() > 2 && parent != null) {
            parent = parent.getChild(Integer.parseInt(sufix.substring(0, 2)));
            sufix = sufix.substring(2);
        }
        if (parent != null) {
            parent.addChild(data);
            drainSink(data, sink);
        } else {
            addToSink(data, sink);
        }
    }

    private static void drainSink(HierarchyData data, Map<String, ArrayList<HierarchyData>> sink) throws HierarchyException {
        ArrayList<HierarchyData> sinkedList = sink.get(data.getValue());
        if (sinkedList != null) {
            for (HierarchyData sinked : sinkedList) {
                data.addChild(sinked);
                drainSink(sinked, sink);
            }
            sink.remove(data.getValue());
        }
    }

    private static void addToSink(HierarchyData data, Map<String, ArrayList<HierarchyData>> sink) {
        String value = data.getValue();
        String key = value.substring(0, value.length() - 2);
        ArrayList<HierarchyData> sinkedList = sink.get(key);
        if (sinkedList == null) {
            sinkedList = new ArrayList<HierarchyData>();
        }
        sinkedList.add(data);
        sink.put(key, sinkedList);
        return;
    }

}
