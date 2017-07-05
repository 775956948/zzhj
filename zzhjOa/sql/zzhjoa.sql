/*创建角色表*/
CREATE TABLE roles(
id INT PRIMARY KEY AUTO_INCREMENT,
NAME NVARCHAR(30) 	/*角色名*/
)

/*创建功能表*/
CREATE TABLE FUNCTION(
id INT PRIMARY KEY AUTO_INCREMENT,
TEXT NVARCHAR(50),			/*节点名称*/
url VARCHAR(200),			/*路径*/
parentId INT ,				/*父节点*/
state VARCHAR(10)      			/*节点状态*/
)

/*角色跟权限表*/
CREATE TABLE function_roles(
id INT PRIMARY KEY AUTO_INCREMENT,	
roleId INT ,	/*角色*/
functionId INT ,	/*功能*/
FOREIGN KEY(functionId) REFERENCES FUNCTION(id),
FOREIGN KEY(roleId) REFERENCES roles(id)		
)
DROP TABLE department
/*部门信息表*/
CREATE TABLE department(
id INT PRIMARY KEY AUTO_INCREMENT,
NAME NVARCHAR(20),			/*部门名称*/
)


/*员工信息表*/
CREATE TABLE users(
id INT PRIMARY KEY AUTO_INCREMENT,
NAME NVARCHAR(20),			/*姓名*/
PASSWORD VARCHAR(30),			/*密码*/
sex NVARCHAR(2),			/*性别*/
birthday DATE,				/*出身年月*/
positiveDate DATE,			/*转正日期*/		   
role_id INT ,				/*所属角色*/
departmentId INT,			/*所属部门*/		
phone INT(15),				/*手机*/
idCard 	INT,				/*身份证*/
NATIONAL VARCHAR(30),			/*名族*/
height FLOAT,				/*身高*/
marital NVARCHAR(5),			/*婚否*/
face NVARCHAR(10),			/*政治面貌*/
address NVARCHAR(50),			/*户口地址*/
graduated_school NVARCHAR(20),		/*毕业学校*/
education NVARCHAR(5),			/*文化程度*/
professional NVARCHAR(20),		/*专业*/
parent_id INT,				/*父id*/
state NVARCHAR(10),			/*用户层级状态（工作日志）*/
induction_date DATA,
image_name NVARCHAR(150),
security_question_id INT,
security_answer NVARCHAR(100),
FOREIGN KEY(departmentId) REFERENCES department(id),
FOREIGN KEY(role_id) REFERENCES roles(id)
)	

/*请假/休假信息表*/
CREATE TABLE rest(
id INT PRIMARY KEY AUTO_INCREMENT,
user_id INT,		        /*申请人*/
rest_text NVARCHAR(250),	/*请假原由*/
rest_date INT ,			/*请假时间*/
DATE DATE,			/*申请时间*/
approver NVARCHAR(20),		/*审批人*/
advice NVARCHAR(200),		/*意见*/
state NVARCHAR(20),		/*任务状态*/
rest_type_id INT,		/*请假类型*/
FOREIGN KEY(user_id) REFERENCES users(id),
FOREIGN KEY(rest_type_id)REFERENCES rest_type(id)
)

/*请假/休假信类型*/
CREATE TABLE rest_type(
id INT PRIMARY KEY AUTO_INCREMENT,
NAME NVARCHAR(20)
)

/*加班信息表*/
CREATE TABLE overtime(
id INT PRIMARY KEY AUTO_INCREMENT,
requestName NVARCHAR(20),	/*申请人*/
overtimeText VARCHAR(250),	/*加班原由*/
overtimeMoney FLOAT,		/*加班金额*/
DATE DATE,			/*申请时间*/
approver NVARCHAR(20),		/*审批人*/
state NVARCHAR(20)		/*任务状态*/
)


