package com.perfect.team.business.config;

import javax.jms.Topic;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
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
}
