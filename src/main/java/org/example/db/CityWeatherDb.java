package org.example.db;

import java.util.HashMap;
import java.util.Map;

public class CityWeatherDb {
	
	private static final Map<Long, CityDataEntity> dataBase = new HashMap<>();
	
	public void add(CityDataEntity entity) {
		// 1
		// 2
		// 3
		dataBase.put(entity.getId(), entity);
	}
}
