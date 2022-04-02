package models;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.*;

@Data
@Builder
@EqualsAndHashCode
@ToString
public class LoginModel {
    private String login;
    private String password;
}
