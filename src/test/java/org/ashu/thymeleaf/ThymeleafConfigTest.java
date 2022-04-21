package org.ashu.thymeleaf;

import java.util.Set;
import java.util.TreeSet;

import org.ashu.thymeleaf.utils.TestUtils;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.type.TypeReference;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class ThymeleafConfigTest {
	
	@Test
	public void testStatic() {
		Student [] studentArray = TestUtils.loadDataFromYamlFile("studentslist.yml", "", new TypeReference<Student[]>() {
		});
		Set<Student> treeSet = new TreeSet<>((student1, student2)-> student1.getHeight() - student2.getHeight() );
		for(Student s: studentArray) {
			treeSet.add(s);
		}
		log.info("{}",treeSet);
	}


}
