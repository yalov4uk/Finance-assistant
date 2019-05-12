package com.perfect.team.common.config;

import javax.jms.Topic;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;

public class JmsConfig {

  public static final String TEMP_TOPIC = "temp-topic";
  private static final String VIRTUAL_TOPIC = "VirtualTopic";
  public static final String TEMP_VIRTUAL_TOPIC = VIRTUAL_TOPIC + "." + TEMP_TOPIC;
  private static final String CONSUMER = "Consumer";
  public static final String TEMP_VIRTUAL_TOPIC_DESTINATION =
      CONSUMER + "." + "temp-consumer" + "." + TEMP_VIRTUAL_TOPIC;

  @Bean
  public Topic topic() {
    return new ActiveMQTopic(JmsConfig.TEMP_VIRTUAL_TOPIC);
  }

  @Bean
  public MessageConverter jacksonJmsMessageConverter() {
    return new MappingJackson2MessageConverter();
  }
}
