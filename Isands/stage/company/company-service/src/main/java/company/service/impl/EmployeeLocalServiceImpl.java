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

import company.model.Employee;
import company.service.base.EmployeeLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the employee local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>company.service.EmployeeLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author sam
 * @see EmployeeLocalServiceBaseImpl
 */
@Component(
        property = "model.class.name=company.model.Employee",
        service = AopService.class
)
public class EmployeeLocalServiceImpl extends EmployeeLocalServiceBaseImpl {

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this class directly. Use <code>company.service.EmployeeLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>company.service.EmployeeLocalServiceUtil</code>.
     */
    public java.util.List<company.model.Employee> getEmployees(int start, int end, Date firstDate, Date lastDate) {

        List<Employee> employeeList = getEmployees(start, end);
        List<Employee> newList = new ArrayList<>(employeeList);

        if (firstDate != null && lastDate != null) {
            for (Employee employee : employeeList) {
                if (employee.getBirthDay().before(firstDate) || employee.getBirthDay().after(lastDate)) {
                    newList.remove(employee);
                }
            }
        } else return employeeList;

        return newList;
    }
}
