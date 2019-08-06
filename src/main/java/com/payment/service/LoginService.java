package com.payment.service;

import com.payment.model.Login;
import com.payment.model.Student;

public interface LoginService {

	public boolean loginValidation(Login login);

	public boolean createStudent(Student student);
}
