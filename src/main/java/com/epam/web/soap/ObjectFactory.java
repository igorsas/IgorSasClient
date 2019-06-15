
package com.epam.web.soap;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.epam.web.soap package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _LogIn_QNAME = new QName("http://soap.web.epam.com/", "logIn");
    private final static QName _GetRolesResponse_QNAME = new QName("http://soap.web.epam.com/", "getRolesResponse");
    private final static QName _AddUser_QNAME = new QName("http://soap.web.epam.com/", "addUser");
    private final static QName _GetAllUsers_QNAME = new QName("http://soap.web.epam.com/", "getAllUsers");
    private final static QName _GetUsersByRole_QNAME = new QName("http://soap.web.epam.com/", "getUsersByRole");
    private final static QName _AddUserResponse_QNAME = new QName("http://soap.web.epam.com/", "addUserResponse");
    private final static QName _GetRoles_QNAME = new QName("http://soap.web.epam.com/", "getRoles");
    private final static QName _GetUsersByRoleResponse_QNAME = new QName("http://soap.web.epam.com/", "getUsersByRoleResponse");
    private final static QName _RemoveUser_QNAME = new QName("http://soap.web.epam.com/", "removeUser");
    private final static QName _LogInResponse_QNAME = new QName("http://soap.web.epam.com/", "logInResponse");
    private final static QName _UserFault_QNAME = new QName("http://soap.web.epam.com/", "UserFault");
    private final static QName _GetAllUsersResponse_QNAME = new QName("http://soap.web.epam.com/", "getAllUsersResponse");
    private final static QName _RemoveUserResponse_QNAME = new QName("http://soap.web.epam.com/", "removeUserResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.epam.web.soap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link LoginModel }
     * 
     */
    public LoginModel createLoginModel() {
        return new LoginModel();
    }

    /**
     * Create an instance of {@link AddUserResponse }
     * 
     */
    public AddUserResponse createAddUserResponse() {
        return new AddUserResponse();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link RemoveUser }
     * 
     */
    public RemoveUser createRemoveUser() {
        return new RemoveUser();
    }

    /**
     * Create an instance of {@link Role }
     * 
     */
    public Role createRole() {
        return new Role();
    }

    /**
     * Create an instance of {@link GetUsersByRoleResponse }
     * 
     */
    public GetUsersByRoleResponse createGetUsersByRoleResponse() {
        return new GetUsersByRoleResponse();
    }

    /**
     * Create an instance of {@link GetRolesResponse }
     * 
     */
    public GetRolesResponse createGetRolesResponse() {
        return new GetRolesResponse();
    }

    /**
     * Create an instance of {@link LogInResponse }
     * 
     */
    public LogInResponse createLogInResponse() {
        return new LogInResponse();
    }

    /**
     * Create an instance of {@link GetUsersByRole }
     * 
     */
    public GetUsersByRole createGetUsersByRole() {
        return new GetUsersByRole();
    }

    /**
     * Create an instance of {@link GetAllUsersResponse }
     * 
     */
    public GetAllUsersResponse createGetAllUsersResponse() {
        return new GetAllUsersResponse();
    }

    /**
     * Create an instance of {@link LogIn }
     * 
     */
    public LogIn createLogIn() {
        return new LogIn();
    }

    /**
     * Create an instance of {@link RemoveUserResponse }
     * 
     */
    public RemoveUserResponse createRemoveUserResponse() {
        return new RemoveUserResponse();
    }

    /**
     * Create an instance of {@link AddUser }
     * 
     */
    public AddUser createAddUser() {
        return new AddUser();
    }

    /**
     * Create an instance of {@link UserFault }
     * 
     */
    public UserFault createUserFault() {
        return new UserFault();
    }

    /**
     * Create an instance of {@link GetAllUsers }
     * 
     */
    public GetAllUsers createGetAllUsers() {
        return new GetAllUsers();
    }

    /**
     * Create an instance of {@link GetRoles }
     * 
     */
    public GetRoles createGetRoles() {
        return new GetRoles();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LogIn }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.web.epam.com/", name = "logIn")
    public JAXBElement<LogIn> createLogIn(LogIn value) {
        return new JAXBElement<LogIn>(_LogIn_QNAME, LogIn.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRolesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.web.epam.com/", name = "getRolesResponse")
    public JAXBElement<GetRolesResponse> createGetRolesResponse(GetRolesResponse value) {
        return new JAXBElement<GetRolesResponse>(_GetRolesResponse_QNAME, GetRolesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.web.epam.com/", name = "addUser")
    public JAXBElement<AddUser> createAddUser(AddUser value) {
        return new JAXBElement<AddUser>(_AddUser_QNAME, AddUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllUsers }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.web.epam.com/", name = "getAllUsers")
    public JAXBElement<GetAllUsers> createGetAllUsers(GetAllUsers value) {
        return new JAXBElement<GetAllUsers>(_GetAllUsers_QNAME, GetAllUsers.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUsersByRole }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.web.epam.com/", name = "getUsersByRole")
    public JAXBElement<GetUsersByRole> createGetUsersByRole(GetUsersByRole value) {
        return new JAXBElement<GetUsersByRole>(_GetUsersByRole_QNAME, GetUsersByRole.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.web.epam.com/", name = "addUserResponse")
    public JAXBElement<AddUserResponse> createAddUserResponse(AddUserResponse value) {
        return new JAXBElement<AddUserResponse>(_AddUserResponse_QNAME, AddUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRoles }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.web.epam.com/", name = "getRoles")
    public JAXBElement<GetRoles> createGetRoles(GetRoles value) {
        return new JAXBElement<GetRoles>(_GetRoles_QNAME, GetRoles.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetUsersByRoleResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.web.epam.com/", name = "getUsersByRoleResponse")
    public JAXBElement<GetUsersByRoleResponse> createGetUsersByRoleResponse(GetUsersByRoleResponse value) {
        return new JAXBElement<GetUsersByRoleResponse>(_GetUsersByRoleResponse_QNAME, GetUsersByRoleResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.web.epam.com/", name = "removeUser")
    public JAXBElement<RemoveUser> createRemoveUser(RemoveUser value) {
        return new JAXBElement<RemoveUser>(_RemoveUser_QNAME, RemoveUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LogInResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.web.epam.com/", name = "logInResponse")
    public JAXBElement<LogInResponse> createLogInResponse(LogInResponse value) {
        return new JAXBElement<LogInResponse>(_LogInResponse_QNAME, LogInResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.web.epam.com/", name = "UserFault")
    public JAXBElement<UserFault> createUserFault(UserFault value) {
        return new JAXBElement<UserFault>(_UserFault_QNAME, UserFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllUsersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.web.epam.com/", name = "getAllUsersResponse")
    public JAXBElement<GetAllUsersResponse> createGetAllUsersResponse(GetAllUsersResponse value) {
        return new JAXBElement<GetAllUsersResponse>(_GetAllUsersResponse_QNAME, GetAllUsersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soap.web.epam.com/", name = "removeUserResponse")
    public JAXBElement<RemoveUserResponse> createRemoveUserResponse(RemoveUserResponse value) {
        return new JAXBElement<RemoveUserResponse>(_RemoveUserResponse_QNAME, RemoveUserResponse.class, null, value);
    }

}
