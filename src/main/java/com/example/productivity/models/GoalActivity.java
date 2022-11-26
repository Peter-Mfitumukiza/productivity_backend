package com.example.productivity.models;

import com.example.productivity.utils.ITEM_STATUS;

import javax.persistence.*;

@Entity
@Table(name = "goal_activities")
public class GoalActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String activityDetail;
    private ITEM_STATUS status;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "goal_id")
    private Goal goal;

    public GoalActivity() {
    }

    public GoalActivity(String activityDetail, ITEM_STATUS status, Goal goal) {
        this.activityDetail = activityDetail;
        this.status = status;
        this.goal = goal;
    }

    public GoalActivity(String activityDetail, Goal goal) {
        this.activityDetail = activityDetail;
        this.goal = goal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActivityDetail() {
        return activityDetail;
    }

    public void setActivityDetail(String activityDetail) {
        this.activityDetail = activityDetail;
    }

    public ITEM_STATUS getStatus() {
        return status;
    }

    public void setStatus(ITEM_STATUS status) {
        this.status = status;
    }

    public Goal getGoal() {
        return goal;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }
}
