package com.telus.subsfraudmgmt.springboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.gcp.pubsub.core.PubSubTemplate;
import org.springframework.cloud.gcp.pubsub.integration.AckMode;
import org.springframework.cloud.gcp.pubsub.integration.inbound.PubSubInboundChannelAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.messaging.MessageChannel;

@Configuration
public class PubSubConfig {

	public static final String FRAUD_TOPIC_SUBSCRIPTION_NAME_PROPERTY_KEY = "${FraudVendorAdapterSvc.pubsub.subscriptionName}";

	@Bean
	public MessageChannel fraudCheckPubSubInputChannel() {
		return new PublishSubscribeChannel();
	}

	@Bean
	@ConditionalOnProperty("FraudVendorAdapterSvc.pubsub.subscriptionName")
	public PubSubInboundChannelAdapter fraudCheckMessageChannelAdapter(PubSubTemplate pubSubTemplate, @Value(FRAUD_TOPIC_SUBSCRIPTION_NAME_PROPERTY_KEY) String subscriptionName) {
		PubSubInboundChannelAdapter adapter = new PubSubInboundChannelAdapter(pubSubTemplate, subscriptionName);
		adapter.setOutputChannel(fraudCheckPubSubInputChannel());
		adapter.setAckMode(AckMode.MANUAL);
		adapter.setPayloadType(String.class);
		return adapter;
	}
}
