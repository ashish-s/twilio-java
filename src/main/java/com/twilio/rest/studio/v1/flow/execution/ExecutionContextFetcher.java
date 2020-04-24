/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.studio.v1.flow.execution;

import com.twilio.base.Fetcher;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class ExecutionContextFetcher extends Fetcher<ExecutionContext> {
    private final String pathFlowSid;
    private final String pathExecutionSid;

    /**
     * Construct a new ExecutionContextFetcher.
     *
     * @param pathFlowSid The SID of the Flow
     * @param pathExecutionSid The SID of the Execution
     */
    public ExecutionContextFetcher(final String pathFlowSid,
                                   final String pathExecutionSid) {
        this.pathFlowSid = pathFlowSid;
        this.pathExecutionSid = pathExecutionSid;
    }

    /**
     * Make the request to the Twilio API to perform the fetch.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Fetched ExecutionContext
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public ExecutionContext fetch(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            Domains.STUDIO.toString(),
            "/v1/Flows/" + this.pathFlowSid + "/Executions/" + this.pathExecutionSid + "/Context",
            client.getRegion()
        );

        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("ExecutionContext fetch failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.apply(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return ExecutionContext.fromJson(response.getStream(), client.getObjectMapper());
    }
}