package com.winfast.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.winfast.model.profile.AgentProfileActivityLogObject;

/**
 * @author Emmanuel Afonrinwo
 *
 */
public interface AgentProfileActivityLogRepository extends CrudRepository<AgentProfileActivityLogObject, Serializable> {

}
