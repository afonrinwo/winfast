/**
 * 
 */
package com.winfast.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.winfast.model.utility.SMSObject;

/**
 * @author Emmanuel Afonrinwo
 *
 */
@Repository
public interface SMSRepository extends CrudRepository<SMSObject, Serializable> {

}
