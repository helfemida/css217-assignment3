# Singleton Database Connection

### Private Constructor: 
The class DatabaseConfig has a private constructor, preventing instantiation from outside the class. This means that no other class can create instances of DatabaseConfig directly.

### Static Instance Variable: 
The class has a private static instance variable (dataSource and jdbcTemplate) that holds the only instance of the class.

### Public Static Method: 
The class provides a public static method (dataSource() and jdbcTemplate()) to return the only instance of the class. If the instance does not exist, the method creates it. This method is static, meaning it can be accessed without instantiating the class.

### Scope "Singleton": 
Spring manages the lifecycle of beans, and by default, Spring beans are singleton scoped. In the configuration, the @Scope("singleton") annotation ensures that only one instance of DataSource and JdbcTemplate beans is created and shared throughout the application context.

After all DatabaseConfig class ensures that only one instance of DataSource and JdbcTemplate is created and used by the software system, which aligns with the requirements of the singleton pattern.

