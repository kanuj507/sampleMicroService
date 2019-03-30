package dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Component;

import model.User;

@RepositoryRestResource
public interface UserRepository extends CrudRepository<User, Long> {

}