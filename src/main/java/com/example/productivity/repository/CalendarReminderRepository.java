package com.example.productivity.repository;

import com.example.productivity.models.CalendarReminder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalendarReminderRepository extends JpaRepository<CalendarReminder, Long> {
}
