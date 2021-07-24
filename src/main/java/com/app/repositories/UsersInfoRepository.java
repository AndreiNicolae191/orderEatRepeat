package com.app.repositories;

import com.app.entities.UsersInfo;
import org.springframework.data.repository.CrudRepository;

public interface UsersInfoRepository extends CrudRepository<UsersInfo,Long> {
}
