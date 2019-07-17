package com.aisino.invoice.test;

import java.io.UnsupportedEncodingException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import com.mysql.jdbc.Connection;
import us.codecraft.webmagic.selector.Html;

/**
 * 
 * 爬虫
 *
 * @version  [VCES V201R001, 2017年10月12日]
 *

 * @since  [产品/模块版本]
 */
public class JavaBoKePageProcessor implements PageProcessor {

    private static List<String> insertList=new LinkedList<>();
    private static Connection conn=null;
    private static PreparedStatement ps =null;
    //标题和链接获取
//    private static String  TITLEQUERY="div.post_item_body h3 a.titlelnk";
//    //作者
//    private static String AUTHORQUERY="div.post_item_foot a.lightblue ";
//    //简介
//    private static String SUMMARYQUERY="div.post_item_body p.post_item_summary";
    //插入sql语句
    private static String insertSql ="INSERT INTO Boke (title,linke,author,authorUrl,summary)VALUES(?,?,?,?,?)";
    
    //初始链接
    private static Connection getConnection(){
        if (conn==null) {
            conn = MySqlJdbcUtils.getOpenConnection();
        }
        return conn;
    }
    
    /**
     *
     * insert操作
     *
     * @date   2017年8月31日
     * @return
     */

    private static synchronized void insertDb(List<String> javaBokes){
        try {

             ps = conn.prepareStatement(insertSql);

            for (String javaBoke:javaBokes) {
                ps.setString(1, javaBoke);

                ps.executeUpdate();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    //初始化带爬取网页地址
    private static List<String> urls(){
        List<String> listUrl =new ArrayList<String>();
        
        for (int i = 1; i <=1959; i++) {
            
            //listUrl.add("http://www.cnblogs.com/cate/java/"+i);
                listUrl.add("http://www.zd9999.com/ci/index_"+i+".htm");
        }
        listUrl.toArray(new String[listUrl.size()]);
        return listUrl;
    }
    
    /**
     *
     * jsoup根据 html 字符串和语法获取内容;
     * @date   2017年8月31日
     * @param htmlText
     * @return
     */
    private static String seletDocumentText(String htmlText,String Query){
        Document doc = Jsoup.parse(htmlText);
        String select = doc.select(Query).text();
        return select;
    }

    /**
     *
     * jsoup根据 html 字符串和语法获取链接地址;

     * @date   2017年8月31日
     * @param htmlText
     * @return
     */
    private static String seletDocumentLink(String htmlText,String Query){
        Document doc = Jsoup.parse(htmlText);
        String select = doc.select(Query).attr("href");
        return select;
    }
    /**
     *    process是定制爬虫逻辑的核心接口，在这里编写抽取逻辑
     * @see us.codecraft.webmagic.processor.PageProcessor#process(us.codecraft.webmagic.Page)
     */
    @Override
    public void process(Page page) {

        page.addTargetRequests(urls());
        //div[@class='post_item']//div[@class='post_item_body']//h3//a[@class='titlelnk']/text()'
        // 定义如何抽取页面信息，并保存下来
        List<String> htmls =page.getHtml().xpath("//font[@color='000000']/html()").all();

        for (String html:htmls) {

            try {

                insertList.add(html);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        
    }

    @Override
    public Site getSite() {
        //抓去网站的相关配置包括：编码、重试次数、抓取间隔
        return Site.me().setSleepTime(1000).setRetryTimes(10).setCharset("gbk");
    }
    
    public static void main(String[] args) {
        long startTime ,endTime;
        System.out.println("========小爬虫【启动】喽！=========");
        getConnection();
        startTime = new Date().getTime();
        //入口
        Spider create = Spider.create(new JavaBoKePageProcessor());
        //定义入口地址
        create.addUrl("http://www.zd9999.com/ci/").thread(5).run();

        insertDb(insertList);
        try {
            ps.close();
            conn.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
        endTime = new Date().getTime();
        System.out.println("========小爬虫【结束】喽！=========");
        System.out.println("用时为："+(endTime-startTime)/1000+"s");
    }

}