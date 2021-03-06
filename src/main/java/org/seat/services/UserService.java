package org.seat.services;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.seat.utils.TimeUtils;
import org.seat.utils.UserPage;
import org.seat.beans.User;
import org.seat.beans.UserExample;
import org.seat.mappers.UserMapper;
import org.seat.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
@Service
public class UserService {
    @Autowired
    private UserMapper mapper;
    public boolean insertUser(User user){
        UserExample ue=new UserExample();
        UserExample.Criteria criteria=ue.createCriteria();
        criteria.andUnameEqualTo(user.getUname());
        if(mapper.selectByExample(ue).size()!=0)
            return false;
        int ret=mapper.insertSelective(user);
        return ret>0;
    }
    public User getUserByName(String uname){
        UserExample ue=new UserExample();
        ue.createCriteria().andUnameEqualTo(uname);
        return mapper.selectByExample(ue).get(0);
    }
    public boolean checkUser(User user){
        UserExample ue=new UserExample();
        UserExample.Criteria criteria=ue.createCriteria();
        criteria.andUnameEqualTo(user.getUname()).andUpwdEqualTo(user.getUpwd());
        return mapper.selectByExample(ue).size()>0;
    }
    public UserPage getUserPage(int pageNum){
        UserPage userPage=new UserPage();
        Page<User> page=PageHelper.startPage(pageNum, PageUtils.pageSize);
        page.setReasonable(true);
        UserExample ue=new UserExample();
        UserExample.Criteria criteria=ue.createCriteria();
        criteria.andUidIsNotNull();
        List<User> users=mapper.selectByExample(ue);
        PageInfo<User> pageInfo=new PageInfo<User>(users,PageUtils.pageListSize);
        userPage.setUserList(users);
        userPage.setPageNum(pageNum);
        userPage.setPageList(PageUtils.parsePageList(pageInfo.getNavigatepageNums()));
        userPage.setPageCount(pageInfo.getPages());
        return userPage;
    }
    public User getUserById(int uid){
        return mapper.selectByPrimaryKey(uid);
    }
    public boolean updateUserState(User user){
        UserExample ue=new UserExample();
        UserExample.Criteria criteria=ue.createCriteria();
        criteria.andUidEqualTo(user.getUid());
        int result=mapper.updateByExampleSelective(user,ue);
        return result>0;
    }
    public boolean deleteUserById(User user){
        return mapper.deleteByPrimaryKey(user.getUid())>0;
    }
}
