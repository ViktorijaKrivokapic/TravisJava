import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class VulnerableCodeExample {

    // Vulnerability 1: Hardcoded sensitive information (e.g., database credentials)
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "password123";

    // Vulnerability 2: Use of outdated library (e.g., log4j 1.x)
    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(VulnerableCodeExample.class);

    public static void main(String[] args) {
        // Vulnerability 3: SQL Injection
        String userInput = args[0]; // User input without validation
        String query = "SELECT * FROM users WHERE username = '" + userInput + "'";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                System.out.println("User: " + rs.getString("username"));
            }
        } catch (Exception e) {
            logger.error("Error executing query: " + e.getMessage());
        }

        // Vulnerability 4: Insecure file handling (e.g., reading sensitive files without proper checks)
        try (BufferedReader br = new BufferedReader(new FileReader("/etc/passwd"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            logger.error("Error reading file: " + e.getMessage());
        }

        // Vulnerability 5: Use of deprecated or insecure cryptographic algorithm (e.g., MD5)
        String password = "myPassword";
        String hashedPassword = org.apache.commons.codec.digest.DigestUtils.md5Hex(password);
        System.out.println("Hashed Password: " + hashedPassword);
    }
}
