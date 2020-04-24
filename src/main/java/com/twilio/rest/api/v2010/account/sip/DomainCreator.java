/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.api.v2010.account.sip;

import com.twilio.base.Creator;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

import java.net.URI;

public class DomainCreator extends Creator<Domain> {
    private String pathAccountSid;
    private final String domainName;
    private String friendlyName;
    private URI voiceUrl;
    private HttpMethod voiceMethod;
    private URI voiceFallbackUrl;
    private HttpMethod voiceFallbackMethod;
    private URI voiceStatusCallbackUrl;
    private HttpMethod voiceStatusCallbackMethod;
    private Boolean sipRegistration;
    private Boolean emergencyCallingEnabled;
    private Boolean secure;

    /**
     * Construct a new DomainCreator.
     *
     * @param domainName The unique address on Twilio to route SIP traffic
     */
    public DomainCreator(final String domainName) {
        this.domainName = domainName;
    }

    /**
     * Construct a new DomainCreator.
     *
     * @param pathAccountSid The SID of the Account that will create the resource
     * @param domainName The unique address on Twilio to route SIP traffic
     */
    public DomainCreator(final String pathAccountSid,
                         final String domainName) {
        this.pathAccountSid = pathAccountSid;
        this.domainName = domainName;
    }

    /**
     * A descriptive string that you created to describe the resource. It can be up
     * to 64 characters long..
     *
     * @param friendlyName A string to describe the resource
     * @return this
     */
    public DomainCreator setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    /**
     * The URL we should when the domain receives a call..
     *
     * @param voiceUrl The URL we should call when receiving a call
     * @return this
     */
    public DomainCreator setVoiceUrl(final URI voiceUrl) {
        this.voiceUrl = voiceUrl;
        return this;
    }

    /**
     * The URL we should when the domain receives a call..
     *
     * @param voiceUrl The URL we should call when receiving a call
     * @return this
     */
    public DomainCreator setVoiceUrl(final String voiceUrl) {
        return setVoiceUrl(Promoter.uriFromString(voiceUrl));
    }

    /**
     * The HTTP method we should use to call `voice_url`. Can be: `GET` or `POST`..
     *
     * @param voiceMethod The HTTP method to use with voice_url
     * @return this
     */
    public DomainCreator setVoiceMethod(final HttpMethod voiceMethod) {
        this.voiceMethod = voiceMethod;
        return this;
    }

    /**
     * The URL that we should call when an error occurs while retrieving or
     * executing the TwiML from `voice_url`..
     *
     * @param voiceFallbackUrl The URL we should call when an error occurs in
     *                         executing TwiML
     * @return this
     */
    public DomainCreator setVoiceFallbackUrl(final URI voiceFallbackUrl) {
        this.voiceFallbackUrl = voiceFallbackUrl;
        return this;
    }

    /**
     * The URL that we should call when an error occurs while retrieving or
     * executing the TwiML from `voice_url`..
     *
     * @param voiceFallbackUrl The URL we should call when an error occurs in
     *                         executing TwiML
     * @return this
     */
    public DomainCreator setVoiceFallbackUrl(final String voiceFallbackUrl) {
        return setVoiceFallbackUrl(Promoter.uriFromString(voiceFallbackUrl));
    }

    /**
     * The HTTP method we should use to call `voice_fallback_url`. Can be: `GET` or
     * `POST`..
     *
     * @param voiceFallbackMethod The HTTP method to use with voice_fallback_url
     * @return this
     */
    public DomainCreator setVoiceFallbackMethod(final HttpMethod voiceFallbackMethod) {
        this.voiceFallbackMethod = voiceFallbackMethod;
        return this;
    }

    /**
     * The URL that we should call to pass status parameters (such as call ended) to
     * your application..
     *
     * @param voiceStatusCallbackUrl The URL that we should call to pass status
     *                               updates
     * @return this
     */
    public DomainCreator setVoiceStatusCallbackUrl(final URI voiceStatusCallbackUrl) {
        this.voiceStatusCallbackUrl = voiceStatusCallbackUrl;
        return this;
    }

