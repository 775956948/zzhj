package test;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zzhj.controller.RestAction;
import com.zzhj.controller.UsersAction;
import com.zzhj.controller.ZiZhiSealAction;
import com.zzhj.po.Department;
import com.zzhj.po.Users;
import com.zzhj.po.ZiZhiSeal;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  ApplicationContext ap =new ClassPathXmlApplicationContext("application_*.xml");
		 ZiZhiSealAction z = (ZiZhiSealAction) ap.getBean("ziZhiSealAction");
		 Map map=z.queryAll(1, 10);
		 List<ZiZhiSeal> list = (List<ZiZhiSeal>) map.get("rows");
		 System.out.println(list.get(1).getApprover());
/*		 ZiZhiSeal a = new ZiZhiSeal();
		 a.setNumber(121);
		 a.setProjectName("��������");
		 a.setCopiesNumber(100);
		 a.setPageNumber(100);
		 a.setRequestDate("2017-05-10");
		 a.setText("����̫�಻��չʾ");
		 Users user = new Users();
		 user.setName("����");
		 Department d = new Department();
		 d.setName("��沿");
		 user.setDepartmentId(d);
		 user.setId(14);
		 a.setUserId(user);
		 int number =z.save(a);
		 System.out.println(number);*/
	}

}
