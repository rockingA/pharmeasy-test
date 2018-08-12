package com.pharmeasy.test.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.*;

@Entity
@Table(name = "PRESCRIPTION_ACCESS")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder(alphabetic = true)
public class PrescriptionAccess {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JsonIgnore
    private Subject from;

    private Long fromExtra;

    @OneToOne
    @JsonIgnore
    private Subject to;

    private Long toExtra;

    @Enumerated(EnumType.STRING)
    private ACCESS access = ACCESS.PENDING;

    private Long prescriptionId;

    private Long lastModifiedDate;

    private Long creationDate;

    private String createdBy;

    private String lastModifiedBy;

    @Version
    private Integer version;


    @PrePersist
    private void doPrePersist(){
        this.creationDate = System.currentTimeMillis();
        this.lastModifiedDate = this.creationDate;
    }

    @PreUpdate
    private void doPreUpdate(){
        this.lastModifiedDate = this.creationDate;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Subject getFrom() {
        return from;
    }

    public void setFrom(Subject from) {
        this.from = from;
    }

    public Long getFromExtra() {
        return fromExtra;
    }

    public void setFromExtra(Long fromExtra) {
        this.fromExtra = fromExtra;
    }

    public Subject getTo() {
        return to;
    }

    public void setTo(Subject to) {
        this.to = to;
    }

    public Long getToExtra() {
        return toExtra;
    }

    public void setToExtra(Long toExtra) {
        this.toExtra = toExtra;
    }

    public ACCESS getAccess() {
        return access;
    }

    public void setAccess(ACCESS access) {
        this.access = access;
    }

    public Long getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Long lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Long getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Long creationDate) {
        this.creationDate = creationDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Long getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(Long prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public PrescriptionAccess(Subject from, Long fromExtra, Subject to, Long toExtra, Long prescriptionId) {
        this.from = from;
        this.fromExtra = fromExtra;
        this.to = to;
        this.toExtra = toExtra;
        this.prescriptionId = prescriptionId;
    }

    public PrescriptionAccess() {
    }
}

