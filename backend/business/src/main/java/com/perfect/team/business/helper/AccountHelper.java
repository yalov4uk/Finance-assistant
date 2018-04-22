package com.perfect.team.business.helper;

import java.math.BigDecimal;

public interface AccountHelper {

  void incBalance(Long accountId, BigDecimal value);

  void incBalance(Long accountId, BigDecimal value, BigDecimal exchangeRate);
}
