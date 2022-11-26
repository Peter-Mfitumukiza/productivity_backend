package com.example.productivity.models;

import javax.persistence.*;

@Entity
@Table(name = "subplan_items")
public class SubPlanItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String subPlanItemSubject;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "plan_item_id")
    private PlanItem planItem;

    public SubPlanItem(String subPlanItemSubject, PlanItem planItem) {
        this.subPlanItemSubject = subPlanItemSubject;
        this.planItem = planItem;
    }

    public SubPlanItem(Long id, String subPlanItemSubject, PlanItem planItem) {
        this.id = id;
        this.subPlanItemSubject = subPlanItemSubject;
        this.planItem = planItem;
    }

    public SubPlanItem() {
    }
}
