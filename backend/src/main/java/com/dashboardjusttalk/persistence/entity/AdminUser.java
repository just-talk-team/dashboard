package com.dashboardjusttalk.persistence.entity;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor

public class AdminUser implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NonNull  private String userName;
    @NonNull  private String password;
    private String email;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AdminUser)) return false;
        AdminUser adminUser = (AdminUser) o;
        return Objects.equals (userName, adminUser.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash (userName);
    }

}