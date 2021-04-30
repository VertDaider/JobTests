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

import company.model.Bank;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Bank in entity cache.
 *
 * @author sam
 * @generated
 */
public class BankCacheModel implements CacheModel<Bank>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof BankCacheModel)) {
			return false;
		}

		BankCacheModel bankCacheModel = (BankCacheModel)object;

		if (bankId == bankCacheModel.bankId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, bankId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", bankId=");
		sb.append(bankId);
		sb.append(", bankName=");
		sb.append(bankName);
		sb.append(", BIK=");
		sb.append(BIK);
		sb.append(", address=");
		sb.append(address);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Bank toEntityModel() {
		BankImpl bankImpl = new BankImpl();

		if (uuid == null) {
			bankImpl.setUuid("");
		}
		else {
			bankImpl.setUuid(uuid);
		}

		bankImpl.setBankId(bankId);

		if (bankName == null) {
			bankImpl.setBankName("");
		}
		else {
			bankImpl.setBankName(bankName);
		}

		bankImpl.setBIK(BIK);

		if (address == null) {
			bankImpl.setAddress("");
		}
		else {
			bankImpl.setAddress(address);
		}

		bankImpl.resetOriginalValues();

		return bankImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		bankId = objectInput.readLong();
		bankName = objectInput.readUTF();

		BIK = objectInput.readLong();
		address = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(bankId);

		if (bankName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(bankName);
		}

		objectOutput.writeLong(BIK);

		if (address == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(address);
		}
	}

	public String uuid;
	public long bankId;
	public String bankName;

	public long BIK;

	public String address;

}