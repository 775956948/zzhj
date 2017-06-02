package test;

import java.util.List;
import java.util.Map;

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
import com.zzhj.po.Users;
import com.zzhj.po.ZiZhiSeal;
import com.zzhj.service.NoticeService;
import com.zzhj.service.RequestSealService;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ApplicationContext ap =new ClassPathXmlApplicationContext(new String[]{"application_context.xml","application_dao.xml","application_mvc.xml"});
		 NoticeService ns=	(NoticeService) ap.getBean("noticeService");
		 List<Notice> list = ns.queryAll();
		 for(Notice notice : list){
			 System.out.println(notice.getId()+notice.getReleaseDate()+notice.getText()+notice.getTheme()+notice.getUserId().getName());
		 }
	

	}

}
