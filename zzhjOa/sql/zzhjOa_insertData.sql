INSERT INTO roles(NAME) VALUES("总经理"),('副总'),('部门经理'),('主管'),('员工'),("总经理助理")



INSERT INTO FUNCTION (TEXT,url,parentId,state)VALUES('出勤管理',NULL,NULL,'closed')
,('人事管理',NULL,NULL,'closed')
,('工作任务管理',NULL,NULL,'closed')
,('报销单管理',NULL,NULL,'closed')
,('行政管理',NULL,NULL,'closed')
,('统计报表',NULL,NULL,'closed')
,('公告管理',NULL,NULL,'closed')
,('审批管理',NULL,NULL,'closed')
,('合同管理',NULL,NULL,'closed')
,('工作报告管理',NULL,NULL,'closed')
,('用户权限管理',NULL,NULL,'closed')
,('盖章管理',NULL,NULL,'closed')

ALTER TABLE users CHANGE roleId role_id INT 

INSERT INTO function_roles(roleId,functionId) VALUES(1,1)
,(1,2)
,(1,3)
,(1,4)
,(1,5)
,(1,6)
,(1,7)
,(1,8)
,(1,9)
,(1,10)
,(1,11)
,(1,12)
,(1,13)
,(1,14)
,(1,15)
INSERT INTO FUNCTION (TEXT,url,parentId,state)VALUES('用车信息','istrativeManager\\carInfo.jsp',5,'open')
,('用户管理','userRole\\userManager.jsp',11,'open')
,('角色管理','userRole\\roleManager.jsp',11,'open')




INSERT INTO car(carNo,carName,state) VALUES('黑A888','奔驰s500','可用')
,('京A000','梅赛德斯S450','可用')
,('农A666','声控驴子车','可用')


INSERT INTO security_question(NAME)VALUES('你的生日'),('你的大学老师'),('你的职业'),('你爱人的名字')

INSERT INTO users(NAME,PASSWORD,role_id) VALUES('admin','admin',1)



INSERT INTO function_roles (role_id,function_id) VALUES(1,15)


INSERT INTO car_Info (carId,requestName,driver,departmentName,requestText,startDate,startNumber,overDate,overNumber) VALUES(2,'张三','老司机','测绘','撩妹子','2017-04-08','12876','2017-04-08','12888')

INSERT INTO department(NAME) VALUES("测绘部"),("房产经纪部"),("地理信息部"),("工装设计部"),("人事部"),("行政部"),("财务部")


INSERT INTO rest_type(NAME) VALUES('病假'),('婚嫁'),('丧假'),('年假'),('事假')


INSERT INTO FUNCTION (TEXT,url,parentId,state) VALUES('请假/休假','kaoQin\\rest.jsp',1,'open')
INSERT INTO FUNCTION (TEXT,url,parentId,state) VALUES('打卡异常','kaoQin\\abnormal.jsp',1,'open')
INSERT INTO FUNCTION (TEXT,url,parentId,state) VALUES('写日志','jobLog\\writeLog.jsp',10,'open')
INSERT INTO FUNCTION (TEXT,url,parentId,state) VALUES('工作报告','jobLog\\jobLog.jsp',10,'open')


UPDATE FUNCTION SET url="jobLog\\writeLog.jsp" WHERE id=31

INSERT INTO function_roles (role_id,function_id) VALUE(1,28)
INSERT INTO function_roles (role_id,function_id) VALUE(1,29)

SELECT * FROM FUNCTION

INSERT INTO function_roles(role_id,function_id) VALUES(1,30)
INSERT INTO function_roles(role_id,function_id) VALUES(1,31)

SELECT * FROM jobLog

SELECT * FROM users

SELECT * FROM function_roles

INSERT INTO function_roles(role_id,function_id) VALUES(1,32)

SELECT * FROM FUNCTION

INSERT INTO FUNCTION (TEXT,url,parentId,state) VALUES('资质章管理','seal\\apply.jsp',12,'open')
INSERT INTO FUNCTION (TEXT,url,parentId,state) VALUES('资质章审批','seal\\approve.jsp',8,'open')
INSERT INTO FUNCTION (TEXT,url,parentId,state) VALUES('公章管理','seal\\apply_officialSeal.html',12,'open')

INSERT INTO FUNCTION (TEXT,url,parentId,state) VALUES('公章审批','seal\\approve_officialSeal.jsp',8,'open')

INSERT INTO FUNCTION (TEXT,url,parentId,state) VALUES('公章经办','seal\\handling_officialSeal.jsp',5,'open')

