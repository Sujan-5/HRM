package com.hrms.Entity;

import javax.persistence.*;

@Entity
@Table(name = "LEAVEREQUEST")
public class EmpEnt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="EID")
    private int eid;

    @Column(name = "Name")
    private String name;

    @Column(name = "From")
    private String from;

    @Column(name = "To")
    private String to;

    @Column(name = "Reason")
    private String reason;

    @Column(name = "Leave")
    private String leave;

    @ManyToOne
    private EntEmployee hrm;


    public EmpEnt(int eid, String name, String from, String to, String reason, String leave) {
        super();
        this.eid = eid;
        this.name = name;
        this.from = from;
        this.to = to;
        this.reason = reason;
        this.leave = leave;
    }

    public EmpEnt() {

    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getLeave() {
        return leave;
    }

    public void setLeave(String leave) {
        this.leave = leave;
    }

    public EntEmployee getHrm() {
        return hrm;
    }

    public void setHrm(EntEmployee hrm) {
        this.hrm = hrm;
    }

    @Override
    public String toString() {
        return "EmpEnt{" +
                "id=" + eid +
                ", name='" + name + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", reason='" + reason + '\'' +
                ", leave='" + leave + '\'' +
                '}';
    }
}
