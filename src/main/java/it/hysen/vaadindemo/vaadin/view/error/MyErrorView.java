package it.hysen.vaadindemo.vaadin.view.error;

import javax.annotation.PostConstruct;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@UIScope
@SpringView(name = MyErrorView.VIEW_NAME)
public class MyErrorView extends VerticalLayout implements View {
	
	private static final long serialVersionUID = 1L;

	public static final String VIEW_NAME = "error";

	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
	}
	
	@PostConstruct
	void init() {
		addComponent(new Label("Error"));
	}

}
