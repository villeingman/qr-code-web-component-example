package org.vaadin.inki.qrgwtapp.client;

import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.user.client.ui.TextBox;

public class PromptTextBox extends TextBox implements FocusHandler,
		ClickHandler, BlurHandler, KeyPressHandler {

	private String prompt = "";

	public PromptTextBox(String prompt) {
		super();
		this.prompt = prompt;
		addBlurHandler(this);
		addFocusHandler(this);
		addClickHandler(this);
		addKeyPressHandler(this);
		showPrompt();
	}

	private void showPrompt() {
		setText(prompt);
		addStyleDependentName("prompt");
	}

	private void hidePrompt() {
		setText(null);
		removeStyleDependentName("prompt");
	}

	@Override
	public void onClick(ClickEvent event) {
		if (prompt.equals(this.getText()))
			hidePrompt();
	}

	@Override
	public void onFocus(FocusEvent event) {
		this.setCursorPos(0);
	}

	@Override
	public void onBlur(BlurEvent event) {
		if (getText().isEmpty()) {
			showPrompt();
		}
	}

	@Override
	public void onKeyPress(KeyPressEvent event) {
		if (prompt.equals(this.getText())
				&& !(event.getNativeEvent().getKeyCode() == KeyCodes.KEY_TAB)) {
			hidePrompt();
		}
	}

}
