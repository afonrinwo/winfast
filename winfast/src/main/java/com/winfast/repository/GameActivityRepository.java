/**
 * 
 */
package com.winfast.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.winfast.model.games.GameActivityLogObject;


/**
 * @author Emmanuel Afonrinwo
 *
 */
@Repository
public interface GameActivityRepository extends CrudRepository<GameActivityLogObject, Serializable> {

}
