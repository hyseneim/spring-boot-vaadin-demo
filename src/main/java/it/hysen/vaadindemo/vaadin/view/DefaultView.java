package it.hysen.vaadindemo.vaadin.view;

import javax.annotation.PostConstruct;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@SpringView(name = DefaultView.VIEW_NAME)
public class DefaultView extends VerticalLayout implements View {

	private static final long serialVersionUID = 1L;

	public static final String VIEW_NAME = "";
	
	@Override
	public void enter(ViewChangeEvent event) {
		// This view is constructed in the init() method()
	}
	
	@PostConstruct
	void init() {
		addComponent(new Label("This is the default view"));
	}

}