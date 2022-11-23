package com.sb.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="MOVIE") // if the table name and class name is matching then writing table annotation is optional
public class Movie implements Serializable { //The java bean class that is mapped with db table is called Entity class
	@Id // want to make mid column as Id column that is become automatically primary key column
	@Column(name="MID") // if the column name and property name is matching then writing column name annotation is optional
	@GeneratedValue(strategy = GenerationType.AUTO) // this is used for SEQUENCE generation in case of oracle, IDENTITY in case of MySql
	private Integer mid;
	@Column(name="MNAME", length = 20)
	private String mname;
	@Column(name="YEAR", length = 20)
	private String year;
	@Column(name="RATING")
	private Float rating;
}
