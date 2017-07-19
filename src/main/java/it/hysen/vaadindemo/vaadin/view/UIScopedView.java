package it.hysen.vaadindemo.vaadin.view;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import it.hysen.vaadindemo.vaadin.component.Customer;

@UIScope
@SpringView(name = UIScopedView.VIEW_NAME)
public class UIScopedView extends VerticalLayout implements View {
	
	private static final long serialVersionUID = 1L;
	
	public static final String VIEW_NAME = "ui";
	
	@Autowired
	private Customer customer;
	
	@Override
	public void enter(ViewChangeEvent event) {
		// This view is constructed in the init() method()
	}
	
	@PostConstruct
	void init() {
		addComponent(new Label("This is a UI scoped view. Customer says: " + customer.sayHello()));
	}

}
