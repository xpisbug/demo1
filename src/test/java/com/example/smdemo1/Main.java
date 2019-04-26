package com.example.smdemo1;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

/**
 * @author xp-dc
 * @date 2019/1/7
 */
public class Main {

	@Test
	public void main(){
		TestTable tt1 = new TestTable();
		tt1.setId(1); // 查询id为1的信息

		TestTable tt2 = new TestTable();
		tt2.setName("xxx"); // 查询name为xxx的信息

		TestTable tt3 = new TestTable();
		tt3.setAge(12); // 查询age为12的信息


		String sql1 = getSql(tt1);
		String sql2 = getSql(tt2);
		String sql3 = getSql(tt3);
		System.out.println(sql1);
		System.out.println(sql2);
		System.out.println(sql3);
		query(sql1);

	}

	private void query(String sql){
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			System.out.println("找不到驱动类，加载驱动失败。");
		}

		String url = "jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8";
		String username = "root";
		String pass = "123123";
		Connection conn = null;
		try{
			conn = DriverManager.getConnection(url, username, pass);
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("数据库链接失败。。");
		}
		Statement stmt = null;
		try{
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				String id = rs.getString("id");
				String name = rs.getString("name");
				String age = rs.getString("age");
				String note = rs.getString("note");
				System.out.println(id+"---"+name+"---"+age+"----"+note);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}

	}

	private String getSql(Object tt){
		StringBuilder sql = new StringBuilder();
		//获取到class
		Class cl = tt.getClass();
		//获取到table名称
		boolean existsTable = cl.isAnnotationPresent(Table.class);
		if(!existsTable){
			return null;
		}
		Table table = (Table)cl.getAnnotation(Table.class);
		//定义表名
		String tableName = table.value();
		sql.append("select * from ").append(tableName).append(" where 1 = 1 ");
		//遍历所有字段
		Field[] fields = cl.getDeclaredFields();
		for(Field field : fields){
			//判断是否存在这个注解
			boolean existsField = field.isAnnotationPresent(Column.class);
			if(!existsField){
				continue;
			}
			//获取注解
			Column column = field.getAnnotation(Column.class);
			String columnName = column.value();
			//获取字段的值
			String fieldName = field.getName();
			String getMethodName = "get"+fieldName.substring(0,1).toUpperCase() + fieldName.substring(1);
			Method method = null;
			Object columnValue = null;
			try{
				method = cl.getMethod(getMethodName);
				columnValue = method.invoke(tt);
			}catch(NoSuchMethodException | IllegalAccessException |InvocationTargetException e){
				e.printStackTrace();
			}

			//int型不需要加单引号，String型需要加单引号
			if(columnValue instanceof Integer && (int)columnValue != 0){
				sql.append("and ").append(columnName).append(" = "+columnValue+" ");
			}else if(columnValue instanceof String){
				if(((String)columnValue).contains(",")){
					String[] values = ((String)columnValue).split(",");
					sql.append("and ").append(columnName).append("in (");
					for(int i = 0; i<values.length; i++){
						sql.append("'").append(values[i]).append("',");
					}
					sql.deleteCharAt(sql.length()-1);
					sql.append(")");
				}else{
					sql.append("and ").append(columnName).append(" = '").append(columnValue).append("'");
				}
			}
		}
		return sql.toString();
	}
}
