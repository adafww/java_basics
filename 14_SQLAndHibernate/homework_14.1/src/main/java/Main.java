import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/skillbox";
        String user = "root";
        String pass = "80958095";
        Connection connection = DriverManager.getConnection(url, user, pass);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT course_name AS course_name, COUNT(*) / (MAX(MONTH(subscription_date)) - MIN(MONTH(subscription_date) ) + 1) AS AVG_salary_month FROM purchaselist WHERE YEAR(subscription_date) = 2018 GROUP BY course_name;");

        System.out.println("Cреднее количество покупок в месяц: \n------------------------------------");
        while(resultSet.next()){
            System.out.println(resultSet.getString("course_name") + " - " + resultSet.getString("AVG_salary_month"));
        }
    }
}
