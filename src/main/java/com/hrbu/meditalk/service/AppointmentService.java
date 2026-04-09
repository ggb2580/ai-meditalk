package com.hrbu.meditalk.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hrbu.meditalk.entity.Appointment;
import org.springframework.stereotype.Service;


public interface AppointmentService extends IService<Appointment> {
    Appointment getOne(Appointment appointment);
    boolean removeAppointment(Appointment appointment);
}
