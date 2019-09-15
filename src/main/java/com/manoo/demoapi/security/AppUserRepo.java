package com.manoo.demoapi.security;



import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public interface AppUserRepo extends MongoRepository<AppUser,String> {



    @Query(value="{ 'email' : ?0 }", fields="{ 'email' : 1, 'name' : 1,'password' : 1}")
    List<AppUser> findByTheAppUsername(String email);

    AppUser findByEmail(String email);

}
