package org.redischool.models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.Set;

/**
 * Created by ReDI on 1/14/2017.
 */

@Entity
@Table(name = "COURSE", uniqueConstraints = {@UniqueConstraint(columnNames = {"COURSE_ID"})})
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(of = {"id"})
@Builder(toBuilder = true)
@Getter

public class Course {

    @Id
    @Column(name = "COURSE_ID")
    private String id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "START_DATE")
    private String startDate;

    @Column(name = "END_DATE")
    private String endDate;

    // maybe this become later Descriptor derivative from first and last date
    @Column(name = "SESSION_PRO_WEEK")
    private byte sessionProWeek;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "COURSE_PERSON",
            joinColumns = {@JoinColumn(name = "COURSE_ID")},
            inverseJoinColumns = {@JoinColumn(name = "PERSON_ID")})
    private Set<Person> persons;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "course")
    private Set<Session> sessions;


}
