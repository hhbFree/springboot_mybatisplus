package com.aisino.invoice.test;

import org.apache.commons.codec.binary.Base64;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.UnsupportedEncodingException;


@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceTest {

    String s="<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
            "\n" +
            "<FPXT_COM_INPUT> \n" +
            "  <ID>0200</ID>  \n" +
            "  <DATA>Cjw/eG1sIHZlcnNpb249IjEuMCIgZW5jb2Rpbmc9InV0Zi04Ij8+Cgo8RlBYVD4gCiAgPElOUFVUPiAKICAgIDxSZWRJbnZSZXFCaWxsPiAKICAgICAgPFJlcU5zcnNiaD4xMTAxMDEwODAxMDEyMTE8L1JlcU5zcnNiaD4gIAogICAgICA8S3BqaD4wPC9LcGpoPiAgCiAgICAgIDxTYmJoPjExMDEwMTA4MDEwMTIxMTwvU2JiaD4gIAogICAgICA8UmVxQmlsbE5vPjY2MTQyMzQxMjEzNjE0MDkyNDE2NTE0NDwvUmVxQmlsbE5vPiAgCiAgICAgIDxCaWxsVHlwZT4wPC9CaWxsVHlwZT4gIAogICAgICA8VHlwZUNvZGUvPiAgCiAgICAgIDxJbnZOby8+ICAKICAgICAgPFN6bGI+MDwvU3psYj4gIAogICAgICA8SXNNdXRpUmF0ZT4wPC9Jc011dGlSYXRlPiAgCiAgICAgIDxEYXRlPjIwMTQtMDctMjk8L0RhdGU+ICAKICAgICAgPEJ1eWVyTmFtZT53aHM8L0J1eWVyTmFtZT4gIAogICAgICA8QnV5VGF4Q29kZT4xMTAxMDEwODAxMDEyMTE8L0J1eVRheENvZGU+ICAKICAgICAgPFNlbGxlck5hbWU+5YyX5Lqs5Lic5pa55aiB5Yqb6IKh5Lu95YWs5Y+4PC9TZWxsZXJOYW1lPiAgCiAgICAgIDxTZWxsVGF4Q29kZT4xMTAxMDIyNTEzMjgzMzM8L1NlbGxUYXhDb2RlPiAgCiAgICAgIDxBbW91bnQ+LTI0NTAuMDA8L0Ftb3VudD4gIAogICAgICA8VGF4UmF0ZT4wLjE3PC9UYXhSYXRlPiAgCiAgICAgIDxUYXg+LTQxNi41MDwvVGF4PiAgCiAgICAgIDxSZXFNZW1vPjExMDAwMDAwMDA8L1JlcU1lbW8+ICAKICAgICAgPFNQQk1CQkg+LTwvU1BCTUJCSD4gIAogICAgICA8U0xCWi8+ICAKICAgICAgPFJlZEludlJlcUJpbGxNeD4gCiAgICAgICAgPEdvb2RzTXg+IAogICAgICAgICAgPEdvb2RzTmFtZT7phY3ku7Y8L0dvb2RzTmFtZT4gIAogICAgICAgICAgPEdvb2RzVW5pdD7lpZc8L0dvb2RzVW5pdD4gIAogICAgICAgICAgPEdvb2RzUHJpY2U+MzUwPC9Hb29kc1ByaWNlPiAgCiAgICAgICAgICA8R29vZHNUYXhSYXRlPjAuMTc8L0dvb2RzVGF4UmF0ZT4gIAogICAgICAgICAgPEdvb2RzR2d4aD5OT1dFbGw8L0dvb2RzR2d4aD4gIAogICAgICAgICAgPEdvb2RzTnVtPi03PC9Hb29kc051bT4gIAogICAgICAgICAgPEdvb2RzSkU+LTI0NTAuMDA8L0dvb2RzSkU+ICAKICAgICAgICAgIDxHb29kc1NFPi00MTYuNTA8L0dvb2RzU0U+ICAKICAgICAgICAgIDxIU19CWj5OPC9IU19CWj4gIAogICAgICAgICAgPFNQQk0vPiAgCiAgICAgICAgICA8UVlTUEJNLz4gIAogICAgICAgICAgPFNZWUhaQ0JaLz4gIAogICAgICAgICAgPFlIWkMvPiAgCiAgICAgICAgICA8TFNMQlovPiAKICAgICAgICA8L0dvb2RzTXg+IAogICAgICA8L1JlZEludlJlcUJpbGxNeD4gCiAgICA8L1JlZEludlJlcUJpbGw+IAogIDwvSU5QVVQ+IAo8L0ZQWFQ+Cg==<DATA/> \n" +
            "</FPXT_COM_INPUT>";

    @Test
    public void testOne(){

        //数据代码
        String yewu="\n<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "\n" +
                "<FPXT> \n" +
                "  <INPUT> \n" +
                "    <RedInvReqBill> \n" +
                "      <ReqNsrsbh>110101080101211</ReqNsrsbh>  \n" +
                "      <Kpjh>0</Kpjh>  \n" +
                "      <Sbbh>110101080101211</Sbbh>  \n" +
                "      <ReqBillNo>661423412136140924165144</ReqBillNo>  \n" +
                "      <BillType>0</BillType>  \n" +
                "      <TypeCode/>  \n" +
                "      <InvNo/>  \n" +
                "      <Szlb>0</Szlb>  \n" +
                "      <IsMutiRate>0</IsMutiRate>  \n" +
                "      <Date>2014-07-29</Date>  \n" +
                "      <BuyerName>whs</BuyerName>  \n" +
                "      <BuyTaxCode>110101080101211</BuyTaxCode>  \n" +
                "      <SellerName>北京东方威力股份公司</SellerName>  \n" +
                "      <SellTaxCode>110102251328333</SellTaxCode>  \n" +
                "      <Amount>-2450.00</Amount>  \n" +
                "      <TaxRate>0.17</TaxRate>  \n" +
                "      <Tax>-416.50</Tax>  \n" +
                "      <ReqMemo>1100000000</ReqMemo>  \n" +
                "      <SPBMBBH>-</SPBMBBH>  \n" +
                "      <SLBZ/>  \n" +
                "      <RedInvReqBillMx> \n" +
                "        <GoodsMx> \n" +
                "          <GoodsName>配件</GoodsName>  \n" +
                "          <GoodsUnit>套</GoodsUnit>  \n" +
                "          <GoodsPrice>350</GoodsPrice>  \n" +
                "          <GoodsTaxRate>0.17</GoodsTaxRate>  \n" +
                "          <GoodsGgxh>NOWEll</GoodsGgxh>  \n" +
                "          <GoodsNum>-7</GoodsNum>  \n" +
                "          <GoodsJE>-2450.00</GoodsJE>  \n" +
                "          <GoodsSE>-416.50</GoodsSE>  \n" +
                "          <HS_BZ>N</HS_BZ>  \n" +
                "          <SPBM/>  \n" +
                "          <QYSPBM/>  \n" +
                "          <SYYHZCBZ/>  \n" +
                "          <YHZC/>  \n" +
                "          <LSLBZ/> \n" +
                "        </GoodsMx> \n" +
                "      </RedInvReqBillMx> \n" +
                "    </RedInvReqBill> \n" +
                "  </INPUT> \n" +
                "</FPXT>\n";

        Base64 base64 = new Base64();

        try {
            yewu = base64.encodeToString(yewu.getBytes("UTF-8"));
            //业务xml
            String biaoshi="<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                    "\n" +
                    "<FPXT_COM_INPUT> \n" +
                    "  <ID>0200</ID>  \n" +
                    "  <DATA>"+yewu+"</DATA> \n" +
                    "</FPXT_COM_INPUT>\n";

            System.out.println(biaoshi);

            } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


}
