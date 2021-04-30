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

package company.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import company.exception.NoSuchPositionException;

import company.model.Position;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the position service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author sam
 * @see PositionUtil
 * @generated
 */
@ProviderType
public interface PositionPersistence extends BasePersistence<Position> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PositionUtil} to access the position persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the positions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching positions
	 */
	public java.util.List<Position> findByUuid(String uuid);

	/**
	 * Returns a range of all the positions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PositionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of positions
	 * @param end the upper bound of the range of positions (not inclusive)
	 * @return the range of matching positions
	 */
	public java.util.List<Position> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the positions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PositionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of positions
	 * @param end the upper bound of the range of positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching positions
	 */
	public java.util.List<Position> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Position>
			orderByComparator);

	/**
	 * Returns an ordered range of all the positions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PositionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of positions
	 * @param end the upper bound of the range of positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching positions
	 */
	public java.util.List<Position> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Position>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first position in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching position
	 * @throws NoSuchPositionException if a matching position could not be found
	 */
	public Position findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Position>
				orderByComparator)
		throws NoSuchPositionException;

	/**
	 * Returns the first position in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching position, or <code>null</code> if a matching position could not be found
	 */
	public Position fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Position>
			orderByComparator);

	/**
	 * Returns the last position in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching position
	 * @throws NoSuchPositionException if a matching position could not be found
	 */
	public Position findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Position>
				orderByComparator)
		throws NoSuchPositionException;

	/**
	 * Returns the last position in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching position, or <code>null</code> if a matching position could not be found
	 */
	public Position fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Position>
			orderByComparator);

	/**
	 * Returns the positions before and after the current position in the ordered set where uuid = &#63;.
	 *
	 * @param positionId the primary key of the current position
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next position
	 * @throws NoSuchPositionException if a position with the primary key could not be found
	 */
	public Position[] findByUuid_PrevAndNext(
			long positionId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Position>
				orderByComparator)
		throws NoSuchPositionException;

	/**
	 * Removes all the positions where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of positions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching positions
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the positions where name = &#63;.
	 *
	 * @param name the name
	 * @return the matching positions
	 */
	public java.util.List<Position> findByname(String name);

	/**
	 * Returns a range of all the positions where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PositionModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of positions
	 * @param end the upper bound of the range of positions (not inclusive)
	 * @return the range of matching positions
	 */
	public java.util.List<Position> findByname(String name, int start, int end);

	/**
	 * Returns an ordered range of all the positions where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PositionModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of positions
	 * @param end the upper bound of the range of positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching positions
	 */
	public java.util.List<Position> findByname(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Position>
			orderByComparator);

	/**
	 * Returns an ordered range of all the positions where name = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PositionModelImpl</code>.
	 * </p>
	 *
	 * @param name the name
	 * @param start the lower bound of the range of positions
	 * @param end the upper bound of the range of positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching positions
	 */
	public java.util.List<Position> findByname(
		String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Position>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first position in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching position
	 * @throws NoSuchPositionException if a matching position could not be found
	 */
	public Position findByname_First(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<Position>
				orderByComparator)
		throws NoSuchPositionException;

	/**
	 * Returns the first position in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching position, or <code>null</code> if a matching position could not be found
	 */
	public Position fetchByname_First(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<Position>
			orderByComparator);

	/**
	 * Returns the last position in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching position
	 * @throws NoSuchPositionException if a matching position could not be found
	 */
	public Position findByname_Last(
			String name,
			com.liferay.portal.kernel.util.OrderByComparator<Position>
				orderByComparator)
		throws NoSuchPositionException;

	/**
	 * Returns the last position in the ordered set where name = &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching position, or <code>null</code> if a matching position could not be found
	 */
	public Position fetchByname_Last(
		String name,
		com.liferay.portal.kernel.util.OrderByComparator<Position>
			orderByComparator);

	/**
	 * Returns the positions before and after the current position in the ordered set where name = &#63;.
	 *
	 * @param positionId the primary key of the current position
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next position
	 * @throws NoSuchPositionException if a position with the primary key could not be found
	 */
	public Position[] findByname_PrevAndNext(
			long positionId, String name,
			com.liferay.portal.kernel.util.OrderByComparator<Position>
				orderByComparator)
		throws NoSuchPositionException;

	/**
	 * Removes all the positions where name = &#63; from the database.
	 *
	 * @param name the name
	 */
	public void removeByname(String name);

	/**
	 * Returns the number of positions where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching positions
	 */
	public int countByname(String name);

	/**
	 * Caches the position in the entity cache if it is enabled.
	 *
	 * @param position the position
	 */
	public void cacheResult(Position position);

	/**
	 * Caches the positions in the entity cache if it is enabled.
	 *
	 * @param positions the positions
	 */
	public void cacheResult(java.util.List<Position> positions);

	/**
	 * Creates a new position with the primary key. Does not add the position to the database.
	 *
	 * @param positionId the primary key for the new position
	 * @return the new position
	 */
	public Position create(long positionId);

	/**
	 * Removes the position with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param positionId the primary key of the position
	 * @return the position that was removed
	 * @throws NoSuchPositionException if a position with the primary key could not be found
	 */
	public Position remove(long positionId) throws NoSuchPositionException;

	public Position updateImpl(Position position);

	/**
	 * Returns the position with the primary key or throws a <code>NoSuchPositionException</code> if it could not be found.
	 *
	 * @param positionId the primary key of the position
	 * @return the position
	 * @throws NoSuchPositionException if a position with the primary key could not be found
	 */
	public Position findByPrimaryKey(long positionId)
		throws NoSuchPositionException;

	/**
	 * Returns the position with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param positionId the primary key of the position
	 * @return the position, or <code>null</code> if a position with the primary key could not be found
	 */
	public Position fetchByPrimaryKey(long positionId);

	/**
	 * Returns all the positions.
	 *
	 * @return the positions
	 */
	public java.util.List<Position> findAll();

	/**
	 * Returns a range of all the positions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PositionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of positions
	 * @param end the upper bound of the range of positions (not inclusive)
	 * @return the range of positions
	 */
	public java.util.List<Position> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the positions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PositionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of positions
	 * @param end the upper bound of the range of positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of positions
	 */
	public java.util.List<Position> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Position>
			orderByComparator);

	/**
	 * Returns an ordered range of all the positions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PositionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of positions
	 * @param end the upper bound of the range of positions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of positions
	 */
	public java.util.List<Position> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Position>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the positions from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of positions.
	 *
	 * @return the number of positions
	 */
	public int countAll();

}