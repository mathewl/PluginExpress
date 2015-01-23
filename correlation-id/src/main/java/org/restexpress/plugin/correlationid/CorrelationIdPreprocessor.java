package org.restexpress.plugin.correlationid;

import org.restexpress.pipeline.Preprocessor;
import org.restexpress.Request;
import org.restexpress.util.RequestContext;

import java.util.UUID;

/**
 * Created by mathewl on 1/13/15.
 */
public class CorrelationIdPreprocessor implements Preprocessor {

    public CorrelationIdPreprocessor() {
    }

    @Override
    public void process(Request request) {

        String CorrelationId = request.getHeader("Correlation-Id");

        if (CorrelationId == null || CorrelationId.isEmpty()) {
            CorrelationId = UUID.randomUUID().toString();
        }

        RequestContext.put("Correlation-Id", CorrelationId);
    }
}
