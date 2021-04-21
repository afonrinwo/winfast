/**
 * 
 */
package com.winwallet.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.winwallet.model.payment.PaymentLogObject;

/**
 * @author Emmanuel Afonrinwo
 *
 */
@Repository
public interface PaymentRepository extends CrudRepository<PaymentLogObject, Serializable> {

}
