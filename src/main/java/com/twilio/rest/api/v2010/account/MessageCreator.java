/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.api.v2010.account;

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

import java.math.BigDecimal;
import java.net.URI;
import java.util.List;

public class MessageCreator extends Creator<Message> {
    private String pathAccountSid;
    private final com.twilio.type.PhoneNumber to;
    private com.twilio.type.PhoneNumber from;
    private String messagingServiceSid;
    private String body;
    private List<URI> mediaUrl;
    private URI statusCallback;
    private String applicationSid;
    private BigDecimal maxPrice;
    private Boolean provideFeedback;
    private Integer validityPeriod;
    private Boolean forceDelivery;
    private Message.ContentRetention contentRetention;
    private Message.AddressRetention addressRetention;
    private Boolean smartEncoded;
    private List<String> persistentAction;

    /**
     * Construct a new MessageCreator.
     *
     * @param to The destination phone number
     * @param from The phone number that initiated the message
     * @param body The text of the message you want to send. Can be up to 1,600
     *             characters in length.
     */
    public MessageCreator(final com.twilio.type.PhoneNumber to,
                          final com.twilio.type.PhoneNumber from,
                          final String body) {
        this.to = to;
        this.from = from;
        this.body = body;
    }

    /**
     * Construct a new MessageCreator.
     *
     * @param pathAccountSid The SID of the Account that will create the resource
     * @param to The destination phone number
     * @param from The phone number that initiated the message
     * @param body The text of the message you want to send. Can be up to 1,600
     *             characters in length.
     */
    public MessageCreator(final String pathAccountSid,
                          final com.twilio.type.PhoneNumber to,
                          final com.twilio.type.PhoneNumber from,
                          final String body) {
        this.pathAccountSid = pathAccountSid;
        this.to = to;
        this.from = from;
        this.body = body;
    }

    /**
     * Construct a new MessageCreator.
     *
     * @param to The destination phone number
     * @param from The phone number that initiated the message
     * @param mediaUrl The URL of the media to send with the message
     */
    public MessageCreator(final com.twilio.type.PhoneNumber to,
                          final com.twilio.type.PhoneNumber from,
                          final List<URI> mediaUrl) {
        this.to = to;
        this.from = from;
        this.mediaUrl = mediaUrl;
    }

    /**
     * Construct a new MessageCreator.
     *
     * @param pathAccountSid The SID of the Account that will create the resource
     * @param to The destination phone number
     * @param from The phone number that initiated the message
     * @param mediaUrl The URL of the media to send with the message
     */
    public MessageCreator(final String pathAccountSid,
                          final com.twilio.type.PhoneNumber to,
                          final com.twilio.type.PhoneNumber from,
                          final List<URI> mediaUrl) {
        this.pathAccountSid = pathAccountSid;
        this.to = to;
        this.from = from;
        this.mediaUrl = mediaUrl;
    }

    /**
     * Construct a new MessageCreator.
     *
     * @param to The destination phone number
     * @param messagingServiceSid The SID of the Messaging Service you want to
     *                            associate with the message.
     * @param body The text of the message you want to send. Can be up to 1,600
     *             characters in length.
     */
    public MessageCreator(final com.twilio.type.PhoneNumber to,
                          final String messagingServiceSid,
                          final String body) {
        this.to = to;
        this.messagingServiceSid = messagingServiceSid;
        this.body = body;
    }

    /**
     * Construct a new MessageCreator.
     *
     * @param pathAccountSid The SID of the Account that will create the resource
     * @param to The destination phone number
     * @param messagingServiceSid The SID of the Messaging Service you want to
     *                            associate with the message.
     * @param body The text of the message you want to send. Can be up to 1,600
     *             characters in length.
     */
    public MessageCreator(final String pathAccountSid,
                          final com.twilio.type.PhoneNumber to,
                          final String messagingServiceSid,
                          final String body) {
        this.pathAccountSid = pathAccountSid;
        this.to = to;
        this.messagingServiceSid = messagingServiceSid;
        this.body = body;
    }

    /**
     * Construct a new MessageCreator.
     *
     * @param to The destination phone number
     * @param messagingServiceSid The SID of the Messaging Service you want to
     *                            associate with the message.
     * @param mediaUrl The URL of the media to send with the message
     */
    public MessageCreator(final com.twilio.type.PhoneNumber to,
                          final String messagingServiceSid,
                          final List<URI> mediaUrl) {
        this.to = to;
        this.messagingServiceSid = messagingServiceSid;
        this.mediaUrl = mediaUrl;
    }

