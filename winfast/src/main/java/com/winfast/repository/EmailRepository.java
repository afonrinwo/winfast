/**
 * 
 */
package com.winfast.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.winfast.model.utility.EmailObject;

/**
 * @author Emmanuel Afonrinwo
 *
 */
@Repository
public interface EmailRepository extends CrudRepository<EmailObject, Serializable> {

}
