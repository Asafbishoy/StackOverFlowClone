package com.asaf.StackOverflowClone.Repository;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUsername(String username);
}
