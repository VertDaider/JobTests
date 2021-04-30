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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Bank}.
 * </p>
 *
 * @author sam
 * @see Bank
 * @generated
 */
public class BankWrapper
	extends BaseModelWrapper<Bank> implements Bank, ModelWrapper<Bank> {

	public BankWrapper(Bank bank) {
		super(bank);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("bankId", getBankId());
		attributes.put("bankName", getBankName());
		attributes.put("BIK", getBIK());
		attributes.put("address", getAddress());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long bankId = (Long)attributes.get("bankId");

		if (bankId != null) {
			setBankId(bankId);
		}

		String bankName = (String)attributes.get("bankName");

		if (bankName != null) {
			setBankName(bankName);
		}

		Long BIK = (Long)attributes.get("BIK");

		if (BIK != null) {
			setBIK(BIK);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}
	}

	/**
	 * Returns the address of this bank.
	 *
	 * @return the address of this bank
	 */
	@Override
	public String getAddress() {
		return model.getAddress();
	}

	/**
	 * Returns the bank ID of this bank.
	 *
	 * @return the bank ID of this bank
	 */
	@Override
	public long getBankId() {
		return model.getBankId();
	}

	/**
	 * Returns the bank name of this bank.
	 *
	 * @return the bank name of this bank
	 */
	@Override
	public String getBankName() {
		return model.getBankName();
	}

	/**
	 * Returns the bik of this bank.
	 *
	 * @return the bik of this bank
	 */
	@Override
	public long getBIK() {
		return model.getBIK();
	}

	/**
	 * Returns the primary key of this bank.
	 *
	 * @return the primary key of this bank
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this bank.
	 *
	 * @return the uuid of this bank
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the address of this bank.
	 *
	 * @param address the address of this bank
	 */
	@Override
	public void setAddress(String address) {
		model.setAddress(address);
	}

	/**
	 * Sets the bank ID of this bank.
	 *
	 * @param bankId the bank ID of this bank
	 */
	@Override
	public void setBankId(long bankId) {
		model.setBankId(bankId);
	}

	/**
	 * Sets the bank name of this bank.
	 *
	 * @param bankName the bank name of this bank
	 */
	@Override
	public void setBankName(String bankName) {
		model.setBankName(bankName);
	}

	/**
	 * Sets the bik of this bank.
	 *
	 * @param BIK the bik of this bank
	 */
	@Override
	public void setBIK(long BIK) {
		model.setBIK(BIK);
	}

	/**
	 * Sets the primary key of this bank.
	 *
	 * @param primaryKey the primary key of this bank
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this bank.
	 *
	 * @param uuid the uuid of this bank
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected BankWrapper wrap(Bank bank) {
		return new BankWrapper(bank);
	}

}