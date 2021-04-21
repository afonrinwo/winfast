package com.winwallet.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.winwallet.model.cashout.CashOutLogObject;
import com.winwallet.model.cashout.CashOutTokenObject;

/**
 * @author Emmanuel Afonrinwo
 *
 */
@Repository
public interface CashOutRepository extends CrudRepository<CashOutLogObject, Serializable> {

	CashOutTokenObject save(CashOutTokenObject cashOutTokenObject);

	CashOutTokenObject findByMsisdn2DebitNetworkAndAmountAndPayToken(String msisdn2Debit, double amount,
			String payToken);

}
