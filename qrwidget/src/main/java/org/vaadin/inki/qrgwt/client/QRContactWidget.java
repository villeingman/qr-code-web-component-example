package org.vaadin.inki.qrgwt.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Widget;

/*
 * Widget that wraps a <qr-code> web component and provides a vCard setter API. 
 * Shows an QR code image on screen containing the given data. 
 * 
 * @author Ville Ingman
 */
public class QRContactWidget extends Widget {

	private static boolean injected = false;

	private String phoneNumber = "";
	private String email = "";
	private String lastName = "";
	private String firstName = "";

	/*
	 * Constuctor. Ensures that needed html templates are added and injects a <qr-code> element to the page. 
	 */
	public QRContactWidget() {
		super();
		ensureHTMLImport();
		Element el = DOM.createElement("qr-code");
		setElement(el);
		refresh();
	}

	/*
	 * Injects the qr-code html template to page head section. 
	 */
	private static void ensureHTMLImport() {
		if (!injected) {
			Element head = Document.get().getElementsByTagName("head")
					.getItem(0);
			Element htmlImport = Document.get().createLinkElement();
			htmlImport.setAttribute("rel", "import");
			htmlImport.setAttribute("href", GWT.getModuleBaseForStaticFiles()
					+ "components/qr-code/qr-code.html");
			head.appendChild(htmlImport);
		}
	}

	/*
	 * Sets all data and calls refresh to update qr-code image
	 */
	public void setData(String firstName, String lastName, String email, String phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		refresh();
	}
	
	/*
	 * Sets the stored values in MECARD format to the <qr-code> element's 'data'
	 * attribute that initiates the QR code image update
	 */
	private void refresh() {
		String mecard = "MECARD:N:" + lastName + "," + firstName + ";EMAIL:"
				+ email + ";TEL:" + phoneNumber + ";";
		getElement().setAttribute("data", mecard);
	}
}
