/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.autopilot.v1.assistant.fieldtype;

import com.twilio.base.Creator;
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
public class FieldValueCreator extends Creator<FieldValue> {
    private final String pathAssistantSid;
    private final String pathFieldTypeSid;
    private final String language;
    private final String value;
    private String synonymOf;

    /**
     * Construct a new FieldValueCreator.
     *
     * @param pathAssistantSid The SID of the Assistant that is the parent of the
     *                         FieldType associated with the new resource
     * @param pathFieldTypeSid The SID of the Field Type associated with the Field
     *                         Value
     * @param language The ISO language-country tag that identifies the language of
     *                 the value
     * @param value The Field Value data
     */
    public FieldValueCreator(final String pathAssistantSid,
                             final String pathFieldTypeSid,
                             final String language,
                             final String value) {
        this.pathAssistantSid = pathAssistantSid;
        this.pathFieldTypeSid = pathFieldTypeSid;
        this.language = language;
        this.value = value;
    }

    /**
     * The string value that indicates which word the field value is a synonym of..
     *
     * @param synonymOf The string value that indicates which word the field value
     *                  is a synonym of
     * @return this
     */
    public FieldValueCreator setSynonymOf(final String synonymOf) {
        this.synonymOf = synonymOf;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the create.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Created FieldValue
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public FieldValue create(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.AUTOPILOT.toString(),
            "/v1/Assistants/" + this.pathAssistantSid + "/FieldTypes/" + this.pathFieldTypeSid + "/FieldValues",
            client.getRegion()
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("FieldValue creation failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.apply(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return FieldValue.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     *
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (language != null) {
            request.addPostParam("Language", language);
        }

        if (value != null) {
            request.addPostParam("Value", value);
        }

        if (synonymOf != null) {
            request.addPostParam("SynonymOf", synonymOf.toString());
        }
    }
}