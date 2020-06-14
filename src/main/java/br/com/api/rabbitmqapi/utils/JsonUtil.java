package br.com.api.rabbitmqapi.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {

	private static ObjectMapper objectMapper = new ObjectMapper();

	public static String toJson(Object o) {
		try {
			return objectMapper.writeValueAsString(o);
		} catch (Exception e) {
			return null;
		}
	}
	
	public static <T> T parseAs(String json, Class<T> klass) {
		try {
			return objectMapper.readValue(json, klass);
		} catch (Exception e) {
			return null;
		}
	}

}
