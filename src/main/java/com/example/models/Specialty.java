package com.example.models;

import io.micronaut.core.annotation.Introspected;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Introspected
public class Specialty implements Serializable {

  private static final long serialVersionUID = 1L;


  @NotNull
  private Long id;

  private String name;

  public Specialty() {
  }

  public @NotNull Long getId() {
    return this.id;
  }

  public void setId(@NotNull Long id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean equals(final Object o) {
    if (o == this) return true;
    if (!(o instanceof Specialty)) return false;
    final Specialty other = (Specialty) o;
    if (!other.canEqual((Object) this)) return false;
    final Object this$id = this.getId();
    final Object other$id = other.getId();
    if (!Objects.equals(this$id, other$id)) return false;
    final Object this$name = this.getName();
    final Object other$name = other.getName();
    if (!Objects.equals(this$name, other$name)) return false;
    return true;
  }

  protected boolean canEqual(final Object other) {
    return other instanceof Specialty;
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $id = this.getId();
    result = result * PRIME + ($id == null ? 43 : $id.hashCode());
    final Object $name = this.getName();
    result = result * PRIME + ($name == null ? 43 : $name.hashCode());
    return result;
  }

  public String toString() {
    return "Specialty(id=" + this.getId() + ", name=" + this.getName() + ")";
  }
}
