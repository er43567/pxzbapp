package cn.zbgl.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ZB_tb")
public class Zhuangbei implements java.io.Serializable  {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int zbId;
	
}
