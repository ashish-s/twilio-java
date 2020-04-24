/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.proxy.v1.service;

import com.twilio.base.Updater;
import com.twilio.converter.DateConverter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import org.joda.time.DateTime;

/**
 * PLEASE NOTE that this class contains beta products that are subject to
 * change. Use them with caution.
 */
public class SessionUpdater extends Updater<Session> {
    private final String pathServiceSid;
    private final String pathSid;
    private DateTime dateExpiry;
    private Integer ttl;
    private Session.Status status;

    /**
     * Construct a new SessionUpdater.
     *
     * @param pathServiceSid The SID of the Service to update the resource from
     * @param pathSid The unique string that identifies the resource
     */
    public SessionUpdater(final String pathServiceSid,
                          final String pathSid) {
        this.pathServiceSid = pathServiceSid;
        this.pathSid = pathSid;
    }

    /**
     * The [ISO 8601](https://en.wikipedia.org/wiki/ISO_8601) date when the Session
     * should expire. If this is value is present, it overrides the `ttl` value..
     *
     * @param dateExpiry The ISO 8601 date when the Session should expire
     * @return this
     */
    public SessionUpdater setDateExpiry(final DateTime dateExpiry) {
        this.dateExpiry = dateExpiry;
        return this;
    }

    /**
     * The time, in seconds, when the session will expire. The time is measured from
     * the last Session create or the Session's last Interaction..
     *
     * @param ttl When the session will expire
     * @return this
     */
    public SessionUpdater setTtl(final Integer ttl) {
        this.ttl = ttl;
        return this;
    }

    /**
     * The new status of the resource. Can be: `in-progress` to re-open a session or
     * `closed` to close a session..
     *
     * @param status The new status of the resource
     * @return this
     */
    public SessionUpdater setStatus(final Session.Status status) {
        this.status = status;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the update.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Updated Session
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Session update(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.PROXY.toString(),
            "/v1/Services/" + this.pathServiceSid + "/Sessions/" + this.pathSid + "",
            client.getRegion()
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Session update failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.apply(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Session.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     *
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (dateExpiry != null) {
            request.addPostParam("DateExpiry", dateExpiry.toString());
        }

        if (ttl != null) {
            request.addPostParam("Ttl", ttl.toString());
        }

        if (status != null) {
            request.addPostParam("Status", status.toString());
        }
    }
}