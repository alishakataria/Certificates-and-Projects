import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ContactUI extends Frame {
    private ContactManager contactManager;
    private Label nameLabel;
    private Label phoneNumberLabel;
    private Label emailAddressLabel;
    private TextField nameField;
    private TextField phoneNumberField;
    private TextField emailAddressField;
    private Button addButton;
    private Button removeButton;
    private Button findButton;
	private Button showButton;
    private TextArea outputArea;

    public ContactUI() {
        super("Contact Manager");
        contactManager = new ContactManager();

        // create labels
        nameLabel = new Label("Name:");
        phoneNumberLabel = new Label("Phone Number:");
        emailAddressLabel = new Label("Email Address:");

        // create text fields
        nameField = new TextField();
        phoneNumberField = new TextField();
        emailAddressField = new TextField();

        // create buttons
        addButton = new Button("Add Contact");
        removeButton = new Button("Remove Contact");
        findButton = new Button("Find Contact");
		showButton = new Button("Show All Contacts");

        // create output area
        outputArea = new TextArea("", 10, 30, TextArea.SCROLLBARS_VERTICAL_ONLY);

        // add action listeners to buttons
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String phoneNumber = phoneNumberField.getText();
                String emailAddress = emailAddressField.getText();
                Contact contact = new Contact(name, phoneNumber, emailAddress);
				if((contact != null) && (contact.getName().length() > 0) && (contact.getPhoneNumber().length() == 10) && (contact.getEmailAddress().contains("@"))){
					contactManager.addContact(contact);
					outputArea.setText("Contact added: " + contact.getName() + "\n");
				}
                else{
					outputArea.setText("Contact cannot be added.\n");
				}
            }
        });
        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                Contact contact = contactManager.findContact(name);
                if (contact != null) {
                    contactManager.removeContact(contact);
                    outputArea.setText("Contact removed: " + contact.getName() + "\n");
                } else {
                    outputArea.setText("Contact not found.\n");
                }
            }
        });
        findButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                Contact contact = contactManager.findContact(name);
                if (contact != null) {
                    outputArea.setText("Contact found:\n" + "Name: " + contact.getName() + "\nPhone Number: " + contact.getPhoneNumber() + "\nEmail Address: " + contact.getEmailAddress() + "\n");
                } else {
                    outputArea.setText("Contact not found.\n");
                }
            }
        });
		showButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                ArrayList<Contact> contacts = contactManager.showAllContacts();
                if (contacts != null) {
					outputArea.setText("Added Contacts:\n");
					for(Contact contact : contacts){
						outputArea.append("Name: " + contact.getName() + "\nPhone Number: " + contact.getPhoneNumber() + "\nEmail Address: " + contact.getEmailAddress() + "\n\n");
					}
                } else {
                    outputArea.append("Contacts are not added yet.\n");
                }
            }
        });

        // create layout
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        add(nameLabel, c);
        c.gridx = 1;
        add(nameField, c);
        c.gridx = 0;
        c.gridy = 1;
        add(phoneNumberLabel, c);
        c.gridx = 1;
        add(phoneNumberField, c);
        c.gridx = 0;
        c.gridy = 2;
        add(emailAddressLabel, c);
        c.gridx = 1;
        add(emailAddressField, c);
        c.gridx = 0;
        c.gridy = 3;
        add(addButton, c);
        c.gridx = 1;
        add(removeButton, c);
        c.gridx = 2;
        add(findButton, c);
		c.gridx = 3;
		add(showButton, c);
        c.gridx = 0;
        c.gridy = 6;
        c.gridwidth = 6;
        add(outputArea, c);

        // set window properties
        pack();
        setVisible(true);
        setLocationRelativeTo(null); // center on screen
        //setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new ContactUI();
    }
}
