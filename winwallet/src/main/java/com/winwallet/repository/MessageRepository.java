/**
 * 
 */
package com.winwallet.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.winwallet.model.utility.SMSObject;

/**
 * @author Emmanuel Afonrinwo
 *
 */
@Repository
public interface MessageRepository extends CrudRepository<SMSObject, Serializable> {

}
