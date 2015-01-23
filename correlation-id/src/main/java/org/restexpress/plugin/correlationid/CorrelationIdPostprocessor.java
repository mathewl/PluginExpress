package org.restexpress.plugin.correlationid;

import org.restexpress.Request;
import org.restexpress.Response;
import org.restexpress.pipeline.Postprocessor;
import org.restexpress.util.RequestContext;

/**
 * Created by mathewl on 1/14/15.
 */
public class CorrelationIdPostprocessor implements Postprocessor {

    public CorrelationIdPostprocessor() {
    }

    @Override
    public void process(Request request, Response response) {

        response.addHeader("Correlation-Id", (String) RequestContext.get("Correlation-Id"));

        RequestContext.clear(); // threads are pooled and re-used, so clear up resources
    }
}
