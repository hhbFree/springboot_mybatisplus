package com.aisino.invoice.service.impl;

import com.aisino.invoice.dao.DealDataDao;
import com.aisino.invoice.service.DealDataService;
import com.aisino.invoice.vo.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DealDataServiceImpl implements DealDataService {

    @Autowired
    private DealDataDao dealDataDao;

    @Override
    public Object get() {
        String returnString=null;
        int i=1;
        List<Customer> customers = this.dealDataDao.getCustomer();
        System.out.println(customers.size());
        try {
            for (Customer customer : customers) {
                i++;
                returnString="第"+i+"条数据";
                this.dealDataDao.insertCustomer(customer);

            }

        }catch (Exception e){
            System.out.println(returnString);
            return returnString+"     ==============>出现错误："+e.getMessage();
        }
        System.gc();
        return returnString;
    }

    @Override
    public Object insertRole() {
        Map<String,Long> map=new HashMap<>();
        List<Long> roleIds=this.dealDataDao.queryRoleIds();
        List<Long> userIds=this.dealDataDao.queryUserIds();
        for (Long userId : userIds) {
            for (Long roleId : roleIds) {
                map.put("userId",userId);
                map.put("roleId",roleId);
                this.dealDataDao.insertUserRole(map);
            }
        }


        return "插入成功";
    }
}
