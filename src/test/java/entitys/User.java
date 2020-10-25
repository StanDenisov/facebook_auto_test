package entitys;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import java.util.Date;

@Data
public class User {
    private String email;
    private String name;
    private String gender;
    private String password;

    @SerializedName("gender_type")
    private String genderType;

    @SerializedName("last_name")
    private String lastName;

    @SerializedName("birthday_date")
    private Date birthdayDate;

    public User() {}
}
