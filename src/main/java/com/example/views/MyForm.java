package com.example.views;

import com.example.entities.User;
import com.example.repositories.UserRepository;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

@SpringComponent
@UIScope
public class MyForm extends VerticalLayout {

    private final UserRepository userRepository;

    public MyForm(UserRepository userRepository) {
        this.userRepository = userRepository;

        // Create a form layout
        FormLayout formLayout = new FormLayout();

        // Create form components (e.g., text fields)
        TextField firstNameField = new TextField("First Name");
        TextField lastNameField = new TextField("Last Name");

        // Add components to the form layout
        formLayout.add(firstNameField, lastNameField);

        // Create a button for form submission
        Button submitButton = new Button("Submit");

        // Handle form submission
        submitButton.addClickListener(event -> {
            // Process form data here
            String firstName = firstNameField.getValue();
            String lastName = lastNameField.getValue();

            // Save data to the database
            User user = new User();
            user.setFirstName(firstName);
            user.setLastName(lastName);
            userRepository.save(user);
        });

        // Add the form layout and the submit button to the main layout
        add(formLayout, submitButton);
    }
}

