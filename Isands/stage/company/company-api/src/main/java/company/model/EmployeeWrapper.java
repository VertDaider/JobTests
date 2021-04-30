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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Employee}.
 * </p>
 *
 * @author sam
 * @see Employee
 * @generated
 */
public class EmployeeWrapper
	extends BaseModelWrapper<Employee>
	implements Employee, ModelWrapper<Employee> {

	public EmployeeWrapper(Employee employee) {
		super(employee);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("employeesId", getEmployeesId());
		attributes.put("surname", getSurname());
		attributes.put("name", getName());
		attributes.put("patronymic", getPatronymic());
		attributes.put("sex", getSex());
		attributes.put("birthDay", getBirthDay());
		attributes.put("position", getPosition());
		attributes.put("dateOfEmployment", getDateOfEmployment());
		attributes.put("salary", getSalary());
		attributes.put("mobilePhone", getMobilePhone());
		attributes.put("jobPhone", getJobPhone());
		attributes.put("bank", getBank());
		attributes.put("archive", isArchive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long employeesId = (Long)attributes.get("employeesId");

		if (employeesId != null) {
			setEmployeesId(employeesId);
		}

		String surname = (String)attributes.get("surname");

		if (surname != null) {
			setSurname(surname);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String patronymic = (String)attributes.get("patronymic");

		if (patronymic != null) {
			setPatronymic(patronymic);
		}

		String sex = (String)attributes.get("sex");

		if (sex != null) {
			setSex(sex);
		}

		Date birthDay = (Date)attributes.get("birthDay");

		if (birthDay != null) {
			setBirthDay(birthDay);
		}

		Integer position = (Integer)attributes.get("position");

		if (position != null) {
			setPosition(position);
		}

		Date dateOfEmployment = (Date)attributes.get("dateOfEmployment");

		if (dateOfEmployment != null) {
			setDateOfEmployment(dateOfEmployment);
		}

		Integer salary = (Integer)attributes.get("salary");

		if (salary != null) {
			setSalary(salary);
		}

		Integer mobilePhone = (Integer)attributes.get("mobilePhone");

		if (mobilePhone != null) {
			setMobilePhone(mobilePhone);
		}

		Integer jobPhone = (Integer)attributes.get("jobPhone");

		if (jobPhone != null) {
			setJobPhone(jobPhone);
		}

		Integer bank = (Integer)attributes.get("bank");

		if (bank != null) {
			setBank(bank);
		}

		Boolean archive = (Boolean)attributes.get("archive");

		if (archive != null) {
			setArchive(archive);
		}
	}

	/**
	 * Returns the archive of this employee.
	 *
	 * @return the archive of this employee
	 */
	@Override
	public boolean getArchive() {
		return model.getArchive();
	}

	/**
	 * Returns the bank of this employee.
	 *
	 * @return the bank of this employee
	 */
	@Override
	public int getBank() {
		return model.getBank();
	}

	/**
	 * Returns the birth day of this employee.
	 *
	 * @return the birth day of this employee
	 */
	@Override
	public Date getBirthDay() {
		return model.getBirthDay();
	}

	/**
	 * Returns the date of employment of this employee.
	 *
	 * @return the date of employment of this employee
	 */
	@Override
	public Date getDateOfEmployment() {
		return model.getDateOfEmployment();
	}

	/**
	 * Returns the employees ID of this employee.
	 *
	 * @return the employees ID of this employee
	 */
	@Override
	public long getEmployeesId() {
		return model.getEmployeesId();
	}

	/**
	 * Returns the job phone of this employee.
	 *
	 * @return the job phone of this employee
	 */
	@Override
	public int getJobPhone() {
		return model.getJobPhone();
	}

	/**
	 * Returns the mobile phone of this employee.
	 *
	 * @return the mobile phone of this employee
	 */
	@Override
	public int getMobilePhone() {
		return model.getMobilePhone();
	}

	/**
	 * Returns the name of this employee.
	 *
	 * @return the name of this employee
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the patronymic of this employee.
	 *
	 * @return the patronymic of this employee
	 */
	@Override
	public String getPatronymic() {
		return model.getPatronymic();
	}

	/**
	 * Returns the position of this employee.
	 *
	 * @return the position of this employee
	 */
	@Override
	public int getPosition() {
		return model.getPosition();
	}

	/**
	 * Returns the primary key of this employee.
	 *
	 * @return the primary key of this employee
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the salary of this employee.
	 *
	 * @return the salary of this employee
	 */
	@Override
	public int getSalary() {
		return model.getSalary();
	}

	/**
	 * Returns the sex of this employee.
	 *
	 * @return the sex of this employee
	 */
	@Override
	public String getSex() {
		return model.getSex();
	}

	/**
	 * Returns the surname of this employee.
	 *
	 * @return the surname of this employee
	 */
	@Override
	public String getSurname() {
		return model.getSurname();
	}

	/**
	 * Returns the uuid of this employee.
	 *
	 * @return the uuid of this employee
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this employee is archive.
	 *
	 * @return <code>true</code> if this employee is archive; <code>false</code> otherwise
	 */
	@Override
	public boolean isArchive() {
		return model.isArchive();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets whether this employee is archive.
	 *
	 * @param archive the archive of this employee
	 */
	@Override
	public void setArchive(boolean archive) {
		model.setArchive(archive);
	}

	/**
	 * Sets the bank of this employee.
	 *
	 * @param bank the bank of this employee
	 */
	@Override
	public void setBank(int bank) {
		model.setBank(bank);
	}

	/**
	 * Sets the birth day of this employee.
	 *
	 * @param birthDay the birth day of this employee
	 */
	@Override
	public void setBirthDay(Date birthDay) {
		model.setBirthDay(birthDay);
	}

	/**
	 * Sets the date of employment of this employee.
	 *
	 * @param dateOfEmployment the date of employment of this employee
	 */
	@Override
	public void setDateOfEmployment(Date dateOfEmployment) {
		model.setDateOfEmployment(dateOfEmployment);
	}

	/**
	 * Sets the employees ID of this employee.
	 *
	 * @param employeesId the employees ID of this employee
	 */
	@Override
	public void setEmployeesId(long employeesId) {
		model.setEmployeesId(employeesId);
	}

	/**
	 * Sets the job phone of this employee.
	 *
	 * @param jobPhone the job phone of this employee
	 */
	@Override
	public void setJobPhone(int jobPhone) {
		model.setJobPhone(jobPhone);
	}

	/**
	 * Sets the mobile phone of this employee.
	 *
	 * @param mobilePhone the mobile phone of this employee
	 */
	@Override
	public void setMobilePhone(int mobilePhone) {
		model.setMobilePhone(mobilePhone);
	}

	/**
	 * Sets the name of this employee.
	 *
	 * @param name the name of this employee
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the patronymic of this employee.
	 *
	 * @param patronymic the patronymic of this employee
	 */
	@Override
	public void setPatronymic(String patronymic) {
		model.setPatronymic(patronymic);
	}

	/**
	 * Sets the position of this employee.
	 *
	 * @param position the position of this employee
	 */
	@Override
	public void setPosition(int position) {
		model.setPosition(position);
	}

	/**
	 * Sets the primary key of this employee.
	 *
	 * @param primaryKey the primary key of this employee
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the salary of this employee.
	 *
	 * @param salary the salary of this employee
	 */
	@Override
	public void setSalary(int salary) {
		model.setSalary(salary);
	}

	/**
	 * Sets the sex of this employee.
	 *
	 * @param sex the sex of this employee
	 */
	@Override
	public void setSex(String sex) {
		model.setSex(sex);
	}

	/**
	 * Sets the surname of this employee.
	 *
	 * @param surname the surname of this employee
	 */
	@Override
	public void setSurname(String surname) {
		model.setSurname(surname);
	}

	/**
	 * Sets the uuid of this employee.
	 *
	 * @param uuid the uuid of this employee
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected EmployeeWrapper wrap(Employee employee) {
		return new EmployeeWrapper(employee);
	}

}