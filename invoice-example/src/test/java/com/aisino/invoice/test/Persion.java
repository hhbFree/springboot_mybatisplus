package com.aisino.invoice.test;

import java.util.ArrayList;
import java.util.List;

public class Persion {
	  private String father;
	    private String mother;
	    private String name;
	    public String getFather(){return father;}
	    public String gctMother() {  return mother;}
	    public String getName() {return name;}
    public Persion(String father,String mother,String name){
          this.father =father;
          this.mother=mother;
          this.name=name;
    }
    public Persion(String [] data){
          this( data[0],data[1],data[2]);
          }
    public boolean isChildrenO(String name){
          if(name == null)
        	  if(father ==null && mother==null)
        		  return true;
        		  else
                      return false;
          return (name.equals(father) || name.equals(mother));
    }
    
    private static List<Persion> createAllData(String [][] allData){
          ArrayList<Persion> list= new ArrayList<Persion>();
          for (String[] persionData:allData){
        	  list.add(new Persion(persionData));
                		
          }
          return list;
    }
    
    
    private static void traverse(List<Persion> allData,String name,Integer level){
          for(Persion persion:allData){
                if(persion.isChildrenO(name)){
                      System.out.print(level.toString() +":"+persion.getName());
                      traverse(allData,persion.getName(),level+1);
                }
          }
    }
	  public static void main(String[] args){
	          List<Persion> list = createAllData(new String[][]{{null,null,"张飞1"},{null,null,"夏铁夫人"},{"张飞","夏侯夫人","张范"},
	        	  {"张飞","夏快夫人","张缩"},{"张苞","无名氏","张道"}});
	          traverse(list,null,1);


	          String aa="SELECT\n" +
                      "\tty.TYPENAME saleType,\n" +
                      "\ti.DEPTNAME,\n" +
                      "\ti.SALEEMPNAME,\n" +
                      "\tgt.TYPENAME,\n" +
                      "\tG .GOODSCODE,\n" +
                      "\tG .GOODSNAME,\n" +
                      "\ts.STOREHOUSE_NAME,\n" +
                      "\tSUM (di.NUMS) SUMNUM,\n" +
                      "\tSUM (di.SUBMONEY) / (1 + G .SLV / 100) AMOUNT,\n" +
                      "\tG .SLV,\n" +
                      "\tSUM (di.SUBMONEY) - SUM (di.SUBMONEY) / (1 + G .SLV / 100) TAXAMOUNT,\n" +
                      "\tSUM (di.SUBMONEY) SUBMONEY,\n" +
                      "\tSUM (H .PRICE) PRICECOST,\n" +
                      "\tSUM (di.SUBMONEY) / (1 + G .SLV / 100) - SUM (H .PRICE) GROSSPROFT,\n" +
                      "\tG . PERCENT\n" +
                      "FROM\n" +
                      "\tTJHT_SYS_ERPDETAILOFINCOME di\n" +
                      "LEFT JOIN TJHT_SYS_ERPBILLOFINCOME i ON i.BILLOFINCOMEID = di.INCOMEID\n" +
                      "LEFT JOIN TJHT_SYS_ERPDETAILOFINVOICE dv ON di.DETAILVOICEID = dv.DETAILINVOICEID\n" +
                      "LEFT JOIN TJHT_SYS_ERPDETAILOFSALE ds ON dv.DETAILOFSALEID = ds.DETAILSALEID\n" +
                      "LEFT JOIN TJHT_SYS_ERPBILLOFSALE s ON ds.BILLSALEID = s.BILLSALEID\n" +
                      "LEFT JOIN TJHT_SYS_ERPSALETYPE ty ON ty.TYPEID = s.SALETYPE\n" +
                      "LEFT JOIN TJHT_SYS_GOODS G ON di.GOODSID = G .GOODSCODE\n" +
                      "LEFT JOIN TJHT_SYS_GOODSTYPE gt ON G .GOODSTYPEID = gt.GOODSTYPEID\n" +
                      "LEFT JOIN TJHT_SYS_ERPDETAILOFTAKEOUT dt ON dt.DETAILOFINVOICEID = dv.DETAILINVOICEID\n" +
                      "LEFT JOIN TJHT_SYS_NUMBERINHOUSE H ON dt.BATCHNO = H .BATCHNO\n" +
                      "WHERE\n" +
                      "\t--出库后才能算出成本 毛利\n" +
                      "\tH .PRICE IS NOT NULL --不含服务费\n" +
                      "AND gt.TYPENAME != '服务费'\n" +
                      "GROUP BY\n" +
                      "\tty.TYPENAME,\n" +
                      "\ti.DEPTNAME,\n" +
                      "\ti.SALEEMPNAME,\n" +
                      "\tgt.TYPENAME,\n" +
                      "\tG .GOODSCODE,\n" +
                      "\tG .GOODSNAME,\n" +
                      "\ts.STOREHOUSE_NAME,\n" +
                      "\tdi.SUBMONEY,\n" +
                      "\tG .SLV,\n" +
                      "\tG . PERCENT\n" +
                      "UNION ALL\n" +
                      "\tSELECT\n" +
                      "\t\tty.TYPENAME saleType,\n" +
                      "\t\ti.DEPTNAME,\n" +
                      "\t\ti.SALEEMPNAME,\n" +
                      "\t\tgt.TYPENAME,\n" +
                      "\t\tG .GOODSCODE,\n" +
                      "\t\tG .GOODSNAME,\n" +
                      "\t\ts.STOREHOUSE_NAME,\n" +
                      "\t\tSUM (di.NUMS) SUMNUM,\n" +
                      "\t\tSUM (di.SUBMONEY) / (1 + G .SLV / 100) AMOUNT,\n" +
                      "\t\tG .SLV,\n" +
                      "\t\tSUM (di.SUBMONEY) - SUM (di.SUBMONEY) / (1 + G .SLV / 100) TAXAMOUNT,\n" +
                      "\t\tSUM (di.SUBMONEY) SUBMONEY,\n" +
                      "\t\tSUM (H .PRICE) PRICECOST,\n" +
                      "\t\tSUM (di.SUBMONEY) / (1 + G .SLV / 100) - SUM (H .PRICE) GROSSPROFT,\n" +
                      "\t\tG . PERCENT\n" +
                      "\tFROM\n" +
                      "\t\tTJHT_SYS_ERPDETAILOFINCOME di\n" +
                      "\tLEFT JOIN TJHT_SYS_ERPBILLOFINCOME i ON i.BILLOFINCOMEID = di.INCOMEID\n" +
                      "\tLEFT JOIN TJHT_SYS_ERPDETAILOFINVOICE dv ON di.DETAILVOICEID = dv.DETAILINVOICEID\n" +
                      "\tLEFT JOIN TJHT_SYS_ERPDETAILOFSALE ds ON dv.DETAILOFSALEID = ds.DETAILSALEID\n" +
                      "\tLEFT JOIN TJHT_SYS_ERPBILLOFSALE s ON ds.BILLSALEID = s.BILLSALEID\n" +
                      "\tLEFT JOIN TJHT_SYS_ERPSALETYPE ty ON ty.TYPEID = s.SALETYPE\n" +
                      "\tLEFT JOIN TJHT_SYS_GOODS G ON di.GOODSID = G .GOODSCODE\n" +
                      "\tLEFT JOIN TJHT_SYS_GOODSTYPE gt ON G .GOODSTYPEID = gt.GOODSTYPEID\n" +
                      "\tLEFT JOIN TJHT_SYS_ERPDETAILOFTAKEOUT dt ON dt.DETAILOFINVOICEID = dv.DETAILINVOICEID\n" +
                      "\tLEFT JOIN TJHT_SYS_NUMBERINHOUSE H ON dt.BATCHNO = H .BATCHNO\n" +
                      "\tWHERE\n" +
                      "\t\t--含服务费\n" +
                      "\t\tG .GOODSNAME = '服务费'\n" +
                      "\tGROUP BY\n" +
                      "\t\tty.TYPENAME,\n" +
                      "\t\ti.DEPTNAME,\n" +
                      "\t\ti.SALEEMPNAME,\n" +
                      "\t\tgt.TYPENAME,\n" +
                      "\t\tG .GOODSCODE,\n" +
                      "\t\tG .GOODSNAME,\n" +
                      "\t\ts.STOREHOUSE_NAME,\n" +
                      "\t\tdi.SUBMONEY,\n" +
                      "\t\tG .SLV,\n" +
                      "\t\tG . PERCENT\n" +
                      "\tUNION ALL\n" +
                      "\t\tSELECT\n" +
                      "\t\t\tty.TYPENAME saleType,\n" +
                      "\t\t\ts.DEPTNAME,\n" +
                      "\t\t\ts.SALEEMPNAME,\n" +
                      "\t\t\tgt.TYPENAME,\n" +
                      "\t\t\tG .GOODSCODE,\n" +
                      "\t\t\tG .GOODSNAME,\n" +
                      "\t\t\ts.STOREHOUSE_NAME,\n" +
                      "\t\t\tSUM (ds.NUMS) SUMNUM,\n" +
                      "\t\t\tSUM (ds.SUBMONEY) / (1 + G .SLV / 100) AMOUNT,\n" +
                      "\t\t\tG .SLV,\n" +
                      "\t\t\tSUM (ds.SUBMONEY) - SUM (ds.SUBMONEY) / (1 + G .SLV / 100) TAXAMOUNT,\n" +
                      "\t\t\tSUM (ds.SUBMONEY) SUBMONEY,\n" +
                      "\t\t\t0 PRICECOST,\n" +
                      "\t\t\t0 GROSSPROFT,\n" +
                      "\t\t\tG . PERCENT\n" +
                      "\t\tFROM\n" +
                      "\t\t\tTJHT_SYS_ERPDETAILOFSALE ds\n" +
                      "\t\tLEFT JOIN TJHT_SYS_ERPBILLOFSALE s ON ds.BILLSALEID = s.BILLSALEID\n" +
                      "\t\tLEFT JOIN TJHT_SYS_ERPSALETYPE ty ON ty.TYPEID = s.SALETYPE\n" +
                      "\t\tLEFT JOIN TJHT_SYS_GOODS G ON ds.GOODSID = G .GOODSCODE\n" +
                      "\t\tLEFT JOIN TJHT_SYS_GOODSTYPE gt ON G .GOODSTYPEID = gt.GOODSTYPEID\n" +
                      "\t\tWHERE\n" +
                      "\t\t\t--快递\n" +
                      "\t\t\tINSTR (G .GOODSNAME, '快递') > 0\n" +
                      "\t\tGROUP BY\n" +
                      "\t\t\tty.TYPENAME,\n" +
                      "\t\t\ts.DEPTNAME,\n" +
                      "\t\t\ts.SALEEMPNAME,\n" +
                      "\t\t\tgt.TYPENAME,\n" +
                      "\t\t\tG .GOODSCODE,\n" +
                      "\t\t\tG .GOODSNAME,\n" +
                      "\t\t\ts.STOREHOUSE_NAME,\n" +
                      "\t\t\tds.SUBMONEY,\n" +
                      "\t\t\tG .SLV,\n" +
                      "\t\t\tG . PERCENT";

                String bb="SELECT\n" +
                        "\tSUM (GROSSPROFT)\n" +
                        "FROM\n" +
                        "\tERP_BONUS_BONUSCALDETAIL bt\n" +
                        "WHERE\n" +
                        "\t1 = 1\n" +
                        "AND BT.\"PERCENT\" = 20\n" +
                        "AND BT.BONUSCALCULATIONID =";

	  }
}