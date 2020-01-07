package com.library.utils;

import java.sql.*;

public class dbUtil {
    public static String url="jdbc:mysql://localhost:3306/library?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
    public static String user="root";
    public static String password="root";
    public static Connection connection=null;
    public static PreparedStatement pstmt=null;
    public static ResultSet rs=null;
    public static Connection getConnect(){   //获取链接
        String sql="s";
        try{
           Class.forName("com.mysql.cj.jdbc.Driver");  //加载驱动
           connection = DriverManager.getConnection(url,user,password);
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }
    public static void closeAll(ResultSet rs,PreparedStatement pstmt,Connection connection) {
        try {
            if(rs!=null)
                rs.close();
            if(pstmt!=null)
                pstmt.close();
            if(connection!=null)
                connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void allUpdata(String sql,Object[] params){    //增删改
        try {
            getConnect();
            pstmt = connection.prepareStatement(sql);
            if(params!=null) {
                for(int i=0;i<=params.length-1;i++) {
                    pstmt.setObject(i+1, params[i]);
                }
            }
            int count = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dbUtil.closeAll(rs,pstmt,connection);
        }
    }
    //========================通用查询
    public static ResultSet queryAll(String sql,Object[] params) {
        try {
            pstmt = dbUtil.getConnect().prepareStatement(sql);
            if(params!=null) {
                for(int i=0;i<=params.length-1;i++) {
                    pstmt.setObject(i+1, params[i]);
                }
            }
            rs = pstmt.executeQuery();
            if(rs!=null){
                return rs;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
            return rs;
    }
}
