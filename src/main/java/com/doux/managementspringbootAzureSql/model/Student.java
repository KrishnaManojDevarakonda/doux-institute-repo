package com.doux.managementspringbootAzureSql.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="Students")
public class Student {

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private Long studentId;
		
		@JsonProperty("name")
		@Column
		private String studentName;
		
		@JsonProperty("contactNumber")
		@Column
		private Long contactNumber;
		
		@JsonProperty("mailId")
		@Column
		private String mailId;
		
		@JsonProperty("location")
		@Column
		private String location;
		public Long getStudentId() {
			return studentId;
		}
		public void setStudentId(Long studentId) {
			this.studentId = studentId;
		}
		public String getStudentName() {
			return studentName;
		}
		public void setStudentName(String studentName) {
			this.studentName = studentName;
		}
		public Long getContactNumber() {
			return contactNumber;
		}
		public void setContactNumber(Long contactNumber) {
			this.contactNumber = contactNumber;
		}
		public String getMailId() {
			return mailId;
		}
		public void setMailId(String mailId) {
			this.mailId = mailId;
		}
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		
		
}
