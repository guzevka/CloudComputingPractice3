package ru.guzeeva.redisproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import redis.clients.jedis.Jedis;

@SpringBootApplication
public class RedisProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisProjectApplication.class, args);

		Jedis jedis = new Jedis("localhost", 6379);
		jedis.set("k_1", "value_1");
		String value_1 = jedis.get("k_1");
		System.out.println("Значение 1: " + value_1);
		jedis.setex("k_2", 10, "value_2");
		String value_2 = jedis.get("k_2");
		System.out.println("Значение 2: " + value_2);

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		String exp = jedis.get("k_2");
		System.out.println("Значение 2 после 10 сек: " + exp);

		jedis.close();
	}

}
