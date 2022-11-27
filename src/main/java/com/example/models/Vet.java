package com.example.models;

import io.micronaut.core.annotation.Introspected;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Introspected
public class Vet implements Serializable {

  private static final long serialVersionUID = 1L;

  @NotNull
  private Long id;

  private String firstName;

  private String lastName;

  private Set<Specialty> specialties = new HashSet<>();

  public Vet() {
  }

  public @NotNull Long getId() {
    return this.id;
  }

  public void setId(@NotNull Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Set<Specialty> getSpecialties() {
    return this.specialties;
  }

  public void setSpecialties(Set<Specialty> specialties) {
    this.specialties = specialties;
  }

  public boolean equals(final Object o) {
    if (o == this) return true;
    if (!(o instanceof Vet)) return false;
    final Vet other = (Vet) o;
    if (!other.canEqual(this)) return false;
    final Object this$id = this.getId();
    final Object other$id = other.getId();
    if (!Objects.equals(this$id, other$id)) return false;
    final Object this$firstName = this.getFirstName();
    final Object other$firstName = other.getFirstName();
    if (!Objects.equals(this$firstName, other$firstName)) return false;
    final Object this$lastName = this.getLastName();
    final Object other$lastName = other.getLastName();
    if (!Objects.equals(this$lastName, other$lastName)) return false;
    final Object this$specialties = this.getSpecialties();
    final Object other$specialties = other.getSpecialties();
    return Objects.equals(this$specialties, other$specialties);
  }

  protected boolean canEqual(final Object other) {
    return other instanceof Vet;
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $id = this.getId();
    result = result * PRIME + ($id == null ? 43 : $id.hashCode());
    final Object $firstName = this.getFirstName();
    result = result * PRIME + ($firstName == null ? 43 : $firstName.hashCode());
    final Object $lastName = this.getLastName();
    result = result * PRIME + ($lastName == null ? 43 : $lastName.hashCode());
    final Object $specialties = this.getSpecialties();
    result = result * PRIME + ($specialties == null ? 43 : $specialties.hashCode());
    return result;
  }

  public String toString() {
    return "Vet(id=" + this.getId() + ", firstName=" + this.getFirstName() + ", lastName=" + this.getLastName() + ", specialties=" + this.getSpecialties() + ")";
  }
}
