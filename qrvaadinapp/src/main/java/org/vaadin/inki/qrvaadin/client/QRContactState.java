package org.vaadin.inki.qrvaadin.client;

import com.vaadin.shared.annotations.DelegateToWidget;

public class QRContactState extends com.vaadin.shared.AbstractComponentState {

	private static final long serialVersionUID = 1L;

	@DelegateToWidget
	public String firstName = "";
	@DelegateToWidget
	public String lastName = "";
	@DelegateToWidget
	public String email = "";
	@DelegateToWidget
	public String phoneNumber = "";

}