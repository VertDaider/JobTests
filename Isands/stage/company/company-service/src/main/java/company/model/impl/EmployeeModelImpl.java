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

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ProxyUtil;

import company.model.Employee;
import company.model.EmployeeModel;
import company.model.EmployeeSoap;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the Employee service. Represents a row in the &quot;Company_Employee&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>EmployeeModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link EmployeeImpl}.
 * </p>
 *
 * @author sam
 * @see EmployeeImpl
 * @generated
 */
@JSON(strict = true)
public class EmployeeModelImpl
	extends BaseModelImpl<Employee> implements EmployeeModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a employee model instance should use the <code>Employee</code> interface instead.
	 */
	public static final String TABLE_NAME = "Company_Employee";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"employeesId", Types.BIGINT},
		{"surname", Types.VARCHAR}, {"name", Types.VARCHAR},
		{"patronymic", Types.VARCHAR}, {"sex", Types.VARCHAR},
		{"birthDay", Types.TIMESTAMP}, {"position", Types.INTEGER},
		{"dateOfEmployment", Types.TIMESTAMP}, {"salary", Types.INTEGER},
		{"mobilePhone", Types.INTEGER}, {"jobPhone", Types.INTEGER},
		{"bank", Types.INTEGER}, {"archive", Types.BOOLEAN}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("employeesId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("surname", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("patronymic", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("sex", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("birthDay", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("position", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("dateOfEmployment", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("salary", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("mobilePhone", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("jobPhone", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("bank", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("archive", Types.BOOLEAN);
	}

	public static final String TABLE_SQL_CREATE =
		"create table Company_Employee (uuid_ VARCHAR(75) null,employeesId LONG not null primary key,surname VARCHAR(75) null,name VARCHAR(75) null,patronymic VARCHAR(75) null,sex VARCHAR(75) null,birthDay DATE null,position INTEGER,dateOfEmployment DATE null,salary INTEGER,mobilePhone INTEGER,jobPhone INTEGER,bank INTEGER,archive BOOLEAN)";

	public static final String TABLE_SQL_DROP = "drop table Company_Employee";

	public static final String ORDER_BY_JPQL = " ORDER BY employee.surname ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY Company_Employee.surname ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)
	 */
	@Deprecated
	public static final long SURNAME_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static Employee toModel(EmployeeSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Employee model = new EmployeeImpl();

		model.setUuid(soapModel.getUuid());
		model.setEmployeesId(soapModel.getEmployeesId());
		model.setSurname(soapModel.getSurname());
		model.setName(soapModel.getName());
		model.setPatronymic(soapModel.getPatronymic());
		model.setSex(soapModel.getSex());
		model.setBirthDay(soapModel.getBirthDay());
		model.setPosition(soapModel.getPosition());
		model.setDateOfEmployment(soapModel.getDateOfEmployment());
		model.setSalary(soapModel.getSalary());
		model.setMobilePhone(soapModel.getMobilePhone());
		model.setJobPhone(soapModel.getJobPhone());
		model.setBank(soapModel.getBank());
		model.setArchive(soapModel.isArchive());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static List<Employee> toModels(EmployeeSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Employee> models = new ArrayList<Employee>(soapModels.length);

		for (EmployeeSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public EmployeeModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _employeesId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEmployeesId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _employeesId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Employee.class;
	}

	@Override
	public String getModelClassName() {
		return Employee.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Employee, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Employee, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Employee, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Employee)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Employee, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Employee, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Employee)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Employee, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Employee, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, Employee>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			Employee.class.getClassLoader(), Employee.class,
			ModelWrapper.class);

		try {
			Constructor<Employee> constructor =
				(Constructor<Employee>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<Employee, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Employee, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Employee, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Employee, Object>>();
		Map<String, BiConsumer<Employee, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Employee, ?>>();

		attributeGetterFunctions.put("uuid", Employee::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<Employee, String>)Employee::setUuid);
		attributeGetterFunctions.put("employeesId", Employee::getEmployeesId);
		attributeSetterBiConsumers.put(
			"employeesId",
			(BiConsumer<Employee, Long>)Employee::setEmployeesId);
		attributeGetterFunctions.put("surname", Employee::getSurname);
		attributeSetterBiConsumers.put(
			"surname", (BiConsumer<Employee, String>)Employee::setSurname);
		attributeGetterFunctions.put("name", Employee::getName);
		attributeSetterBiConsumers.put(
			"name", (BiConsumer<Employee, String>)Employee::setName);
		attributeGetterFunctions.put("patronymic", Employee::getPatronymic);
		attributeSetterBiConsumers.put(
			"patronymic",
			(BiConsumer<Employee, String>)Employee::setPatronymic);
		attributeGetterFunctions.put("sex", Employee::getSex);
		attributeSetterBiConsumers.put(
			"sex", (BiConsumer<Employee, String>)Employee::setSex);
		attributeGetterFunctions.put("birthDay", Employee::getBirthDay);
		attributeSetterBiConsumers.put(
			"birthDay", (BiConsumer<Employee, Date>)Employee::setBirthDay);
		attributeGetterFunctions.put("position", Employee::getPosition);
		attributeSetterBiConsumers.put(
			"position", (BiConsumer<Employee, Integer>)Employee::setPosition);
		attributeGetterFunctions.put(
			"dateOfEmployment", Employee::getDateOfEmployment);
		attributeSetterBiConsumers.put(
			"dateOfEmployment",
			(BiConsumer<Employee, Date>)Employee::setDateOfEmployment);
		attributeGetterFunctions.put("salary", Employee::getSalary);
		attributeSetterBiConsumers.put(
			"salary", (BiConsumer<Employee, Integer>)Employee::setSalary);
		attributeGetterFunctions.put("mobilePhone", Employee::getMobilePhone);
		attributeSetterBiConsumers.put(
			"mobilePhone",
			(BiConsumer<Employee, Integer>)Employee::setMobilePhone);
		attributeGetterFunctions.put("jobPhone", Employee::getJobPhone);
		attributeSetterBiConsumers.put(
			"jobPhone", (BiConsumer<Employee, Integer>)Employee::setJobPhone);
		attributeGetterFunctions.put("bank", Employee::getBank);
		attributeSetterBiConsumers.put(
			"bank", (BiConsumer<Employee, Integer>)Employee::setBank);
		attributeGetterFunctions.put("archive", Employee::getArchive);
		attributeSetterBiConsumers.put(
			"archive", (BiConsumer<Employee, Boolean>)Employee::setArchive);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_uuid = uuid;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalUuid() {
		return getColumnOriginalValue("uuid_");
	}

	@JSON
	@Override
	public long getEmployeesId() {
		return _employeesId;
	}

	@Override
	public void setEmployeesId(long employeesId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_employeesId = employeesId;
	}

	@JSON
	@Override
	public String getSurname() {
		if (_surname == null) {
			return "";
		}
		else {
			return _surname;
		}
	}

	@Override
	public void setSurname(String surname) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_surname = surname;
	}

	@JSON
	@Override
	public String getName() {
		if (_name == null) {
			return "";
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_name = name;
	}

	@JSON
	@Override
	public String getPatronymic() {
		if (_patronymic == null) {
			return "";
		}
		else {
			return _patronymic;
		}
	}

	@Override
	public void setPatronymic(String patronymic) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_patronymic = patronymic;
	}

	@JSON
	@Override
	public String getSex() {
		if (_sex == null) {
			return "";
		}
		else {
			return _sex;
		}
	}

	@Override
	public void setSex(String sex) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_sex = sex;
	}

	@JSON
	@Override
	public Date getBirthDay() {
		return _birthDay;
	}

	@Override
	public void setBirthDay(Date birthDay) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_birthDay = birthDay;
	}

	@JSON
	@Override
	public int getPosition() {
		return _position;
	}

	@Override
	public void setPosition(int position) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_position = position;
	}

	@JSON
	@Override
	public Date getDateOfEmployment() {
		return _dateOfEmployment;
	}

	@Override
	public void setDateOfEmployment(Date dateOfEmployment) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_dateOfEmployment = dateOfEmployment;
	}

	@JSON
	@Override
	public int getSalary() {
		return _salary;
	}

	@Override
	public void setSalary(int salary) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_salary = salary;
	}

	@JSON
	@Override
	public int getMobilePhone() {
		return _mobilePhone;
	}

	@Override
	public void setMobilePhone(int mobilePhone) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_mobilePhone = mobilePhone;
	}

	@JSON
	@Override
	public int getJobPhone() {
		return _jobPhone;
	}

	@Override
	public void setJobPhone(int jobPhone) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_jobPhone = jobPhone;
	}

	@JSON
	@Override
	public int getBank() {
		return _bank;
	}

	@Override
	public void setBank(int bank) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_bank = bank;
	}

	@JSON
	@Override
	public boolean getArchive() {
		return _archive;
	}

	@JSON
	@Override
	public boolean isArchive() {
		return _archive;
	}

	@Override
	public void setArchive(boolean archive) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_archive = archive;
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (entry.getValue() != getColumnValue(entry.getKey())) {
				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, Employee.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Employee toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Employee>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		EmployeeImpl employeeImpl = new EmployeeImpl();

		employeeImpl.setUuid(getUuid());
		employeeImpl.setEmployeesId(getEmployeesId());
		employeeImpl.setSurname(getSurname());
		employeeImpl.setName(getName());
		employeeImpl.setPatronymic(getPatronymic());
		employeeImpl.setSex(getSex());
		employeeImpl.setBirthDay(getBirthDay());
		employeeImpl.setPosition(getPosition());
		employeeImpl.setDateOfEmployment(getDateOfEmployment());
		employeeImpl.setSalary(getSalary());
		employeeImpl.setMobilePhone(getMobilePhone());
		employeeImpl.setJobPhone(getJobPhone());
		employeeImpl.setBank(getBank());
		employeeImpl.setArchive(isArchive());

		employeeImpl.resetOriginalValues();

		return employeeImpl;
	}

	@Override
	public int compareTo(Employee employee) {
		int value = 0;

		value = getSurname().compareTo(employee.getSurname());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Employee)) {
			return false;
		}

		Employee employee = (Employee)object;

		long primaryKey = employee.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<Employee> toCacheModel() {
		EmployeeCacheModel employeeCacheModel = new EmployeeCacheModel();

		employeeCacheModel.uuid = getUuid();

		String uuid = employeeCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			employeeCacheModel.uuid = null;
		}

		employeeCacheModel.employeesId = getEmployeesId();

		employeeCacheModel.surname = getSurname();

		String surname = employeeCacheModel.surname;

		if ((surname != null) && (surname.length() == 0)) {
			employeeCacheModel.surname = null;
		}

		employeeCacheModel.name = getName();

		String name = employeeCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			employeeCacheModel.name = null;
		}

		employeeCacheModel.patronymic = getPatronymic();

		String patronymic = employeeCacheModel.patronymic;

		if ((patronymic != null) && (patronymic.length() == 0)) {
			employeeCacheModel.patronymic = null;
		}

		employeeCacheModel.sex = getSex();

		String sex = employeeCacheModel.sex;

		if ((sex != null) && (sex.length() == 0)) {
			employeeCacheModel.sex = null;
		}

		Date birthDay = getBirthDay();

		if (birthDay != null) {
			employeeCacheModel.birthDay = birthDay.getTime();
		}
		else {
			employeeCacheModel.birthDay = Long.MIN_VALUE;
		}

		employeeCacheModel.position = getPosition();

		Date dateOfEmployment = getDateOfEmployment();

		if (dateOfEmployment != null) {
			employeeCacheModel.dateOfEmployment = dateOfEmployment.getTime();
		}
		else {
			employeeCacheModel.dateOfEmployment = Long.MIN_VALUE;
		}

		employeeCacheModel.salary = getSalary();

		employeeCacheModel.mobilePhone = getMobilePhone();

		employeeCacheModel.jobPhone = getJobPhone();

		employeeCacheModel.bank = getBank();

		employeeCacheModel.archive = isArchive();

		return employeeCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Employee, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Employee, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Employee, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((Employee)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<Employee, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Employee, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Employee, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Employee)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Employee>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

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

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<Employee, Object> function = _attributeGetterFunctions.get(
			columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((Employee)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("uuid_", _uuid);
		_columnOriginalValues.put("employeesId", _employeesId);
		_columnOriginalValues.put("surname", _surname);
		_columnOriginalValues.put("name", _name);
		_columnOriginalValues.put("patronymic", _patronymic);
		_columnOriginalValues.put("sex", _sex);
		_columnOriginalValues.put("birthDay", _birthDay);
		_columnOriginalValues.put("position", _position);
		_columnOriginalValues.put("dateOfEmployment", _dateOfEmployment);
		_columnOriginalValues.put("salary", _salary);
		_columnOriginalValues.put("mobilePhone", _mobilePhone);
		_columnOriginalValues.put("jobPhone", _jobPhone);
		_columnOriginalValues.put("bank", _bank);
		_columnOriginalValues.put("archive", _archive);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("uuid_", 1L);

		columnBitmasks.put("employeesId", 2L);

		columnBitmasks.put("surname", 4L);

		columnBitmasks.put("name", 8L);

		columnBitmasks.put("patronymic", 16L);

		columnBitmasks.put("sex", 32L);

		columnBitmasks.put("birthDay", 64L);

		columnBitmasks.put("position", 128L);

		columnBitmasks.put("dateOfEmployment", 256L);

		columnBitmasks.put("salary", 512L);

		columnBitmasks.put("mobilePhone", 1024L);

		columnBitmasks.put("jobPhone", 2048L);

		columnBitmasks.put("bank", 4096L);

		columnBitmasks.put("archive", 8192L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private Employee _escapedModel;

}