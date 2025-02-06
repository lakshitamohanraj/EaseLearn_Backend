package com.lakshita.easelearn.repository;

import org.springframework.stereotype.Repository;
import com.lakshita.easelearn.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface ProfileRepository extends JpaRepository<Profile,Long> {

}
