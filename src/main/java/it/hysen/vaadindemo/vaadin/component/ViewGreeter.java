package it.hysen.vaadindemo.vaadin.component;

import java.io.Serializable;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.ViewScope;

@SpringComponent
@ViewScope
public class ViewGreeter implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public String sayHello() {
		StringBuilder hello = new StringBuilder();
		hello.append("Hello from a view scoped bean:");
		hello.append(" ");
		hello.append(getClass().getName());
		return hello.toString();
	}

}
