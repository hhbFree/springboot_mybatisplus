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
	          
	  }
}