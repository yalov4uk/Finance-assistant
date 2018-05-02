package com.perfect.team.business.listener;

import com.perfect.team.business.event.ConfirmationChangedEvent;
import com.perfect.team.business.model.Confirmation;
import com.perfect.team.business.model.User;
import com.perfect.team.business.service.UserService;
import javax.inject.Inject;
import org.springframework.context.event.EventListener;
import org.springframework.mail.MailMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class ConfirmationChangerListener {

  @Inject
  private JavaMailSender mailSender;

  @Inject
  private UserService userService;

  @Async
  @EventListener
  public void onApplicationEvent(ConfirmationChangedEvent event) {
    if (event.getOld() == null) {
      sendMail(event.getCur());
    }
    if (event.getCur() != null && event.getCur().getConfirmed() != null && event.getCur()
        .getConfirmed()) {
      userService.update(new User(event.getCur().getUser().getId(), true));
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
