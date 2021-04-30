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
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link company.service.http.BankServiceSoap}.
 *
 * @author sam
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class BankSoap implements Serializable {

	public static BankSoap toSoapModel(Bank model) {
		BankSoap soapModel = new BankSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setBankId(model.getBankId());
		soapModel.setBankName(model.getBankName());
		soapModel.setBIK(model.getBIK());
		soapModel.setAddress(model.getAddress());

		return soapModel;
	}

	public static BankSoap[] toSoapModels(Bank[] models) {
		BankSoap[] soapModels = new BankSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BankSoap[][] toSoapModels(Bank[][] models) {
		BankSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BankSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BankSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BankSoap[] toSoapModels(List<Bank> models) {
		List<BankSoap> soapModels = new ArrayList<BankSoap>(models.size());

		for (Bank model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BankSoap[soapModels.size()]);
	}

	public BankSoap() {
	}

	public long getPrimaryKey() {
		return _bankId;
	}

	public void setPrimaryKey(long pk) {
		setBankId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getBankId() {
		return _bankId;
	}

	public void setBankId(long bankId) {
		_bankId = bankId;
	}

	public String getBankName() {
		return _bankName;
	}

	public void setBankName(String bankName) {
		_bankName = bankName;
	}

	public long getBIK() {
		return _BIK;
	}

	public void setBIK(long BIK) {
		_BIK = BIK;
	}

	public String getAddress() {
		return _address;
	}

	public void setAddress(String address) {
		_address = address;
	}

	private String _uuid;
	private long _bankId;
	private String _bankName;

	private long _BIK;

	private String _address;

}