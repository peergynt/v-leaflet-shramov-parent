package org.peimari.gleaflet.client.resources;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.ScriptInjector;

public class LeafletShramovResourceInjector {

    protected static LeafletShramovClientBundle bundle;

    public static void ensureInjected() {
        if (bundle == null) {
            LeafletResourceInjector.ensureInjected();
            bundle = GWT.create(LeafletShramovClientBundle.class);
            LeafletShramovResourceInjector injector = GWT
                    .create(LeafletShramovResourceInjector.class);
            injector.injectResources();
        }
    }

    /**
     * Override this with deferred binding to customize injected stuff
     */
    protected void injectResources() {
        final String text = bundle.google().getText();
        ScriptInjector.fromString(text).setWindow(nativeTopWindow()).inject();
    }

    private static native JavaScriptObject nativeTopWindow() /*-{
     return $wnd;
    }-*/;

}
