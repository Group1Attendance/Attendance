package com.groupone.attendance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.groupone.attendance.entity.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

}
