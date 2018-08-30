package com.anychart.core.utils;

import com.anychart.APIlib;

import java.util.Locale;

// class
/**
 * Interactivity class for stocks.
 */
public class StockInteractivity extends Interactivity {

    protected StockInteractivity() {

    }

    public static StockInteractivity instantiate() {
        return new StockInteractivity("new anychart.core.utils.stockInteractivity()");
    }

    

    public StockInteractivity(String jsChart) {
        jsBase = "stockInteractivity" + ++variableIndex;
        APIlib.getInstance().addJSLine(jsBase + " = " + jsChart + ";");
    }

    public String getJsBase() {
        return jsBase;
    }

    
    /**
     * Getter for the multi-select on click.
     */
    public void multiSelectOnClick() {
        APIlib.getInstance().addJSLine(jsBase + ".multiSelectOnClick();");
    }
    /**
     * Setter for the multi-select on click.
     */
    public com.anychart.core.utils.StockInteractivity multiSelectOnClick(Boolean value) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".multiSelectOnClick(%s);", value));

        return this;
    }
    /**
     * Removes all listeners from an object. You can also optionally remove listeners of some particular type.
     */
    public void removeAllListeners(String type) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".removeAllListeners(%s);", wrapQuotes(type)));
    }
    /**
     * Getter for the scrolling.
     */
    public void scrollOnMouseWheel() {
        APIlib.getInstance().addJSLine(jsBase + ".scrollOnMouseWheel();");
    }
    /**
     * Setter for the scrolling.<br/>
Allows use mouse wheel for scrolling. Press "ctrl" or "shift" and scroll mouse wheel.
     */
    public com.anychart.core.utils.StockInteractivity scrollOnMouseWheel(Boolean value) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".scrollOnMouseWheel(%s);", value));

        return this;
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
    /**
     * Getter for the unselectOnClickOutOfPoint.
     */
    public void unselectOnClickOutOfPoint() {
        APIlib.getInstance().addJSLine(jsBase + ".unselectOnClickOutOfPoint();");
    }
    /**
     * Setter for the unselectOnClickOutOfPoint.<br/>
If the value is <b>true<b/>, disables select all points when clicking outside the chart point.
     */
    public com.anychart.core.utils.StockInteractivity unselectOnClickOutOfPoint(Boolean value) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".unselectOnClickOutOfPoint(%s);", value));

        return this;
    }
    /**
     * Getter for the zoom.
     */
    public void zoomOnMouseWheel() {
        APIlib.getInstance().addJSLine(jsBase + ".zoomOnMouseWheel();");
    }
    /**
     * Setter for the zoom.<br/>
Allows use mouse wheel for zooming.
     */
    public com.anychart.core.utils.StockInteractivity zoomOnMouseWheel(Boolean value) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".zoomOnMouseWheel(%s);", value));

        return this;
    }
    /**
     * 
     */
    public com.anychart.core.utils.StockInteractivity allowMultiSeriesSelection(Boolean value) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".allowMultiSeriesSelection(%s);", value));

        return this;
    }
    /**
     * Getter for the hover mode.
     */
    public void hoverMode() {
        APIlib.getInstance().addJSLine(jsBase + ".hoverMode();");
    }
    /**
     * Setter for the hover mode.
     */
    public com.anychart.core.utils.StockInteractivity hoverMode(com.anychart.enums.HoverMode value) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".hoverMode(%s);", (value != null) ? value.getJsBase() : null));

        return this;
    }
    /**
     * Setter for the hover mode.
     */
    public com.anychart.core.utils.StockInteractivity hoverMode(String value) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".hoverMode(%s);", wrapQuotes(value)));

        return this;
    }
    /**
     * Getter for the selection mode.
     */
    public void selectionMode() {
        APIlib.getInstance().addJSLine(jsBase + ".selectionMode();");
    }
    /**
     * Setter for the selection mode.
     */
    public com.anychart.core.utils.StockInteractivity selectionMode(com.anychart.enums.SelectionMode value) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".selectionMode(%s);", (value != null) ? value.getJsBase() : null));

        return this;
    }
    /**
     * Setter for the selection mode.
     */
    public com.anychart.core.utils.StockInteractivity selectionMode(String value) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".selectionMode(%s);", wrapQuotes(value)));

        return this;
    }
    /**
     * Getter for the spot radius.
     */
    public void spotRadius() {
        APIlib.getInstance().addJSLine(jsBase + ".spotRadius();");
    }
    /**
     * Setter for the spot radius.
Size of the area under cursor in pixels for radius hovering.
<b>Note:</b> Works only with "by-spot" value in the {@link anychart.core.utils.Interactivity#hoverMode} method.
     */
    public com.anychart.core.utils.StockInteractivity spotRadius(Number value) {
        APIlib.getInstance().addJSLine(String.format(Locale.US, jsBase + ".spotRadius(%s);", value));

        return this;
    }

}