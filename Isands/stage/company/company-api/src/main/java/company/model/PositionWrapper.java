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
 * This class is a wrapper for {@link Position}.
 * </p>
 *
 * @author sam
 * @see Position
 * @generated
 */
public class PositionWrapper
	extends BaseModelWrapper<Position>
	implements ModelWrapper<Position>, Position {

	public PositionWrapper(Position position) {
		super(position);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("positionId", getPositionId());
		attributes.put("name", getName());
		attributes.put("archive", isArchive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long positionId = (Long)attributes.get("positionId");

		if (positionId != null) {
			setPositionId(positionId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Boolean archive = (Boolean)attributes.get("archive");

		if (archive != null) {
			setArchive(archive);
		}
	}

	/**
	 * Returns the archive of this position.
	 *
	 * @return the archive of this position
	 */
	@Override
	public boolean getArchive() {
		return model.getArchive();
	}

	/**
	 * Returns the name of this position.
	 *
	 * @return the name of this position
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the position ID of this position.
	 *
	 * @return the position ID of this position
	 */
	@Override
	public long getPositionId() {
		return model.getPositionId();
	}

	/**
	 * Returns the primary key of this position.
	 *
	 * @return the primary key of this position
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this position.
	 *
	 * @return the uuid of this position
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this position is archive.
	 *
	 * @return <code>true</code> if this position is archive; <code>false</code> otherwise
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
	 * Sets whether this position is archive.
	 *
	 * @param archive the archive of this position
	 */
	@Override
	public void setArchive(boolean archive) {
		model.setArchive(archive);
	}

	/**
	 * Sets the name of this position.
	 *
	 * @param name the name of this position
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the position ID of this position.
	 *
	 * @param positionId the position ID of this position
	 */
	@Override
	public void setPositionId(long positionId) {
		model.setPositionId(positionId);
	}

	/**
	 * Sets the primary key of this position.
	 *
	 * @param primaryKey the primary key of this position
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this position.
	 *
	 * @param uuid the uuid of this position
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected PositionWrapper wrap(Position position) {
		return new PositionWrapper(position);
	}

}