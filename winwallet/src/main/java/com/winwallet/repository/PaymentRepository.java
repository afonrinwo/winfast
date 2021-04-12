/**
 * 
 */
package com.winwallet.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.winwallet.model.payment.PaymentLogObject;

/**
 * @author Emmanuel Afonrinwo
 *
 */
public interface PaymentRepository extends CrudRepository<PaymentLogObject, Serializable> {

}