    /**
     * Construct a new MessageCreator.
     *
     * @param pathAccountSid The SID of the Account that will create the resource
     * @param to The destination phone number
     * @param messagingServiceSid The SID of the Messaging Service you want to
     *                            associate with the message.
     * @param mediaUrl The URL of the media to send with the message
     */
    public MessageCreator(final String pathAccountSid,
                          final com.twilio.type.PhoneNumber to,
                          final String messagingServiceSid,
                          final List<URI> mediaUrl) {
        this.pathAccountSid = pathAccountSid;
        this.to = to;
        this.messagingServiceSid = messagingServiceSid;
        this.mediaUrl = mediaUrl;
    }

    /**
     * The URL we should call using the `status_callback_method` to send status
     * information to your application. If specified, we POST these message status
     * changes to the URL: `queued`, `failed`, `sent`, `delivered`, or
     * `undelivered`. Twilio will POST its [standard request
     * parameters](https://www.twilio.com/docs/sms/twiml#request-parameters) as well
     * as some additional parameters including `MessageSid`, `MessageStatus`, and
     * `ErrorCode`. If you include this parameter with the `messaging_service_sid`,
     * we use this URL instead of the Status Callback URL of the [Messaging
     * Service](https://www.twilio.com/docs/sms/services/api). URLs must contain a
     * valid hostname and underscores are not allowed..
     *
     * @param statusCallback The URL we should call to send status information to
     *                       your application
     * @return this
     */
    public MessageCreator setStatusCallback(final URI statusCallback) {
        this.statusCallback = statusCallback;
        return this;
    }

    /**
     * The URL we should call using the `status_callback_method` to send status
     * information to your application. If specified, we POST these message status
     * changes to the URL: `queued`, `failed`, `sent`, `delivered`, or
     * `undelivered`. Twilio will POST its [standard request
     * parameters](https://www.twilio.com/docs/sms/twiml#request-parameters) as well
     * as some additional parameters including `MessageSid`, `MessageStatus`, and
     * `ErrorCode`. If you include this parameter with the `messaging_service_sid`,
     * we use this URL instead of the Status Callback URL of the [Messaging
     * Service](https://www.twilio.com/docs/sms/services/api). URLs must contain a
     * valid hostname and underscores are not allowed..
     *
     * @param statusCallback The URL we should call to send status information to
     *                       your application
     * @return this
     */
    public MessageCreator setStatusCallback(final String statusCallback) {
        return setStatusCallback(Promoter.uriFromString(statusCallback));
    }

    /**
     * The SID of the application that should receive message status. We POST a
     * `message_sid` parameter and a `message_status` parameter with a value of
     * `sent` or `failed` to the
     * [application](https://www.twilio.com/docs/usage/api/applications)'s
     * `message_status_callback`. If a `status_callback` parameter is also passed,
     * it will be ignored and the application's `message_status_callback` parameter
     * will be used..
     *
     * @param applicationSid The application to use for callbacks
     * @return this
     */
    public MessageCreator setApplicationSid(final String applicationSid) {
        this.applicationSid = applicationSid;
        return this;
    }

    /**
     * The maximum total price in US dollars that you will pay for the message to be
     * delivered. Can be a decimal value that has up to 4 decimal places. All
     * messages are queued for delivery and the message cost is checked before the
     * message is sent. If the cost exceeds `max_price`, the message will fail and a
     * status of `Failed` is sent to the status callback. If `MaxPrice` is not set,
     * the message cost is not checked..
     *
     * @param maxPrice The total maximum price up to 4 decimal places in US dollars
     *                 acceptable for the message to be delivered.
     * @return this
     */
    public MessageCreator setMaxPrice(final BigDecimal maxPrice) {
        this.maxPrice = maxPrice;
        return this;
    }

    /**
     * Whether to confirm delivery of the message. Set this value to `true` if you
     * are sending messages that have a trackable user action and you intend to
     * confirm delivery of the message using the [Message Feedback
     * API](https://www.twilio.com/docs/sms/api/message-feedback-resource). This
     * parameter is `false` by default..
     *
     * @param provideFeedback Whether to confirm delivery of the message
     * @return this
     */
    public MessageCreator setProvideFeedback(final Boolean provideFeedback) {
        this.provideFeedback = provideFeedback;
        return this;
    }

    /**
     * How long in seconds the message can remain in our outgoing message queue.
     * After this period elapses, the message fails and we call your status
     * callback. Can be between 1 and the default value of 14,400 seconds. After a
     * message has been accepted by a carrier, however, we cannot guarantee that the
     * message will not be queued after this period. We recommend that this value be
     * at least 5 seconds..
     *
     * @param validityPeriod The number of seconds that the message can remain in
     *                       our outgoing queue.
     * @return this
     */
    public MessageCreator setValidityPeriod(final Integer validityPeriod) {
        this.validityPeriod = validityPeriod;
        return this;
    }

