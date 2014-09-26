package org.vaadin.inki.qrvaadin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import org.jsoup.nodes.Element;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.BootstrapFragmentResponse;
import com.vaadin.server.BootstrapListener;
import com.vaadin.server.BootstrapPageResponse;
import com.vaadin.server.ServiceException;
import com.vaadin.server.SessionInitEvent;
import com.vaadin.server.SessionInitListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("valo")
@SuppressWarnings("serial")
public class MyVaadinUI extends UI {

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = MyVaadinUI.class, widgetset = "org.vaadin.inki.qrvaadin.AppWidgetSet")
	public static class Servlet extends VaadinServlet implements
			SessionInitListener, BootstrapListener {
		
		@Override
		protected void servletInitialized() throws ServletException {
			super.servletInitialized();
			getService().addSessionInitListener(this);
		}

		@Override
		public void sessionInit(SessionInitEvent event) throws ServiceException {
			event.getSession().addBootstrapListener(this);
		}

		@Override
		public void modifyBootstrapPage(BootstrapPageResponse response) {
			Element head = response.getDocument().getElementsByTag("head").get(0);

			// add platform.js for getting Polymer project
			Element platform = response.getDocument().createElement("script");
			platform.attr("src", "VAADIN/platform/platform.js");
			head.appendChild(platform);
		}

		@Override
		public void modifyBootstrapFragment(BootstrapFragmentResponse response) {}
	}

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);

		layout.addComponent(new Label("QR code just for you"));
		layout.addComponent(new QRContactComponent("Luke", "Skywalker",
				"luke@rebels.com", "+3589285739"));
	}

}
