package dev.donhk;

import dev.donhk.database.DatabaseServer;
import dev.donhk.utils.Utils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Connection;
import java.sql.Statement;

@SpringBootApplication
public class WebContentApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebContentApplication.class, args);
    }

    @Bean(name = "dataSource")
    public Connection dataSource() throws Exception {
        final DatabaseServer server = new DatabaseServer("myuser", "mypass", "mydb");
        server.startServer();
        final Connection conn = server.getConnection();
        final Statement stmt = conn.createStatement();
        stmt.execute(Utils.resource2txt("database/schema.sql"));
        return conn;
    }
}
