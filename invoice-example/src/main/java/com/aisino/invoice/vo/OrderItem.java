package com.aisino.invoice.vo;

/**
 * 订单明细
 */
public class OrderItem {

    private String googsNo;//商品编码

    private String goodsname; //商品名称 b

    private String listtaxitem;//税目 x

    private String standard;//规则型号 x

    private String unit;//计量单位 x

    private String nums;//数量 b

    private String price;//单价 b

    private String amount;//金额 x

    private String priceKind;//含税标志 x

    private String taxAount;//税额 x (须符合计算关系)
}