    /**
     * The URL that we should call to pass status parameters (such as call ended) to
     * your application..
     *
     * @param voiceStatusCallbackUrl The URL that we should call to pass status
     *                               updates
     * @return this
     */
    public DomainCreator setVoiceStatusCallbackUrl(final String voiceStatusCallbackUrl) {
        return setVoiceStatusCallbackUrl(Promoter.uriFromString(voiceStatusCallbackUrl));
    }

    /**
     * The HTTP method we should use to call `voice_status_callback_url`. Can be:
     * `GET` or `POST`..
     *
     * @param voiceStatusCallbackMethod The HTTP method we should use to call
     *                                  `voice_status_callback_url`
     * @return this
     */
    public DomainCreator setVoiceStatusCallbackMethod(final HttpMethod voiceStatusCallbackMethod) {
        this.voiceStatusCallbackMethod = voiceStatusCallbackMethod;
        return this;
    }

    /**
     * Whether to allow SIP Endpoints to register with the domain to receive calls.
     * Can be `true` or `false`. `true` allows SIP Endpoints to register with the
     * domain to receive calls, `false` does not..
     *
     * @param sipRegistration Whether SIP registration is allowed
     * @return this
     */
    public DomainCreator setSipRegistration(final Boolean sipRegistration) {
        this.sipRegistration = sipRegistration;
        return this;
    }

    /**
     * Whether emergency calling is enabled for the domain. If enabled, allows
     * emergency calls on the domain from phone numbers with validated addresses..
     *
     * @param emergencyCallingEnabled Whether emergency calling is enabled for the
     *                                domain.
     * @return this
     */
    public DomainCreator setEmergencyCallingEnabled(final Boolean emergencyCallingEnabled) {
        this.emergencyCallingEnabled = emergencyCallingEnabled;
        return this;
    }

    /**
     * Whether secure SIP is enabled for the domain. If enabled, TLS will be
     * enforced and SRTP will be negotiated on all incoming calls to this sip
     * domain..
     *
     * @param secure Whether secure SIP is enabled for the domain
     * @return this
     */
    public DomainCreator setSecure(final Boolean secure) {
        this.secure = secure;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the create.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Created Domain
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Domain create(final TwilioRestClient client) {
        this.pathAccountSid = this.pathAccountSid == null ? client.getAccountSid() : this.pathAccountSid;
        Request request = new Request(
            HttpMethod.POST,
            Domains.API.toString(),
            "/2010-04-01/Accounts/" + this.pathAccountSid + "/SIP/Domains.json",
            client.getRegion()
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Domain creation failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.apply(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Domain.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     *
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (domainName != null) {
            request.addPostParam("DomainName", domainName);
        }

        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);
        }

        if (voiceUrl != null) {
            request.addPostParam("VoiceUrl", voiceUrl.toString());
        }

        if (voiceMethod != null) {
            request.addPostParam("VoiceMethod", voiceMethod.toString());
        }

        if (voiceFallbackUrl != null) {
            request.addPostParam("VoiceFallbackUrl", voiceFallbackUrl.toString());
        }

        if (voiceFallbackMethod != null) {
            request.addPostParam("VoiceFallbackMethod", voiceFallbackMethod.toString());
        }

        if (voiceStatusCallbackUrl != null) {
            request.addPostParam("VoiceStatusCallbackUrl", voiceStatusCallbackUrl.toString());
        }

        if (voiceStatusCallbackMethod != null) {
            request.addPostParam("VoiceStatusCallbackMethod", voiceStatusCallbackMethod.toString());
        }

        if (sipRegistration != null) {
            request.addPostParam("SipRegistration", sipRegistration.toString());
        }

        if (emergencyCallingEnabled != null) {
            request.addPostParam("EmergencyCallingEnabled", emergencyCallingEnabled.toString());
        }

        if (secure != null) {
            request.addPostParam("Secure", secure.toString());
        }
    }
}