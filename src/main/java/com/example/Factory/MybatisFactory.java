package com.example.Factory;

import io.micronaut.context.annotation.Context;
import io.micronaut.context.annotation.Factory;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;

@Factory
public class MybatisFactory {

  private final DataSource dataSource;

  public MybatisFactory(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  @Context
  public SqlSessionFactory sqlSessionFactory() {

    TransactionFactory ts = new JdbcTransactionFactory();

    Environment env = new Environment("pet-clinic", ts, dataSource);

    Configuration config = new Configuration(env);

    config.addMappers("com.example.repo");

    return new SqlSessionFactoryBuilder().build(config);
  }


}
