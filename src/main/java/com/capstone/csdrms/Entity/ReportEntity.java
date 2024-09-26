package com.capstone.csdrms.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tblreport")
public class ReportEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportId;

    private Long studentId; 

    private Long adviserId; 

    private String date;
    private String time;
    private String complaint;
    private String complainant;
    private String received;
    private boolean complete;

    @ManyToOne
    @JoinColumn(name = "studentId", referencedColumnName = "id", insertable = false, updatable = false)
    private StudentEntity student;

    @ManyToOne
    @JoinColumn(name = "adviserId", referencedColumnName = "user_id", insertable = false, updatable = false)
    private AdviserEntity adviser;

    public ReportEntity() {
    }

    public ReportEntity(Long reportId, Long studentId, Long adviserId, String date, String time, String complaint,
                        String complainant, String received, boolean complete, StudentEntity student, AdviserEntity adviser) {
        this.reportId = reportId;
        this.studentId = studentId;
        this.adviserId = adviserId;
        this.date = date;
        this.time = time;
        this.complaint = complaint;
        this.complainant = complainant;
        this.received = received;
        this.complete = complete;
        this.student = student;
        this.adviser = adviser;
    }

    // Getters and setters for all fields

    public Long getReportId() {
        return reportId;
    }

    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getAdviserId() {
        return adviserId;
    }

    public void setAdviserId(Long adviserId) {
        this.adviserId = adviserId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

    public String getComplainant() {
        return complainant;
    }

    public void setComplainant(String complainant) {
        this.complainant = complainant;
    }

    public String getReceived() {
        return received;
    }

    public void setReceived(String received) {
        this.received = received;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
    }

    public AdviserEntity getAdviser() {
        return adviser;
    }

    public void setAdviser(AdviserEntity adviser) {
        this.adviser = adviser;
    }
}
