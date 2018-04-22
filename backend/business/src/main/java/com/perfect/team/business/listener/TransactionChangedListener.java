package com.perfect.team.business.listener;

import com.perfect.team.business.event.TransactionChangedEvent;
import com.perfect.team.business.helper.AccountHelper;
import com.perfect.team.business.model.Transaction;
import java.util.Objects;
import javax.inject.Inject;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class TransactionChangedListener {

  @Inject
  private AccountHelper accountHelper;

  @Async
  @EventListener
  public void onApplicationEvent(TransactionChangedEvent event) {
    if (event.getOld() == null || event.getCur() == null || !Objects
        .equals(event.getOld().getValue(), event.getCur().getValue()) || !Objects
        .equals(event.getOld().getAccount().getId(), event.getCur().getAccount().getId())) {
      rollbackOld(event.getOld());
      commitCur(event.getCur());
    }
  }

  private void rollbackOld(Transaction old) {
    if (old != null) {
      accountHelper.incBalance(old.getAccount().getId(), old.getValue());
    }
  }

  private void commitCur(Transaction cur) {
    if (cur != null) {
      accountHelper.incBalance(cur.getAccount().getId(), cur.getValue().negate());
    }
  }
}
