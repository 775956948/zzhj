package test;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Executors;

import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zzhj.po.Task;
import com.zzhj.service.RequestGoodsService;
import com.zzhj.service.TaskService;

public class Test {
	
	private static TaskService ts = new TaskService();
	
/*	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ApplicationContext ap =new ClassPathXmlApplicationContext(new String[]{"application_context.xml"});
		 TaskService t = (TaskService) ap.getBean("taskService");
		 Map<String,Object> map = t.departmentQueryAll(10, 1,0);
		 List<Task> list =(List<Task>) map.get("rows");
		 for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getTaskTheme());
		}

	}*/

}
