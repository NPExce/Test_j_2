package org.example;

import org.example.api.open_weather.CityOwResponse;
import org.example.services.WeatherService;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello world!");
		
		var isRunning = true;
		var isFirstRun = true;
		while(isRunning) {
			isFirstRun = showWelcomeMenu(isFirstRun);
			
			Scanner sc = new Scanner(System.in);
			String userInput = sc.nextLine();
			
			switch (userInput) {
				case "X" -> isRunning = false;
				case "Y" -> {
					final CityOwResponse weatherFromOpenWeather = new WeatherService().getWeatherFromOpenWeather("Warsaw");
					System.out.println("City name: " + weatherFromOpenWeather.getName());
				}
				case "C" -> {
					System.out.println("Type a city to find");
					Scanner scCityToFind = new Scanner(System.in);
					String userInputCityToFind = scCityToFind.nextLine();

					final CityOwResponse weatherFromOpenWeather = new WeatherService().getWeatherFromOpenWeather(userInputCityToFind);
					String message = """
							------------------------------
							City weather data from [%s] :
							- city name: 		[%s]
							- wind speed:		[%s]
							- temp: 			[%s]
							- pressure: 		[%s]
							""".formatted(
							weatherFromOpenWeather.getDt(),
							weatherFromOpenWeather.getName(),
							weatherFromOpenWeather.getWind().getSpeed(),
							weatherFromOpenWeather.getMain().getTemp(),
							weatherFromOpenWeather.getMain().getPressure()
					);
					System.out.println(message);
				}
				default -> System.out.println("ERROR!!! INVALID INPUT");
			}
		}
	}
	
	private static boolean showWelcomeMenu(boolean isFirstRun) {
		if (isFirstRun) {
			System.out.println("""
				----------------------
				WELCOME!
				type X to quit
				type Y to get a weather stats
				type C to show what city you want to find
				----------------------
				""");
			isFirstRun = false;
		}
		return isFirstRun;
	}
}
