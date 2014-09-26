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
	 * Sets the stored values in MECARD format to the <qr-code> element's 'data'
	 * attribute that initiates the QR code image update
	 */
	private void refresh() {
		String mecard = "MECARD:N:" + lastName + "," + firstName + ";EMAIL:"
				+ email + ";TEL:" + phoneNumber + ";";
		getElement().setAttribute("data", mecard);
	}

	public void setPhoneNumber(String value) {
		this.phoneNumber = value;
		refresh();
	}

	public void setEmail(String value) {
		this.email = value;
	}

	public void setLastName(String value) {
		this.lastName = value;
	}

	public void setFirstName(String value) {
		this.firstName = value;
	}

}
