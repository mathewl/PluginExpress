/*
    Copyright 2014, Strategic Gains, Inc.

	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at

		http://www.apache.org/licenses/LICENSE-2.0

	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.
 */
package org.restexpress.plugin.correlationid;

import org.restexpress.RestExpress;
import org.restexpress.plugin.AbstractPlugin;

/**
 * Adds a Preprocessor and a Final Postprocess to set/maintain a Correlation-Id.
 *
 * The Preprocessor  reads a Correlation-Id header and saves the value to RequestContext.
 *
 * If the Correlation-Id header is not present a new random UUID is created.
 *
 * Correlation-Id value is accessible during the request lifecycle via the following:
 *     String correlationIdValue = (String) RequestContext.get("Correlation-Id");
 *
 * The FinalProcessor adds the Correlation-Id header/value to the Response.
 * 
 * @author mathewl
 * @since Jan 23, 2015
 */
public class CorrelationIdPlugin
extends AbstractPlugin
{
	private String name;

	public CorrelationIdPlugin()
	{
		super();
	}

	@Override
	public CorrelationIdPlugin register(RestExpress restExpress)
	{
		if (isRegistered()) return this;

		super.register(restExpress);

        restExpress.addPreprocessor(new CorrelationIdPreprocessor());
        restExpress.addFinallyProcessor(new CorrelationIdPostprocessor());

		return this;
	}

}
