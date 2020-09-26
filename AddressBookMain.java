import java.util.*;

/**
 * 
 */

/**
 * @author Rachit
 *
 */
public class AddressBookMain {
	private List<ContactsUC1> addressList = new ArrayList<ContactsUC1>();
	
	public void addContact(ContactsUC1 contactObj){
		addressList.add(contactObj);
		}
	public void viewAddressList() {
		ContactsUC1 c;
		for(int i=0;i<addressList.size();i++)
		{
			System.out.println(((ContactsUC1)(addressList.get(i))).getFirstName());
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AddressBookMain addressObj = new AddressBookMain();
		
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
		String phoneNo= sc.nextLine();
		System.out.println("Email");
		String email = sc.nextLine();
		//Input
		
		ContactsUC1 contactObj = new ContactsUC1(firstName,lastName,address,city,state,zip,phoneNo,email);
		addressObj.addContact(contactObj);
		addressObj.viewAddressList();
	}

}
