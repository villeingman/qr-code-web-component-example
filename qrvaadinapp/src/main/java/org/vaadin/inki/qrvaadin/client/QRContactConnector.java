package org.vaadin.inki.qrvaadin.client;

import org.vaadin.inki.qrgwt.client.QRContactWidget;
import org.vaadin.inki.qrvaadin.QRContactComponent;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.shared.ui.Connect;

@Connect(QRContactComponent.class)
public class QRContactConnector extends AbstractComponentConnector {

	private static final long serialVersionUID = 1L;

	public QRContactConnector() {
	}

	@Override
	protected Widget createWidget() {
		return GWT.create(QRContactWidget.class);
	}

	@Override
	public QRContactWidget getWidget() {
		return (QRContactWidget) super.getWidget();
	}

	@Override
	public QRContactState getState() {
		return (QRContactState) super.getState();
	}

	@Override
	public void onStateChanged(StateChangeEvent stateChangeEvent) {
		super.onStateChanged(stateChangeEvent);
	}
}
