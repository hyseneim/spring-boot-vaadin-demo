package it.hysen.vaadindemo.vaadin;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.SpringViewDisplay;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

import it.hysen.vaadindemo.vaadin.view.DefaultView;
import it.hysen.vaadindemo.vaadin.view.UIScopedView;
import it.hysen.vaadindemo.vaadin.view.ViewScopedView;
import it.hysen.vaadindemo.vaadin.view.error.MyErrorView;

@Theme("valo")
@SpringUI
@SpringViewDisplay
public class MyVaadinUI extends UI implements ViewDisplay {
	
	private static final long serialVersionUID = 1L;
	// private static final Logger LOGGER =
	// LoggerFactory.getLogger(MyVaadinUI.class);

	private Panel springViewDisplay;
	
	private Button createNavigationButton(String caption, final String viewName) {
		Button button = new Button(caption);
		button.addStyleName(ValoTheme.BUTTON_SMALL);
		button.addClickListener(event -> {
			UI ui = getUI();
			Navigator navigator = ui.getNavigator();
			navigator.navigateTo(viewName);
		});
		return button;
	}
	
	@Override
	protected void init(VaadinRequest request) {
		getUI().getNavigator().setErrorView(MyErrorView.class);

		final VerticalLayout root = new VerticalLayout();
		root.setSizeFull();
		setContent(root);
		
		final CssLayout navigationBar = new CssLayout();
		navigationBar.addStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
		navigationBar.addComponent(createNavigationButton("Default View", DefaultView.VIEW_NAME));
		navigationBar.addComponent(createNavigationButton("UI Scoped View", UIScopedView.VIEW_NAME));
		navigationBar.addComponent(createNavigationButton("View Scoped View", ViewScopedView.VIEW_NAME));
		root.addComponent(navigationBar);
		
		springViewDisplay = new Panel();
		springViewDisplay.setSizeFull();
		root.addComponent(springViewDisplay);
		root.setExpandRatio(springViewDisplay, 1.0f);
	}
	
	@Override
	public void showView(View view) {
		springViewDisplay.setContent((Component) view);
	}
	
}
