/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package company.service.impl;

import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.SystemException;
import company.model.Bank;
import company.service.BankLocalServiceUtil;
import company.service.base.BankLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

import java.util.List;

/**
 * The implementation of the bank local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>company.service.BankLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author sam
 * @see BankLocalServiceBaseImpl
 */
@Component(
        property = "model.class.name=company.model.Bank", service = AopService.class
)
public class BankLocalServiceImpl extends BankLocalServiceBaseImpl {

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this class directly. Use <code>company.service.BankLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>company.service.BankLocalServiceUtil</code>.
     */
    public Bank addBank(String name, long bik, String address) throws SystemException {
        long id = counterLocalService.increment();

        Bank bank = BankLocalServiceUtil.createBank(id);

        bank.setBIK(bik);
        bank.setBankName(name);
        bank.setAddress(address);

        BankLocalServiceUtil.addBank(bank);
        return bank;
    }

    public List getAllBanks() {
        List banks = null;

        try {
            int countBanks = BankLocalServiceUtil.getBanksCount();

            banks = BankLocalServiceUtil.getBanks(0, countBanks);
        } catch (SystemException e) {
            e.printStackTrace();
        }
        return banks;
    }
}