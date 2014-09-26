package org.vaadin.inki.qrgwtapp.client;

import org.vaadin.inki.qrgwt.client.QRContactWidget;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class App implements EntryPoint, KeyUpHandler {

	private PromptTextBox firstNameField = new PromptTextBox("First name");
	private PromptTextBox lastNameField = new PromptTextBox("Last name");
	private PromptTextBox emailField = new PromptTextBox("Email");
	private PromptTextBox phoneField = new PromptTextBox("Phone");
	private QRContactWidget qrCodeImage = new QRContactWidget();

	public void onModuleLoad() {

		firstNameField.setWidth("140px");
		lastNameField.setWidth("180px");
		emailField.setWidth("100%");
		phoneField.setWidth("100%");

		firstNameField.addKeyUpHandler(this);
		lastNameField.addKeyUpHandler(this);
		emailField.addKeyUpHandler(this);
		phoneField.addKeyUpHandler(this);

		HTML desc = new HTML(
				"<h2>QRCode time! Enter your contact details below</h2>");

		Grid fields = new Grid(3, 2);
		fields.getCellFormatter().getElement(1, 0).setAttribute("colspan", "2");
		fields.getCellFormatter().getElement(2, 0).setAttribute("colspan", "2");
		fields.setWidget(0, 0, firstNameField);
		fields.setWidget(0, 1, lastNameField);
		fields.setWidget(1, 0, emailField);
		fields.setWidget(2, 0, phoneField);

		HorizontalPanel panel = new HorizontalPanel();
		panel.add(fields);
		panel.add(qrCodeImage);

		VerticalPanel main = new VerticalPanel();
		main.addStyleName("main-panel");
		main.add(desc);
		main.add(panel);

		RootPanel.get().clear();
		RootPanel.get().add(main);
	}

	@Override
	public void onKeyUp(KeyUpEvent event) {
		qrCodeImage.setFirstName(firstNameField.getValue());
		qrCodeImage.setLastName(lastNameField.getValue());
		qrCodeImage.setEmail(emailField.getValue());
		qrCodeImage.setPhoneNumber(phoneField.getValue());
	}
}