INSERT INTO FUNCTION (TEXT,url,parentId,state) VALUES('资质章经办','seal\\handling.jsp',5,'open')
INSERT INTO FUNCTION (TEXT,url,parentId,state) VALUES('公交一卡通管理','busCard\\busCardRecord.jsp',5,'open')
INSERT INTO FUNCTION (TEXT,url,parentId,state) VALUES('发布公告','notice\\writeNotice.jsp',7,'open')
INSERT INTO FUNCTION (TEXT,url,parentId,state) VALUES('员工通讯录','HRManager\\userInfo.jsp',2,'open')
INSERT INTO FUNCTION (TEXT,url,parentId,state) VALUES('发布任务','task\\addtask.html',3,'open')
INSERT INTO FUNCTION (TEXT,url,parentId,state) VALUES('下达任务','task\\queryOwnTask.html',3,'open')
INSERT INTO FUNCTION (TEXT,url,parentId,state) VALUES('查看所有任务','task\\queryAllTask.html',3,'open')
INSERT INTO FUNCTION (TEXT,url,parentId,state) VALUES('接收任务','task\\OwnTask.html',3,'open')
INSERT INTO FUNCTION (TEXT,url,parentId,state) VALUES('审批反馈信息','task\\feedbackApproval.html',3,'open')
INSERT INTO FUNCTION (TEXT,url,parentId,state) VALUES('申请任务反馈信息','task\\requestFeedback.html',3,'open')
INSERT INTO FUNCTION (TEXT,url,parentId,state) VALUES('公告管理','notice\\noticeManager.jsp',7,'open')
INSERT INTO FUNCTION (TEXT,url,parentId,state) VALUES('工作质量检测','task\\qualityTask.html',3,'open')
INSERT INTO FUNCTION (TEXT,url,parentId,state) VALUES('办公用品申请','manageGoods\\applyItems.html',4,'open')
INSERT INTO FUNCTION (TEXT,url,parentId,state) VALUES('查看申请单','manageGoods\\approvalResultItems.html',4,'open')
INSERT INTO FUNCTION (TEXT,url,parentId,state) VALUES('办公用品审批','manageGoods\\subjectItems.html',4,'open')
INSERT INTO FUNCTION (TEXT,url,parentId,state) VALUES('办公用品管理','manageGoods\\viewAllItems.html',4,'open')
INSERT INTO FUNCTION (TEXT,url,parentId,state) VALUES('请假审批','kaoQin\\ApprovalLeave.html',1,'open')
INSERT INTO FUNCTION (TEXT,url,parentId,state) VALUES('请假管理','kaoQin\\manageLeave.html',1,'open')



SELECT * FROM FUNCTION

INSERT INTO function_roles(role_id,function_id) VALUES(1,35)
INSERT INTO function_roles(role_id,function_id) VALUES(1,36)
INSERT INTO function_roles(role_id,function_id) VALUES(1,37)
INSERT INTO function_roles(role_id,function_id) VALUES(1,39)
INSERT INTO function_roles(role_id,function_id) VALUES(1,40)
INSERT INTO function_roles(role_id,function_id) VALUES(1,41)
INSERT INTO function_roles(role_id,function_id) VALUES(1,42)
INSERT INTO function_roles(role_id,function_id) VALUES(1,43)
INSERT INTO function_roles(role_id,function_id) VALUES(1,44)
INSERT INTO function_roles(role_id,function_id) VALUES(1,45)
INSERT INTO function_roles(role_id,function_id) VALUES(1,46)
INSERT INTO function_roles(role_id,function_id) VALUES(1,47)
INSERT INTO function_roles(role_id,function_id) VALUES(1,48)
INSERT INTO function_roles(role_id,function_id) VALUES(1,49)
INSERT INTO function_roles(role_id,function_id) VALUES(1,50)
INSERT INTO function_roles(role_id,function_id) VALUES(1,51)
INSERT INTO function_roles(role_id,function_id) VALUES(1,52)
INSERT INTO function_roles(role_id,function_id) VALUES(1,53)
INSERT INTO function_roles(role_id,function_id) VALUES(1,54)
INSERT INTO function_roles(role_id,function_id) VALUES(1,55)
INSERT INTO function_roles(role_id,function_id) VALUES(1,56)
INSERT INTO function_roles(role_id,function_id) VALUES(1,57)



SELECT * FROM FUNCTION

INSERT INTO function_roles(role_id,function_Id)VALUES(1,33)

INSERT INTO function_roles(role_id,function_Id)VALUES(1,34)

SELECT * FROM function_roles

SELECT * FROM users

INSERT INTO seal (type_name) VALUES('公章'),('合同章'),('财务章'),('法人章')

SELECT * FROM zi_zhi_seal

SELECT * FROM request_Seal

SELECT * FROM seal

INSERT INTO bus_card(card_number)VALUES('1111'),('222'),('3333')
SELECT * FROM bus_card_record

INSERT INTO bus_card_record(bus_card_id,user_id,START,over,start_date,over_date,start_money,over_money)
 VALUES(1,2,'大兴','昌平','2017-05-21','2017-05-22','100.5','99.8')

SELECT u.NAME FROM users u INNER JOIN department d ON u.departmentId=d.id INNER JOIN roles r ON r.id=u.role_id WHERE d.name='测绘部' AND r.name='主管'

	UPDATE tasks SET task_theme=#{taskTheme},task_text=#{taskText},task_day=#{taskDay} where id=#{id}
SELECT ;

SELECT * FROM users
SELECT * FROM roles

UPDATE feedback SET over_date=DATE_FORMAT(NOW(),'%Y-%m-%d')

		INSERT INTO feedback(request_name,request_date,task_name,info,state)
		VALUES("123","2017-02-12","asdf","asdf","asdf")