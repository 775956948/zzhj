package test;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zzhj.controller.RestAction;
import com.zzhj.controller.UsersAction;
import com.zzhj.controller.ZiZhiSealAction;
import com.zzhj.po.ZiZhiSeal;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  ApplicationContext ap =new ClassPathXmlApplicationContext("application_*.xml");
		 ZiZhiSealAction z = (ZiZhiSealAction) ap.getBean("ziZhiSealAction");
		 Map map =z.queryAll(1, 10);
		 List<ZiZhiSeal> list =(List) map.get("rows");
		 for (ZiZhiSeal ziZhiSeal : list) {
			System.out.println(ziZhiSeal.getNumber());
		}
	}

}
