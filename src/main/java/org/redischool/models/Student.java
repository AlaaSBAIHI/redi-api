package org.redischool.models;

import lombok.Getter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by ReDI on 1/14/2017.
 */
@Entity
@Table(name = "STUDENT")
@DiscriminatorValue("STUDENT")
@Getter
public class Student extends Person {


}
