package com.aisino.invoice.dao;

import com.aisino.invoice.vo.Customer;

import java.util.List;
import java.util.Map;

public interface DealDataDao {
    List<Customer> getCustomer();

    void insertCustomer(Customer customer);

    List<Long> queryRoleIds();

    List<Long> queryUserIds();

    void insertUserRole(Map<String, Long> map);
}
