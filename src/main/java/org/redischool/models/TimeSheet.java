package org.redischool.models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Created by ReDI on 1/14/2017.
 */
@Entity
@Table(name = "TIME_SHEET", uniqueConstraints = {@UniqueConstraint(columnNames = {"PERSON_ID", "SESSION_ID"})})
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(of = {"id"})
@Builder(toBuilder = true)
@Getter
public class TimeSheet {
    @Id
    @Column(name = "TIME_SHEET_ID")
    private String id;

    @ManyToOne
    @JoinColumn(name = "PERSON_ID")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "SESSION_ID")
    private Session session;

    @Column(name = "PRESENT")
    private Boolean present;
}