/*打卡异常表*/
CREATE TABLE abnormal(
id INT PRIMARY KEY AUTO_INCREMENT,
user_id INT,			/*申请人*/
abnormal_type NVARCHAR(20),	/*异常类型*/
abnormal_date DATETIME,		/*异常时间*/
abnormalText NVARCHAR(250),	/*异常原由*/
DATE DATETIME,			/*申请时间*/
approver NVARCHAR(20),		/*审批人*/
state NVARCHAR(20)		/*任务状态*/
)
/*离职信息表*/
CREATE TABLE departure(
id INT PRIMARY KEY AUTO_INCREMENT,
requestName NVARCHAR(20),	/*申请人*/
DATE DATE,			/*申请时间*/
departureDate DATE,		/*离职时间*/
departureText NVARCHAR(250),	/*离职原由*/
approver NVARCHAR(20),		/*审批人*/
state NVARCHAR(20)		/*审批状态*/
)	

SELECT * FROM tasks
/*任务信息表*/
CREATE TABLE  tasks(
id INT PRIMARY KEY AUTO_INCREMENT,
user_name NVARCHAR(50),		/*发布人*/
task_theme NVARCHAR(50),	/*任务主题*/
task_text TEXT,			/*任务的详情*/
task_address NVARCHAR(80),	/*项目的地址*/
entrusted_unit NVARCHAR(80),	/*委托单位*/
CLIENT	NVARCHAR(50),		/*委托人*/
client_phone VARCHAR(50),	/*委托人电话*/
task_date DATE, 		/*任务发布日期*/ 
recipient NVARCHAR(50),		/*接收人*/
implement NVARCHAR(50),		/*执行人*/
implement_date DATE,		/*任务开始时间*/
Speed INT,			/*任务的进度*/
task_phase NVARCHAR(50),	/*任务阶段*/
inspection NVARCHAR(20),	/*质量检测*/
inspection_user NVARCHAR(50),	/*质检人*/
success_date DATE,		/*任务结束时间*/
over_date DATE,			/*指定结束时间*/			
state NVARCHAR(10)		/*任务的状态*/
)



/*任务信息反馈表*/
CREATE TABLE feedback(
id INT PRIMARY KEY AUTO_INCREMENT,
request_name NVARCHAR(10),	/*申请人*/
request_date DATE,		/*申请时间*/
task_id INT,			/*任务主题*/
info NVARCHAR(250),		/*任务信息*/
refuse_info NVARCHAR(250),	/*打回信息*/
approver NVARCHAR(10),		/*审批人*/
over_date DATE,			/*完成时间*/
state NVARCHAR(5),		/*状态*/
FOREIGN KEY(task_id) REFERENCES tasks(id)
)

/*工作日志*/
CREATE TABLE jobLog(
id INT PRIMARY KEY AUTO_INCREMENT,
user_id INT,
theme NVARCHAR(60),
TEXT TEXT,
DATE DATE,
FOREIGN KEY(user_id) REFERENCES users(id)
)




/*报销单信息表*/
CREATE TABLE expense(
id INT PRIMARY KEY AUTO_INCREMENT,
requestName NVARCHAR(20), /*申请人*/
expenseText NVARCHAR(250),/*报销原由*/
money FLOAT,		/*金额*/
DATE DATE,		/*申请日期*/
approver NVARCHAR(20),	/*审批人*/
state NVARCHAR(20)	/*审批状态*/
)

/*公章信息表*/
CREATE TABLE seal(
id INT PRIMARY KEY AUTO_INCREMENT,
type_name NVARCHAR(20)/*章名称*/
)

/*公章申请表*/
CREATE TABLE request_Seal(
id INT PRIMARY KEY AUTO_INCREMENT,
number INT,		/*编号*/
user_id INT,		/*申请人*/
project_name NVARCHAR(225),/*项目名称*/
seal_id INT ,		/*章类型*/
pageNumber INT,		/*页数*/
copiesNumber INT,	/*份数*/
TEXT NVARCHAR(225),	/*收文主题*/
approver NVARCHAR(20),	/*审批人*/
request_date DATE,	/*申请日期*/
agent NVARCHAR(20),	/*经办人*/
over_date DATE,		/*盖章日期*/
state NVARCHAR(20),	/*审批状态*/
why NVARCHAR(10),       /*是否骑缝*/
FOREIGN KEY(seal_id) REFERENCES seal(id),
FOREIGN KEY(user_id) REFERENCES users(id)
)

