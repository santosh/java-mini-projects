package entities;

public class User {
    private String firstName;
    private String lastName;
    private Contact contact;
    private Address address;
    private int userId;
    public static int counter = 1;

     public User(String firstName, String lastName, Contact contact, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.contact = new Contact(contact);
        this.address = new Address(address);
        this.userId = counter;
        counter++;
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    public Contact getContact() {
        return contact;
    }

    public Address getAddress() {
        return address;
    }

    public int getUserId() {
        return userId;
    }

    public static class Contact {
        private String emailID;
        private String phone;

        public Contact(String emailID, String phone) {
            this.emailID = emailID;
            this.phone = phone;
        }

        public Contact(Contact obj) {
            this.emailID = obj.emailID;
            this.phone = obj.phone;
        }

        public String getEmailID() {
            return emailID;
        }

        public String getPhone() {
            return phone;
        }
    }

    public static class Address {
        private String city;
        private String locality;
        private String state;
        private int pinCode;

        public Address(String city, String locality, String state, int pinCode) {
            this.city = city;
            this.locality = locality;
            this.state = state;
            this.pinCode = pinCode;
        }

        public Address(Address obj) {
            this.city = obj.city;
            this.locality = obj.locality;
            this.state = obj.state;
            this.pinCode = obj.pinCode;
        }


        public String getCity() {
            return city;
        }

        public String getLocality() {
            return locality;
        }

        public String getState() {
            return state;
        }

        public int getPinCode() {
            return pinCode;
        }
    }
}
