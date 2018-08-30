package com.anychart.data;

import com.anychart.APIlib;
import com.anychart.core.Base;

import java.util.Locale;

// class
/**
 * Table mapping constructor.
 */
public class TableMapping extends Base {

    protected TableMapping() {

    }

    public static TableMapping instantiate() {
        return new TableMapping("new anychart.data.tableMapping()");
    }

    

    public TableMapping(String jsChart) {
        jsBase = "tableMapping" + ++variableIndex;
        APIlib.getInstance().addJSLine(jsBase + " = " + jsChart + ";");
    }

    public String getJsBase() {
        return jsBase;
    }

    
    /**
     * Adds a field to the mapping.
     */
    public com.anychart.data.TableMapping addField(String name, Number column, com.anychart.enums.AggregationType type, Number weightsColumn) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".addField(%s, %s, %s, %s);", wrapQuotes(name), column, (type != null) ? type.getJsBase() : null, weightsColumn));

        return this;
    }
    /**
     * Adds a field to the mapping.
     */
    public com.anychart.data.TableMapping addField(String name, Number column, String type, Number weightsColumn) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".addField(%s, %s, %s, %s);", wrapQuotes(name), column, wrapQuotes(type), weightsColumn));

        return this;
    }
    /**
     * Returns new selectable object for the mapping.
     */
    public com.anychart.data.TableSelectable createSelectable() {
        return new com.anychart.data.TableSelectable(jsBase + ".createSelectable()");
    }
    /**
     * Removes all listeners from an object. You can also optionally remove listeners of some particular type.
     */
    public void removeAllListeners(String type) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".removeAllListeners(%s);", wrapQuotes(type)));
    }
    public void setOnClickListener(com.anychart.chart.common.listener.ListenersInterface.OnClickListener listener) {
        StringBuilder js = new StringBuilder();

        js.append(jsBase).append(".listen('pointClick', function(e) {");

        if (listener.getFields() != null) {
            js.append("var result = ");
            for (String field : listener.getFields()) {
                js.append(String.format(Locale.US, "'%1$s' + ':' + e.point.get('%1$s') + ',' +", field));
            }
            js.setLength(js.length() - 8);
            js.append(";");

            js.append("android.onClick(result);");
        } else {
            js.append("android.onClick(null);");
        }
        js.append("});");

        com.anychart.chart.common.listener.ListenersInterface.getInstance().setOnClickListener(listener);

        APIlib.getInstance().addJSLine(js.toString());
    }
    /**
     * Removes an event listener which was added with listen() by the key returned by listen() or listenOnce().
     */
    public void unlistenByKey(String key) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".unlistenByKey(%s);", wrapQuotes(key)));
    }

}