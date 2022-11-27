package com.example.repo;

import com.example.models.Vet;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Collection;
import java.util.Set;

public interface VetRepo {


  @Select("SELECT * FROM petclinic.vets")
  Collection<Vet> findAll();

  @Select("SELECT * FROM petclinic.vets WHERE id = #{id}")
  Vet findById(@Param("id") Long id) throws Exception;


  @Select("SELECT * FROM petclinic.vets WHERE UPPER(first_name) = #{firstName} AND UPPER(last_name) = #{lastName}")
  Vet findByName(@Param("firstName") String firstName, @Param("lastName") String lastName) throws Exception;

  @Select({
    "INSERT INTO petclinic.vets(id, first_name, last_name)\n" +
      "VALUES (COALESCE(#{id}, (select nextval('petclinic.vets_id_seq'))),#{firstName},#{lastName})\n" +
      "ON CONFLICT (id)\n" +
      "DO UPDATE SET first_name = #{firstName}, last_name = #{lastName}  \n" +
      "WHERE petclinic.vets.id = #{id}\n" +
      "RETURNING id"
  })
  @Options(flushCache = Options.FlushCachePolicy.TRUE)
  Long save(Vet vet) throws Exception;


  @Select(value = {
    "SELECT DISTINCT id, first_name, last_name FROM petclinic.vets WHERE id IN(\n" +
      "SELECT DISTINCT vet_id FROM petclinic.vet_specialties WHERE specialty_id = #{specialtyId}\n" +
      ")"
  })
  Set<Vet> findBySpecialtyId(@Param("specialtyId") Long specialtyId) throws Exception;


  //Delete Vet
  @Select("DELETE FROM petclinic.vets WHERE id = #{id}")
  void deleteById(@Param("id") Long id) throws Exception;

}
