package test;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zzhj.controller.BusCardAction;
import com.zzhj.controller.BusCardRecordAction;
import com.zzhj.controller.RequestSealAction;
import com.zzhj.controller.RestAction;
import com.zzhj.controller.UsersAction;
import com.zzhj.controller.ZiZhiSealAction;
import com.zzhj.po.BusCard;
import com.zzhj.po.BusCardRecord;
import com.zzhj.po.Department;
import com.zzhj.po.Notice;
import com.zzhj.po.RequestSeal;
import com.zzhj.po.Task;
import com.zzhj.po.Users;
import com.zzhj.po.ZiZhiSeal;
import com.zzhj.service.NoticeService;
import com.zzhj.service.RequestSealService;
import com.zzhj.service.SecurityQuestionService;
import com.zzhj.service.TaskService;

public class Test {
	
	private static TaskService ts = new TaskService();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 /*ApplicationContext ap =new ClassPathXmlApplicationContext(new String[]{"application_context.xml","application_dao.xml","application_mvc.xml"});
		 NoticeService s = (NoticeService) ap.getBean("noticeService");
		 System.out.println(s.queryAllList(1, 10));*/
		 int[] a ={1,3,5,7,8};
		 int max=a[4];
		 int min=a[3];
		 int sum=0;
		 for (int i = 0; i < a.length; i++) {
			if(max<a[i])
				max=a[i];
			
			if(min>a[i])
				min=a[i];
			
			sum=sum+a[i];
		}
		 
		 System.out.println(max+"----"+min+"-----"+sum);
		
		

	}

}
