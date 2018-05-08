package auction.domain;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "User.count", query = "SELECT COUNT(u) FROM User AS u"),
        @NamedQuery(name = "User.getAll", query = "SELECT u FROM User AS u"),
        @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User AS u WHERE u.email = :email")
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String email;

    public User() {}

    public User(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        return email.equals(user.email);
    }

    @Override
    public int hashCode()
    {
        int result = id;
        result = 31 * result + email.hashCode();
        return result;
    }
}
