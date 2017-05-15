package test;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zzhj.controller.RequestSealAction;
import com.zzhj.controller.RestAction;
import com.zzhj.controller.UsersAction;
import com.zzhj.controller.ZiZhiSealAction;
import com.zzhj.po.Department;
import com.zzhj.po.RequestSeal;
import com.zzhj.po.Users;
import com.zzhj.po.ZiZhiSeal;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  ApplicationContext ap =new ClassPathXmlApplicationContext("application_*.xml");
		 RequestSealAction r = (RequestSealAction) ap.getBean("requestSealAction");
		 Map map =r.queryAll(1, 10);
		 List<RequestSeal> list =(List) map.get("rows");
		 System.out.println(list.get(0).getProjectName());
	

	}

}
