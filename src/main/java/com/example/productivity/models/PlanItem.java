package com.example.productivity.models;

import com.example.productivity.utils.ITEM_STATUS;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "plan_items")
public class PlanItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String planItemSubject;
    private ITEM_STATUS status;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "plan_id")
    private Plan plan;
    public PlanItem() {
    }

    public PlanItem(String planItemSubject, ITEM_STATUS status, Plan plan) {
        this.planItemSubject = planItemSubject;
        this.status = status;
        this.plan = plan;
    }

    public PlanItem(Long id, String planItemSubject, ITEM_STATUS status, Plan plan) {
        this.id = id;
        this.planItemSubject = planItemSubject;
        this.status = status;
        this.plan = plan;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlanItemSubject() {
        return planItemSubject;
    }

    public void setPlanItemSubject(String planItemSubject) {
        this.planItemSubject = planItemSubject;
    }

    public ITEM_STATUS getStatus() {
        return status;
    }

    public void setStatus(ITEM_STATUS status) {
        this.status = status;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

}
