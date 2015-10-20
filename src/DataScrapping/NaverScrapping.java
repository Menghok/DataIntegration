package DataScrapping;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/*import java.util.ArrayList;

import model.dto.Type;*/

public class NaverScrapping {
	
	
	/*public ArrayList<Type> getAllType()
	{
		return null;
	}*/
	public static void main(String[] args) {
		try {
			Document doc = Jsoup.connect("http://news.naver.com/main/officeList.nhn").get();
			String newsType = doc.title();
			System.out.println(newsType);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
