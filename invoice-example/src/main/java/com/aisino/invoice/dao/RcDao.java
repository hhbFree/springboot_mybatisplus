package com.aisino.invoice.dao;

import java.util.Map;

public interface RcDao {
    Map<String, Object> findGoodsIdByCode(Map<String, Object> code);

    Integer findRcId();

    Integer findStoreIdByName(Map<String, Object> mapXml);

    void insertRc(Map<String, Object> map);

    Integer findRcMxId();

    void insertRcmx(Map<String, Object> mapMx);
}
