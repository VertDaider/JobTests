package ru.test.portlet;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.vulcan.util.ActionUtil;

import company.exception.NoSuchBankException;
import company.model.Bank;
import company.model.Employee;
import company.model.Position;
import company.service.*;
import company.service.persistence.BankPersistence;
import org.osgi.service.component.annotations.Reference;
import ru.test.constants.AppPortletKeys;


import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.*;

import org.osgi.service.component.annotations.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * @author user
 */
@Component(
        immediate = true,
        property = {
                "com.liferay.portlet.display-category=category.sample",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.instanceable=false",
                "javax.portlet.display-name=App",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/view.jsp",
                "javax.portlet.name=" + AppPortletKeys.APP,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class AppPortlet extends MVCPortlet {

    private static Log _log = LogFactoryUtil.getLog(MVCPortlet.class);

    public void addBank(ActionRequest request, ActionResponse response) throws PortalException {

        ServiceContext serviceContext = ServiceContextFactory.getInstance(Bank.class.getName(), request);

        String name = ParamUtil.getString(request, "bankName");
        String address = ParamUtil.getString(request, "address");
        long bik = ParamUtil.getLong(request, "bik");

        long bankId = CounterLocalServiceUtil.increment();
        Bank bank = null;
        bank = BankLocalServiceUtil.createBank(bankId);

        bank.setBankName(name);
        bank.setBIK(bik);
        bank.setAddress(address);

        bank = BankLocalServiceUtil.addBank(bank);

        if (bank != null) {
            SessionMessages.add((PortletRequest) request.getPortletSession(), "bank-add-success");
            _log.info("Bank have been added successfully");
        } else {
            SessionErrors.add((PortletRequest) request.getPortletSession(), "bank-add-error");
            _log.error("There is an Error in adding Bank");
        }

    }

    public void deleteBank(ActionRequest request, ActionResponse response) throws PortalException {
        long bankId = ParamUtil.getLong(request, "bankId");

        Bank bank = BankLocalServiceUtil.deleteBank(bankId);
    }

    public void editBank(ActionRequest request, ActionResponse response) throws PortalException {
        long bankId = ParamUtil.getLong(request, "bankId");

        String address = ParamUtil.getString(request, "address");
        long bik = ParamUtil.getLong(request, "BIK");

        Bank bank = BankLocalServiceUtil.getBank(bankId);

        bank.setBIK(bik);
        bank.setAddress(address);

        bank = BankLocalServiceUtil.updateBank(bank);
    }

    public void addPosition(ActionRequest request, ActionResponse response) throws PortalException {

        ServiceContext serviceContext = ServiceContextFactory.getInstance(Position.class.getName(), request);

        String name = ParamUtil.getString(request, "name");
        boolean isArchive = ParamUtil.getBoolean(request, "archive", false);

        long positionId = CounterLocalServiceUtil.increment();

         Position position = PositionLocalServiceUtil.createPosition(positionId);

        position.setName(name);
        position.setArchive(isArchive);

        position = PositionLocalServiceUtil.addPosition(position);

    }

    public void deletePos(ActionRequest request, ActionResponse response) throws PortalException  {
        long posId = ParamUtil.getLong(request, "posId");

        List list = EmployeeLocalServiceUtil.getEmployees(0, EmployeeLocalServiceUtil.getEmployeesCount());
        for (Object employee : list) {
            Employee emp = (Employee) employee;
            if (emp.getPosition() == posId && !emp.isArchive()) {
                SessionErrors.add((PortletRequest) request.getPortletSession(), "pos-del-error");
                _log.error("На данной должности работает сотрудник");
            } else {
                Position position = PositionLocalServiceUtil.deletePosition(posId);
            }
        }


    }

    public void editPos (ActionRequest request, ActionResponse response) throws PortalException  {
        long posId = ParamUtil.getLong(request, "posId");

        String name = ParamUtil.getString(request, "name");
        boolean isArchive = ParamUtil.getBoolean(request, "archive", false);

        Position position = PositionLocalServiceUtil.getPosition(posId);

        position.setName(name);
        position.setArchive(isArchive);

        position = PositionLocalServiceUtil.updatePosition(position);
    }

}