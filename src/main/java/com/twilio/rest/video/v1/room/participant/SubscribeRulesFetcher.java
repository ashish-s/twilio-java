/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.video.v1.room.participant;

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
 * PLEASE NOTE that this class contains beta products that are subject to
 * change. Use them with caution.
 */
public class SubscribeRulesFetcher extends Fetcher<SubscribeRules> {
    private final String pathRoomSid;
    private final String pathParticipantSid;

    /**
     * Construct a new SubscribeRulesFetcher.
     *
     * @param pathRoomSid The SID of the Room resource where the subscribe rules to
     *                    fetch apply
     * @param pathParticipantSid The SID of the Participant resource with the
     *                           subscribe rules to fetch
     */
    public SubscribeRulesFetcher(final String pathRoomSid,
                                 final String pathParticipantSid) {
        this.pathRoomSid = pathRoomSid;
        this.pathParticipantSid = pathParticipantSid;
    }

    /**
     * Make the request to the Twilio API to perform the fetch.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Fetched SubscribeRules
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public SubscribeRules fetch(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            Domains.VIDEO.toString(),
            "/v1/Rooms/" + this.pathRoomSid + "/Participants/" + this.pathParticipantSid + "/SubscribeRules",
            client.getRegion()
        );

        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("SubscribeRules fetch failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.apply(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }

            throw new ApiException(
                restException.getMessage(),
                restException.getCode(),
                restException.getMoreInfo(),
                restException.getStatus(),
                null
            );
        }

        return SubscribeRules.fromJson(response.getStream(), client.getObjectMapper());
    }
}