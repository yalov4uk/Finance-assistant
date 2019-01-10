package com.perfect.team.business.listener;

import com.perfect.team.business.helper.AccountHelper;
import com.perfect.team.common.config.JmsConfig;
import com.perfect.team.common.event.TransferChangedEvent;
import com.perfect.team.common.model.Transfer;
import java.util.Objects;
import javax.inject.Inject;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class TransferChangedListener {

  @Inject
  private AccountHelper accountHelper;

  @JmsListener(destination = JmsConfig.TEMP_VIRTUAL_TOPIC_DESTINATION)
  public void onApplicationEvent(TransferChangedEvent event) {
    if (event.getOld() == null || event.getCur() == null || !Objects
        .equals(event.getOld().getValue(), event.getCur().getValue()) || !Objects
        .equals(event.getOld().getFromAccount().getId(), event.getCur().getFromAccount().getId())
        || !Objects
        .equals(event.getOld().getToAccount().getId(), event.getCur().getToAccount().getId())) {
      rollbackOld(event.getOld());
      commitCur(event.getCur());
    }
  }

  private void rollbackOld(Transfer old) {
    if (old != null) {
      accountHelper.incBalance(old.getFromAccount().getId(), old.getValue());
      accountHelper
          .incBalance(old.getToAccount().getId(), old.getValue().negate(), old.getExchangeRate());
    }
  }

  private void commitCur(Transfer cur) {
    if (cur != null) {
      accountHelper.incBalance(cur.getFromAccount().getId(), cur.getValue().negate());
      accountHelper.incBalance(cur.getToAccount().getId(), cur.getValue(), cur.getExchangeRate());
    }
  }
}
