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

import company.model.Position;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Position in entity cache.
 *
 * @author sam
 * @generated
 */
public class PositionCacheModel
	implements CacheModel<Position>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PositionCacheModel)) {
			return false;
		}

		PositionCacheModel positionCacheModel = (PositionCacheModel)object;

		if (positionId == positionCacheModel.positionId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, positionId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", positionId=");
		sb.append(positionId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", archive=");
		sb.append(archive);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Position toEntityModel() {
		PositionImpl positionImpl = new PositionImpl();

		if (uuid == null) {
			positionImpl.setUuid("");
		}
		else {
			positionImpl.setUuid(uuid);
		}

		positionImpl.setPositionId(positionId);

		if (name == null) {
			positionImpl.setName("");
		}
		else {
			positionImpl.setName(name);
		}

		positionImpl.setArchive(archive);

		positionImpl.resetOriginalValues();

		return positionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		positionId = objectInput.readLong();
		name = objectInput.readUTF();

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

		objectOutput.writeLong(positionId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeBoolean(archive);
	}

	public String uuid;
	public long positionId;
	public String name;
	public boolean archive;

}