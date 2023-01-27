package sba.sms;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import sba.sms.models.Student;
import sba.sms.services.CourseService;
import sba.sms.services.StudentService;
import sba.sms.utils.CommandLine;
import sba.sms.utils.HibernateUtil;

class AppTest {


	static StudentService studentService;
	@Test
    void getStudentByEmailTest(){
        Student expected = new Student("anthony@gmail.com", "anthony gallegos", "password");
        assertThat(studentService.getStudentByEmail("anthony@gmail.com")).isEqualTo(expected);
    }
}