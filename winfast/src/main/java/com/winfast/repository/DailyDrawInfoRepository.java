/**
 * 
 */
package com.winfast.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.winfast.model.games.DailyDrawInfoObject;



/**
 * @author Emmanuel Afonrinwo
 *
 */
@Repository
public interface DailyDrawInfoRepository extends CrudRepository<DailyDrawInfoObject, Serializable> {

	boolean existsByDrawId(String draw_id);

}
