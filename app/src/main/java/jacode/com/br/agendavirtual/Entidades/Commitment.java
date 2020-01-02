package jacode.com.br.agendavirtual.Entidades;

public class Commitment {

    private String name;
    private String description;
    private String date;
    private String keyCommitment;
    private String status;
    private String uid;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getKeyCommitment() {
        return keyCommitment;
    }

    public void setKeyCommitment(String keyCommitment) {
        this.keyCommitment = keyCommitment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
