package ru.test.portlet;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import company.model.Bank;
import company.model.Employee;
import company.model.Position;
import company.service.BankLocalServiceUtil;
import company.service.EmployeeLocalServiceUtil;
import company.service.PositionLocalServiceUtil;
import org.osgi.service.component.annotations.Component;
import ru.test.constants.AppPortletKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

        Bank bank = BankLocalServiceUtil.createBank(bankId);

        bank.setBankName(name);
        bank.setBIK(bik);
        bank.setAddress(address);

        BankLocalServiceUtil.addBank(bank);

        SessionMessages.add((PortletRequest) request.getPortletSession(), "bank-add-success");
        _log.info("Bank have been added successfully");
    }

    public void deleteBank(ActionRequest request, ActionResponse response) throws PortalException {
        long bankId = ParamUtil.getLong(request, "bankId");
        BankLocalServiceUtil.deleteBank(bankId);
    }

    public void editBank(ActionRequest request, ActionResponse response) throws PortalException {
        long bankId = ParamUtil.getLong(request, "bankId");

        String address = ParamUtil.getString(request, "address");
        long bik = ParamUtil.getLong(request, "BIK");

        Bank bank = BankLocalServiceUtil.getBank(bankId);

        bank.setBIK(bik);
        bank.setAddress(address);

        BankLocalServiceUtil.updateBank(bank);
    }

    public void addPosition(ActionRequest request, ActionResponse response) throws PortalException {

        ServiceContext serviceContext = ServiceContextFactory.getInstance(Position.class.getName(), request);

        String name = ParamUtil.getString(request, "name");
        boolean isArchive = ParamUtil.getBoolean(request, "archive", false);

        long positionId = CounterLocalServiceUtil.increment();

        Position position = PositionLocalServiceUtil.createPosition(positionId);

        position.setName(name);
        position.setArchive(isArchive);

        PositionLocalServiceUtil.addPosition(position);
    }

    public void deletePos(ActionRequest request, ActionResponse response) throws PortalException {
        long posId = ParamUtil.getLong(request, "posId");

        List list = EmployeeLocalServiceUtil.getEmployees(0, EmployeeLocalServiceUtil.getEmployeesCount());

        // проверяем, работает ли кто-то на удаляемой должности
        for (Object employee : list) {
            Employee emp = (Employee) employee;
            if (emp.getPosition() == posId && !emp.isArchive()) {
                SessionErrors.add((PortletRequest) request.getPortletSession(), "pos-del-error");
                _log.error("На данной должности работает сотрудник");
            } else {
                PositionLocalServiceUtil.deletePosition(posId);
            }
        }
    }

    public void editPos(ActionRequest request, ActionResponse response) throws PortalException {
        long posId = ParamUtil.getLong(request, "posId");

        String name = ParamUtil.getString(request, "name");
        boolean isArchive = ParamUtil.getBoolean(request, "archive", false);

        Position position = PositionLocalServiceUtil.getPosition(posId);

        position.setName(name);
        position.setArchive(isArchive);

        PositionLocalServiceUtil.updatePosition(position);
    }

    public void addEmployee(ActionRequest request, ActionResponse response) throws PortalException {
        ServiceContext serviceContext = ServiceContextFactory.getInstance(Employee.class.getName(), request);

        String name = ParamUtil.getString(request, "name");
        String surname = ParamUtil.getString(request, "surname");
        String patronymic = ParamUtil.getString(request, "patronymic");
        String gender;
        if (ParamUtil.getString(request, "sex").equals("man")) {
            gender = "мужской";
        } else {
            gender = "женский";
        }
        SimpleDateFormat df = new SimpleDateFormat("");
        Date birthDay = ParamUtil.getDate(request, "birthDay", df);
        int position = ParamUtil.getInteger(request, "position");
        Date dateOfEmployment = ParamUtil.getDate(request, "dateOfEmployment", df);
        int salary = ParamUtil.getInteger(request, "salary");
        int mobilePhone = ParamUtil.getInteger(request, "mobilePhone");
        int jobPhone = ParamUtil.getInteger(request, "jobPhone");
        int bank = ParamUtil.getInteger(request, "bank");
        boolean archive = ParamUtil.getBoolean(request, "archive", false);

        long empId = CounterLocalServiceUtil.increment();
        Employee employee = EmployeeLocalServiceUtil.createEmployee(empId);

        employee.setName(name);
        employee.setSurname(surname);
        employee.setPatronymic(patronymic);
        employee.setSex(gender);
        employee.setBirthDay(birthDay);
        employee.setPosition(position);
        employee.setDateOfEmployment(dateOfEmployment);
        employee.setSalary(salary);
        employee.setMobilePhone(mobilePhone);
        employee.setJobPhone(jobPhone);
        employee.setBank(bank);
        employee.setArchive(!archive);

        EmployeeLocalServiceUtil.addEmployee(employee);
    }

    public void deleteEmployee (ActionRequest request, ActionResponse response) throws PortalException {
        long empId = ParamUtil.getLong(request, "employeeId");
        EmployeeLocalServiceUtil.deleteEmployee(empId);
    }

    public void editEmployee (ActionRequest request, ActionResponse response) throws PortalException, ParseException {
        long empId = ParamUtil.getLong(request, "empId");

        String name = ParamUtil.getString(request, "name");
        String surname = ParamUtil.getString(request, "surname");
        String patronymic = ParamUtil.getString(request, "patronymic");
        String gender;
        if (ParamUtil.getString(request, "sex").equals("man")) {
            gender = "мужской";
        } else {
            gender = "женский";
        }

        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        String birthDayStr = ParamUtil.getString(request, "birthDay");
        Date birthDay = df.parse(birthDayStr);
        String dateOfEmploymentStr = ParamUtil.getString(request, "dateOfEmployment");
        Date dateOfEmployment = df.parse(dateOfEmploymentStr);

        int position = ParamUtil.getInteger(request, "position");
        int salary = ParamUtil.getInteger(request, "salary");
        int mobilePhone = ParamUtil.getInteger(request, "mobilePhone");
        int jobPhone = ParamUtil.getInteger(request, "jobPhone");
        int bank = ParamUtil.getInteger(request, "bank");
        boolean archive = ParamUtil.getBoolean(request, "archive", false);

        Employee employee = EmployeeLocalServiceUtil.getEmployee(empId);

        employee.setName(name);
        employee.setSurname(surname);
        employee.setPatronymic(patronymic);
        employee.setSex(gender);
        employee.setBirthDay(birthDay);
        employee.setPosition(position);
        employee.setDateOfEmployment(dateOfEmployment);
        employee.setSalary(salary);
        employee.setMobilePhone(mobilePhone);
        employee.setJobPhone(jobPhone);
        employee.setBank(bank);
        employee.setArchive(!archive);

        EmployeeLocalServiceUtil.updateEmployee(employee);
    }

    public void editArchiveEmp (ActionRequest request, ActionResponse response) throws PortalException {
        long empId = ParamUtil.getLong(request, "employeeId");
        Employee employee = EmployeeLocalServiceUtil.getEmployee(empId);
        employee.setArchive(!employee.getArchive());
        EmployeeLocalServiceUtil.updateEmployee(employee);
    }

    public void editArchivePos (ActionRequest request, ActionResponse response) throws PortalException {
        long posId = ParamUtil.getLong(request, "posId");
        Position position = PositionLocalServiceUtil.getPosition(posId);
        position.setArchive(!position.getArchive());
        PositionLocalServiceUtil.updatePosition(position);
    }

    public void filterEmpBirthDay (ActionRequest request, ActionResponse response) throws PortalException, ParseException {
        SimpleDateFormat df = new SimpleDateFormat("MM.dd.yyyy");

        String firstDateStr = ParamUtil.getString(request, "firstDate");
        String lastDateStr = ParamUtil.getString(request, "lastDate");
        Date firstDate = df.parse(firstDateStr);
        Date lastDate = df.parse(lastDateStr);
        request.setAttribute("firstDate", firstDate);
        request.setAttribute("lastDate", lastDate);
    }
}