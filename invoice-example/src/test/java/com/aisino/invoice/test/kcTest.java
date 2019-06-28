package com.aisino.invoice.test;

import com.aisino.invoice.dao.RcDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class kcTest {

    @Autowired
    private RcDao rcDao;

    @Test
    public void getExcel() throws Exception{
        FileInputStream inputStream;

        inputStream = new FileInputStream(new File("E:\\project\\erp\\期初数据\\111.xlsx"));
        ExcelParser pa = new ExcelParser();
        ExcelParser parse = pa.parse(inputStream);
        // 1.查询出excel内的数据
        List<String[]> datas = parse.getDatas();
        for (String[] data : datas) {
            System.out.println(data[2]);//商品编码，库房名称
            Map<String,Object> mapXml=new HashMap<>();
            mapXml.put("code",data[2]);
            //2.根据商品编码查找商品id和单价
             Map<String,Object> mapG=this.rcDao.findGoodsIdByCode(mapXml);//商品编码

            System.out.println(mapG);

            //3.插入入库表
            Map<String,Object> map=new HashMap<>();
            //入库单id   select SEQ_TJHT_RK_CGRK.currval  from dual
            Integer rcId=this.rcDao.findRcId();

            map.put("rkid",rcId);

            //入库人id
            String  RKR_ID= "1000053";
            map.put("rkr_id",RKR_ID);
            //入库人名称
            String RKR_NAME="郝红搏";
            map.put("rkr_name",RKR_NAME);

            //入库部门id
            String RKR_DEMPID="55737";
            map.put("rkr_dempid",RKR_DEMPID);



            //入库日期

            //入库类型
            String RKLX="01";//采购入库

            map.put("rklx",RKLX);

            Double rkje=Double.parseDouble(data[10])*Double.parseDouble(mapG.get("PRICE").toString());
            map.put("rkje",rkje);

            map.put("bz","期初数据");//备注

            map .put("zdr_id","1000053");//制单人id

            map.put("zdr_name","郝红搏");

            map.put("zdr_dempid","55737");

            map.put("shr_name","郝红搏");

            map.put("shr_id","55737");

            map.put("kfmc",data[8]);//库房名称
            mapXml.put("storeName",data[8]);
            //根据库房名称查询库房id
            Integer StoreId=this.rcDao.findStoreIdByName(mapXml);


            map.put("kf_id",StoreId);

            //入库单
            SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
            String RK_ORDER_ID="RKD-"+sdf.format(new Date(System.currentTimeMillis()));
            map.put("rk_order_id",RK_ORDER_ID);

            //单据类型
            map.put("djlx","蓝字");

            //供应商id
            map.put("order_gysid","1");

            //供应商name
            map.put("order_gysmc","期初数据");
            this.rcDao.insertRc(map);


            //4.插入商品明细表
            Map<String,Object> mapMx=new HashMap<>();
            mapMx.put("rkid",rcId);

            //入库明细id //SEQ_TJHT_RK_RKMX
            Integer SEQ_TJHT_RK_RKMX=this.rcDao.findRcMxId();
            mapMx.put("rkmxid",SEQ_TJHT_RK_RKMX);

            mapMx.put("spbm",data[2]);//商品编码

            mapMx.put("spmc",data[3]);

            mapMx.put("spxh",data[5]);

            mapMx.put("spdw",data[6]);

            mapMx.put("spsl",data[10]);

            mapMx.put("nospsl",data[10]);

            mapMx.put("spdj",Double.parseDouble(mapG.get("PRICE").toString()));

            mapMx.put("kfmc",data[8]);

            mapMx.put("rkje",rkje);

            mapMx.put("sqr_id","1000053");

            mapMx.put("sqr_name","郝红搏");

            mapMx.put("order_gysid",1);//供应商id

            mapMx.put("order_gysmc","期初数据");

            mapMx.put("ddmxid",null);


            mapMx.put("bhsje",rkje/(1+Double.parseDouble(mapG.get("SLV").toString()))*+Double.parseDouble(mapG.get("SLV").toString()));// rkje/(1+slv1)*slv1;//含税金额

            this.rcDao.insertRcmx(mapMx);
        }
    }

    @Test
    public void test(){
        List<Integer> list=new ArrayList<>();



        Integer[] a={1,2,3,4,5};
        for (Integer integer : a) {
            list.add(integer);
        }
        Integer[] b={234,433,34,423,12};

        for (Integer integerB : b) {
            list.add(integerB);
        }

        //排序
        Collections.sort(list);
        System.out.println(list);
    }


}
