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
 * This class is used by SOAP remote services, specifically {@link company.service.http.PositionServiceSoap}.
 *
 * @author sam
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class PositionSoap implements Serializable {

	public static PositionSoap toSoapModel(Position model) {
		PositionSoap soapModel = new PositionSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setPositionId(model.getPositionId());
		soapModel.setName(model.getName());
		soapModel.setArchive(model.isArchive());

		return soapModel;
	}

	public static PositionSoap[] toSoapModels(Position[] models) {
		PositionSoap[] soapModels = new PositionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PositionSoap[][] toSoapModels(Position[][] models) {
		PositionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PositionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PositionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PositionSoap[] toSoapModels(List<Position> models) {
		List<PositionSoap> soapModels = new ArrayList<PositionSoap>(
			models.size());

		for (Position model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PositionSoap[soapModels.size()]);
	}

	public PositionSoap() {
	}

	public long getPrimaryKey() {
		return _positionId;
	}

	public void setPrimaryKey(long pk) {
		setPositionId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getPositionId() {
		return _positionId;
	}

	public void setPositionId(long positionId) {
		_positionId = positionId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
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
	private long _positionId;
	private String _name;
	private boolean _archive;

}