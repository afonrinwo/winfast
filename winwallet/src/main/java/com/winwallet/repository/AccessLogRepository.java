package com.winwallet.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.winwallet.model.AccessLogObject;

@Repository
public interface AccessLogRepository extends CrudRepository<AccessLogObject, Serializable> {

}
