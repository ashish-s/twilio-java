/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.preview.sync.service;

import com.twilio.base.Fetcher;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

/**
 * PLEASE NOTE that this class contains preview products that are subject to
 * change. Use them with caution. If you currently do not have developer preview
 * access, please contact help@twilio.com.
 */
public class SyncMapFetcher extends Fetcher<SyncMap> {
    private final String pathServiceSid;
    private final String pathSid;

    /**
     * Construct a new SyncMapFetcher.
     *
     * @param pathServiceSid The service_sid
     * @param pathSid The sid
     */
    public SyncMapFetcher(final String pathServiceSid,
                          final String pathSid) {
        this.pathServiceSid = pathServiceSid;
        this.pathSid = pathSid;
    }

    /**
     * Make the request to the Twilio API to perform the fetch.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Fetched SyncMap
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public SyncMap fetch(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            Domains.PREVIEW.toString(),
            "/Sync/Services/" + this.pathServiceSid + "/Maps/" + this.pathSid + "",
            client.getRegion()
        );

        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("SyncMap fetch failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.apply(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return SyncMap.fromJson(response.getStream(), client.getObjectMapper());
    }
}