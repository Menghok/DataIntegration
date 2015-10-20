package model;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

public class DBUtilities {
	Connection con;
	
	public Connection getConnect() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://192.168.178.254/naver_scrape", "root", "");
	    return con;
	}
	
	public void close() throws Exception{
		con.close();
	}
	
	public static void main(String[] args) {
		DBUtilities db = new DBUtilities();
		try{
			Connection c = db.getConnect();
			String url = "http://news.naver.com/main/officeList.nhn";
//			Document doc = Jsoup.parse(new URL(url).openStream(), "ISO-8859-1", url);
			Document doc = Jsoup.connect(url).get();
			doc.outputSettings().charset("euc-kr");
			Elements ths = doc.getElementById("groupOfficeList").getElementsByTag("th");
			for(Element th : ths){
				System.out.println(th.text());
				PreparedStatement pstmt = c.prepareStatement("INSERT INTO Types(typename) VALUES(?)");
				pstmt.setString(1, th.text());
				pstmt.executeUpdate();
				System.out.println("______");
			}
			
			
		}catch(Exception e){
			System.err.println(e.getMessage());
		}finally{
			try {
				db.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
