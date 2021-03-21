package com.winwallet.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.winwallet.model.cashout.CashOutLogObject;

/**
 * @author Emmanuel Afonrinwo
 *
 */
public interface CashOutLogRepository extends CrudRepository<CashOutLogObject, Serializable> {

}
