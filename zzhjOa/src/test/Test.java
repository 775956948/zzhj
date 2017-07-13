package test;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zzhj.service.Actions;
import com.zzhj.service.TaskService;

public class Test {
	
	private static TaskService ts = new TaskService();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ApplicationContext ap =new ClassPathXmlApplicationContext(new String[]{"application_context.xml"});
		 Actions a =(Actions) ap.getBean("actionImpl");
		 a.action();
		
		

	}

}
