package t15.Oglasi.appUser.user.profil;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ProfilRequest {
    private Long userId;
    private String ime;
    private String prezime;
    private String bio;
    private String telefon;
    private String mesto;
    private String email;

    public ProfilRequest(Long userId, String ime, String prezime, String bio, String telefon, String mesto, String email) {
        this.userId = userId;
        this.ime = ime;
        this.prezime = prezime;
        this.bio = bio;
        this.telefon = telefon;
        this.mesto = mesto;
        this.email = email;
    }
}
