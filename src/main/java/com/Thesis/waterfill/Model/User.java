package com.Thesis.waterfill.Model;

import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = {"username"}),
    @UniqueConstraint(columnNames = {"email"}),
})

public class User {
    private @Id
    @GeneratedValue Long id;
    String username;
    String email;
    String password;

    @ManyToMany(fetch =  FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name ="user_id", referencedColumnName =  "id"),
            inverseJoinColumns = @JoinColumn( name = "role_id", referencedColumnName ="id"))
            private Set <Role> roles;

            User(){}

            

            public User(String username, String email, String password) {
                this.username = username;
                this.email = email;
                this.password = password;
            }



            public Long getId() {
                return id;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public void setRoles(Set<Role> roles) {
                this.roles = roles;
            }

            public String getUsername() {
                return username;
            }

            public String getEmail() {
                return email;
            }

            public String getPassword() {
                return password;
            }

            public Set<Role> getRoles() {
                return roles;
            }
            

}
