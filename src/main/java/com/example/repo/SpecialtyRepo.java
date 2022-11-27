package com.example.repo;

import com.example.models.Specialty;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Collection;
import java.util.Set;

public interface SpecialtyRepo {

  @Select("SELECT * FROM petclinic.specialties")
  Collection<Specialty> findAll();

  @Select("SELECT * FROM petclinic.specialties WHERE id = #{id}")
  Specialty findById(@Param("id") Long id) throws Exception;


  @Select("SELECT * FROM petclinic.specialties WHERE UPPER(name) = #{name}")
  Specialty findByName(@Param("name") String name) throws Exception;

  @Select({
    "INSERT INTO petclinic.specialties(id, name)\n" +
      "VALUES (COALESCE(#{id}, (select nextval('petclinic.specialties_id_seq'))),#{name})\n" +
      "ON CONFLICT (id)\n" +
      "DO UPDATE SET name = #{name}  \n" +
      "WHERE petclinic.specialties.id = #{id}\n" +
      "RETURNING id"
  })
  @Options(flushCache = Options.FlushCachePolicy.TRUE)
  Long save(Specialty specialty) throws Exception;


  @Select(value = {
    "SELECT DISTINCT id, name FROM petclinic.specialties WHERE id IN(\n" +
      "SELECT DISTINCT specialty_id FROM petclinic.vet_specialties WHERE vet_id = #{vetId}\n" +
      ")"
  })
  Set<Specialty> findByVetId(@Param("vetId") Long vetId) throws Exception;


  //Delete Specialty
  @Select("DELETE FROM petclinic.specialties WHERE id = #{id}")
  void deleteById(@Param("id") Long id) throws Exception;

}
