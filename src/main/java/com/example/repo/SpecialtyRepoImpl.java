package com.example.repo;

import com.example.Factory.MybatisFactory;
import com.example.models.Specialty;
import jakarta.inject.Singleton;
import org.apache.ibatis.session.SqlSession;

import java.util.Collection;
import java.util.Set;

@Singleton
public class SpecialtyRepoImpl implements SpecialtyRepo {

  private final MybatisFactory mybatisFactory;

  public SpecialtyRepoImpl(MybatisFactory mybatisFactory) {
    this.mybatisFactory = mybatisFactory;
  }


  private final SpecialtyRepo getSpecialtyRepo(SqlSession sqlSession) {
    return sqlSession.getMapper(SpecialtyRepo.class);
  }

  @Override
  public Collection<Specialty> findAll() {
    try (SqlSession sqlSession = mybatisFactory.sqlSessionFactory().openSession()) {
      return getSpecialtyRepo(sqlSession).findAll();
    }
  }

  @Override
  public Specialty findById(Long id) throws Exception {
    try (SqlSession sqlSession = mybatisFactory.sqlSessionFactory().openSession()) {
      return getSpecialtyRepo(sqlSession).findById(id);
    }
  }

  @Override
  public Specialty findByName(String name) throws Exception {
    try (SqlSession sqlSession = mybatisFactory.sqlSessionFactory().openSession()) {
      return getSpecialtyRepo(sqlSession).findByName(name);
    }
  }

  @Override
  public Long save(Specialty specialty) throws Exception {
    try (SqlSession sqlSession = mybatisFactory.sqlSessionFactory().openSession()) {
      Long id = getSpecialtyRepo(sqlSession).save(specialty);
      sqlSession.commit();
      return id;
    }
  }

  @Override
  public Set<Specialty> findByVetId(Long vetId) throws Exception {
    try (SqlSession sqlSession = mybatisFactory.sqlSessionFactory().openSession()) {
      return getSpecialtyRepo(sqlSession).findByVetId(vetId);
    }
  }

  @Override
  public void deleteById(Long id) throws Exception {
    try (SqlSession sqlSession = mybatisFactory.sqlSessionFactory().openSession()) {
      getSpecialtyRepo(sqlSession).deleteById(id);
      sqlSession.commit();
    }
  }


}
