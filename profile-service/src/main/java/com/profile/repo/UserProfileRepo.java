package com.profile.repo;

import com.profile.entity.UserProfile;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepo extends Neo4jRepository<UserProfile, String> {
}
