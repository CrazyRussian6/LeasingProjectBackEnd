package lt.swedbank.itacademy.ItAkaLeasingSystemBackEnd.utils;

public class EndPoints {

    public static final String CUSTOMERS = "/customers";
    public static final String CUSTOMERS_ADD_BUSINESS_CUSTOMER = "/customers/addBusinessCustomer";
    public static final String CUSTOMERS_ADD_PRIVATE_CUSTOMER = "/customers/addPrivateCustomer";
    public static final String CUSTOMERS_EXISTS_BY_USER_ID = "/customers/{userId}";
    public static final String CUSTOMERS_EXISTS_BY_EMAIL = "customers/{email}";
    public static final String CUSTOMERS_EXISTSBY_ID_AND_EMAIL = "/customers/check";
    public static final String CUSTOMERS_LOGIN = "/customers/login";

    public static final String OFFICER_LOGIN = "/officer/login";
    public static final String CUSTOMERS_CHANGE_PASSWORD = "/customers/change/password";
    public static final String CUSTOMERS_CHANGE_FORGOT = "customers/change/forgot";

    public static final String CUSTOMERS_FORGOTPASSWORD_CREDS = "customers/forgotpassword";
    public static final String CUSTOMERS_RESETPASSWORDVAL = "customers/resetpasswordval";

    public static final String VEHICLES = "/vehicles";
    public static final String VEHICLES_ADD = "/vehicles/add";

    public static final String VEHICLE_LEASINGS = "/vehicleLeasings";
    public static final String VEHICLE_LEASINGS_ADD = "/vehicleLeasings/add";
    public static final String VEHICLE_LEASINGS_GET_BY_ID = "/vehicleLeasings/{id}";
    public static final String VEHICLE_LEASINGS_UPDATESTATUS_ID = "/vehicleLeasings/updatestatus{id}";

    //public static final String PASS_RECOVERY_TOKEN_LINK = "http://localhost:4200/new-pass?token=";
    public static final String PASS_RECOVERY_TOKEN_LINK = "https://leasingcourseprojectapp.herokuapp.com/new-pass?token=";

    public static final String OFFICER_LOANS = "/officer/loans";

    public static final String[] PUBLIC_ENDPOINTS = new String[]{
            CUSTOMERS,
            CUSTOMERS_ADD_BUSINESS_CUSTOMER,
            CUSTOMERS_ADD_PRIVATE_CUSTOMER,
            CUSTOMERS_EXISTS_BY_USER_ID,
            CUSTOMERS_EXISTS_BY_EMAIL,
            CUSTOMERS_EXISTSBY_ID_AND_EMAIL,
            CUSTOMERS_LOGIN,
            OFFICER_LOGIN,
            CUSTOMERS_CHANGE_PASSWORD,
            CUSTOMERS_CHANGE_FORGOT,
            CUSTOMERS_FORGOTPASSWORD_CREDS,
            CUSTOMERS_RESETPASSWORDVAL,
            VEHICLES,
            VEHICLES_ADD,
            VEHICLE_LEASINGS,
            VEHICLE_LEASINGS_ADD,
            VEHICLE_LEASINGS_GET_BY_ID,
            VEHICLE_LEASINGS_UPDATESTATUS_ID,
            PASS_RECOVERY_TOKEN_LINK
    };

    public static final String[] PROTECTED_ENDPOINTS = new String[]{
        OFFICER_LOANS
    };
}
