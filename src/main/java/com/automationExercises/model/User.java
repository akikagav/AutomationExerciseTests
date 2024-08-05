package com.automationExercises.model;

public class User {
    private String email;
    private String password;
    private String name;
    private Gender title;
    private int dayId;
    private int monthId;
    private int yearId;
    private boolean signUpForNewsletter;
    private boolean receiveForOffers;
    private String firstName;
    private String lastName;
    private String company;
    private String address1;
    private String address2;
    private int countryId;
    private String state;
    private String city;
    private String zipcode;
    private String mobileNumber;
    private int[] products;
    private String checkoutMessage;

    private AccountCart cart;

    public User(String email,
                String password,
                String name,
                Gender title,
                int dayId,
                int monthId,
                int yearId,
                boolean signUpForNewsletter,
                boolean receiveForOffers,
                String firstName,
                String lastName,
                String company,
                String address1,
                String address2,
                int countryId,
                String state,
                String city,
                String zipcode,
                String mobileNumber,
                int[] products,
                String checkoutMessage,
                AccountCart cart) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.title = title;
        this.dayId = dayId;
        this.monthId = monthId;
        this.yearId = yearId;
        this.signUpForNewsletter = signUpForNewsletter;
        this.receiveForOffers = receiveForOffers;
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.address1 = address1;
        this.address2 = address2;
        this.countryId = countryId;
        this.state = state;
        this.city = city;
        this.zipcode = zipcode;
        this.mobileNumber = mobileNumber;
        this.products = products;
        this.checkoutMessage = checkoutMessage;
        this.cart = cart;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getTitle() {
        return title;
    }

    public void setTitle(Gender title) {
        this.title = title;
    }

    public int getDayId() {
        return dayId;
    }

    public void setDayId(int dayId) {
        this.dayId = dayId;
    }

    public int getMonthId() {
        return monthId;
    }

    public void setMonthId(int monthId) {
        this.monthId = monthId;
    }

    public int getYearId() {
        return yearId;
    }

    public void setYearId(int yearId) {
        this.yearId = yearId;
    }

    public boolean isSignUpForNewsletter() {
        return signUpForNewsletter;
    }

    public void setSignUpForNewsletter(boolean signUpForNewsletter) {
        this.signUpForNewsletter = signUpForNewsletter;
    }

    public boolean isReceiveForOffers() {
        return receiveForOffers;
    }

    public void setReceiveForOffers(boolean receiveForOffers) {
        this.receiveForOffers = receiveForOffers;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public int[] getProducts() {
        return products;
    }

    public void setProducts(int[] products) {
        this.products = products;
    }

    public String getCheckoutMessage() {
        return checkoutMessage;
    }

    public void setCheckoutMessage(String checkoutMessage) {
        this.checkoutMessage = checkoutMessage;
    }

    public AccountCart getCart() {
        return cart;
    }

    public void setCart(AccountCart cart) {
        this.cart = cart;
    }
}
