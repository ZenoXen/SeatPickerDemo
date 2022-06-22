package org.seat.services;

import org.seat.beans.Admin;
import org.seat.beans.AdminExample;
import org.seat.mappers.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminMapper mapper;

    public boolean checkAdmin(Admin admin) {
        AdminExample ae = new AdminExample();
        AdminExample.Criteria criteria = ae.createCriteria();
        criteria.andAdminNameEqualTo(admin.getAdminName());
        criteria.andAdminPwdEqualTo(admin.getAdminPwd());
        List<Admin> admins = mapper.selectByExample(ae);
        return !admins.isEmpty();
    }
}
