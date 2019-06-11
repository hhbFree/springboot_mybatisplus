package com.aisino.invoice.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * 订单类
 */
public class Order {
    /* ##################客户所需信息##################*/
    /**
     * 用户信息接收后，查询crm与erp erp不存在，插入erp信息
     */
    private String customerId; //x

    private String customerName;//b

    private String customerTaxCode;//b

    //银行账号、开票地址、开票电话、开户银行


    /*##################销售订单所需信息###############*/
    private String billType;//1纸质发票(普通发票) 2纸质发票(专用发票) 3电子发票(正票) 4电子发票(红票) b

    private String notes;//备注 x

    private String invoicer;//开票人 b

    private String checker;//审核人 x

    private String ashierc;//收款人 x

    private String billNumber;//订单编号/收费单编号 b

    private String mailMethod;//邮寄方式 1.不寄票 2.随货寄票 3.EMS寄票 b

    private String transportMethod;//运输方式 1.自提 2.快递 3.送货

    private String saleMan;//销售人员

    private String saleType;//销售类型

    //纸质票、

    //电子票、


    /*##################销售订单明细所需信息###############*/
    List<OrderItem> orderItemList=new ArrayList<>();


    /*##################订单状态###############*/
    /**
     * 未开票:开票状态：未开票   审核状态：已审核
     *
     * 已开票:出库状态：未出库  开票状态：已开票
     */
    private String invoiceState;//1.未开票  2.已开票  b

}
