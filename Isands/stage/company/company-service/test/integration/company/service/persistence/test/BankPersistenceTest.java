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

package company.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import company.exception.NoSuchBankException;

import company.model.Bank;

import company.service.BankLocalServiceUtil;
import company.service.persistence.BankPersistence;
import company.service.persistence.BankUtil;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class BankPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(Propagation.REQUIRED, "company.service"));

	@Before
	public void setUp() {
		_persistence = BankUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Bank> iterator = _banks.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Bank bank = _persistence.create(pk);

		Assert.assertNotNull(bank);

		Assert.assertEquals(bank.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Bank newBank = addBank();

		_persistence.remove(newBank);

		Bank existingBank = _persistence.fetchByPrimaryKey(
			newBank.getPrimaryKey());

		Assert.assertNull(existingBank);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addBank();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Bank newBank = _persistence.create(pk);

		newBank.setUuid(RandomTestUtil.randomString());

		newBank.setBankName(RandomTestUtil.randomString());

		newBank.setBIK(RandomTestUtil.nextLong());

		newBank.setAddress(RandomTestUtil.randomString());

		_banks.add(_persistence.update(newBank));

		Bank existingBank = _persistence.findByPrimaryKey(
			newBank.getPrimaryKey());

		Assert.assertEquals(existingBank.getUuid(), newBank.getUuid());
		Assert.assertEquals(existingBank.getBankId(), newBank.getBankId());
		Assert.assertEquals(existingBank.getBankName(), newBank.getBankName());
		Assert.assertEquals(existingBank.getBIK(), newBank.getBIK());
		Assert.assertEquals(existingBank.getAddress(), newBank.getAddress());
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid("");

		_persistence.countByUuid("null");

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testCountBybankName() throws Exception {
		_persistence.countBybankName("");

		_persistence.countBybankName("null");

		_persistence.countBybankName((String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Bank newBank = addBank();

		Bank existingBank = _persistence.findByPrimaryKey(
			newBank.getPrimaryKey());

		Assert.assertEquals(existingBank, newBank);
	}

	@Test(expected = NoSuchBankException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Bank> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"Company_Bank", "uuid", true, "bankId", true, "bankName", true,
			"BIK", true, "address", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Bank newBank = addBank();

		Bank existingBank = _persistence.fetchByPrimaryKey(
			newBank.getPrimaryKey());

		Assert.assertEquals(existingBank, newBank);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Bank missingBank = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingBank);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Bank newBank1 = addBank();
		Bank newBank2 = addBank();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newBank1.getPrimaryKey());
		primaryKeys.add(newBank2.getPrimaryKey());

		Map<Serializable, Bank> banks = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, banks.size());
		Assert.assertEquals(newBank1, banks.get(newBank1.getPrimaryKey()));
		Assert.assertEquals(newBank2, banks.get(newBank2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Bank> banks = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(banks.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Bank newBank = addBank();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newBank.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Bank> banks = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, banks.size());
		Assert.assertEquals(newBank, banks.get(newBank.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Bank> banks = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(banks.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Bank newBank = addBank();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newBank.getPrimaryKey());

		Map<Serializable, Bank> banks = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, banks.size());
		Assert.assertEquals(newBank, banks.get(newBank.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			BankLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Bank>() {

				@Override
				public void performAction(Bank bank) {
					Assert.assertNotNull(bank);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Bank newBank = addBank();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Bank.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("bankId", newBank.getBankId()));

		List<Bank> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Bank existingBank = result.get(0);

		Assert.assertEquals(existingBank, newBank);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Bank.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("bankId", RandomTestUtil.nextLong()));

		List<Bank> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Bank newBank = addBank();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Bank.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("bankId"));

		Object newBankId = newBank.getBankId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("bankId", new Object[] {newBankId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingBankId = result.get(0);

		Assert.assertEquals(existingBankId, newBankId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Bank.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("bankId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"bankId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Bank addBank() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Bank bank = _persistence.create(pk);

		bank.setUuid(RandomTestUtil.randomString());

		bank.setBankName(RandomTestUtil.randomString());

		bank.setBIK(RandomTestUtil.nextLong());

		bank.setAddress(RandomTestUtil.randomString());

		_banks.add(_persistence.update(bank));

		return bank;
	}

	private List<Bank> _banks = new ArrayList<Bank>();
	private BankPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}