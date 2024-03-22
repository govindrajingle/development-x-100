package com.random.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "manual_table")
public class ManualTable {
	
	 	@Id
	    private int sr_no;
	    private String test;
	    
		public int getSr_no() {
			return sr_no;
		}
		public void setSr_no(int sr_no) {
			this.sr_no = sr_no;
		}
		public String getTest() {
			return test;
		}
		public void setTest(String test) {
			this.test = test;
		}

}
