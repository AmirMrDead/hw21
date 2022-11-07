package entity;

import base.entity.BaseEntity;
import jakarta.persistence.MappedSuperclass;
import lombok.*;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class Person extends BaseEntity {

    private String firstname;
    private String lastname;
    private String nationalCode;
    private String password;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(nationalCode, person.nationalCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nationalCode);
    }
}
