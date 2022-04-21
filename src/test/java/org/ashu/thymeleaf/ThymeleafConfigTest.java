package org.ashu.thymeleaf;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.ashu.thymeleaf.utils.TestUtils;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.type.TypeReference;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class ThymeleafConfigTest {

	@Test
	public void testStatic() {
		HashMap<Integer, String> hashMap;
		Hashtable<Integer, String> hashTable;
		Student[] studentArray = TestUtils.loadDataFromYamlFile("studentslist.yml", "", new TypeReference<Student[]>() {
		});
		Set<Student> treeSet = new TreeSet<>((student1, student2) -> student1.getHeight() - student2.getHeight());
		for (Student s : studentArray) {
			treeSet.add(s);
		}

		Map<Integer, Student> studentMap = Stream.of(studentArray)
				.collect(Collectors.toMap(student -> student.getHeight(), student -> student));
		List<Object> list = studentMap.entrySet().stream().map(entry -> entry.getValue()).collect(Collectors.toList());
		log.info("{}", list);
	}
}
