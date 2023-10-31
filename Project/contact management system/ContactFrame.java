import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContactFrame extends Frame {
  private ContactManager contactManager;
  private TextField nameField;
  private TextField phoneNumberField;
  private TextField emailAddressField;
  
  public ContactFrame(ContactManager contactManager) {
    super("Contact Manager");
    this.contactManager = contactManager;
    
    Label nameLabel = new Label("Name:");
    Label phoneNumberLabel = new Label("Phone Number:");
    Label emailAddressLabel = new Label("Email Address:");
    
    nameField = new TextField();
    phoneNumberField = new TextField();
    emailAddressField = new TextField();
    
    Button addButton = new Button("Add Contact");
    addButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String name = nameField.getText();
        String phoneNumber = phoneNumberField.getText();
        String emailAddress = emailAddressField.getText();
        Contact contact = new Contact(name, phoneNumber, emailAddress);
		contactManager.addContact(contact);
    });
    
    add(nameLabel);
    add(nameField
  }
}