package org.redischool.models;

import lombok.Getter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by ReDI on 1/14/2017.
 */

@Entity
@Table(name = "TEACHER")
@DiscriminatorValue("TEACHER")
@Getter
public class Teacher extends Person {

}
