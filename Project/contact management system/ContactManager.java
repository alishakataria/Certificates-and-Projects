import java.util.ArrayList;

public class ContactManager {
  private ArrayList<Contact> contacts;
  
  public ContactManager() {
    contacts = new ArrayList<Contact>();
  }
  
  public void addContact(Contact contact) {
    contacts.add(contact);
  }
  
  public void removeContact(Contact contact) {
    contacts.remove(contact);
  }
  
  public Contact findContact(String name) {
    for (Contact contact : contacts) {
      if (contact.getName().equals(name)) {
        return contact;
      }
    }
    return null;
  }
  
  public ArrayList<Contact> showAllContacts(){
	if(contacts.size() > 0){
		return contacts;  
	}
	return null;
  }
}