package com.github.paczarny.myblog.model;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long id;
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    @Email
    private String email;
    @OneToOne()
    @JoinColumn(name="userDetails_id")
    private UserDetails userDetails;
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER )
    private List<Article> articleList;
    @ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles", joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id_user")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id_role")})
    private Set<Role> roles = new HashSet<>();


    public User(String username, String password, String email, Set<Role> roles) {
        this.username=username;
        this.password = password;
        this.email=email;
        this.roles = roles;
    }

    public User(){
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void addRole(Role role) {getRoles().add(role);}

    public Set<Role> getRoles() {
        return roles;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }

    public List<Article> getArticleList() {
        return articleList;
    }

    public void addArticle(Article article){
        articleList.add(article);
    }

    public String getEmail() {
        return email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) { this.username = username; }

    public String getUsername() { return username; }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    public Long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

}
