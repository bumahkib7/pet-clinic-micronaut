package com.example.repo;

import com.example.Factory.MybatisFactory;
import com.example.models.Vet;
import jakarta.inject.Singleton;
import org.apache.ibatis.session.SqlSession;

import java.util.Collection;
import java.util.Set;

@Singleton
public class VetRepoImpl implements VetRepo {

  private final MybatisFactory mybatisFactory;

  public VetRepoImpl(VetRepo vetRepo, MybatisFactory mybatisFactory) {
    this.mybatisFactory = mybatisFactory;
  }

  private VetRepo getSpecialtyRepo(SqlSession sqlSession) {
    return sqlSession.getMapper(VetRepo.class);
  }

  @Override
  public Collection<Vet> findAll() {
    try (SqlSession sqlSession = mybatisFactory.sqlSessionFactory().openSession()) {
      return getSpecialtyRepo(sqlSession).findAll();
    }
  }

  @Override
  public Vet findById(Long id) throws Exception {
    try (SqlSession sqlSession = mybatisFactory.sqlSessionFactory().openSession()) {
      return getSpecialtyRepo(sqlSession).findById(id);
    }
  }

  @Override
  public Vet findByName(String firstName, String lastName) throws Exception {
    try (SqlSession sqlSession = mybatisFactory.sqlSessionFactory().openSession()) {
      return getSpecialtyRepo(sqlSession).findByName(firstName, lastName);
    }
  }

  @Override
  public Long save(Vet vet) throws Exception {
    try (SqlSession sqlSession = mybatisFactory.sqlSessionFactory().openSession()) {
      Long id = getSpecialtyRepo(sqlSession).save(vet);
      sqlSession.commit();
      return id;
    }
  }

  @Override
  public Set<Vet> findBySpecialtyId(Long specialtyId) throws Exception {
    try (SqlSession sqlSession = mybatisFactory.sqlSessionFactory().openSession()) {
      return getSpecialtyRepo(sqlSession).findBySpecialtyId(specialtyId);
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
