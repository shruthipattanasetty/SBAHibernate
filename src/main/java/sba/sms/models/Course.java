package sba.sms.models;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import sba.sms.models.Student;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table
@Entity
public class Course {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "id")
	int id;
	@NonNull
	@Column(columnDefinition = "varchar(50)", name = "name")
	String name;
	@NonNull
	@Column(columnDefinition = "varchar(50)", name = "instructor")
	String instructor;
	
	@ToString.Exclude
	@ManyToMany(mappedBy = "courses", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH},fetch = FetchType.EAGER)
	private Set<Student> students = new LinkedHashSet<>();
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) 
			return true;
		if(obj == null) 
			return false;
		if(getClass() != obj.getClass()) 
			return false;
		Course course = (Course) obj;
		return id == course.id && name.equals(course.name) && instructor.equals(course.instructor);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id,name,instructor);
	}



}
