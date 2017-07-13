package test;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;

import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zzhj.service.RequestGoodsService;
import com.zzhj.service.TaskService;

public class Test {
	
	private static TaskService ts = new TaskService();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ApplicationContext ap =new ClassPathXmlApplicationContext(new String[]{"application_context.xml"});
		 RequestGoodsService a =(RequestGoodsService) ap.getBean("requestGoodsService");
/*		 	a.approver(11111, "dd", 11111);*/
			System.out.println("+++++++++++++"+AopUtils.isAopProxy(a));
			System.out.println("+++++++++++++"+AopUtils.isCglibProxy(a));
			System.out.println("+++++++++++++"+AopUtils.isJdkDynamicProxy(a));

	}

}