    /**
     * Reserved.
     *
     * @param forceDelivery Reserved
     * @return this
     */
    public MessageCreator setForceDelivery(final Boolean forceDelivery) {
        this.forceDelivery = forceDelivery;
        return this;
    }

    /**
     * Determines if the message content can be stored or redacted based on privacy
     * settings.
     *
     * @param contentRetention Determines if the message content can be stored or
     *                         redacted based on privacy settings
     * @return this
     */
    public MessageCreator setContentRetention(final Message.ContentRetention contentRetention) {
        this.contentRetention = contentRetention;
        return this;
    }

    /**
     * Determines if the address can be stored or obfuscated based on privacy
     * settings.
     *
     * @param addressRetention Determines if the address can be stored or
     *                         obfuscated based on privacy settings
     * @return this
     */
    public MessageCreator setAddressRetention(final Message.AddressRetention addressRetention) {
        this.addressRetention = addressRetention;
        return this;
    }

    /**
     * Whether to detect Unicode characters that have a similar GSM-7 character and
     * replace them. Can be: `true` or `false`..
     *
     * @param smartEncoded Whether to detect Unicode characters that have a similar
     *                     GSM-7 character and replace them
     * @return this
     */
    public MessageCreator setSmartEncoded(final Boolean smartEncoded) {
        this.smartEncoded = smartEncoded;
        return this;
    }

    /**
     * Rich actions for Channels Messages..
     *
     * @param persistentAction Rich actions for Channels Messages.
     * @return this
     */
    public MessageCreator setPersistentAction(final List<String> persistentAction) {
        this.persistentAction = persistentAction;
        return this;
    }

    /**
     * Rich actions for Channels Messages..
     *
     * @param persistentAction Rich actions for Channels Messages.
     * @return this
     */
    public MessageCreator setPersistentAction(final String persistentAction) {
        return setPersistentAction(Promoter.listOfOne(persistentAction));
    }

    /**
     * A Twilio phone number in
     * [E.164](https://www.twilio.com/docs/glossary/what-e164) format, an
     * [alphanumeric sender
     * ID](https://www.twilio.com/docs/sms/send-messages#use-an-alphanumeric-sender-id), or a [Channel Endpoint address](https://www.twilio.com/docs/sms/channels#channel-addresses) that is enabled for the type of message you want to send. Phone numbers or [short codes](https://www.twilio.com/docs/sms/api/short-code) purchased from Twilio also work here. You cannot, for example, spoof messages from a private cell phone number. If you are using `messaging_service_sid`, this parameter must be empty..
     *
     * @param from The phone number that initiated the message
     * @return this
     */
    public MessageCreator setFrom(final com.twilio.type.PhoneNumber from) {
        this.from = from;
        return this;
    }

    /**
     * A Twilio phone number in
     * [E.164](https://www.twilio.com/docs/glossary/what-e164) format, an
     * [alphanumeric sender
     * ID](https://www.twilio.com/docs/sms/send-messages#use-an-alphanumeric-sender-id), or a [Channel Endpoint address](https://www.twilio.com/docs/sms/channels#channel-addresses) that is enabled for the type of message you want to send. Phone numbers or [short codes](https://www.twilio.com/docs/sms/api/short-code) purchased from Twilio also work here. You cannot, for example, spoof messages from a private cell phone number. If you are using `messaging_service_sid`, this parameter must be empty..
     *
     * @param from The phone number that initiated the message
     * @return this
     */
    public MessageCreator setFrom(final String from) {
        return setFrom(Promoter.phoneNumberFromString(from));
    }

    /**
     * The SID of the [Messaging
     * Service](https://www.twilio.com/docs/sms/services#send-a-message-with-copilot) you want to associate with the Message. Set this parameter to use the [Messaging Service Settings and Copilot Features](https://www.twilio.com/console/sms/services) you have configured and leave the `from` parameter empty. When only this parameter is set, Twilio will use your enabled Copilot Features to select the `from` phone number for delivery..
     *
     * @param messagingServiceSid The SID of the Messaging Service you want to
     *                            associate with the message.
     * @return this
     */
    public MessageCreator setMessagingServiceSid(final String messagingServiceSid) {
        this.messagingServiceSid = messagingServiceSid;
        return this;
    }

