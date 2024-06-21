package za.ac.cput.soccer;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootTest
class SoccerApplicationTests {

	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/player";
		String user = "postgres";
		String password = "Chadsmith2024";

		try (Connection conn = DriverManager.getConnection(url, user, password)) {
			if (conn != null) {
				System.out.println("Connected to the PostgreSQL server successfully.");
			} else {
				System.out.println("Failed to make connection!");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
