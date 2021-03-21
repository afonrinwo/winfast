/**
 * 
 */
package com.winfast.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.winfast.model.games.DailyDrawResultObject;



/**
 * @author Emmanuel Afonrinwo
 *
 */
@Repository
public interface DailyDrawResultRepository extends CrudRepository<DailyDrawResultObject, Serializable> {

}
