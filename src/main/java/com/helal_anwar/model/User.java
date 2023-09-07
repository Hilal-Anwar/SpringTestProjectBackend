package com.helal_anwar.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "users")
public record User(@Id String id, String name, String email) {
}