    /**
     * The text of the message you want to send. Can be up to 1,600 characters in
     * length..
     *
     * @param body The text of the message you want to send. Can be up to 1,600
     *             characters in length.
     * @return this
     */
    public MessageCreator setBody(final String body) {
        this.body = body;
        return this;
    }

    /**
     * The URL of the media to send with the message. The media can be of type
     * `gif`, `png`, and `jpeg` and will be formatted correctly on the recipient's
     * device. The media size limit is 5MB for supported file types (JPEG, PNG, GIF)
     * and 500KB for [other
     * types](https://www.twilio.com/docs/sms/accepted-mime-types) of accepted
     * media. To send more than one image in the message body, provide multiple
     * `media_url` parameters in the POST request. You can include up to 10
     * `media_url` parameters per message. You can send images in an SMS message in
     * only the US and Canada..
     *
     * @param mediaUrl The URL of the media to send with the message
     * @return this
     */
    public MessageCreator setMediaUrl(final List<URI> mediaUrl) {
        this.mediaUrl = mediaUrl;
        return this;
    }

    /**
     * The URL of the media to send with the message. The media can be of type
     * `gif`, `png`, and `jpeg` and will be formatted correctly on the recipient's
     * device. The media size limit is 5MB for supported file types (JPEG, PNG, GIF)
     * and 500KB for [other
     * types](https://www.twilio.com/docs/sms/accepted-mime-types) of accepted
     * media. To send more than one image in the message body, provide multiple
     * `media_url` parameters in the POST request. You can include up to 10
     * `media_url` parameters per message. You can send images in an SMS message in
     * only the US and Canada..
     *
     * @param mediaUrl The URL of the media to send with the message
     * @return this
     */
    public MessageCreator setMediaUrl(final URI mediaUrl) {
        return setMediaUrl(Promoter.listOfOne(mediaUrl));
    }

    /**
     * The URL of the media to send with the message. The media can be of type
     * `gif`, `png`, and `jpeg` and will be formatted correctly on the recipient's
     * device. The media size limit is 5MB for supported file types (JPEG, PNG, GIF)
     * and 500KB for [other
     * types](https://www.twilio.com/docs/sms/accepted-mime-types) of accepted
     * media. To send more than one image in the message body, provide multiple
     * `media_url` parameters in the POST request. You can include up to 10
     * `media_url` parameters per message. You can send images in an SMS message in
     * only the US and Canada..
     *
     * @param mediaUrl The URL of the media to send with the message
     * @return this
     */
    public MessageCreator setMediaUrl(final String mediaUrl) {
        return setMediaUrl(Promoter.uriFromString(mediaUrl));
    }

    /**
     * Make the request to the Twilio API to perform the create.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Created Message
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Message create(final TwilioRestClient client) {
        this.pathAccountSid = this.pathAccountSid == null ? client.getAccountSid() : this.pathAccountSid;
        Request request = new Request(
            HttpMethod.POST,
            Domains.API.toString(),
            "/2010-04-01/Accounts/" + this.pathAccountSid + "/Messages.json",
            client.getRegion()
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Message creation failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.apply(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Message.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     *
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (to != null) {
            request.addPostParam("To", to.toString());
        }

        if (from != null) {
            request.addPostParam("From", from.toString());
        }

        if (messagingServiceSid != null) {
            request.addPostParam("MessagingServiceSid", messagingServiceSid);
        }

        if (body != null) {
            request.addPostParam("Body", body);
        }

        if (mediaUrl != null) {
            for (URI prop : mediaUrl) {
                request.addPostParam("MediaUrl", prop.toString());
            }
        }

        if (statusCallback != null) {
            request.addPostParam("StatusCallback", statusCallback.toString());
        }

        if (applicationSid != null) {
            request.addPostParam("ApplicationSid", applicationSid);
        }

        if (maxPrice != null) {
            request.addPostParam("MaxPrice", maxPrice.toString());
        }

        if (provideFeedback != null) {
            request.addPostParam("ProvideFeedback", provideFeedback.toString());
        }

        if (validityPeriod != null) {
            request.addPostParam("ValidityPeriod", validityPeriod.toString());
        }

        if (forceDelivery != null) {
            request.addPostParam("ForceDelivery", forceDelivery.toString());
        }

        if (contentRetention != null) {
            request.addPostParam("ContentRetention", contentRetention.toString());
        }

        if (addressRetention != null) {
            request.addPostParam("AddressRetention", addressRetention.toString());
        }

        if (smartEncoded != null) {
            request.addPostParam("SmartEncoded", smartEncoded.toString());
        }

        if (persistentAction != null) {
            for (String prop : persistentAction) {
                request.addPostParam("PersistentAction", prop);
            }
        }
    }
}