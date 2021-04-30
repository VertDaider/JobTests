/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package company.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link company.service.http.EmployeeServiceSoap}.
 *
 * @author sam
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class EmployeeSoap implements Serializable {

	public static EmployeeSoap toSoapModel(Employee model) {
		EmployeeSoap soapModel = new EmployeeSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setEmployeesId(model.getEmployeesId());
		soapModel.setSurname(model.getSurname());
		soapModel.setName(model.getName());
		soapModel.setPatronymic(model.getPatronymic());
		soapModel.setSex(model.getSex());
		soapModel.setBirthDay(model.getBirthDay());
		soapModel.setPosition(model.getPosition());
		soapModel.setDateOfEmployment(model.getDateOfEmployment());
		soapModel.setSalary(model.getSalary());
		soapModel.setMobilePhone(model.getMobilePhone());
		soapModel.setJobPhone(model.getJobPhone());
		soapModel.setBank(model.getBank());
		soapModel.setArchive(model.isArchive());

		return soapModel;
	}

	public static EmployeeSoap[] toSoapModels(Employee[] models) {
		EmployeeSoap[] soapModels = new EmployeeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmployeeSoap[][] toSoapModels(Employee[][] models) {
		EmployeeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EmployeeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmployeeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmployeeSoap[] toSoapModels(List<Employee> models) {
		List<EmployeeSoap> soapModels = new ArrayList<EmployeeSoap>(
			models.size());

		for (Employee model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EmployeeSoap[soapModels.size()]);
	}

	public EmployeeSoap() {
	}

	public long getPrimaryKey() {
		return _employeesId;
	}

	public void setPrimaryKey(long pk) {
		setEmployeesId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getEmployeesId() {
		return _employeesId;
	}

	public void setEmployeesId(long employeesId) {
		_employeesId = employeesId;
	}

	public String getSurname() {
		return _surname;
	}

	public void setSurname(String surname) {
		_surname = surname;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getPatronymic() {
		return _patronymic;
	}

	public void setPatronymic(String patronymic) {
		_patronymic = patronymic;
	}

	public String getSex() {
		return _sex;
	}

	public void setSex(String sex) {
		_sex = sex;
	}

	public Date getBirthDay() {
		return _birthDay;
	}

	public void setBirthDay(Date birthDay) {
		_birthDay = birthDay;
	}

	public int getPosition() {
		return _position;
	}

	public void setPosition(int position) {
		_position = position;
	}

	public Date getDateOfEmployment() {
		return _dateOfEmployment;
	}

	public void setDateOfEmployment(Date dateOfEmployment) {
		_dateOfEmployment = dateOfEmployment;
	}

	public int getSalary() {
		return _salary;
	}

	public void setSalary(int salary) {
		_salary = salary;
	}

	public int getMobilePhone() {
		return _mobilePhone;
	}

	public void setMobilePhone(int mobilePhone) {
		_mobilePhone = mobilePhone;
	}

	public int getJobPhone() {
		return _jobPhone;
	}

	public void setJobPhone(int jobPhone) {
		_jobPhone = jobPhone;
	}

	public int getBank() {
		return _bank;
	}

	public void setBank(int bank) {
		_bank = bank;
	}

	public boolean getArchive() {
		return _archive;
	}

	public boolean isArchive() {
		return _archive;
	}

	public void setArchive(boolean archive) {
		_archive = archive;
	}

	private String _uuid;
	private long _employeesId;
	private String _surname;
	private String _name;
	private String _patronymic;
	private String _sex;
	private Date _birthDay;
	private int _position;
	private Date _dateOfEmployment;
	private int _salary;
	private int _mobilePhone;
	private int _jobPhone;
	private int _bank;
	private boolean _archive;

}