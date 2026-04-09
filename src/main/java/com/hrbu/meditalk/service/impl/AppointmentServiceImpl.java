package com.hrbu.meditalk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hrbu.meditalk.entity.Appointment;
import com.hrbu.meditalk.mapper.AppointmentMapper;
import com.hrbu.meditalk.service.AppointmentService;
import org.springframework.stereotype.Service;

@Service
public class AppointmentServiceImpl extends ServiceImpl<AppointmentMapper, Appointment> implements AppointmentService {
    /**
     * 查询订单是否存在
     *
     * @param appointment
     * @return
     */
    @Override
    public Appointment getOne(Appointment appointment) {
        LambdaQueryWrapper<Appointment> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Appointment::getUsername, appointment.getUsername());
//        queryWrapper.eq(Appointment::getIdCard, appointment.getIdCard());
        queryWrapper.eq(Appointment::getDepartment, appointment.getDepartment());
        queryWrapper.eq(Appointment::getDate, appointment.getDate());
        queryWrapper.eq(Appointment::getTime, appointment.getTime());

        Appointment appointmentDB = baseMapper.selectOne(queryWrapper);
        return appointmentDB;
    }

    /*
    * 取消预约
    * */
    @Override
    public boolean removeAppointment(Appointment appointment) {
        LambdaQueryWrapper<Appointment> queryWrapper = new LambdaQueryWrapper<>();
        if (appointment.getUsername() != null){
            queryWrapper.eq(Appointment::getUsername,appointment.getUsername());
        }
        queryWrapper.eq(Appointment::getIdCard,appointment.getIdCard());
        queryWrapper.eq(Appointment::getDate,appointment.getDate());

        int delete = baseMapper.delete(queryWrapper);
        return delete > 0;
    }
}
