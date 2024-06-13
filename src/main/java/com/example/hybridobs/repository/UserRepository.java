package com.example.hybridobs.repository;

import com.example.hybridobs.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
}
