package org.cshaifasweng.winter.models;

import java.util.Collection;
import java.util.Date;


public class Employee extends User {

    private Date employedSince;

    public Employee() {}

    public Employee(String email, String password, String firstName, String lastName,
                    String phone, Collection<Role> roles, Date employedSince) {
        super(email, password, firstName, lastName, phone, roles);
        this.employedSince = employedSince;
    }

    public Date getEmployedSince() {
        return employedSince;
    }

    public void setEmployedSince(Date employedSince) {
        this.employedSince = employedSince;
    }
}
