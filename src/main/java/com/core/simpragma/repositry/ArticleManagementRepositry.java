package com.core.simpragma.repositry;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.core.simpragma.vo.RegistrationInfo;

public interface ArticleManagementRepositry extends CrudRepository<RegistrationInfo, String> {

	RegistrationInfo save(RegistrationInfo registrationInfo);

	@Query("select r.passWord from RegistrationInfo r where r.userName=:userName")
	String findPassWordByUserName(@Param("userName") String userName);

}
