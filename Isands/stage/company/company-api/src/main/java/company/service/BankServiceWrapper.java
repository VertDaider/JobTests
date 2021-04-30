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

package company.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link BankService}.
 *
 * @author sam
 * @see BankService
 * @generated
 */
public class BankServiceWrapper
	implements BankService, ServiceWrapper<BankService> {

	public BankServiceWrapper(BankService bankService) {
		_bankService = bankService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _bankService.getOSGiServiceIdentifier();
	}

	@Override
	public BankService getWrappedService() {
		return _bankService;
	}

	@Override
	public void setWrappedService(BankService bankService) {
		_bankService = bankService;
	}

	private BankService _bankService;

}