package med.voll.api.domain.address;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.address.dto.CreateAddress;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String public_place;
    private String district;
    private String zipcode;
    private String number;
    private String complement;
    private String city;
    private String fu;

    public Address(CreateAddress address) {
        this.public_place = address.public_place();
        this.district = address.district();
        this.zipcode = address.zipcode();
        this.number = address.number();
        this.complement = address.complement();
        this.city = address.city();
        this.fu = address.fu();
    }

    public void updateAddress(CreateAddress address) {
        if(address.public_place() != null) {
            this.public_place = address.public_place();
        }
        if(address.district() != null) {
            this.district = address.district();
        }
        if(address.zipcode() != null) {
            this.zipcode = address.zipcode();
        }
        if(address.number() != null) {
            this.number = address.number();
        }
        if(address.complement() != null) {
            this.complement = address.complement();
        }
        if(address.city() != null) {
            this.city = address.city();
        }
        if(address.fu() != null) {
            this.fu = address.fu();
        }
    }
}
