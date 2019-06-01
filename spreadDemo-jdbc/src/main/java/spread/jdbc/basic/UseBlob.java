package spread.jdbc.basic;

import spread.jdbc.basic.util.JdbcUtil;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.*;

/**
 * 使用blob
 */
public class UseBlob {

    /***
     * 1，建表，增加一个picture字段
     * 2，提供一个图片
     * 3，通过blob 方式添加进去
     * 4，读取，使用输出流输出
     */

    /**
     * 插入blob
     */
    public static void insertBlob() {
        /**
         * 获取连接
         * 得到prepareStatement
         * 插入blob
         *
         */
        try( Connection connection = JdbcUtil.getConnection();) {
            InputStream inputStream = UseBlob.class.getClassLoader().getResourceAsStream("IMG_20190407_143735.jpg");
            String sql = "insert into person(name,age,picture) values (?,?,?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql);){
                preparedStatement.setString(1,"blob1");
                preparedStatement.setInt(2,22);
                preparedStatement.setBlob(3,inputStream);
                preparedStatement.execute();
                System.out.println("执行完毕！");
            }
        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * 在数据库中得到      */
    public static void getBlob() {
        /**
         * 获取连接
         * 执行sql
         * 获取blob
         * 输出
         */
        try( Connection connection = JdbcUtil.getConnection();) {

            String sql = "select * from person where id = 2";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
                 ResultSet resultSet = preparedStatement.executeQuery();){
                while (resultSet.next()) {
                    Blob picture = resultSet.getBlob("picture");
                    InputStream binaryStream = picture.getBinaryStream();
                    //输出
                    int len = 0;
                    //得到resource资源路径
                    String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
                    OutputStream outputStream = new FileOutputStream(path+"/newIMG33.jpg");
                    byte[] buffer = new byte[1024];
                    while ((len = binaryStream.read(buffer,0,buffer.length)) != -1) {
                        outputStream.write(buffer,0,buffer.length);
                    }
                }
                System.out.println("执行完毕！");
            }
        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

//        insertBlob();

        getBlob();

    }



}
