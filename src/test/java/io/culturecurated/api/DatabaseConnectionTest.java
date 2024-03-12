package io.culturecurated.api;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.beans.factory.annotation.Autowired;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class DatabaseConnectionTest {

    @Autowired
    private DataSource dataSource;

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String dbUsername;

    @Value("${spring.datasource.password}")
    private String dbPassword;

    @Test
    public void testDataSource() {
        assertNotNull(dataSource);
    }

    @Test
    public void testConnection() {
        try (Connection connection = dataSource.getConnection()) {
            assertTrue(connection.isValid(5));
            assertEquals(dbUrl, "jdbc:postgresql://localhost:5432/culture_curated_db");
        } catch (SQLException e) {
            fail("Connection failed: " + e.getMessage());
        }
    }
}