package io.confluent.developer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CacheMessage {

	private static Map<String, List<String>> cache = new HashMap<>();

	public static void put(String key, String message) {

		if (!cache.containsKey(key)) {

			cache.put(key, new ArrayList<String>());
		}

		cache.get(key).add(message);
	}

	public static String get(String key, int index) {

		return cache.get(key).get(index);
	}

	public static List<String> get(String key) {

		return cache.get(key);
	}
}