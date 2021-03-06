package org.seat.services;

import org.seat.beans.Admin;
import org.seat.beans.AdminExample;
import org.seat.mappers.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
@Service
public class AdminService {
    @Autowired
    private AdminMapper mapper;
    public boolean checkAdmin(Admin admin){
        AdminExample ae=new AdminExample();
        AdminExample.Criteria criteria=ae.createCriteria();
        criteria.andAdminNameEqualTo(admin.getAdminName());
        criteria.andAdminPwdEqualTo(admin.getAdminPwd());
        List<Admin> admins=mapper.selectByExample(ae);
        if(!admins.isEmpty()) return true;
        return false;
    }
}
