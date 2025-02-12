package com.lakshita.easelearn.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lakshita.easelearn.entity.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
	//getting teacher object by its unique userId->foreing key reference from userTable
	
//	@Query(value = "select t1_0.id,t1_0.name,p1_0.id,p1_0.date_of_join,p1_0.description,"
//			+ "p1_0.location,t2_0.id,t2_0.name,t2_0.profile_id,t2_0.user_id,u2_0.id,u2_0.email,u2_0.name,"
//			+ "u2_0.password,u2_0.role from teacher t1_0 left join profile p1_0 on p1_0.id=t1_0.profile_id left join teacher "
//			+ "t2_0 on t2_0.id=p1_0.teacher_id left join user u2_0 on u2_0.id=t1_0.user_id where t1_0.id=?", nativeQuery = true)
	@Query("SELECT t FROM Teacher t WHERE t.user.id = :userId")
	 Optional<Teacher> findByUserId(@Param("userId") Long userId);
}