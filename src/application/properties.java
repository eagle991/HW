# Настройки подключения к базе данных
spring.datasource.url=jdbc:postgresql://localhost:5432/hogwarts
spring.datasource.username=student
spring.datasource.password=chocolatefrog

# Настройки Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect