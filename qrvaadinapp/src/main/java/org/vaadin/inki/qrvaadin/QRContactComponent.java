package org.vaadin.inki.qrvaadin;

import org.vaadin.inki.qrvaadin.client.QRContactState;

import com.vaadin.ui.AbstractComponent;

public class QRContactComponent extends AbstractComponent {

	private static final long serialVersionUID = 1L;

	public QRContactComponent() {
		super();
	}

	public QRContactComponent(String firstName, String lastName, String email,
			String phoneNumber) {
		getState().firstName = firstName;
		getState().lastName = lastName;
		getState().email = email;
		getState().phoneNumber = phoneNumber;
	}

	@Override
	public QRContactState getState() {
		return (QRContactState) super.getState();
	}
}
