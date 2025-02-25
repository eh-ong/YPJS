package ypjs.project.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Data
public class Address {

    private String address;

    private String addressDetail;

    private String zipcode;

    public Address() {
    }

    public Address(String address, String addressDetail, String zipcode) {
        this.address = address;
        this.addressDetail = addressDetail;
        this.zipcode = zipcode;
    }
}