/*办公用品申请表*/
CREATE TABLE Office_Supplies(
id INT PRIMARY KEY AUTO_INCREMENT,
requestName NVARCHAR(20),/*申请人*/
departmentId INT ,/*所属部门*/
NAME NVARCHAR(20), 	/*物品名称*/
money FLOAT,		/*金额*/
approver NVARCHAR(20),	/*审批人*/
state NVARCHAR(20),	/*审批状态*/
DATE DATE ,		/*申请日期*/
FOREIGN KEY(departmentId) REFERENCES department(id)
)
/*公告信息表*/
CREATE TABLE notice(
id INT PRIMARY KEY AUTO_INCREMENT, 
theme NVARCHAR(60),			/*主题*/
TEXT TEXT ,         			/*内容*/
user_id INT,	 			/*用户外键*/	
release_date DATE,	  		/*发布时间*/
FOREIGN KEY(user_id) REFERENCES users(id)
)
 /*汽车信息表*/
CREATE TABLE car(
id INT PRIMARY KEY AUTO_INCREMENT,
carNo VARCHAR(20),
carName NVARCHAR(20),
state NVARCHAR(10)
) 


/*用车记录信息表*/
CREATE TABLE car_Info(
id INT PRIMARY KEY AUTO_INCREMENT,
carId INT ,
requestName NVARCHAR(20), /*申请人*/
driver NVARCHAR(20),	 /*司机*/
departmentName NVARCHAR(20), /*所属于部门*/
requestText TEXT, /*用途*/
startDate DATETIME, /*出车时间*/
startNumber FLOAT, /*出车里程数*/
overDate DATETIME, /*收车时间*/
overNumber FLOAT , /*收车里程数*/
FOREIGN KEY(carId) REFERENCES car(id)
)
/*合同管理表*/
CREATE TABLE contract(
id INT PRIMARY KEY AUTO_INCREMENT,
TYPE NVARCHAR(60),/*合同类型*/
NAME NVARCHAR(60), /*合同名*/
partyA NVARCHAR(20), /*甲方*/
partyB NVARCHAR(20) /*乙方*/
) 


/*资质章*/
CREATE TABLE zi_zhi_Seal(
id INT PRIMARY KEY AUTO_INCREMENT,
number INT,		/*编号*/
projectName NVARCHAR(225),/*项目名称*/
pageNumber INT,		/*页数*/
copiesNumber INT,	/*份数*/
TEXT NVARCHAR(225),	/*盖章内容*/
why NVARCHAR(225),	/*盖章事由*/
user_id INT,		/*申请人*/
requestDate DATE,	/*申请日期*/
approver NVARCHAR(20),	/*审批人*/
agent NVARCHAR(20),	/*经办人*/
overDate DATE ,		/*结束日期*/
state NVARCHAR(10),	/*状态*/
FOREIGN KEY(user_id) REFERENCES users(id)
)
/*公交卡*/
CREATE TABLE bus_card(
id INT  PRIMARY KEY AUTO_INCREMENT,
card_number NVARCHAR(60),
state NVARCHAR(5)
)

/*公交卡记录表*/
CREATE TABLE bus_card_record(
id INT PRIMARY KEY AUTO_INCREMENT,
bus_card_id INT,
user_id INT,
START NVARCHAR(30),
over  NVARCHAR(30),
start_date NVARCHAR(30),
over_date NVARCHAR(30),
start_money FLOAT,
over_money FLOAT,
FOREIGN KEY(bus_card_id) REFERENCES bus_card(id),
FOREIGN KEY(user_id) REFERENCES users(id)
)
/*密保问题表*/
CREATE TABLE security_question(
id INT PRIMARY KEY AUTO_INCREMENT,
NAME NVARCHAR(50)
)


