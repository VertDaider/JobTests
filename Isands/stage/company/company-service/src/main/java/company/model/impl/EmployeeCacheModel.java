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

package company.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import company.model.Employee;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Employee in entity cache.
 *
 * @author sam
 * @generated
 */
public class EmployeeCacheModel
	implements CacheModel<Employee>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmployeeCacheModel)) {
			return false;
		}

		EmployeeCacheModel employeeCacheModel = (EmployeeCacheModel)object;

		if (employeesId == employeeCacheModel.employeesId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, employeesId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", employeesId=");
		sb.append(employeesId);
		sb.append(", surname=");
		sb.append(surname);
		sb.append(", name=");
		sb.append(name);
		sb.append(", patronymic=");
		sb.append(patronymic);
		sb.append(", sex=");
		sb.append(sex);
		sb.append(", birthDay=");
		sb.append(birthDay);
		sb.append(", position=");
		sb.append(position);
		sb.append(", dateOfEmployment=");
		sb.append(dateOfEmployment);
		sb.append(", salary=");
		sb.append(salary);
		sb.append(", mobilePhone=");
		sb.append(mobilePhone);
		sb.append(", jobPhone=");
		sb.append(jobPhone);
		sb.append(", bank=");
		sb.append(bank);
		sb.append(", archive=");
		sb.append(archive);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Employee toEntityModel() {
		EmployeeImpl employeeImpl = new EmployeeImpl();

		if (uuid == null) {
			employeeImpl.setUuid("");
		}
		else {
			employeeImpl.setUuid(uuid);
		}

		employeeImpl.setEmployeesId(employeesId);

		if (surname == null) {
			employeeImpl.setSurname("");
		}
		else {
			employeeImpl.setSurname(surname);
		}

		if (name == null) {
			employeeImpl.setName("");
		}
		else {
			employeeImpl.setName(name);
		}

		if (patronymic == null) {
			employeeImpl.setPatronymic("");
		}
		else {
			employeeImpl.setPatronymic(patronymic);
		}

		if (sex == null) {
			employeeImpl.setSex("");
		}
		else {
			employeeImpl.setSex(sex);
		}

		if (birthDay == Long.MIN_VALUE) {
			employeeImpl.setBirthDay(null);
		}
		else {
			employeeImpl.setBirthDay(new Date(birthDay));
		}

		employeeImpl.setPosition(position);

		if (dateOfEmployment == Long.MIN_VALUE) {
			employeeImpl.setDateOfEmployment(null);
		}
		else {
			employeeImpl.setDateOfEmployment(new Date(dateOfEmployment));
		}

		employeeImpl.setSalary(salary);
		employeeImpl.setMobilePhone(mobilePhone);
		employeeImpl.setJobPhone(jobPhone);
		employeeImpl.setBank(bank);
		employeeImpl.setArchive(archive);

		employeeImpl.resetOriginalValues();

		return employeeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		employeesId = objectInput.readLong();
		surname = objectInput.readUTF();
		name = objectInput.readUTF();
		patronymic = objectInput.readUTF();
		sex = objectInput.readUTF();
		birthDay = objectInput.readLong();

		position = objectInput.readInt();
		dateOfEmployment = objectInput.readLong();

		salary = objectInput.readInt();

		mobilePhone = objectInput.readInt();

		jobPhone = objectInput.readInt();

		bank = objectInput.readInt();

		archive = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(employeesId);

		if (surname == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(surname);
		}

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (patronymic == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(patronymic);
		}

		if (sex == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(sex);
		}

		objectOutput.writeLong(birthDay);

		objectOutput.writeInt(position);
		objectOutput.writeLong(dateOfEmployment);

		objectOutput.writeInt(salary);

		objectOutput.writeInt(mobilePhone);

		objectOutput.writeInt(jobPhone);

		objectOutput.writeInt(bank);

		objectOutput.writeBoolean(archive);
	}

	public String uuid;
	public long employeesId;
	public String surname;
	public String name;
	public String patronymic;
	public String sex;
	public long birthDay;
	public int position;
	public long dateOfEmployment;
	public int salary;
	public int mobilePhone;
	public int jobPhone;
	public int bank;
	public boolean archive;

}