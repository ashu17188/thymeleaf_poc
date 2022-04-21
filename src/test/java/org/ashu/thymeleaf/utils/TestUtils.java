package org.ashu.thymeleaf.utils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.validation.constraints.NotNull;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.FileCopyUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class TestUtils {

	public static String readFileToString(@NotNull String fileName, @NotNull String folderPath) {
		ResourceLoader resourceLoader = new DefaultResourceLoader();
		Resource resource = resourceLoader.getResource(folderPath + "/" + fileName);
		return asString(resource);
	}

	public static String asString(Resource resource) {
		try {
			Reader reader = new InputStreamReader(resource.getInputStream());
			return FileCopyUtils.copyToString(reader);
		} catch (IOException e) {
			throw new IllegalArgumentException("Cannot read resource" + resource + "because of " + e.getMessage());
		}
	}

	/**
	 * 
	 * @param <T>        Any Type object which needs to be downloaded.
	 * @param fileName   ex. studentlist.yml
	 * @param folderPath folder within resources.
	 * @return Array of T
	 */
	public static <T> T[] loadDataFromYamlFile(String fileName, String folderPath, TypeReference<T[]> typeReference) {
		ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
		mapper.findAndRegisterModules();
		T[] list = null;
		try {
			list = mapper.readValue(TestUtils.readFileToString(fileName, folderPath), typeReference);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return list;
	}

}
