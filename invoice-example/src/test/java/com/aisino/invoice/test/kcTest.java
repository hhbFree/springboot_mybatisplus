package com.aisino.invoice.test;

import com.aisino.invoice.dao.RcDao;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class kcTest {

    // 找不到商品名称
    List<Map<String,Object>> missGoodMap = new ArrayList<>();
    // 找不到库房的
    List<Map<String,Object>> missStoreData = new ArrayList<>();

    @Autowired
    private RcDao rcDao;

    @Test
    public void getExcel() throws Exception{

        //创建excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        //创建sheet页
        HSSFSheet sheet = wb.createSheet("找不到商品名称");
        HSSFSheet sheet2 = wb.createSheet("找不到库房的");

        //创建标题行
        HSSFRow titleRow = sheet.createRow(0);
        titleRow.createCell(0).setCellValue("序号");
        titleRow.createCell(1).setCellValue("业务组织");
        titleRow.createCell(2).setCellValue("物料编码");
        titleRow.createCell(3).setCellValue("物料名称");
        titleRow.createCell(4).setCellValue("助记码");
        titleRow.createCell(5).setCellValue("规格型号");
        titleRow.createCell(6).setCellValue("单位");
        titleRow.createCell(7).setCellValue("物品分类名称");
        titleRow.createCell(8).setCellValue("仓库");
        titleRow.createCell(9).setCellValue("物料属性");
        titleRow.createCell(10).setCellValue("现存量");
        titleRow.createCell(11).setCellValue("可用量");
        titleRow.createCell(12).setCellValue("预计入库数量");
        titleRow.createCell(13).setCellValue("预计出库数量");

        HSSFRow titleRow2 = sheet2.createRow(0);
        titleRow2.createCell(0).setCellValue("序号");
        titleRow2.createCell(1).setCellValue("业务组织");
        titleRow2.createCell(2).setCellValue("物料编码");
        titleRow2.createCell(3).setCellValue("物料名称");
        titleRow2.createCell(4).setCellValue("助记码");
        titleRow2.createCell(5).setCellValue("规格型号");
        titleRow2.createCell(6).setCellValue("单位");
        titleRow2.createCell(7).setCellValue("物品分类名称");
        titleRow2.createCell(8).setCellValue("仓库");
        titleRow2.createCell(9).setCellValue("物料属性");
        titleRow2.createCell(10).setCellValue("现存量");
        titleRow2.createCell(11).setCellValue("可用量");
        titleRow2.createCell(12).setCellValue("预计入库数量");
        titleRow2.createCell(13).setCellValue("预计出库数量");


        FileInputStream inputStream;

        inputStream = new FileInputStream(new File("E:\\子公司.xlsx"));
//      inputStream = new FileInputStream(new File("C:\\Users\\Administrator\\Desktop\\子公司可用量6.28.xls"));
        ExcelParser pa = new ExcelParser();
        ExcelParser parse = pa.parse(inputStream);

        // 1.查询出excel内的数据
        List<String[]> datas = parse.getDatas();
        for (String[] data : datas) {
            //System.out.println(data[2]);//商品编码，库房名称
            Map<String,Object> mapXml=new HashMap<>();
            mapXml.put("code",data[2]);
            //2.根据商品编码查找商品id和单价
             Map<String,Object> mapG=this.rcDao.findGoodsIdByCode(mapXml);//商品编码
            if(mapG==null){

                System.out.println("找不到对应商品："+data[0]);

                HSSFRow dataRow = sheet.createRow(sheet.getLastRowNum()+1);
                dataRow.createCell(0).setCellValue(data[0]);
                dataRow.createCell(1).setCellValue(data[1]);
                dataRow.createCell(2).setCellValue(data[2]);
                dataRow.createCell(3).setCellValue(data[3]);
                dataRow.createCell(4).setCellValue(data[4]);
                dataRow.createCell(5).setCellValue(data[5]);
                dataRow.createCell(6).setCellValue(data[6]);
                dataRow.createCell(7).setCellValue(data[7]);
                dataRow.createCell(8).setCellValue(data[8]);
                dataRow.createCell(9).setCellValue(data[9]);
                dataRow.createCell(10).setCellValue(data[10]);
                dataRow.createCell(11).setCellValue(data[11]);
                dataRow.createCell(12).setCellValue(data[12]);
                dataRow.createCell(13).setCellValue(data[13]);


//                Integer StoreId=this.rcDao.findStoreIdByName(mapXml);
//                if (StoreId==null){
//                    System.out.println("找不到库房："+data[2]);
//
//                    HSSFRow dataRow2 = sheet2.createRow(sheet2.getLastRowNum()+1);
//                    dataRow2.createCell(0).setCellValue(data[0]);
//                    dataRow2.createCell(1).setCellValue(data[1]);
//                    dataRow2.createCell(2).setCellValue(data[2]);
//                    dataRow2.createCell(3).setCellValue(data[3]);
//                    dataRow2.createCell(4).setCellValue(data[4]);
//                    dataRow2.createCell(5).setCellValue(data[5]);
//                    dataRow2.createCell(6).setCellValue(data[6]);
//                    dataRow2.createCell(7).setCellValue(data[7]);
//                    dataRow2.createCell(8).setCellValue(data[8]);
//                    dataRow2.createCell(9).setCellValue(data[9]);
//                    dataRow2.createCell(10).setCellValue(data[10]);
//                    dataRow2.createCell(11).setCellValue(data[11]);
//                    dataRow2.createCell(12).setCellValue(data[12]);
//                    dataRow2.createCell(13).setCellValue(data[13]);
//
//                }

                continue;
            }


            //3.插入入库表
            Map<String,Object> map=new HashMap<>();
            //入库单id   select SEQ_TJHT_RK_CGRK.currval  from dual
            Integer rcId=this.rcDao.findRcId();

            map.put("rkid",rcId);

            //入库人id
            String  RKR_ID= "711125063516246319";
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

            map .put("zdr_id","711125063516246319");//制单人id

            map.put("zdr_name","郝红搏");

            map.put("zdr_dempid","55737");

            map.put("shr_name","郝红搏");

            map.put("shr_id","55737");

            map.put("kfmc",data[8]);//库房名称
            mapXml.put("storeName",data[8]);
            //根据库房名称查询库房id
            Integer StoreId=this.rcDao.findStoreIdByName(mapXml);
           if (StoreId==null){
               System.out.println("找不到库房："+data[2]);

               HSSFRow dataRow = sheet2.createRow(sheet2.getLastRowNum()+1);
               dataRow.createCell(0).setCellValue(data[0]);
               dataRow.createCell(1).setCellValue(data[1]);
               dataRow.createCell(2).setCellValue(data[2]);
               dataRow.createCell(3).setCellValue(data[3]);
               dataRow.createCell(4).setCellValue(data[4]);
               dataRow.createCell(5).setCellValue(data[5]);
               dataRow.createCell(6).setCellValue(data[6]);
               dataRow.createCell(7).setCellValue(data[7]);
               dataRow.createCell(8).setCellValue(data[8]);
               dataRow.createCell(9).setCellValue(data[9]);
               dataRow.createCell(10).setCellValue(data[10]);
               dataRow.createCell(11).setCellValue(data[11]);
               dataRow.createCell(12).setCellValue(data[12]);
               dataRow.createCell(13).setCellValue(data[13]);
               continue;
           }

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

            mapMx.put("sqr_id","711125063516246319");

            mapMx.put("sqr_name","郝红搏");

            mapMx.put("order_gysid",1);//供应商id

            mapMx.put("order_gysmc","期初数据");

            mapMx.put("ddmxid",null);

            if(mapG.get("SLV")!=null&&rkje!=null&&mapG.get("SLV")!=""){

            mapMx.put("bhsje",rkje/(1+Double.parseDouble(mapG.get("SLV").toString()))*+Double.parseDouble(mapG.get("SLV").toString()));// rkje/(1+slv1)*slv1;//含税金额
            }

            this.rcDao.insertRcmx(mapMx);
        }

        //输出Excel文件1
        FileOutputStream output=new FileOutputStream("C:\\Users\\Administrator\\Desktop\\子公司.xlsx");
        wb.write(output);//写入磁盘
        output.close();

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
