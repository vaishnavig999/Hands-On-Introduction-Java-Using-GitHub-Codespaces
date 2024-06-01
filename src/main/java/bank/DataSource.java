package bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataSource {

  public static Connection connect() {
    String db_file = "jdbc:sqlite:resources/bank.db";
    Connection connection = null;

    try {
      connection = DriverManager.getConnection(db_file);
      //System.out.println("We're connected");
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return connection;
  }

  public static Customer getCustomer(String username) {
    String sql = "select * from customers where username = ?";
    Customer customer = null;

    try (Connection connection = connect();
        PreparedStatement statement = connection.prepareStatement(sql)) {
      statement.setString(1, username);
      try (ResultSet resultSet = statement.executeQuery()) {

        customer = new Customer(
            resultSet.getInt("id"),
            resultSet.getString("name"),
            resultSet.getString("username"),
            resultSet.getString("password"),
            resultSet.getInt("account_id"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return customer;
  }

  public static Account getAccount(int account_id){
      String sql = "select * from Accounts where id = ?";
      Account account = null;
      try(Connection connection = connect();
        PreparedStatement statement = connection.prepareStatement(sql)){
          statement.setInt(1, account_id);

          try(ResultSet resultSet = statement.executeQuery()){
              account = new Account(
                resultSet.getInt("id"),
                resultSet.getString("type"),
                resultSet.getDouble("balance"));
          }
        }catch(SQLException e){
          e.printStackTrace();
        }
    return account;
  }
  
  public static void updateAccountBalance(int account_id, double balance){
    String sql = "update accounts set balance = ? where id = ?";
    try(Connection connection = connect();
    PreparedStatement statement = connection.prepareStatement(sql);){
      statement.setDouble(1, balance);
      statement.setInt(2, account_id);
      
      statement.executeUpdate();

  }catch(SQLException e){
    e.printStackTrace();
  }
  }
  /* For Testing
  public static void main(String[] args) {
    // connect();
    Customer customer = getCustomer("telloy3x@bigcartel.com");
    Account account = getAccount(customer.getAccountId());
    System.out.println(customer.getName() + " " + account.getBalance());
  }*/
}
