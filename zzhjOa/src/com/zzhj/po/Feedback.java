package com.zzhj.po;

import java.io.Serializable;
/**
 * ��Ϣ������Ϣpo��
 * @author asus
 *
 */
public class Feedback implements Serializable{

	private int id;
	//���������
	private String taskName;
	//��������Ϣ
	private String info;
	//������
	private Users approver;
	//״̬
	private String state;
}
