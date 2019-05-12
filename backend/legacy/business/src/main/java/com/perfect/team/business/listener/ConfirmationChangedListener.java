package com.perfect.team.business.listener;

import com.perfect.team.common.config.JmsConfig;
import com.perfect.team.common.event.ConfirmationCreatedEvent;
import com.perfect.team.common.model.Confirmation;
import javax.inject.Inject;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.mail.MailMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class ConfirmationChangedListener {

  @Inject
  private JavaMailSender mailSender;

//  @Inject
//  private UserService userService;

  @JmsListener(destination = JmsConfig.TEMP_VIRTUAL_TOPIC_DESTINATION)
  public void onApplicationEvent(ConfirmationCreatedEvent event) {
    if (event.getOld() == null) {
      sendMail(event.getCur());
    }
    if (event.getCur() != null && event.getCur().getConfirmed() != null && event.getCur()
        .getConfirmed()) {
//      userService.update(new User(event.getCur().getUser().getId(), true));
    }
  }

  private void sendMail(Confirmation cur) {
    MailMessage message = new SimpleMailMessage();
    message.setFrom("temp@temp.com");
    message.setTo("valery.yalauchuk@ontravelsolutions.com");
    message.setText(cur.getCode() + "\n" + cur.getUser().getId());
    mailSender.send((SimpleMailMessage) message);
  }
}
