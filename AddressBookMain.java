import java.util.*;

/**Ability to add multiple address book to system
 * 
 * 
 */

/**
 * @author Rachit
 *
 */
public class AddressBookMain {
	Scanner sc = new Scanner(System.in);
	private List<ContactsUC1> addressList = new ArrayList<ContactsUC1>();

	HashMap<String, List<ContactsUC1>> addressBookMap = new HashMap<String, List<ContactsUC1>>();

	// Map to store multiple address
	public void addContact(ContactsUC1 contactObj) {
		addressList.add(contactObj);
	}
	// Add contact to address book

	public boolean editDetails(String firstName, String lastName) {
		ContactsUC1 editObj;
		boolean contactFound = false;
		for (int i = 0; i < addressList.size(); i++) {
			editObj = (ContactsUC1) addressList.get(i);
			if ((editObj.getFirstName().equals(firstName)) && (editObj.getLastName().equals(lastName))) {
				System.out.println("Enter new Address:");
				editObj.setAddress(sc.nextLine());
				System.out.println("Enter new City");
				editObj.setCity(sc.nextLine());
				System.out.println("Enter new State");
				editObj.setState(sc.nextLine());
				System.out.println("Enter new Zip");
				editObj.setZip(sc.nextLine());
				System.out.println("Enter new Phone no");
				editObj.setPhoneNo(sc.nextLine());
				System.out.println("Enter new Email");
				editObj.setEmail(sc.nextLine());
				contactFound = true;
				break;
			}
		}
		return contactFound;
	}
	// Edit contact details

	public boolean removeDetails(String firstName, String lastName) {
		ContactsUC1 removeObj;
		boolean contactFound = false;
		for (int i = 0; i < addressList.size(); i++) {
			removeObj = (ContactsUC1) addressList.get(i);
			if ((removeObj.getFirstName().equals(firstName)) && (removeObj.getLastName().equals(lastName))) {
				addressList.remove(i);
				contactFound = true;
				break;
			}
		}
		return contactFound;
	}
	// Remove contact from given address book

	public void addAddressList(String listName) {
		List<ContactsUC1> newAddressList = new ArrayList<ContactsUC1>();
		addressBookMap.put(listName, newAddressList);
		System.out.println("Address Book added");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AddressBookMain addressObj = new AddressBookMain();
		int choice = 0;

		while (choice != 6) {
			if (addressObj.addressBookMap.isEmpty()) {
				System.out.println("Please add an address book to begin");
				System.out.println("Enter the name of address book that u want to add:");
				String listName = sc.nextLine();
				addressObj.addAddressList(listName);
			}
			// Checking in address list is present in hashmap
			System.out.println("Enter the name of the address book you want to access");
			String listName = sc.nextLine();
			if (addressObj.addressBookMap.containsKey(listName)) {
				addressObj.addressList = addressObj.addressBookMap.get(listName);
			}

			else {
				System.out.println("Address list with name" + listName + " not present. Please add it first.");
			}

			// This condition checks if there is atleast one address book present. If not,
			// you have to add an address book to begin.
			System.out.println(
					"Enter a choice: \n 1)Add a new contact \n 2)Edit a contact \n 3)Delete Contact \n 4)Add Address Book \n 5)View Address Book \n 6)Exit");
			choice = Integer.parseInt(sc.nextLine());
			switch (choice) {
			case 1: {
				System.out.println("Add Person Details:");
				System.out.println("First Name:");
				String firstName = sc.nextLine();
				System.out.println("Last Name:");
				String lastName = sc.nextLine();
				System.out.println("Address:");
				String address = sc.nextLine();
				System.out.println("City:");
				String city = sc.nextLine();
				System.out.println("State:");
				String state = sc.nextLine();
				System.out.println("Zip:");
				String zip = sc.nextLine();
				System.out.println("Phone no:");
				String phoneNo = sc.nextLine();
				System.out.println("Email");
				String email = sc.nextLine();
				// Input
				ContactsUC1 contactObj = new ContactsUC1(firstName, lastName, address, city, state, zip, phoneNo,
						email);
				addressObj.addContact(contactObj);
				break;
			}
			case 2: {
				System.out.println("Enter first name press Enter and then enter last name of person to edit details:");
				String firstName = sc.nextLine();
				String lastName = sc.nextLine();
				boolean contactFound = addressObj.editDetails(firstName, lastName);
				if (contactFound == true)
					System.out.println("Details successfully edit");
				else
					System.out.println("Contact not found");
				break;
			}
			case 3: {
				System.out.println("Enter first name press Enter and then enter last name of person to delete data");
				String firstName = sc.nextLine();
				String lastName = sc.nextLine();
				boolean contactFound = addressObj.removeDetails(firstName, lastName);
				if (contactFound == true)
					System.out.println("Details successfully deleted");
				else
					System.out.println("Contact not found");
				break;
			}
			case 4: {
				System.out.println("Enter the name of address book that u want to add:");
				listName = sc.nextLine();
				addressObj.addAddressList(listName);
				break;
			}
			case 5: {
				System.out.println(" "+addressObj.addressList);
				break;
			}
			case 6: {
				System.out.println("Thank you for using the application");
			}
			}
		}
	}

}
//Added ability to enter contact for different person in UC 3 itself
