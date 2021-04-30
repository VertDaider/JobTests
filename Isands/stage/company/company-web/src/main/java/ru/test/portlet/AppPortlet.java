package ru.test.portlet;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.vulcan.util.ActionUtil;
import company.service.BankLocalService;
import company.model.Bank;
import company.service.BankLocalServiceUtil;
import company.service.BankServiceUtil;
import org.osgi.service.component.annotations.Reference;
import ru.test.constants.AppPortletKeys;


import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.*;

import org.osgi.service.component.annotations.Component;

import java.io.IOException;
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

        @Reference
        private BankLocalService _bankLocalService;


        public void addBank(ActionRequest request, ActionResponse response) {

        }

//        @Override
//        public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
//                throws IOException, PortletException {
//
//                SearchContainer<Bank> searchContainer =
//                        new SearchContainer<Bank>(renderRequest, renderResponse.createRenderURL(), null, "there-are-no-courses");
//
//                searchContainer.setDelta(5);
//
//        }

}