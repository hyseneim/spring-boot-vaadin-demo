package it.hysen.vaadindemo.vaadin.view;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import it.hysen.vaadindemo.vaadin.component.Customer;
import it.hysen.vaadindemo.vaadin.component.ViewGreeter;

@SpringView(name = ViewScopedView.VIEW_NAME)
public class ViewScopedView extends VerticalLayout implements View {

	private static final long serialVersionUID = 1L;

	public static final String VIEW_NAME = "view";

	// A new instance will be created for every view instance created
	@Autowired
	private ViewGreeter viewGreeter;

	// The same instance will be used by all views of the UI
	@Autowired
	private Customer customer;

	@Override
	public void enter(ViewChangeEvent event) {
		// This view is constructed in the init() method()
	}

	@PostConstruct
	void init() {
		addComponent(new Label("This is a view scoped view"));
		addComponent(new Label(customer.sayHello()));
		addComponent(new Label(viewGreeter.sayHello()));
	}

}
