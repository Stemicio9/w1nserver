package clientauthw1nserver.w1nserver.model;

import javax.persistence.*;

@Entity
@Table(name = "profilo")
public class Profilo {

    @Id
    @Column(name = "ID")
    private long id;     // Sarà lo stesso id dell'utente


    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "TELEFONO")
    private String telefono;
    @Column(name = "TELEFONO_VISIBILE")
    private boolean telefonoVisibile;
    @Column(name = "EMAIL")
    private String email;

    @Column(name = "DESCRIZIONE")
    private String descrizione;


    @Column(name = "NUMERO_MATCH")
    private String numeroMatch;

    @Column(name = "FEEDBACK_POSITIVI")
    private String feedbackPositivi;

    @Column(name = "NUMERO_BLACKLIST")
    private String numeroBlacklist;





    public String getEmail() {
        return email;
    }


    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getFeedbackPositivi() {
        return feedbackPositivi;
    }

    public String getNumeroBlacklist() {
        return numeroBlacklist;
    }

    public String getNumeroMatch() {
        return numeroMatch;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public boolean isTelefonoVisibile() {
        return telefonoVisibile;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setFeedbackPositivi(String feedbackPositivi) {
        this.feedbackPositivi = feedbackPositivi;
    }

    public void setNumeroBlacklist(String numeroBlacklist) {
        this.numeroBlacklist = numeroBlacklist;
    }

    public void setNumeroMatch(String numeroMatch) {
        this.numeroMatch = numeroMatch;
    }

    public void setTelefonoVisibile(boolean telefonoVisibile) {
        this.telefonoVisibile = telefonoVisibile;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
}
